package com.javalec.ex.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BoardDAO;
import com.javalec.ex.dto.BoardDTO;

public class BoardDeleteService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		BoardDAO dao = BoardDAO.getInstance();
		// BoardDTO boardContent = dao.removeBoardContent(bId);
		int ri = dao.removeBoardContent(bId);
		request.setAttribute("ri", ri);
	}

}
