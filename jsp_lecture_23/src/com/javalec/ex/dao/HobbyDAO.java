package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.ex.ConnectionPool;
import com.javalec.ex.dto.HobbyDTO;

public class HobbyDAO {
	
	private static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://192.168.35.173:3306/test";
	// private static final String DB_URL = "jdbc:mariadb://localhost:3306/test";
	
	private static final String DB_USERNAME = "temp1";
	private static final String DB_PASSWORD = "1234";
	
	private static Connection conn;
	PreparedStatement pstm = null;
	Statement stm = null;
	ResultSet rs = null;
	
	private static HobbyDAO instance = new HobbyDAO();
	
	private HobbyDAO() {
		
	}
	
	public static HobbyDAO getInstance() {
		return instance;
	}
	
	public ArrayList<HobbyDTO> hobbyListSelect() throws SQLException {
		
		ArrayList<HobbyDTO> hobbyDTOList = new ArrayList<HobbyDTO>();
		
		try {
			conn = ConnectionPool.getConnection();
			String hobbySelectSql = "SELECT hobby_code, hobby FROM hobby_table WHERE 1=1 ORDER BY seq asc";
			pstm = conn.prepareStatement(hobbySelectSql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				String hobbyCode = rs.getString("hobby_code");
				String hobby = rs.getString("hobby");
				
				HobbyDTO hobbyDTO = new HobbyDTO();
				hobbyDTO.setHobbyCode(hobbyCode);
				hobbyDTO.setHobby(hobby);
				hobbyDTOList.add(hobbyDTO);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			// System.out.println(e.toString());
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
				if(pstm != null) pstm.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
		
		return hobbyDTOList;
	}
	
}
