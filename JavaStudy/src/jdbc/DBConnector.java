package jdbc;

import java.sql.*;

public class DBConnector {

	private static String driverName = "oracle.jdbc.driver.OracleDriver"; 
	private static String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private static String user = "hr";
	private static String password = "yuni1212";
	
	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
