package jdbc.quiz;

import java.sql.*;

public class A04_SQLInjection {

	// coffee 테이블에 SQLInjection을 공격을 성공시켜보세요.
	// (일부러 ?를 사용하지 않아야 함)
	
	// 프로그램의 기본 동작은 가격이 원하는 가격대의 커피를 조회하는 기능입니다.
	// 프로그램의 원래 동작은 사용자가 원하는 id의 커피를 삭제하는 동작이다
	
	private static String driverName = "oracle.jdbc.driver.OracleDriver"; 
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
		//+ 내가 푼거
		//+ price_chk_st("3000", "4000");
/*		
		//+ 강사님이 시도한거, 어짜피 2개가 실행되지 않음을 확인함
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "hr";
		String password = "yuni1212";

		// DELETE FROM coffee WHERE id =1 or 1=1
		String id = "3";
		
		String sql = "DELETE FROM coffee WHERE id =" + id;
		
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				// PreparedStatement의 구버전 (보안상 문제가 있는 버전)
				Statement statement = conn.createStatement();
				int rows = statement.executeUpdate(sql);
				
				System.out.println("done.");
				//pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
*/
	}
	
	public static void price_chk_int(int check1, int check2) {
		
		String sql = "SELECT * FROM coffee "
				+ "WHERE price >="+ check1 + "AND price <=" + check2;
		
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				
				
				try(
					ResultSet rs = pstmt.executeQuery();	
				) {
					while(rs.next()) {
						System.out.printf("%-10s%-6d\n",
								rs.getString("name"),
								rs.getInt("price"));
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void price_chk_st(String check1, String check2) {
		
		String sql = "SELECT * FROM coffee "
				+ "WHERE price >="+ check1 + " AND price <=" + check2;
		
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				try(
					ResultSet rs = pstmt.executeQuery();	
				) {
					while(rs.next()) {
						System.out.printf("%-10s%-6d\n",
								rs.getString("name"),
								rs.getInt("price"));
					}
				}		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
