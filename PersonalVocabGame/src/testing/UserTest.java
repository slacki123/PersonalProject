package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import jsonRewrite.User;

public class UserTest {

	@Test
	public void getAdminStatusTest() {
		User user = new User("username", "password");
		assertFalse("User has admin status", user.getAdminStatus());

	}
	
	@Test
	public void getAccessGrantedTest() {
		User user = new User("username", "password");
		user.setAccessGranted(true);

		assertTrue("Access Not Granted", user.getAccessGranted());
	}
	

}
