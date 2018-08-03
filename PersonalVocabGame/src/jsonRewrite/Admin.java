package jsonRewrite;

public class Admin extends User {
	

	public Admin(String username, String password) {
		super(username, password);
		this.adminPrivileges = true;
		UserDatabase.createUser(username, password, true);	
		UserDatabase.deleteUser(username);
	}
	
	public boolean getAdminStatus() {
		return true;
	}
	
	public void grantAdminPrivileges(User user) {
		user.adminPrivileges = true;
	}
	
	public void revokeAdminPrivileges(User user) {
		user.adminPrivileges = false;
	}
	

	
	
	

}
