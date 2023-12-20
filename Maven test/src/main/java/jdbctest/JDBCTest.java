package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {

	public static void main(String[] args) {
		 Connection conn = null;
		 String driverClass = "com.mysql.cj.jdbc.Driver";
		 String url = "jdbc:mysql://localhost:3306/jwebdb?serverTime=Asia/seoul";
		 String username = "jweb";
		 String password = "pwjweb";
		 
		 try {
			Class.forName(driverClass); //오라클 연결 드라이버
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("db연결성공:"+conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
