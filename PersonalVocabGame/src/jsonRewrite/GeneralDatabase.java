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

	static int synonym_id;

	
	public static void databaseInput(String sqlStatement) {
		accessDB();
		insertCreateDelete(sqlStatement);
		closeDB();

	}

	public static void closeDB() {
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
	}

	public static void accessDB() {
		// should probably be able to set create,insert,update and delete as separate
		// methods

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
			stmt= conn.createStatement();
			String sql4 = sqlStatement;
			stmt.executeUpdate(sql4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
