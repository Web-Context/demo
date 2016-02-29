package com.gehc.apps.demo.dablog.bootstrap;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
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
public class DataSetReader<T, D> {

	@Autowired
	ResourceLoader loader;

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
				reader = new JsonReader(new FileReader(loader.getResource("classpath:" + filename).getURI().getPath()));
				List<T> list = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().fromJson(reader,
						new TypeToken<List<T>>() {
						}.getType());
				for (T item : list) {
					repo.insert(item);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
