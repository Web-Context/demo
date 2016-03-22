package com.gehc.apps.demo.dablog.bootstrap;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gehc.apps.demo.dablog.model.platform.Platform;
import com.gehc.apps.demo.dablog.model.post.Post;
import com.gehc.apps.demo.dablog.model.user.User;
import com.gehc.apps.demo.dablog.services.DataSetReader;

/**
 * Auto inject data to Post collection
 * 
 * @author Frédéric Delorme
 *
 */
@Component
public class DataBootstrap {
	private static final Logger LOGGER = Logger.getLogger(DataBootstrap.class);

	@Autowired
	DataSetReader<Post> postDataset;
	@Autowired
	DataSetReader<Platform> pfDataset;
	@Autowired
	DataSetReader<User> userDataset;

	@PostConstruct
	public void inject() {

		try {
			pfDataset.importData("dataset/platform.json", true, true);
			postDataset.importData("dataset/post.json", true, true);
			userDataset.importData("dataset/user.json", true, true);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Unable to load data for an unknown entity");
		}
	}
}
