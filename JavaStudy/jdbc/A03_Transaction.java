package jdbc;

import java.sql.*;

public class A03_Transaction {
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "hr";
		String password = "yuni1212";
		
		String sql1 = "UPDATE coffee SET price=price-5000"; //+ 모든 메뉴의 가격을 5천원 차감
		String sql2 = "SELECT count(*) AS m_count FROM coffee "
				+ "WHERE price < 0"; //+ 가격이 0보다 작은것
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			// AutoCommit을 꺼야 직접 트랜잭선을 관리할 수 있다
			conn.setAutoCommit(false); //+ 오토커밋을 꺼줘야한다!
			
			// 첫 번째 쿼리문을 준비함
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			
			// 첫 번째 쿼리문은 UPDATE문이기 때문에 executeUpdate()를 실행하면
			// 몇 행이나 변했는지 리턴 값으로 알려줌
			int update_rows = pstmt.executeUpdate(); //+ 바뀐 행의 줄 수를 알수 있음..
			
			if (update_rows == 0) {
				pstmt.close();
				conn.close(); //+ 변경이 이루어지지 않을 경우 종료시킴 (업데이트 되지 않은 경우)
				return; // 메서드 종료
			}else {
				System.out.println(update_rows + "줄 변경 완료");
			}
			
			// 두 번째 쿼리문을 준비함
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			
			// 두 번째 쿼리문은 SELECT문이기 때문에 executeQuery()로 실행하면
			// SELECT 결과가 ResultSet으로 반환됨.
			ResultSet rs = pstmt2.executeQuery();
			
			// rs.next()는 다음 읽을 값이 있는지 체크한 후 읽을 값이 있다면 커서를 다음으로 옮기는 메서드
			rs.next();
			// int minus_rows = rs.getInt(1); //+ count(*)가 첫번째 컬럼이기 때문에 1을 넣음, oracle은 첫번째가 0이 아닌 1이다
			int minus_rows = rs.getInt("m_count"); //+ AS 이름을 지정하면 이름으로 넣을 수 있다.
			
			// 그룹 함수를 적용한 쿼리문이라 결과가 한 행만 나올 것이 뻔하기 때문에 반복문을 궅이 사용하지 않았다.
			if (minus_rows > 0) {
				System.out.println("음수가 된 가격이 있어서 모든 작업을 취소합니다.");
				conn.rollback();
			}else {
				System.out.println("음수가 된 가격이 없어서 작업을 확정짓습니다.");
				conn.commit();
			}
			
			rs.close();
			pstmt2.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
