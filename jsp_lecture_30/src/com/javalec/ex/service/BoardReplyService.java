package com.javalec.ex.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.BoardDAO;
import com.javalec.ex.dto.BoardDTO;

public class BoardReplyService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		
		/*
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		int bGroup = Integer.parseInt(request.getParameter("bGroup"));
		int bStep = Integer.parseInt(request.getParameter("bStep"));
		int bIndent = Integer.parseInt(request.getParameter("bIndent"));
		*/
		
		System.out.println("bId in BoardReplyService => " + request.getParameter("bId"));
		System.out.println("bGroup in BoardReplyService => " + request.getParameter("bGroup"));
		System.out.println("bStep in BoardReplyService => " + request.getParameter("bStep"));
		System.out.println("bIndent in BoardReplyService => " + request.getParameter("bIndent"));
		System.out.println("bId == bGroup => " + request.getParameter("bId").equals(request.getParameter("bGroup")));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		
		if(request.getParameter("bId").equals(request.getParameter("bGroup"))) {
			BoardDTO boardDTO = new BoardDTO();
			
			int ri1 = dao.updateBStep(Integer.parseInt(request.getParameter("bGroup")));
			boardDTO.setbId(Integer.parseInt(request.getParameter("bId")));
			boardDTO.setbName(request.getParameter("bName"));
			boardDTO.setbTitle(request.getParameter("bTitle"));
			boardDTO.setbContent(request.getParameter("bContent"));
			boardDTO.setbGroup(Integer.parseInt(request.getParameter("bGroup")));
			boardDTO.setbStep(1);
			boardDTO.setbIndent(1);
			int ri2 = dao.insertBoardReply(boardDTO);
			
			/*
			HashMap<String, Integer> resultMap01 = dao.getStepAndIndentByBGroup(Integer.parseInt(request.getParameter("bGroup")));
			System.out.println("resultMap01 in BoardReplyService => " + resultMap01);
			int maxBStep = resultMap01.get("maxBStep");
			int minBIndent = resultMap01.get("minBIndent");
			System.out.println("maxBStep in BoardReplyService => " + maxBStep);
			System.out.println("minBIndent in BoardReplyService => " + minBIndent);
			boardDTO.setbStep(++maxBStep);
			boardDTO.setbIndent(++minBIndent);
			*/
			System.out.println("boardDTO.toString()1 in BoardReplyService => " + boardDTO.toString());
		}
		else {
			int bIndent = Integer.parseInt(request.getParameter("bIndent"));
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setbName(request.getParameter("bName"));
			boardDTO.setbTitle(request.getParameter("bTitle"));
			boardDTO.setbContent(request.getParameter("bContent"));
			boardDTO.setbGroup(Integer.parseInt(request.getParameter("bGroup")));
			boardDTO.setbStep(Integer.parseInt(request.getParameter("bStep")));
			boardDTO.setbIndent(++bIndent);
			
			int ri2 = dao.insertBoardReply(boardDTO);
			System.out.println("boardDTO.toString()2 in BoardReplyService => " + boardDTO.toString());
		}
		/*
		
		
		// BoardDTO boardDTO = new BoardDTO();
		boardDTO.setbId(Integer.parseInt(request.getParameter("bId")));
		boardDTO.setbName(request.getParameter("bName"));
		boardDTO.setbTitle(request.getParameter("bTitle"));
		boardDTO.setbContent(request.getParameter("bContent"));
		boardDTO.setbGroup(Integer.parseInt(request.getParameter("bGroup")));
		boardDTO.setbStep(Integer.parseInt(request.getParameter("bStep")));
		boardDTO.setbIndent(Integer.parseInt(request.getParameter("bIndent")));
		*/
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		/*
		BoardDAO dao = BoardDAO.getInstance();
		// BoardDTO boardContent = dao.removeBoardContent(bId);
		int ri = dao.insertBoardReply(boardDTO);
		request.setAttribute("ri", ri);
		*/
	}

}
