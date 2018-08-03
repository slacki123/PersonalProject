package backend;

public class Main {
	
	public static void main(String[] args) {
		Database.accessDB();
		Admin.accessDB();
		LogIn.logIn();
		
		while(LogIn.accessGranted==true) {
		
		Backend.menu();}
//		Backend.selectSet();
		
	}

}
