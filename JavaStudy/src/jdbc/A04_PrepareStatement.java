package jdbc;

import java.sql.*;

public class A04_PrepareStatement {
	
	private static String driverName = "oracle.jdbc.driver.OracleDriver"; //+ �ѹ��� ����Ǹ�Ǵ�, static�� ����Ͽ� ������ �� �ִ�
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
		
		// ����� �������� �غ��� �� ������ ���� �������� ?�� �̿��Ѵ�.
		String exploit = "a'; DELETE FROM employees; --"; //+(���Ȼ��� ����) : �����Ͱ� �����ɼ� �ִ�.
		// String keyword = "le";
		
		String user_input = "le";
		String keyword = String.format("%%%s%%", user_input.toLowerCase());
		
		// String sql = "SELECT * FROM employees WHERE first_name='%" + keyword + "%'"; //+ �̷��� ����ϸ� �ȵȴ�.(���Ȼ��� ����)
		
		// String sql = "SELECT * FROM employees WHERE first_name LIKE ?";
		// ?�� ���� SQL Injextion�� ����� �� �ִ�.
		String sql = "SELECT * FROM employees "
				+ "WHERE lower(first_name) LIKE ?";
		
		//+ Auto close�� �Ǵ� ���, close�� ���� �ʾƵ� �ȴ�.
		try(
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			// pstmt�� ?�� ä���
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
