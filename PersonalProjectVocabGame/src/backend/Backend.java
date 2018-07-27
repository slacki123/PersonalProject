package backend;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Backend {

	static LinkedList<String> answers = new LinkedList<String>(); // better name would be answer choices
	Random rand = new Random();
	static int correctAnswers;
	static int wrongAnswers;
	static int totalAnswers;
	static int synonymID;
	static String corAnswer;
	static String questionWord;
	static boolean accessGranted;
	
	static Scanner sc = new Scanner(System.in);
	
	public static void gameIntro() {
		while(accessGranted==false) {
		System.out.println("Welcome to vocabulary game! Please enter your username below to log in");
		System.out.print(">");
		String username = sc.nextLine(); // might be the reason for errors
		
		try {
		String user = Database.fetchUsername(username);
		}
		catch(NullPointerException e) {
		
//		if(user.equals(null)) { //IF user doesn't exist...
			System.out.println("User not found. Please create a new user by typing in a user name");
			String userName = sc.nextLine();
			System.out.println("Choose your password");
			String password = sc.nextLine();
			System.out.println("Type in your email");
			String email = sc.nextLine();
			Database.createUser(userName, password, email);
//		}
		}
		
		if (username.equals(user)) {
			System.out.println("User correct: Type in your password below");
			accessGranted = true;
			
		}}
		
	}

	public static void startRound(int set_id) {
		// chose your words set scanner input 1/2/3/4
		for (int j = 0; j < 5; j++) {

			// please select your set 'input' above for loop
			questionWord = Database.accessAndReadFirstWord(set_id); // RandomfetchDB, where id is 'rand num' and set
			// is 'input'"
			synonymID = Database.synonym_id;
			// remove that word from database?

			System.out.println("Your new word is '" + questionWord + "'");

			System.out.println("Type in one of the synonyms below");

			while (answers.size() < 3) {

				String wrongQuestionWord = Database.readNextWrongWords(set_id); // "Db fetch where id is 'nextrand num'
																				// and
				// set is 'input' and synononym id NOT
				if (!answers.contains(wrongQuestionWord)) {

					answers.add(wrongQuestionWord);
				}

			}

			while (answers.size() < 4) {

				corAnswer = Database.readNextCorrectWord(1);

				if (!questionWord.equals(corAnswer)) {

					answers.add(corAnswer);
				}
			}

			Collections.shuffle(answers);
			for (String a : answers) {
				System.out.println("-" + a);
			}

			Scanner sc = new Scanner(System.in);
			System.out.print(">");
			String input = sc.nextLine();
			totalAnswers++;

			if (input.equals(corAnswer)) {
				System.out.println("\nCorrect! \n");
				correctAnswers++;
			} else {
				System.out.println("\nWrong");
				System.out.println("The correct answer is " + corAnswer + "\n");
				wrongAnswers++;
			}
			answers.clear();
		}
		System.out.println("Round over, you got " + correctAnswers + " correct and " + wrongAnswers
				+ " answers wrong out of total " + totalAnswers);

		Database.close();

	}
}
