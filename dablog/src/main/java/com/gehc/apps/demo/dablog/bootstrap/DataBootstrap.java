package com.gehc.apps.demo.dablog.bootstrap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	DataSetReader<Post, Long> dataset;

	@PostConstruct
	public void inject() {

		dataset.importData("dataset/post.json", Post.class, true);
	}
}
