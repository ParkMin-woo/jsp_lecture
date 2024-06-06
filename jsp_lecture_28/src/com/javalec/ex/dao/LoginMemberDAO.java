package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.ex.ConnectionPool;
import com.javalec.ex.dto.LoginMemberDTO;

public class LoginMemberDAO {
	
	public static final int MEMBER_NONEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	
	private static Connection conn;
	PreparedStatement pstm = null;
	Statement stm = null;
	ResultSet rs = null;
	
	private static LoginMemberDAO instance = new LoginMemberDAO();
	
	private LoginMemberDAO() {
		// super();
		// TODO Auto-generated constructor stub
	}
	
	public static LoginMemberDAO getInstance() {
		return instance;
	}

	public ArrayList<LoginMemberDTO> loginMemberSelect() throws SQLException {
		
		ArrayList<LoginMemberDTO> memberDTOList = new ArrayList<LoginMemberDTO>();
		
		try {
			conn = ConnectionPool.getConnection();
			String loginMemberSelectSql = "SELECT a.seq, a.id, a.pwd, a.name, a.address, b.graduated_academy, a.major, a.hobby, case when a.gender = 'M' then '남성' ELSE '여성' END AS gender FROM login_table a INNER JOIN graduated_table b ON a.graduated_academy = b.gratuated_code WHERE 1=1 ORDER BY a.seq asc";
			pstm = conn.prepareStatement(loginMemberSelectSql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String graduatedAcademy = rs.getString("graduated_academy");
				String major = rs.getString("major");
				String hobby = rs.getString("hobby");
				String gender = rs.getString("gender");
				
				LoginMemberDTO memberDTO = new LoginMemberDTO();
				memberDTO.setSeq(seq);
				memberDTO.setId(id);
				memberDTO.setPwd(pwd);
				memberDTO.setName(name);
				memberDTO.setAddress(address);
				memberDTO.setGraduatedAcademy(graduatedAcademy);
				memberDTO.setMajor(major);
				memberDTO.setHobby(hobby);
				memberDTO.setGender(gender);
				memberDTOList.add(memberDTO);
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
		
		return memberDTOList;
		
	}
	
}
