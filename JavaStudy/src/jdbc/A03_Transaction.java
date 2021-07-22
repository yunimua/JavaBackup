package jdbc;

import java.sql.*;

public class A03_Transaction {
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "hr";
		String password = "yuni1212";
		
		String sql1 = "UPDATE coffee SET price=price-5000"; //+ ��� �޴��� ������ 5õ�� ����
		String sql2 = "SELECT count(*) AS m_count FROM coffee "
				+ "WHERE price < 0"; //+ ������ 0���� ������
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			// AutoCommit�� ���� ���� Ʈ���輱�� ������ �� �ִ�
			conn.setAutoCommit(false); //+ ����Ŀ���� ������Ѵ�!
			
			// ù ��° �������� �غ���
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			
			// ù ��° �������� UPDATE���̱� ������ executeUpdate()�� �����ϸ�
			// �� ���̳� ���ߴ��� ���� ������ �˷���
			int update_rows = pstmt.executeUpdate(); //+ �ٲ� ���� �� ���� �˼� ����..
			
			if (update_rows == 0) {
				pstmt.close();
				conn.close(); //+ ������ �̷������ ���� ��� �����Ŵ (������Ʈ ���� ���� ���)
				return; // �޼��� ����
			}else {
				System.out.println(update_rows + "�� ���� �Ϸ�");
			}
			
			// �� ��° �������� �غ���
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			
			// �� ��° �������� SELECT���̱� ������ executeQuery()�� �����ϸ�
			// SELECT ����� ResultSet���� ��ȯ��.
			ResultSet rs = pstmt2.executeQuery();
			
			// rs.next()�� ���� ���� ���� �ִ��� üũ�� �� ���� ���� �ִٸ� Ŀ���� �������� �ű�� �޼���
			rs.next();
			// int minus_rows = rs.getInt(1); //+ count(*)�� ù��° �÷��̱� ������ 1�� ����, oracle�� ù��°�� 0�� �ƴ� 1�̴�
			int minus_rows = rs.getInt("m_count"); //+ AS �̸��� �����ϸ� �̸����� ���� �� �ִ�.
			
			// �׷� �Լ��� ������ �������̶� ����� �� �ุ ���� ���� ���ϱ� ������ �ݺ����� ���� ������� �ʾҴ�.
			if (minus_rows > 0) {
				System.out.println("������ �� ������ �־ ��� �۾��� ����մϴ�.");
				conn.rollback();
			}else {
				System.out.println("������ �� ������ ��� �۾��� Ȯ�������ϴ�.");
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
