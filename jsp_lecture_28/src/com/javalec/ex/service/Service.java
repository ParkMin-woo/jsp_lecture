package com.javalec.ex.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dto.LoginMemberDTO;

public interface Service {

	public ArrayList<LoginMemberDTO> execute(HttpServletRequest request, HttpServletResponse response) throws SQLException;
	
}
