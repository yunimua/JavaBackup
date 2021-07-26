package jdbc.quiz;

import java.sql.*;

public class A01_SearchByName {

	/*
		# 사용자로부터 문자열을 입력받으면 해당 문자열이 이름에 포함된
		  모든 사원을 조회해보세요.
		  (대소문자 구문없이 모두 검색되어야 함.)
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
			System.out.println("해당 라이브러리를 찾을 수 없음");
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
			System.out.println("getConnection 안됨");
		}
		
		System.out.println("실행 끝");
	}
}

