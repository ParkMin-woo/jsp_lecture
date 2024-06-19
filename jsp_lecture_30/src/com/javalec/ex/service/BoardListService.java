package com.javalec.ex.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BoardDAO;
import com.javalec.ex.dto.BoardDTO;

public class BoardListService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardDTO> boardList = dao.getBoardList();
		request.setAttribute("boardList", boardList);
	}

}
