package jdbc;

import java.sql.*;
import java.util.*;

import jdbc.model.*;

public class A07_DataModelClass {
	
	public static void main(String[] args) {
		
		// DB���� ������ �����ʹ� �����͸� Ŭ������ �־� �δ� ���� ����.
		
		// A06_HikariCP�� ������ ���� ����� �� �ִ�
		// getConnection() �޼��带 ������ �� coffee ���̺��� ���� �ֿܼ� ��� ����غ�����.
		
		String sql = "SELECT * FROM coffee";
		
		// ������ Ŭ������ ���׸����� Ȱ���� �پ��� �÷����� ���� �̿��� �� �ִ�
		ArrayList<Coffee> list = new ArrayList<>();
		try(
			Connection conn = A06_HikariCP.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			ResultSetMetaData meta = rs.getMetaData();
			
			// 1. �켱 �÷� �̸����� ã�´�
			
//			Class<?> coffee_class = Class.forName("jdbc.model.Coffee");
//			
//			coffee_class.getMethod("setName").invoke(coffee_class, null);
			
			while(rs.next()) {
				list.add(new Coffee(rs.getInt("id"), rs.getString("name"), rs.getInt("price")));
				// 2. ������ Ŭ������ �÷� �̸��� ��ġ�ϴ� �ʵ忡 ���� ä�� �ִ´�. //+ �ּ�ó���ѰͰ� �̾����� �������� ����
				
			}
			
			System.out.println(list); //+ Ŀ�� �ν��Ͻ� ������ŭ ���´�.
			
			//+ �̰� ���� ������
//			ResultSetMetaData meta = rs.getMetaData();
//        	
//    		int COLUMN_SIZE = meta.getColumnCount();
//    		
//    		while(rs.next()) {
//    			for(int i =1; i <= COLUMN_SIZE; ++i) {
//    				System.out.printf("%-10s\t", rs.getObject(i));
//    			}
//    			System.out.println();
//    		}

		    }catch (SQLException e) {
				e.printStackTrace();
			} //catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
	}
}
