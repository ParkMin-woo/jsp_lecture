package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.ex.ConnectionPool;
import com.javalec.ex.dto.GraduatedDTO;

public class GraduatedDAO {
	
	private static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://192.168.35.173:3306/test";
	// private static final String DB_URL = "jdbc:mariadb://localhost:3306/test";
	
	private static final String DB_USERNAME = "temp1";
	private static final String DB_PASSWORD = "1234";
	
	private static Connection conn;
	PreparedStatement pstm = null;
	Statement stm = null;
	ResultSet rs = null;
	
	private static GraduatedDAO instance = new GraduatedDAO();
	
	
	
	private GraduatedDAO() {
		// super();
		// TODO Auto-generated constructor stub
	}
	
	public static GraduatedDAO getInstance() {
		return instance;
	}



	public ArrayList<GraduatedDTO> graduatedListSelect() throws SQLException {
		
		ArrayList<GraduatedDTO> graduatedDTOList = new ArrayList<GraduatedDTO>();
		
		try {
			conn = ConnectionPool.getConnection();
			String graduatedSelectSql = "SELECT gratuated_code, graduated_academy FROM graduated_table WHERE 1=1 ORDER BY seq asc";
			pstm = conn.prepareStatement(graduatedSelectSql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				String gratuatedCode = rs.getString("gratuated_code");
				String graduatedAcademy = rs.getString("graduated_academy");
				
				GraduatedDTO graduatedDTO = new GraduatedDTO();
				graduatedDTO.setGratuatedCode(gratuatedCode);
				graduatedDTO.setGraduatedAcademy(graduatedAcademy);
				graduatedDTOList.add(graduatedDTO);
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
		
		return graduatedDTOList;
		
	}
	
}
