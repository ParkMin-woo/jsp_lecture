package com.javalec.ex.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.LoginMemberDAO;
import com.javalec.ex.dto.LoginMemberDTO;

public class MembersAllService implements Service {

	@Override
	public ArrayList<LoginMemberDTO> execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		
		LoginMemberDAO loginMemberDAO = LoginMemberDAO.getInstance();
		ArrayList<LoginMemberDTO> allLoginMemberList = loginMemberDAO.loginMemberSelect();
		
		return allLoginMemberList;
	}

}
