package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TotalLifeCycleEX
 */
@WebServlet(description = "서블릿과 앱의 라이프 사이클 작동 순서 이해", urlPatterns = { "/CycleEx" })
public class TotalLifeCycleEX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotalLifeCycleEX() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * init() 메소드 실행 전 선처리 작업을 해주기 위한 메소드 생성
     * 메소드 위에 @PostConstruct라고 붙인 다음에 메소드를 생성합니다.
     */
    @PostConstruct
    private void initPostConstruct() {
    	System.out.println("initPostConstruct 메소드 실행");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init 메소드 실행");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("TotalLifeCycleEX - doPost() 메소드 실행");
		
		// 한글 data 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("이름 : " + name + "<br />");
		writer.println("아이디 : " + id + "<br />");
		writer.println("</body></html>");
		
		writer.close();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy 메소드 실행");
	}
    
    /**
     * destroy() 메소드 실행 후 후처리 작업을 해주기 위한 메소드 생성
     * 메소드 위에 @PreDestroy라고 붙인 다음에 메소드를 생성합니다.
     */
	@PreDestroy
	private void destroyPreDestroy() {
    	System.out.println("destroyPreDestroy 메소드 실행");
	}

}
