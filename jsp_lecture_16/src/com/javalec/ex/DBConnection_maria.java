package com.javalec.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection_maria {
	
	private static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://192.168.35.173:3306/";
	
	private static final String DB_USERNAME = "temp1";
	private static final String DB_PASSWORD = "1234";
	
	private static Connection conn;
	PreparedStatement pstm = null;
	
	private static void connectDB() {
		try {
			Class.forName(DB_DRIVER_CLASS);
			Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이브 로딩 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 연결 실패");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection_maria test = new DBConnection_maria();
		test.connectDB();
	}

}
