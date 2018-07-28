package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/vocabularygame?useSSL=false";
	static final String USER = "root";
	static final String PASS = "password";

	static Connection conn = null;
	static Statement stmt = null;
	
	static int synonym_id;
	

	
	public static boolean fetchAdminStatus(String username) {
		
		try {
			stmt = conn.createStatement();
			String sql2 = "SELECT admin_status FROM user WHERE username= " + "'" + username + "'";
			ResultSet rs = stmt.executeQuery(sql2);

			// fetch which values you want for each iteration
			while (rs.next() ) {
		
				boolean admin_status = rs.getBoolean("admin_status");
				return admin_status;
				}
		
			rs.close(); // If not closed, then it will print all the results in the table

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		
		return (Boolean) null;
		
	}
	
	public static String fetchPassword(String username) {
		
		try {
			stmt = conn.createStatement();
			String sql2 = "SELECT password FROM user WHERE username= " + "'" + username + "'";
			ResultSet rs = stmt.executeQuery(sql2);

			// fetch which values you want for each iteration
			while (rs.next() ) {
		
				String password = rs.getString("password");
				return password;
				}
		
			rs.close(); // If not closed, then it will print all the results in the table

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		
		return null;
		
	}

	
	public static void createUser(String username, String password) {
		// Insert records, create a separate create for each database table

		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "INSERT INTO user(username, password, admin_status) VALUES ('" + username + "','"+password+"', false);";
		try {
			stmt.executeUpdate(sql);
			System.out.println("User with user name " + username + " created");
		} catch (SQLException e) {
			System.out.println("Username with name " + username + " has already been taken");
		}
		

		// Read Records
	}
		
	
	public static String fetchUsername(String userIn) {
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			String sql2 = "SELECT * FROM user WHERE username= " + "'" + userIn+ "'";
			ResultSet rs = stmt.executeQuery(sql2);

			// fetch which values you want for each iteration
			while (rs.next() ) {
		
				String username = rs.getString("username");
				return username;
				}
		
			rs.close(); // If not closed, then it will print all the results in the table

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		
		return null;
		
	}

	public static String readNextCorrectWord(int set_id) {
		// should probably be able to set create,insert,update and delete as separate
		// methods

		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			String sql2 = "SELECT word_name, synonym_id FROM word WHERE set_id =" + set_id + " and synonym_id = " + Backend.synonymID + " ORDER BY RAND() limit 1";
			ResultSet rs = stmt.executeQuery(sql2);

			// fetch which values you want for each iteration
			while (rs.next()) {
		
				String word_name = rs.getString("word_name");
				synonym_id = rs.getInt("synonym_id");
				return word_name;
				}
		
			rs.close(); // If not closed, then it will print all the results in the table

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return null;

	}
	
	
	public static String readNextWrongWords(int set_id) {
		// should probably be able to set create,insert,update and delete as separate
		// methods



		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			String sql2 = "SELECT word_name, synonym_id FROM word WHERE set_id =" + set_id + " and synonym_id != " + Backend.synonymID + " ORDER BY RAND() limit 1";
			ResultSet rs = stmt.executeQuery(sql2);

			// fetch which values you want for each iteration
			while (rs.next()) {
		
				String word_name = rs.getString("word_name");
				synonym_id = rs.getInt("synonym_id");
				return word_name;
				}
		
			rs.close(); // If not closed, then it will print all the results in the table

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return null;

	}
	
	public static String accessAndReadFirstWord(int set_id) {
		// should probably be able to set create,insert,update and delete as separate
		// methods


		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			String sql2 = "SELECT word_name, synonym_id FROM word WHERE set_id =" + set_id + " ORDER BY RAND() limit 1";
			ResultSet rs = stmt.executeQuery(sql2);

			// fetch which values you want for each iteration
			while (rs.next()) {
		
				String word_name = rs.getString("word_name");
				synonym_id = rs.getInt("synonym_id");
				return word_name;
				}
		
			rs.close(); // If not closed, then it will print all the results in the table

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return null;

	}
	

	

	public static void accessDB() {
		// should probably be able to set create,insert,update and delete as separate
		// methods

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

//			e1.printStackTrace();
		}

		// Make a connection

		System.out.println("Connecting to Database database...");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {

//			e.printStackTrace();
		}
	}

	public static void create() {
		// Insert records, create a separate create for each database table

		System.out.println("Inserting records into the table...");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "INSERT INTO city(ID, Name, CountryCode, District, Population) VALUES (99999, 'Java', 'A', 'Java', 1992)";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inserted records into the table...");

		// Read Records
	}

	public static void read() {

		System.out.println("Creating statement and reading records...");

		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			String sql2 = "SELECT * FROM city WHERE name='Herat'";
			ResultSet rs = stmt.executeQuery(sql2);

			// fetch which values you want for each iteration
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String CountryCode = rs.getString("CountryCode");
				int population = rs.getInt("Population");
				System.out.println("ID: " + id + ", name: " + name + ", Country code: " + CountryCode + ", population: "
						+ population); // should probably use a return statement
			}
			rs.close(); // If not closed, then it will print all the results in the table

		} catch (SQLException e2) {
			e2.printStackTrace();
		}

	}

	public static void update() {

		System.out.println("Creating statement...");
		try {
			stmt = conn.createStatement();
			String sql3 = "UPDATE Languages SET date = 1994 WHERE id in (1, 2)";
			stmt.executeUpdate(sql3);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void delete() {
		System.out.println("Creating statement...");
		try {
			stmt= conn.createStatement();
			String sql4 = "DELETE FROM Languages ”+ “WHERE id = 1";
			stmt.executeUpdate(sql4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close() {

		if (stmt != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Closing database. Goodbye!");
	}
	
	
	
}