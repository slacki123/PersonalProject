package jsonRewrite;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabase extends GeneralDatabase {

	public static void getUserList() {
		accessDB();	
		try {
			String sqlCreateStatement = "SELECT * FROM user ORDER BY admin_status DESC";
			ResultSet rs = databaseCreateStatement(sqlCreateStatement);	
			while (rs.next()) {
				String username = rs.getString("username");
				boolean adminPrivileges = rs.getBoolean("admin_status");	
				System.out.println("Username: " + username + ", " + "Admin Status: " + adminPrivileges);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}

	public static void deleteUser(String username) {
		String sqlStatement = "DELETE FROM user WHERE username = '" + username + "';";
		databaseStatement(sqlStatement);
	}
	public static void createUser(String username, String password, boolean adminPrivileges) {
		String sqlStatement = "INSERT INTO user(username, password, admin_status) VALUES ('" + username + "','"
				+ password + "'," + adminPrivileges + ");";
		databaseStatement(sqlStatement);
	}

}
