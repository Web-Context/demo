package com.gehc.apps.demo.dablog.bootstrap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

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
 *
 */
@Component
public class DataSetReader<T> {

	private final static Logger logger = Logger.getLogger(DataSetReader.class);

	@Autowired
	private MongoRepository<T, ?> repo;

	/**
	 * 
	 * @param collection
	 * @param filename
	 * @param clazz
	 */
	@SuppressWarnings("serial")
	public void importData(String filename, Class<T> clazz, boolean emptyOnly) {

		if ((emptyOnly && repo.count() == 0) || (!emptyOnly)) {
			try {
				JsonReader reader;
				String datasetPath = getClass().getResource("/" + filename).getPath();
				logger.info(String.format("dataset for class %s path: %s", clazz.getCanonicalName(), datasetPath));
				BufferedReader in = new BufferedReader(
						new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(filename), "utf-8"));
				reader = new JsonReader(in);
				List<T> list = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().fromJson(reader,
						new TypeToken<List<T>>() {
						}.getType());
				for (T item : list) {
					repo.insert(item);
					logger.debug(
							"insert data: "
									+ item.toString().trim().substring(0,
											(item.toString().length() > 100 ? 120 : item.toString().length()) - 1)
							+ "...}");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
