package com.javalec.ex.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BoardDAO;
import com.javalec.ex.dto.BoardDTO;

public class BoardContentService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		BoardDAO dao = BoardDAO.getInstance();
		
		// list.jsp에서 content-view.jsp로 접근 시 먼저 조회수를 update한 다음에 게시글을 보여준다.
		int ri = dao.updateBoardHit(bId);
		BoardDTO boardContent = dao.getBoardContent(bId);
		int replyCnt = dao.getReplyCnt(boardContent);
		int remainCnt = dao.getRemainCnt(boardContent);
		System.out.println("replyCnt in BoardContentService => " + replyCnt);
		request.setAttribute("ri", ri);
		request.setAttribute("boardContent", boardContent);
		request.setAttribute("replyCnt", replyCnt);
		request.setAttribute("remainCnt", remainCnt);
	}

}
