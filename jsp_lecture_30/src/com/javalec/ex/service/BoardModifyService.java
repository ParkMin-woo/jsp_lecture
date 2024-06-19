package com.javalec.ex.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.BoardDAO;
import com.javalec.ex.dto.BoardDTO;

public class BoardModifyService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("BoardModifyService bId => " + request.getParameter("bId"));
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bContent = request.getParameter("bContent");
		HttpSession session = request.getSession();
		session.invalidate();
		BoardDAO dao = BoardDAO.getInstance();
		// BoardDTO boardContent = dao.removeBoardContent(bId);
		int ri = dao.updateBoardContent(bId, bContent);
		request.setAttribute("ri", ri);
	}
	
}
