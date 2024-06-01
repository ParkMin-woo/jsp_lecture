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
	
	private static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://192.168.35.173:3306/test";
	// private static final String DB_URL = "jdbc:mariadb://localhost:3306/test";
	
	private static final String DB_USERNAME = "temp1";
	private static final String DB_PASSWORD = "1234";
	
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
	
	public int existedLoginIdSelect(String id, String pwd) throws SQLException {
		
		// LoginMemberDTO existedLoginId = new LoginMemberDTO();
		int ri = 0;
		String dbPwd;
		
		try {
			conn = ConnectionPool.getConnection();
			String existedIdSelectSql = "SELECT * FROM login_table WHERE 1=1 and id = ?";	//  /* and pwd = ? */
			pstm = conn.prepareStatement(existedIdSelectSql);
			pstm.setString(1, id);
			// pstm.setString(2, pwd);
			rs = pstm.executeQuery();
			
			/*
			while(rs.next()) {
				i++;
			}
			*/
			
			if(rs.next()) {
				dbPwd = rs.getString("pwd");
				if(pwd.equals(dbPwd)) {
					ri = LoginMemberDAO.MEMBER_LOGIN_SUCCESS;		// 로그인 OK , 1
				} else {
					ri = LoginMemberDAO.MEMBER_LOGIN_PW_NO_GOOD;	// ID, 패스워드 불일치 , 0
				}
				
			} else {
				ri = LoginMemberDAO.MEMBER_LOGIN_IS_NOT;			// 존재하지 않은 회원 , -1
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
		
		return ri;
		
	}
	
	public int duplicateIdSelect(String id) throws SQLException {

		int ri = 0;
		int i = 0;
		
		try {
			conn = ConnectionPool.getConnection();
			String existedIdSelectSql = "SELECT * FROM login_table WHERE 1=1 and id = ?";
			pstm = conn.prepareStatement(existedIdSelectSql);
			i = 0;
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			/*
			while(rs.next()) {
				i++;
			}
			*/
			
			if(rs.next()) {
				ri = LoginMemberDAO.MEMBER_EXISTENT;
			} else {
				ri = LoginMemberDAO.MEMBER_NONEXISTENT;
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
		
		return ri;
		
	}
	
	public int getMaxSeq() throws SQLException {

		int i = 0;
		
		try {
			conn = ConnectionPool.getConnection();
			String existedIdSelectSql = "SELECT nvl(MAX(seq), 0) AS max_seq FROM login_table WHERE 1=1";
			pstm = conn.prepareStatement(existedIdSelectSql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				i = rs.getInt("max_seq");
				i++;
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
		
		return i;
		
	}

	public int insertLoginSql(LoginMemberDTO loginMemberDTO) throws SQLException {
		int ri = 0;
		int i = 0;
		
		try {
			conn = ConnectionPool.getConnection();
			String insertLoginSql = "INSERT INTO login_table VALUES(?, ?, ?, ?, ?, ? ,? ,? ,?)";
			
			pstm = conn.prepareStatement(insertLoginSql);
			pstm.setInt(1, loginMemberDTO.getSeq());
			pstm.setString(2, loginMemberDTO.getId());
			pstm.setString(3, loginMemberDTO.getPwd());
			pstm.setString(4, loginMemberDTO.getName());
			pstm.setString(5, loginMemberDTO.getAddress());
			pstm.setString(6, loginMemberDTO.getGraduatedAcademy());
			pstm.setString(7, loginMemberDTO.getMajor());
			pstm.setString(8, loginMemberDTO.getHobby());
			pstm.setString(9, loginMemberDTO.getGender());
			
			i = pstm.executeUpdate();
			ri = LoginMemberDAO.MEMBER_JOIN_SUCCESS;
			System.out.println("result => " + i);
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
		
		return ri;
	}
	
	public LoginMemberDTO retrieveLoginId(String id) throws SQLException {

		LoginMemberDTO dto = new LoginMemberDTO();
		
		try {
			conn = ConnectionPool.getConnection();
			String existedIdSelectSql = "SELECT * FROM login_table WHERE 1=1 and id = ?";
			pstm = conn.prepareStatement(existedIdSelectSql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto.setName(rs.getString("name"));
				dto.setPwd(rs.getString("pwd"));
				dto.setAddress(rs.getString("address"));
				dto.setGraduatedAcademy(rs.getString("graduated_academy"));
				dto.setMajor(rs.getString("major"));
				dto.setHobby(rs.getString("hobby"));
				dto.setGender(rs.getString("gender"));
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
		
		return dto;
		
	}

	public int updateLoginSql(LoginMemberDTO loginMemberDTO) throws SQLException {
		int ri = 0;
		
		try {
			conn = ConnectionPool.getConnection();
			String insertLoginSql = "UPDATE login_table SET pwd = ? , name = ? , address = ? , graduated_academy =? , major =? , hobby = ? , gender = ? WHERE 1=1 AND id = ?";
			
			pstm = conn.prepareStatement(insertLoginSql);
			pstm.setString(1, loginMemberDTO.getPwd());
			pstm.setString(2, loginMemberDTO.getName());
			pstm.setString(3, loginMemberDTO.getAddress());
			pstm.setString(4, loginMemberDTO.getGraduatedAcademy());
			pstm.setString(5, loginMemberDTO.getMajor());
			pstm.setString(6, loginMemberDTO.getHobby());
			pstm.setString(7, loginMemberDTO.getGender());
			pstm.setString(8, loginMemberDTO.getId());
			
			ri = pstm.executeUpdate();
			System.out.println("result => " + ri);
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
		
		return ri;
	}
	
}
