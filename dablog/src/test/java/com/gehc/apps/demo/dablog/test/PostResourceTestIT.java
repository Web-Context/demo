/**
 * 
 */
package com.gehc.apps.demo.dablog.test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gehc.apps.demo.dablog.DaBlogApp;
import com.gehc.apps.demo.dablog.model.post.Post;
import com.gehc.apps.demo.dablog.services.DataSetReader;

/**
 * 
 * 
 * @author Frédéric Delorme
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DaBlogApp.class)
@WebIntegrationTest(randomPort = true)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostResourceTestIT{

	@Autowired
	DataSetReader<Post> postDataReader;

	@Value("${local.server.port}")
	private int port;

	@Before
	public void setUp() throws Exception {
		postDataReader.importData("dataset/post.json", false, true);
	}

	@Test
	public void test_1_findByType() throws Exception {
		get("/avi/posts").then().body("page.totalElements", equalTo(2));
		get("/avi/posts").then().body("_embedded.posts[0].title", equalTo("Lego La grande aventure"));
		get("/avi/posts").then().body("_embedded.posts[1].title", equalTo("Zootopie"));
	}

	/**
	 * http://localhost:8080/api/posts/search/findByTypeAndTitleLikeIgnoreCase?
	 * type=movie&title=Zootopie
	 */
	@Test
	public void test_1_findByTypeAndTitleLikeIgnoreCase() throws Exception {
		get("/api/posts/search/findByTypeAndTitleLikeIgnoreCase?type=movie&title=zootopie").then()
				.body("_embedded.posts[0].title", equalTo("Zootopie"));
	}

}
