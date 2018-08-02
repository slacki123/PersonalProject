package project;



public class Main {
	

	public static void main(String[] args) {
		GameDatabase.accessDB();
		AdminDatabase.accessDB();
		LogIn.logIn();
		while(LogIn.accessGranted==true) {
		
		Game.menu();}
//		Backend.selectSet();
		
	}

}
