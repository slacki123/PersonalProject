package project;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	static LinkedList<String> answers = new LinkedList<String>(); // better name would be answer choices
	Random rand = new Random();
	static int correctAnswers;
	static int wrongAnswers;
	static int totalAnswers;
	static int synonymID;
	static String corAnswer;
	static String questionWord;
	static int currentSet;
	static Scanner sc = new Scanner(System.in);

	public static void adminMenu() {

		System.out.println(
				"The admin activities are: \n-add words \n-get word list  \n-change words \n-delete words \n-get user list \n-delete user \nOr type anything to exit to menu");
		System.out.print("> ");
		String userIn = sc.nextLine();
		if (userIn.equalsIgnoreCase("add words")) {
			System.out.print("Word name: ");
			String wordName = sc.nextLine();
			System.out.print("use example: ");
			String wordUseExample = sc.nextLine();

			System.out.println("To add to set 1. synonym_id's are 1-artificial, 2-destroy, 3-obnoxious");
			System.out.print("Synonym id: ");
			String synonym_id = sc.nextLine();

			AdminDatabase.addWordsIntoSet1(wordName, wordUseExample, synonym_id);
			adminMenu();
		} else if (userIn.equalsIgnoreCase("change words")) {

			System.out.print("Of which word, the use example you want to change: ");
			String word_name = sc.nextLine();
			System.out.print("What you want to change it to: ");
			String changeTo = sc.nextLine();

			AdminDatabase.changeWordExample(changeTo, word_name);
			adminMenu();

		}

		else if (userIn.equalsIgnoreCase("delete words")) {

			System.out.print("Word you want to delete: ");
			String wordName = sc.nextLine();

			AdminDatabase.deleteWords(wordName);
			adminMenu();

		}

		else if (userIn.equalsIgnoreCase("get user list")) {

			AdminDatabase.getUserList();
			adminMenu();
		}

		else if (userIn.equalsIgnoreCase("delete user")) {

			System.out.print("Username you want to delete: ");
			String username = sc.nextLine();

			AdminDatabase.deleteUser(username);
			adminMenu();
		} else if (userIn.equalsIgnoreCase("get word list")) {
			AdminDatabase.getWordList();
			adminMenu();

		} else {

			menu();
		}
	}

	public static void menu() {

		System.out.println("What would you like to do? type these to either \n-Select set\n-Change user\n");
		// bunch of if statements
		if (GameDatabase.fetchAdminStatus(LogIn.loggedInUsername)) { // if admin status is true
			System.out.println("For admin actions type in \n-Admin\n");
		}

		System.out.print("> ");
		String userIn = sc.nextLine();

		if (userIn.equalsIgnoreCase("select set")) {
			selectSet();

		}

		else if (userIn.equalsIgnoreCase("change user")) {
			LogIn.accessGranted=false;
			LogIn.logIn();

		} else if (userIn.equalsIgnoreCase("admin")) {
			if (GameDatabase.fetchAdminStatus(LogIn.loggedInUsername)) {
				adminMenu();
			} else {
				System.out.println("You do not have admin privileges \n");
				menu();
			}

		} else System.out.println("Input not recognised.");

	}


	public static void selectSet() {
		System.out.println("Choose the set number. Your only available set number is: set 1");
		System.out.print("> ");
		String selectSet = sc.nextLine();
		int set = Integer.parseInt(selectSet);
		System.out.println("You have selected set " + set + "\n");
		
		startRound(set);

	}

	public static void startRound(int set_id) {
		// chose your words set scanner input 1/2/3/4
		for (int j = 0; j < 5; j++) {

			// please select your set 'input' above for loop
			questionWord = GameDatabase.accessAndReadFirstWord(set_id); // RandomfetchDB, where id is 'rand num' and set
			// is 'input'"
			synonymID = GameDatabase.synonym_id;
			// remove that word from database?

			System.out.println("Your new word is '" + questionWord + "'");

			System.out.println("Type in one of the synonyms below");

			while (answers.size() < 3) {

				String wrongQuestionWord = GameDatabase.readNextWrongWords(set_id); // "Db fetch where id is 'nextrand num'
																				// and
				// set is 'input' and synononym id NOT
				if (!answers.contains(wrongQuestionWord)) {

					answers.add(wrongQuestionWord);
				}

			}

			while (answers.size() < 4) {

				corAnswer = GameDatabase.readNextCorrectWord(1);

				if (!questionWord.equals(corAnswer)) {

					answers.add(corAnswer);
				}
			}

			Collections.shuffle(answers);
			for (String a : answers) {
				System.out.println("-" + a);
			}

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
				+ " answers wrong out of total " + totalAnswers + "\n");
		// Unlock next set "set this+1 has been unlocked

//		Database.close();

	}

}
