package com.gehc.apps.demo.dablog.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

/**
 * Read data set and inject into corresponding repository.
 * 
 * @author Frédéric Delorme
 * @author Nicolas Grussenmeyer
 *
 */
@Component
public class DataSetReader<T> {

	private final static Logger logger = Logger.getLogger(DataSetReader.class);

	@SuppressWarnings("rawtypes")
	@Autowired
	private List<MongoRepository> repos;

	/**
	 * Import a JSON dataset into database for entity entityClazz
	 * 
	 * @param filename
	 *            JSON dataset with format <code>[path]/entity.json</code>.
	 * @param ifEmptyOnly
	 *            will import data inly if collection/table is empty.
	 * @param dropData
	 *            will drop all data before importing this dataset.
	 */
	@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
	public void importData(String filename, Class<T> entityClazz, boolean ifEmptyOnly, boolean dropData) {

		MongoRepository repo = getRepoForClass(entityClazz);

		if ((ifEmptyOnly && repo.count() == 0) || (!ifEmptyOnly) || dropData) {
			if (dropData) {
				repo.deleteAll();
			}
			try {
				JsonReader reader;
				String datasetPath = getClass().getResource("/" + filename).getPath();
				logger.info(
						String.format("dataset for class %s path: %s", entityClazz.getCanonicalName(), datasetPath));
				BufferedReader in = new BufferedReader(
						new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(filename), "utf-8"));
				reader = new JsonReader(in);
				List<T> list = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().fromJson(reader,
						new TypeToken<List<?>>() {
						}.getType());

				for (Object item : list) {
					repo.insert(item);
					logger.debug(
							"insert data: "
									+ (item != null
											? item.toString().trim()
													.substring(0,
															(item.toString().length() > 100 ? 120
																	: item.toString().length()) - 1)
											: "unable to toString()")
									+ "...}");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Import data intop corresponding filename class: if file is
	 * <code>post.json</code>, data will be imported with <code>Post</code>
	 * entity.
	 * 
	 * @param filename
	 *            JSON dataset with format <code>[path]/entity.json</code>.
	 * @param ifEmptyOnly
	 *            will import data inly if collection/table is empty.
	 * @param dropData
	 *            will drop all data before importing this dataset.
	 * @return
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public long importData(String filename, boolean ifEmptyOnly, boolean dropData) throws ClassNotFoundException {
		String classNameLowerCase = filename.substring(filename.lastIndexOf("/") + 1, filename.indexOf("."));

		String fullClassName = "com.gehc.apps.demo.dablog.model." + classNameLowerCase + "."
				+ StringUtils.capitalize(classNameLowerCase);
		logger.info(String.format("detect class '%s' from file '%s'", fullClassName, filename));
		@SuppressWarnings("rawtypes")
		Class clazz = Class.forName(fullClassName);
		importData(filename, clazz, ifEmptyOnly, dropData);
		return getRepoForClass(clazz).count();
	}

	/**
	 * retrieve specific Repository for the clazz.
	 * 
	 * @param clazz
	 *            to retrieve repositrory for.
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public MongoRepository getRepoForClass(Class clazz) {
		Optional<MongoRepository> findFirst = repos.stream().filter(d -> {
			return ((ParameterizedType) d.getClass().getInterfaces()[0].getGenericInterfaces()[0])
					.getActualTypeArguments()[0].equals(clazz);
		}).findFirst();

		return findFirst.get();
	}

}
