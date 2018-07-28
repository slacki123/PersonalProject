package backend;

import java.util.Scanner;

public class LogIn {

	static boolean accessGranted;
	static String loggedInUsername;

	static Scanner sc = new Scanner(System.in);

	public static void logIn() {

		System.out.println("Welcome to vocabulary game! Please enter your username below to log in");
		System.out.print(">");
		String usernameInput = sc.nextLine(); // might be the reason for errors

		while (accessGranted == false) {

			try {

				String fetchedUser1 = Database.fetchUsername(usernameInput);

				if (usernameInput.equals(fetchedUser1)) {
					
					logInUsernameFound(usernameInput);
					
				} else {
					System.out.println("User not recognised. Please try again or type 'register' to create an account");
					String input = sc.nextLine();

					String fetchedUser2 = Database.fetchUsername(input);

					if (input.equalsIgnoreCase("register")) {
						System.out.println("Please create a new user by typing in a user name");
						String userName = sc.nextLine();
						System.out.println("Choose your password");
						String password = sc.nextLine();
						
						Database.createUser(userName, password);
					} else {
						if (input.equals(fetchedUser2)) {
							
							logInUsernameFound(input);
						}
					}
				}
			} catch (Exception e) {

				System.out.println("User not found.");
			}
		}
	}

	public static void logInUsernameFound(String usernameInput) {

		System.out.println("User found: Type in your password below");
		String passwordInput = sc.nextLine();

		String fetchedPassword = Database.fetchPassword(usernameInput);

		if (passwordInput.equals(fetchedPassword)) {
			accessGranted = true;
			loggedInUsername = usernameInput;

			System.out.println("\nLog-in successful!\n");
			
			System.out.println("Logged-in as: " + LogIn.loggedInUsername);
			System.out.println("Admin privileges: " + Database.fetchAdminStatus(LogIn.loggedInUsername) + "\n");

		}

		while (!passwordInput.equals(fetchedPassword)) {
			System.out.println("Incorrect password. Try again or type 'back' to return to change your username");

			passwordInput = sc.nextLine();

			if (passwordInput.equalsIgnoreCase("back")) {
				logIn();
			}

			else if (passwordInput.equals(fetchedPassword)) {
				accessGranted = true;

				System.out.println("\nLog-in successful!\n");
				loggedInUsername = usernameInput;
				System.out.println("Logged-in as: " + LogIn.loggedInUsername);
				System.out.println("Admin privileges: " + Database.fetchAdminStatus(LogIn.loggedInUsername) + "\n");

			}

		}

	}

}
