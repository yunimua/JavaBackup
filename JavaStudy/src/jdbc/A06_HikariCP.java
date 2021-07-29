package jdbc;

import java.sql.*;

import com.zaxxer.hikari.*;

public class A06_HikariCP {
	
	private static HikariConfig config; //+ HikariConfig�� HikariDataSource�� �����س���, static�� �ִ´�..!
	private static HikariDataSource datasource;
	
	static {
		config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
        config.setUsername("hr");
        config.setPassword("yuni1212");
        config.addDataSourceProperty("maximumPoolSize", 20); //+ �ƽø� ����� �����س��°� ����
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
			�� Frequently used : ���� �ڼ��� ���� Ȯ���� �����ϴ�
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
