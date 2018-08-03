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
		//Deletes existing user in database and creates new with the new admin rights
//		UserDatabase.deleteUser(user.getUsername());
		user.adminPrivileges = true;
		
		//Consider creating a new user class to avoid adding deleteUser to every method
	}
	
	public void revokeAdminPrivileges(User user) {
		//Deletes existing user in database and creates new with the new admin rights
//		UserDatabase.deleteUser(user.getUsername());
		user.adminPrivileges = false;
		
		// I think i need to fetch database where username is that username
		
		
	}
	
	public void getUserList() {
	UserDatabase.getUserList();
	}
	

}
