package com.gehc.apps.demo.dablog.bootstrap;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.util.List;

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
public class DataSetReader<T, D> {

	@Autowired
	private MongoRepository<T, ?> repo;

	/**
	 * 
	 * @param collection
	 * @param filename
	 * @param clazz
	 */
	@SuppressWarnings("serial")
	public void importData( String filename, Class<T> clazz, boolean emptyOnly ) {

		if ((emptyOnly && repo.count() == 0) || (!emptyOnly)) {
			try {
				JsonReader reader = new JsonReader(new FileReader(this
						.getClass().getResource("/" + filename).toURI()
						.getPath()));
				List<T> list = new GsonBuilder()
						.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create()
						.fromJson(reader, new TypeToken<List<T>>() {
						}.getType());
				for (T item : list) {
					repo.insert(item);
				}
			} catch (FileNotFoundException | URISyntaxException e) {
				e.printStackTrace();
			}

		}
	}
}
