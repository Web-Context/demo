package com.gehc.apps.demo.dablog.bootstrap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gehc.apps.demo.dablog.model.platform.Platform;
import com.gehc.apps.demo.dablog.model.post.Post;
import com.gehc.apps.demo.dablog.model.user.User;

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
	@Autowired
	DataSetReader<User> userDataset;

	@PostConstruct
	public void inject() {

		pfDataset.importData("dataset/platform.json", Platform.class, true,true);
		postDataset.importData("dataset/post.json", Post.class, true,true);
		userDataset.importData("dataset/user.json", User.class, true,true);
	}
}
