package jdbc;

import java.sql.*;
import java.util.*;

import jdbc.DBConnector;
import jdbc.model.*;

public class A07_DataJoinModel {

	/*
		employees와 departments를 모두 조인한 결과를 알맞은 모델에 담아 출력 해보세요.
		ResultSet??	
	*/
	
	public static void main(String[] args) {
		
		String sql = "SELECT "
				+ " e.*, "
				+ " d.* , "
				+ " e.manager_id AS mid1, "
				+ " d.manager_id AS mid2"
				+ " FROM employees e, departments d"
				+ " WHERE e.department_id = d.department_id";
		
		ArrayList<Employee> employee_list = new ArrayList<>();
		
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {			
			ResultSetMetaData meta = rs.getMetaData();
			
			for (int i = 1, len = meta.getColumnCount(); i <= len; ++i) {
				System.out.println(meta.getColumnLabel(i));
			}
			
			while(rs.next()) {
				employee_list.add(new Employee(
							rs.getInt("employee_id"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("email"),
							rs.getString("phone_number"),
							rs.getDate("hire_date"),
							rs.getString("job_id"),
							rs.getDouble("salary"),
							rs.getDouble("commision_pct"),
							rs.getInt("mid1"),
							rs.getInt("department_id"),
							new Department(
									rs.getInt("department_id"),
									rs.getString("department_name"),
									rs.getInt("mid2"),
									rs.getInt("location_id")
									)
						));
			}
			System.out.println("잘 꺼냄");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(employee_list);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String sql = "SELECT * FROM employees e, departments d WHERE e.department_id = d.department_id";
//		
//		ArrayList<Employees> list1 = new ArrayList<>();
//		ArrayList<Departments> list2 = new ArrayList<>();
//		
//		try(
//				Connection conn = DBConnector.getConnection(); 
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery();	
//			){
//				ResultSetMetaData meta = rs.getMetaData();
//				 
//				System.out.println("Employees departments Join 결과");
//	    		
//	    		while(rs.next()) {
//					list1.add(new Employees(rs.getInt("employee_id"), rs.getString("first_name"), rs.getString("last_name"), 
//							rs.getString("email"), rs.getString("job_id"), rs.getInt("salary"), rs.getInt("department_id")));
//					list2.add(new Departments(rs.getInt("employee_id"), rs.getString("first_name"), 
//							rs.getInt("salary"), rs.getInt("department_id")));		
//				}
//	    		
//	    		System.out.println(list1);
//	    		
//	    		int COLUMN_SIZE = meta.getColumnCount();
//        		
//        		while(rs.next()) {
//        			for(int i =1; i <= COLUMN_SIZE; ++i) {
//        				System.out.printf("%-20s\t", rs.getObject(i));
//        			}
//        			System.out.println();
//        		}
//	    		
//			}catch (SQLException e) {
//				e.printStackTrace();
//			}
		
	}
}
