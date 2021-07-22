package jdbc;

import java.sql.*;

public class A02_executeUpdate {

	
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "hr";
		String password = "yuni1212";
		
		// INSERT, UPDATE, DELETE�� ���� ����� ��ȭ�� ���� ������ ���´�.
		// �׷��� A02_executeUpdate() �޼���� ���ϰ��� int��.
		String sql = "UPDATE coffee SET price=price+100 WHERE id < 5"; //+ Ŀ�� ������ 100���� ����
		String sql2 = "DELETE FROM coffee WHERE price > 3500"; //+ Ŀ�� ������ 3500�� �̻��� �޴� ����
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn
				= DriverManager.getConnection(url, user, password);
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int rows = pstmt.executeUpdate();
			
			//System.out.println(rows + "���� ����Ǿ����ϴ�.");
			System.out.println(rows + "row(s) changed.");
			
			pstmt.close();
			
			// �ѹ��� ���ῡ �������� ������ ���� �� ���� �ִ�.
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			
			int deleted_rows = pstmt2.executeUpdate();
			
			System.out.println(deleted_rows + "row(s) deleted.");
			
			pstmt2.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
