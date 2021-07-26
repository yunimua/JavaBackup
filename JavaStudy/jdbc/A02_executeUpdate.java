package jdbc;

import java.sql.*;

public class A02_executeUpdate {

	
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "hr";
		String password = "yuni1212";
		
		// INSERT, UPDATE, DELETE는 실행 결과가 변화한 행의 개수로 나온다.
		// 그래서 A02_executeUpdate() 메서드는 리턴값이 int다.
		String sql = "UPDATE coffee SET price=price+100 WHERE id < 5"; //+ 커피 가격이 100원씩 증가
		String sql2 = "DELETE FROM coffee WHERE price > 3500"; //+ 커피 가격이 3500원 이상인 메뉴 삭제
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn
				= DriverManager.getConnection(url, user, password);
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int rows = pstmt.executeUpdate();
			
			//System.out.println(rows + "줄이 변경되었습니다.");
			System.out.println(rows + "row(s) changed.");
			
			pstmt.close();
			
			// 한번의 연결에 여러개의 구문을 실행 할 수도 있다.
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
