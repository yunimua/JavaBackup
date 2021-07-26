package jdbc.quiz;

import java.sql.*;

public class A04_SQLInjection {

	// coffee ���̺� SQLInjection�� ������ �������Ѻ�����.
	// (�Ϻη� ?�� ������� �ʾƾ� ��)
	
	// ���α׷��� �⺻ ������ ������ ���ϴ� ���ݴ��� Ŀ�Ǹ� ��ȸ�ϴ� ����Դϴ�.
	// ���α׷��� ���� ������ ����ڰ� ���ϴ� id�� Ŀ�Ǹ� �����ϴ� �����̴�
	
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
		//+ ���� Ǭ��
		//+ price_chk_st("3000", "4000");
/*		
		//+ ������� �õ��Ѱ�, ��¥�� 2���� ������� ������ Ȯ����
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
				// PreparedStatement�� ������ (���Ȼ� ������ �ִ� ����)
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
