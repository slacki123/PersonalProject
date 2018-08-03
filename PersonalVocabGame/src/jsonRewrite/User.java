package jsonRewrite;

public class User {

	private String username;
	private String password;
	private boolean accessGranted;
	protected boolean adminPrivileges;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.adminPrivileges = false;
		UserDatabase.createUser(username, password, false);			
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public boolean getAdminStatus() {
		return adminPrivileges;
	}
	
	public void setAccessGranted(boolean bool) {
		this.accessGranted = bool;
	}
	
	public boolean getAccessGranted() {
		return accessGranted;
	}
	
	public void logIn() {
		

	}
	
	
	
	

}
