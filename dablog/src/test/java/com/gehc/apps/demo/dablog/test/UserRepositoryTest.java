package com.gehc.apps.demo.dablog.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gehc.apps.demo.dablog.DaBlogApp;
import com.gehc.apps.demo.dablog.model.user.UnknownUserException;
import com.gehc.apps.demo.dablog.model.user.User;
import com.gehc.apps.demo.dablog.model.user.UserRepository;
import com.gehc.apps.demo.dablog.services.DataSetReader;

/**
 * Unit testing for UserRepository specific method.
 * 
 * 
 * @author Frédéric Delorme
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DaBlogApp.class)
@WebIntegrationTest(randomPort = true)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepo;

	@Autowired
	DataSetReader<User> dsr;

	@Before
	public void setUp() throws Exception {
		dsr.importData("dataset/user.json", false, true);
	}

	@Test
	public void test_1_FindByUsername() {
		User user = userRepo.findByUsername("user1");
		assertEquals("'user1' has not been found from test set.", "user1firstname", user.getFirstname());
	}

	@Test
	public void test_2_Authenticate() {
		assertTrue("'user1' has not been authentified !", userRepo.authenticate("user1", "user1"));
	}

	@Test
	public void test_3_AuthenticateAndLogin() {
		User user;
		try {
			user = userRepo.authenticateAndLogin("user1", "user1");
			assertNotNull(user);
			assertEquals("'user1' has not been authentified !", "user1firstname", user.getFirstname());
		} catch (UnknownUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = UnknownUserException.class)
	public void test_4_AuthenticateAndLoginUnknwonUserException() throws UnknownUserException {
		userRepo.authenticateAndLogin("userX", "userX");
	}

}
