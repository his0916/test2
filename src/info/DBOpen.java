package info;

import java.sql.*;
public class DBOpen {
	public Connection getConnection() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl1";
		String id = "test01";
		String pw = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pw);
		} catch(ClassNotFoundException e) {
			System.out.println("Oracle ����̹��� ã�� �� �����ϴ�");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
