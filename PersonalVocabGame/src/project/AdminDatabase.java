package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDatabase {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/vocabularygame?useSSL=false";
	static final String USER = "root";
	static final String PASS = "password";

	static Connection conn = null;
	static Statement stmt = null;

	static void getWordList() {

		System.out.println("Retrieving list of users:");

		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			String sql2 = "SELECT * FROM word ORDER BY word_id DESC";
			ResultSet rs = stmt.executeQuery(sql2);

			// fetch which values you want for each iteration
			while (rs.next()) {
				String word_name = rs.getString("word_name");
				String word_use_example = rs.getString("word_use_example");
				int set_id = rs.getInt("set_id");
				int synonym_id = rs.getInt("synonym_id");
				System.out.println("Word: " + word_name + "| Use example: " + word_use_example + "| Set number: "
						+ set_id + "| Synonym_id: " + synonym_id); // should probably
				// use a return
				// statement
			}
			rs.close();
			System.out.println();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	static void addWordsIntoSet1(String wordName, String wordUseExample, String synonymID) {

		try {
			stmt = conn.createStatement();
			String sql3 = "INSERT IGNORE word(word_id, word_name, word_use_example, set_id, synonym_id) VAlUES((SELECT max(word_id) FROM(SELECT*FROM word) AS wrd)+1,'"
					+ wordName + "', '" + wordUseExample + "',1," + synonymID + ")";
			stmt.executeUpdate(sql3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Word " + wordName + " has been added to database \n");
	}

	static void deleteWords(String wordName) {

		try {
			stmt = conn.createStatement();
			String sql3 = "DELETE FROM word WHERE word_name=" + "'" + wordName + "'";
			stmt.executeUpdate(sql3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Word " + wordName + " has been deleted from database \n");
	}

	static void getUserList() {

		System.out.println("Retrieving list of users:");

		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			String sql2 = "SELECT * FROM user ORDER BY admin_status DESC";
			ResultSet rs = stmt.executeQuery(sql2);

			// fetch which values you want for each iteration
			while (rs.next()) {
				String username = rs.getString("username");
				boolean admin_status = rs.getBoolean("admin_status");
				System.out.println("username: " + username + ", " + "Admin status: " + admin_status); // should probably
																										// use a return
																										// statement
			}
			rs.close();
			System.out.println();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	static void changeWordExample(String changeTo, String word_name) {

		try {
			stmt = conn.createStatement();
			String sql3 = "UPDATE word SET word_use_example = '" + changeTo + "' WHERE word_name = '" + word_name + "'";
			stmt.executeUpdate(sql3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Use example for '" + word_name + "' changed to '" + changeTo + "'\n");
	}

	static void deleteUser(String username) {

		try {
			stmt = conn.createStatement();
			String sql4 = "DELETE FROM user WHERE username =" + "'" + username + "'";
			stmt.executeUpdate(sql4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Username " + username + " has been deleted from database\n");
	}

	public static void accessDB() {
		// should probably be able to set create,insert,update and delete as separate
		// methods

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}

		// Make a connection

		System.out.println("Connecting to Admin database...");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
