/**
 * 
 */
package com.gehc.apps.demo.angularyo.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.gehc.apps.demo.angularjs.AngularYoApp;
import com.gehc.apps.demo.angularjs.model.post.Post;
import com.gehc.apps.demo.angularjs.model.post.PostRepository;

/**
 * @author 'Frederic
 *
 */
@SpringApplicationConfiguration(classes = AngularYoApp.class)
public class AngularYoAppTest {

	private static Logger log = Logger.getLogger(AngularYoApp.class);
	
	@Autowired
	PostRepository postRepository;

	@Test
	public void testPostRepository() {

		postRepository.save(new Post("1", "title1", "post", "header1", "content1", new Date(), "user1", new Date()));
		postRepository.save(new Post("2", "title2", "post", "header2", "content2", new Date(), "user2", new Date()));

		for (Post post : postRepository.findAll()) {
			log.info("Hello " + post.toString());
		}

		postRepository.deleteAll();
	}
}