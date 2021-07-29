package jdbc;

import java.sql.*;

public class A05_MetaData {

	public static void main(String[] args) {
		
		// SELECT문으로 가져온 ResultSet에서 ResultSetMetaData를 얻을 수 있고
		// ResultSetMataData 클래스로 가져온 데이터들의 메타데이터를 볼 수 있다.
		
		String sql1 = "SELECT * "
//				+ "employee_id, "
//				+ "job_id, "
//				+ "department_id "
				+ "FROM employees";
		String sql2 = "SELECT * FROM coffee";
		
		try(
			Connection conn = DBConnector.getConnection(); //+ DBConnector에서 꺼내와서 쓴다
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			ResultSet rs1 = pstmt1.executeQuery();
			ResultSet rs2 = pstmt2.executeQuery();		
		){
			 ResultSetMetaData meta1 = rs1.getMetaData();
			 
			 System.out.println("Employees 테이블의 정보");
			 System.out.println("컬럼의 개수: " + meta1.getColumnCount() + "개");
			 
			 int MAX_COLUMN = meta1.getColumnCount();
			 
			 for (int col = 1; col <= MAX_COLUMN; ++ col) {
				 System.out.printf("%-20s%-14s%-25s\n", 
						 meta1.getColumnName(col), 
						 meta1.getColumnTypeName(col),
						 meta1.getColumnClassName(col)
						 );
			 }
			 
			 // 연습문제 : meta2도 출력해보세요
			 
			 ResultSetMetaData meta2 = rs2.getMetaData();
			 			 
			 int MAX_COLUMN_CHK = meta2.getColumnCount();
			 System.out.println("coffee 테이블의 정보");
			 System.out.println("컬럼의 개수: " + MAX_COLUMN_CHK + "개");
			 
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
