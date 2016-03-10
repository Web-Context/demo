package com.gehc.apps.demo.dablog.bootstrap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gehc.apps.demo.dablog.model.platform.Platform;
import com.gehc.apps.demo.dablog.model.post.Post;

/**
 * Auto inject data to Post collection
 * 
 * @author Frédéric Delorme
 *
 */
@Component 
public class DataBootstrap {
	@Autowired
	DataSetReader<Post> postDataset;
	@Autowired
	DataSetReader<Platform> pfDataset;

	@PostConstruct
	public void inject() {

		pfDataset.importData("dataset/platform.json", Platform.class, true);
		postDataset.importData("dataset/post.json", Post.class, true);
	}
}
