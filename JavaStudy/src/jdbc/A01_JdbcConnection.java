package jdbc;

import java.sql.*;

public class A01_JdbcConnection {

	/*
		# JDBC
		  - Java Database Connectivity. 자바 데이터베이스 연결
		  - DB에 쿼리문을 전달하여 실행하고 결과를 받아오는 Java API
		  - 다양한 종류의 DB와 연결될 수 있도록 설계되어 있다
		  - Java쪽 소스코드는 어떤 DB와 연결하더라도 항상 일정하다.
		  - DB를 제작한 쪽에서 JDBC에서 요구하는 형태에 맞춰서 자바와의 연결을
		  	구현하기 때문에 자바 프로그래머들은 새로운 DB도 쉽게 사용할 수 있다
		
		# OJDBC
		  - 오라클 데이터베이스가 JDBC API와 소통하기 위해 만든 라이브러리
		  - 오라클DB가 설치된 폴더 내부에 포함되어 있다
	*/
	// C:\JavaStudy\oracle\sqldeveloper\jdbc\lib : 해당 폴더에 있는 파일을 추가해야한다 > libraries에..
	
	public static void main(String[] args) {
		
		// 1. Class.foname()으로 jdbc드라이버를 로드한다
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 라이브러리를 찾을 수 없음");
		}
		// 2. DriverManager 클래스를 통해 DB에 연결한다.
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1",
					"hr",
					"yuni1212"
			);
			/*
				3. 생성된 연결 객체에 전송하고자 하는 쿼리문을 실어놓는다.
				※ 쿼리문에 ;을 넣으면 실행되지 않는다
			*/
			String sql = "SELECT employee_id, last_name, salary, department_name " //+ 마지막 띄어쓰기 반드시필요!!
					+ "FROM employees INNER JOIN departments USING (department_id) "
					+ "ORDER BY employee_id ASC";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
//			PreparedStatement pstmt
//			 = conn.prepareStatement("SELECT * FROM employees");
			/*
				4. 준비해놓은 쿼리문을 실행한다
					SELECT문은 executeQuery() 메서드를 사용해야 하고
					INSERT, UPDATE, DELETE는 executeUpdate() 메서드를 사용해야 한다
			*/
			ResultSet rs = pstmt.executeQuery();
			
			// 5. 받아온 쿼리 결과를 사용한다.
			while (rs.next()) { //+ 다음것이 있으면 하나씩 꺼내면서 실행된다
				System.out.printf("%-10d%-15s%-8d%s\n",
						rs.getInt("employee_id"),
						rs.getString("last_name"),
						rs.getInt("salary"),
						rs.getString("department_name")); //+ 실행안됨, 확인필요!!
			}
			// 6. 다 사용한 연결을 나중에 연 순서대로 닫아준다.
			rs.close();
			pstmt.close();
			conn.close();
			//+ 닫아두지 않으면 메모리가 터짐!
			
		} catch (SQLException e) {
			System.out.println("getConnection 하다가 문제 생김");
		}
		System.out.println("main 끝");
	}
}
