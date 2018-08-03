package jsonRewrite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GeneralDatabase {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/vocabularygame?useSSL=false";
	static final String USER = "root";
	static final String PASS = "password";

	static Connection conn = null;
	static Statement stmt = null;

	public static void databaseStatement(String sqlStatement) {
		accessDB();
		insertCreateDelete(sqlStatement);
		closeDB();

	}

	public static void closeDB() {
		if (stmt != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public static void accessDB() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}

		try {

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void insertCreateDelete(String sqlStatement) {

		try {

			stmt = conn.createStatement();
			String sql4 = sqlStatement;
			stmt.executeUpdate(sql4);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
