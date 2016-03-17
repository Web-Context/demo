/**
 * 
 */
package com.gehc.apps.demo.dablog.test;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gehc.apps.demo.dablog.DaBlogApp;
import com.gehc.apps.demo.dablog.model.post.Post;
import com.gehc.apps.demo.dablog.services.DataSetReader;

/**
 * Unit test for class DataSetReader, tools to import JSON data to MongoDB
 * database.
 * 
 * @see DataSetReader
 * @author Frédéric Delorme
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DaBlogApp.class)
@WebIntegrationTest(randomPort = true)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataSetReaderTest {

	@Autowired
	DataSetReader<Post> dsr;

	/**
	 * Test method for
	 * {@link com.gehc.apps.demo.dablog.services.DataSetReader#importData(java.lang.String, java.lang.Class, boolean, boolean)}
	 * .
	 * 
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test_1_ImportData() throws ClassNotFoundException {
		long nb = dsr.importData("dataset/post.json", false, true);
		assertEquals("Bad item number of imported data from file dataset/post.json", 2,nb);
	}

	/**
	 * Test method for
	 * {@link com.gehc.apps.demo.dablog.services.DataSetReader#importData(java.lang.String, java.lang.Class, boolean, boolean)}
	 * .
	 */
	@Test
	public void test_2_ImportDataWithClazz() {
		long nb = 0;
		dsr.importData("dataset/post.json", Post.class, false, true);
		nb = dsr.getRepoForClass(Post.class).count();
		assertEquals("Bad item number of imported data from fle dataset/post.json", 2,nb);
	}

	@Test(expected = ClassNotFoundException.class)
	public void test_3_ImportDataClassNotFoundException() throws ClassNotFoundException {
		dsr.importData("dataset/machin.json", false, true);
	}

}
