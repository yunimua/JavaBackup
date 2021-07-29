package jdbc;

import java.sql.*;
import java.util.*;

import jdbc.model.*;

public class A07_DataModelClass {
	
	public static void main(String[] args) {
		
		// DB에서 꺼내온 데이터는 데이터모델 클래스에 넣어 두는 것이 좋다.
		
		// A06_HikariCP에 다음과 같이 사용할 수 있는
		// getConnection() 메서드를 구현한 후 coffee 테이블의 행을 콘솔에 모두 출력해보세요.
		
		String sql = "SELECT * FROM coffee";
		
		// 데이터 클래스를 제네릭으로 활용해 다양한 컬렉션을 쉽게 이용할 수 있다
		ArrayList<Coffee> list = new ArrayList<>();
		try(
			Connection conn = A06_HikariCP.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			ResultSetMetaData meta = rs.getMetaData();
			
			// 1. 우선 컬럼 이름들을 찾는다
			
//			Class<?> coffee_class = Class.forName("jdbc.model.Coffee");
//			
//			coffee_class.getMethod("setName").invoke(coffee_class, null);
			
			while(rs.next()) {
				list.add(new Coffee(rs.getInt("id"), rs.getString("name"), rs.getInt("price")));
				// 2. 데이터 클래스의 컬럼 이름과 일치하는 필드에 값을 채워 넣는다. //+ 주석처리한것과 이어지는 내용으로 제외
				
			}
			
			System.out.println(list); //+ 커피 인스턴스 개수만큼 나온다.
			
			//+ 이건 내가 적은거
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
