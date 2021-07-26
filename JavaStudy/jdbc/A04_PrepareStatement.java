package jdbc;

import java.sql.*;

public class A04_PrepareStatement {
	
	private static String driverName = "oracle.jdbc.driver.OracleDriver"; //+ 한번만 실행되면되니, static을 사용하여 만들어둘 수 있다
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
	
	public static void main(String[] args) {
		
		// 사용할 쿼리문을 준비할 때 변수를 넣을 지리에는 ?를 이용한다.
		String exploit = "a'; DELETE FROM employees; --"; //+(보안상의 이유) : 데이터가 삭제될수 있다.
		// String keyword = "le";
		
		String user_input = "le";
		String keyword = String.format("%%%s%%", user_input.toLowerCase());
		
		// String sql = "SELECT * FROM employees WHERE first_name='%" + keyword + "%'"; //+ 이렇게 사용하면 안된다.(보안상의 이유)
		
		// String sql = "SELECT * FROM employees WHERE first_name LIKE ?";
		// ?를 쓰면 SQL Injextion을 방어할 수 있다.
		String sql = "SELECT * FROM employees "
				+ "WHERE lower(first_name) LIKE ?";
		
		//+ Auto close가 되는 방식, close를 하지 않아도 된다.
		try(
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			// pstmt의 ?를 채운다
			pstmt.setString(1, keyword);
			
			try(
				ResultSet rs = pstmt.executeQuery();	
			) {
				while(rs.next()) {
					System.out.printf("%-6d%-14s%-20s\n",
							rs.getInt("employee_id"),
							rs.getString("first_name"),
							rs.getString("job_id"));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
