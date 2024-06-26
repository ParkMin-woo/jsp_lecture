package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerEx
 */
@WebServlet(description = "Controller 예제입니다.", urlPatterns = { "*.do" })
public class FrontControllerEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerEx() {
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
		
		String uri = request.getRequestURI();
		System.out.println("uri => " + uri);
		String conPath = request.getContextPath();
		System.out.println("conPath => " + conPath);
		String command = uri.substring(conPath.length());
		System.out.println("command => " + command);
		
		if(command.equals("/insert.do")) {
			System.out.println("insert");
			System.out.println("------------");
		}
		else if(command.equals("/update.do")) {
			System.out.println("update");
			System.out.println("------------");
		}
		else if(command.equals("/select.do")) {
			System.out.println("select");
			System.out.println("------------");
		}
		else {
			System.out.println("delete");
			System.out.println("------------");
		}
	}

}
