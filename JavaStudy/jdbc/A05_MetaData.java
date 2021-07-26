package jdbc;

import java.sql.*;

public class A05_MetaData {

	public static void main(String[] args) {
		
		// SELECT������ ������ ResultSet���� ResultSetMetaData�� ���� �� �ְ�
		// ResultSetMataData Ŭ������ ������ �����͵��� ��Ÿ�����͸� �� �� �ִ�.
		
		String sql1 = "SELECT * "
//				+ "employee_id, "
//				+ "job_id, "
//				+ "department_id "
				+ "FROM employees";
		String sql2 = "SELECT * FROM coffee";
		
		try(
			Connection conn = DBConnector.getConnection(); //+ DBConnector���� �����ͼ� ����
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			ResultSet rs1 = pstmt1.executeQuery();
			ResultSet rs2 = pstmt2.executeQuery();		
		){
			 ResultSetMetaData meta1 = rs1.getMetaData();
			 
			 System.out.println("Employees ���̺��� ����");
			 System.out.println("�÷��� ����: " + meta1.getColumnCount() + "��");
			 
			 int MAX_COLUMN = meta1.getColumnCount();
			 
			 for (int col = 1; col <= MAX_COLUMN; ++ col) {
				 System.out.printf("%-20s%-14s%-25s\n", 
						 meta1.getColumnName(col), 
						 meta1.getColumnTypeName(col),
						 meta1.getColumnClassName(col)
						 );
			 }
			 
			 // �������� : meta2�� ����غ�����
			 
			 ResultSetMetaData meta2 = rs2.getMetaData();
			 			 
			 int MAX_COLUMN_CHK = meta2.getColumnCount();
			 System.out.println("coffee ���̺��� ����");
			 System.out.println("�÷��� ����: " + MAX_COLUMN_CHK + "��");
			 
			 for (int col = 1; col <= MAX_COLUMN_CHK; ++ col) {
				 System.out.printf("%-15s%-15s%-25s\n", 
						 meta2.getColumnName(col), 
						 meta2.getColumnTypeName(col),
						 meta2.getColumnClassName(col)
						 );
			 }
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
