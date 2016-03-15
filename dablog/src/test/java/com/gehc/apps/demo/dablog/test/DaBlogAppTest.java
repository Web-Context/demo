/**
 * 
 */
package com.gehc.apps.demo.dablog.test;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.gehc.apps.demo.dablog.DaBlogApp;
import com.gehc.apps.demo.dablog.model.post.Post;
import com.gehc.apps.demo.dablog.model.post.PostRepository;
import com.gehc.apps.demo.dablog.model.post.PublicationState;

/**
 * @author 'Frederic
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DaBlogApp.class)
@WebIntegrationTest(randomPort = true)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DaBlogAppTest {

	private static Logger log = Logger.getLogger(DaBlogApp.class);

	RestTemplate restTemplate = new TestRestTemplate();

	@Autowired
	PostRepository postRepository;

	@Before
	public void before() {
		postRepository.save(new Post("1", "uuid1", "title1", "game", "header1", "content1", new Date(), "user1",
				new Date(), PublicationState.PUBLISHED));
		postRepository.save(new Post("2", "uuid2", "title2", "movie", "header2", "content2", new Date(), "user2",
				new Date(), PublicationState.PUBLISHED));
	}

	@After
	public void after() {
		postRepository.deleteAll();
	}

	@Test
	public void test_1_PostRepositoryFindAll() {
		for (Post post : postRepository.findAll()) {
			log.info("post: " + post.getTitle());
			assertNotNull("", post.getId());
		}
	}

	@Test
	public void test_2_restPostRepositoryForUiid() {
		Post post = postRepository.findByUiid("uuid1");
		Assert.assertEquals("Post with uiid='uuid1' was not found.", "uuid1", post.getUiid());

	}

	@Test
	public void test_3_restPostRepositoryForTypeMovie() {
		List<Post> posts = postRepository.findByType("movie");
		Assert.assertEquals("Not movie post was found.", 1, posts.size());

	}

	@Test
	public void test_4_restPostRepositoryForTypeGame() {
		List<Post> posts = postRepository.findByType("game");
		Assert.assertEquals("Not game post was found.", 1, posts.size());

	}

	@Test
	public void test_5_restPostRepositoryForTypeGameAndTitleLike() {
		List<Post> posts = postRepository.findByTypeAndTitleLikeIgnoreCase("game", "title");
		Assert.assertEquals("Not game post was found for title='title'.", 1, posts.size());

	}

}