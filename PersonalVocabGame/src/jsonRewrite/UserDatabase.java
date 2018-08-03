package jsonRewrite;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabase extends GeneralDatabase {

	public static String getUserList() throws SQLException {
		accessDB();
		String sqlCreateStatement = "SELECT username, adminPrivileges FROM user";
		
		ResultSet rs = databaseCreateStatement(sqlCreateStatement);

		while (rs.next()) {
			String username = rs.getString("username");
			boolean adminPrivileges = rs.getBoolean("admin_status");
			
			return "Username: " + username + ", " + "Admin Status: " + adminPrivileges;
		}
		rs.close();
		
		closeDB();
		return null;

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
