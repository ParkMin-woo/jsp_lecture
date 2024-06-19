package com.javalec.ex.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.BoardDAO;
import com.javalec.ex.dto.BoardDTO;

public class BoardReplyViewService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/*
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardDTO> boardReply = dao.getBoardReply();
		request.setAttribute("boardReply", boardReply);
		*/
		
		// System.out.println("bId in BoardReplyViewService => " + request.getParameter("bId"));
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO boardContent = dao.getBoardContent(bId);
		
		System.out.println("bId in BoardReplyViewService => " + boardContent.getbId());
		System.out.println("bGroup in BoardReplyViewService => " + boardContent.getbGroup());
		System.out.println("bStep in BoardReplyViewService => " + boardContent.getbStep());
		System.out.println("bIndent in BoardReplyViewService => " + boardContent.getbIndent());
		
		HttpSession session = request.getSession();
		session.setAttribute("bId", boardContent.getbId());
		session.setAttribute("bGroup", boardContent.getbGroup());
		session.setAttribute("bStep", boardContent.getbStep());
		session.setAttribute("bIndent", boardContent.getbIndent());
	}

}
