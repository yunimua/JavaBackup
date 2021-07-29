package jdbc;

import java.sql.*;

import com.zaxxer.hikari.*;

public class A06_HikariCP {
	
	private static HikariConfig config; //+ HikariConfig와 HikariDataSource를 선언해놓고, static에 넣는다..!
	private static HikariDataSource datasource;
	
	static {
		config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
        config.setUsername("hr");
        config.setPassword("yuni1212");
        config.addDataSourceProperty("maximumPoolSize", 20); //+ 맥시멈 사이즈를 지정해놓는게 좋다
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        
        datasource = new HikariDataSource(config);
	}
	
	public static Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}

	public static void main(String[] args) {
		
		HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
        config.setUsername("hr");
        config.setPassword("yuni1212");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        
		/*
			https://github.com/brettwooldridge/HikariCP/blob/dev/README.md#frequently-used
			ㄴ Frequently used : 에서 자세한 설명 확인이 가능하다
		*/
        
        HikariDataSource ds = new HikariDataSource(config);
        
        String sql = "SELECT * FROM coffee";
        
        try(
    			Connection conn = ds.getConnection();
    			PreparedStatement pstmt = conn.prepareStatement(sql);
        		ResultSet rs = pstmt.executeQuery();
    		){
        		ResultSetMetaData meta = rs.getMetaData();
        	
        		int COLUMN_SIZE = meta.getColumnCount();
        		
        		while(rs.next()) {
        			for(int i =1; i <= COLUMN_SIZE; ++i) {
        				System.out.printf("%s\t", rs.getObject(i));
        			}
        			System.out.println();
        		}
        	
        }catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
}
