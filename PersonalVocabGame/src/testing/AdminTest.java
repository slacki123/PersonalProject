package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import jsonRewrite.Admin;
import jsonRewrite.User;

public class AdminTest {

	@Test
	public void getAdminStatusTest() {
		User user = new Admin("username", "password");

		assertTrue("User does not have admin status", user.getAdminStatus());

	}

	@Test
	public void getAccessGrantedTest() {
		User admin = new Admin("username", "password");
		admin.setAccessGranted(true);

		assertTrue("Access Not Granted", admin.getAccessGranted());
	}

	@Test
	public void getUsernameTest() {
		User admin = new Admin("username", "password");

		assertEquals("Wrong username", "username", admin.getUsername());
	}

	@Test
	public void getPasswordTest() {
		User admin = new Admin("username", "password");

		assertEquals("Wrong username", "password", admin.getPassword());
	}

	@Test
	public void grantAdminPrivilegesTest() {
		User user = new User("username", "password");
		Admin admin = new Admin("username", "password");

		admin.grantAdminPrivileges(user);

		assertTrue("User has not received admin status", user.getAdminStatus());
	}

	@Test
	public void revokeAdminPrivilegesTest() {
		User user = new User("username", "password");
		Admin admin = new Admin("username", "password");

		admin.grantAdminPrivileges(user);
		admin.revokeAdminPrivileges(user);

		assertFalse("User has not received admin status", user.getAdminStatus());
	}

}