package com.javalec.ex.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dto.BoardDTO;
import com.javalec.ex.service.BoardContentService;
import com.javalec.ex.service.BoardDeleteService;
import com.javalec.ex.service.BoardListService;
import com.javalec.ex.service.BoardModifyService;
import com.javalec.ex.service.BoardModifyViewService;
import com.javalec.ex.service.BoardReplyService;
import com.javalec.ex.service.BoardReplyViewService;
import com.javalec.ex.service.BoardService;
import com.javalec.ex.service.BoardWriteService;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(description = "MVC 게시판 예제", urlPatterns = { "*.do" })
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("actionDo");
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		System.out.println("uri => " + uri);
		String conPath = request.getContextPath();
		System.out.println("conPath => " + conPath);
		String command = uri.substring(conPath.length());
		System.out.println("command => " + command);
		
		String viewPage = null;
		BoardService boardService = null;
		
		if(command.equals("/write_view.do")) {
			viewPage = "write_view.jsp";
		}
		
		else if(command.equals("/write.do")) {
			boardService = new BoardWriteService();
			try {
				boardService.execute(request, response);
				viewPage = "list.do";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/list.do")) {
			boardService = new BoardListService();
			try {
				boardService.execute(request, response);
				viewPage = "list.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/content_view.do")) {
			boardService = new BoardContentService();
			try {
				boardService.execute(request, response);
				viewPage = "content_view.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/modify_view.do")) {
			boardService = new BoardModifyViewService();
			try {
				boardService.execute(request, response);
				viewPage = "modify_view.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			boardService = new BoardModifyService();
			try {
				boardService.execute(request, response);
				viewPage = "modify_view.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
		else if(command.equals("/modify.do")) {
			boardService = new BoardModifyService();
			try {
				boardService.execute(request, response);
				viewPage = "list.do";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/delete.do")) {
			boardService = new BoardDeleteService();
			try {
				boardService.execute(request, response);
				viewPage = "list.do";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/reply_view.do")) {
			boardService = new BoardReplyViewService();
			try {
				boardService.execute(request, response);
				viewPage = "reply_view.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/reply.do")) {
			boardService = new BoardReplyService();
			try {
				boardService.execute(request, response);
				viewPage = "list.do";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("다시 한 번 do에 매핑된 곳이 있는지 살펴보세요...");
		}
		
		RequestDispatcher rDispatcher = request.getRequestDispatcher(viewPage);
		rDispatcher.forward(request, response);
	}

}
