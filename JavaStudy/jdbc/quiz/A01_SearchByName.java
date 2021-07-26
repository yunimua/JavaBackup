package jdbc.quiz;

import java.sql.*;

public class A01_SearchByName {

	/*
		# ����ڷκ��� ���ڿ��� �Է¹����� �ش� ���ڿ��� �̸��� ���Ե�
		  ��� ����� ��ȸ�غ�����.
		  (��ҹ��� �������� ��� �˻��Ǿ�� ��.)
	*/
	static Connection conn = null;
	
	public static void main(String[] args) {
		
		lib_join();
		name_chk("le");

	}
	
	public static void lib_join() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("�ش� ���̺귯���� ã�� �� ����");
		}
	}
	
	public static void name_chk(String text) {
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1",
					"hr",
					"yuni1212"
			);
			
			String upperStr = text.toUpperCase();
			String name = "SELECT * "
					+ "FROM employees INNER JOIN departments USING (department_id) "
					+ "WHERE UPPER(first_name) LIKE '%" + upperStr +"%' " 
					+ "ORDER BY employee_id ASC";
			
			PreparedStatement pstmt = conn.prepareStatement(name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { 
				System.out.printf("%-15s\n", rs.getString("first_name")); 
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("getConnection �ȵ�");
		}
		
		System.out.println("���� ��");
	}
}

