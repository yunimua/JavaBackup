package jdbc;

import java.sql.*;

public class A01_JdbcConnection {

	/*
		# JDBC
		  - Java Database Connectivity. �ڹ� �����ͺ��̽� ����
		  - DB�� �������� �����Ͽ� �����ϰ� ����� �޾ƿ��� Java API
		  - �پ��� ������ DB�� ����� �� �ֵ��� ����Ǿ� �ִ�
		  - Java�� �ҽ��ڵ�� � DB�� �����ϴ��� �׻� �����ϴ�.
		  - DB�� ������ �ʿ��� JDBC���� �䱸�ϴ� ���¿� ���缭 �ڹٿ��� ������
		  	�����ϱ� ������ �ڹ� ���α׷��ӵ��� ���ο� DB�� ���� ����� �� �ִ�
		
		# OJDBC
		  - ����Ŭ �����ͺ��̽��� JDBC API�� �����ϱ� ���� ���� ���̺귯��
		  - ����ŬDB�� ��ġ�� ���� ���ο� ���ԵǾ� �ִ�
	*/
	// C:\JavaStudy\oracle\sqldeveloper\jdbc\lib : �ش� ������ �ִ� ������ �߰��ؾ��Ѵ� > libraries��..
	
	public static void main(String[] args) {
		
		// 1. Class.foname()���� jdbc����̹��� �ε��Ѵ�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("�ش� ���̺귯���� ã�� �� ����");
		}
		// 2. DriverManager Ŭ������ ���� DB�� �����Ѵ�.
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1",
					"hr",
					"yuni1212"
			);
			/*
				3. ������ ���� ��ü�� �����ϰ��� �ϴ� �������� �Ǿ���´�.
				�� �������� ;�� ������ ������� �ʴ´�
			*/
			String sql = "SELECT employee_id, last_name, salary, department_name " //+ ������ ���� �ݵ���ʿ�!!
					+ "FROM employees INNER JOIN departments USING (department_id) "
					+ "ORDER BY employee_id ASC";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
//			PreparedStatement pstmt
//			 = conn.prepareStatement("SELECT * FROM employees");
			/*
				4. �غ��س��� �������� �����Ѵ�
					SELECT���� executeQuery() �޼��带 ����ؾ� �ϰ�
					INSERT, UPDATE, DELETE�� executeUpdate() �޼��带 ����ؾ� �Ѵ�
			*/
			ResultSet rs = pstmt.executeQuery();
			
			// 5. �޾ƿ� ���� ����� ����Ѵ�.
			while (rs.next()) { //+ �������� ������ �ϳ��� �����鼭 ����ȴ�
				System.out.printf("%-10d%-15s%-8d%s\n",
						rs.getInt("employee_id"),
						rs.getString("last_name"),
						rs.getInt("salary"),
						rs.getString("department_name")); //+ ����ȵ�, Ȯ���ʿ�!!
			}
			// 6. �� ����� ������ ���߿� �� ������� �ݾ��ش�.
			rs.close();
			pstmt.close();
			conn.close();
			//+ �ݾƵ��� ������ �޸𸮰� ����!
			
		} catch (SQLException e) {
			System.out.println("getConnection �ϴٰ� ���� ����");
		}
		System.out.println("main ��");
	}
}
