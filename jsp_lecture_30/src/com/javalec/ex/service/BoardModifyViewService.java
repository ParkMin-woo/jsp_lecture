package com.javalec.ex.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardModifyViewService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		
		/*
		int bId = Integer.parseInt(request.getParameter("bId"));
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO boardContent = dao.getBoardContent(bId);
		request.setAttribute("boardContent", boardContent);
		*/
		
		System.out.println("bId => " + request.getParameter("bId"));
		System.out.println("bName => " + request.getParameter("bName"));
		System.out.println("bTitle => " + request.getParameter("bTitle"));
		System.out.println("bContent => " + request.getParameter("bContent"));
		
		HttpSession session = request.getSession();
		session.setAttribute("bId", request.getParameter("bId"));
		session.setAttribute("bName", request.getParameter("bName"));
		session.setAttribute("bTitle", request.getParameter("bTitle"));
		session.setAttribute("bContent", request.getParameter("bContent"));
	}

}
