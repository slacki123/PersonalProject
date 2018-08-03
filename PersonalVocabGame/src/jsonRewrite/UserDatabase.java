package jsonRewrite;

import java.sql.Connection;
import java.sql.Statement;

public class UserDatabase {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/vocabularygame?useSSL=false";
	static final String USER = "root";
	static final String PASS = "password";

	static Connection conn = null;
	static Statement stmt = null;

	public static void deleteUser(String username) {
		
		String sqlStatement = "DELETE FROM user WHERE username = '" + username + "';";
		GeneralDatabase.databaseStatement(sqlStatement);
	}
	
	public static void createUser(String username, String password, boolean adminPrivileges) {
		
		String sqlStatement = "INSERT INTO user(username, password, admin_status) VALUES ('" + username + "','"
				+ password + "'," + adminPrivileges + ");";
		
		GeneralDatabase.databaseStatement(sqlStatement);
		
	}

}
