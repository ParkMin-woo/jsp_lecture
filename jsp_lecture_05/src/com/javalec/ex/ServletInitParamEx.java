package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInitParamEx
 */
@WebServlet(
	description = "서블릿 초기화 파라미터 예제입니다."
	, urlPatterns = { "/InitEx" }
	, initParams = {
		@WebInitParam(name="id", value="mwpark0930")
		, @WebInitParam(name="pwd", value="1q2w3e4r")
		, @WebInitParam(name="path", value="경기도 안산시")
	}
)
public class ServletInitParamEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInitParamEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 초기화 파라미터는 특정 서블릿의 필요에 의해서 사용하는 목적
		String id = getInitParameter("id");
		String pwd = getInitParameter("pwd");
		String path = getInitParameter("path");
		
		// Servlet Context 파라미터는 모든 서블릿에 공유하는 목적으로 사용한다.
		String dept = getServletContext().getInitParameter("dept");
		String addr = getServletContext().getInitParameter("addr");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("web.xml에 설정한 init parameter" + "<br />");
		writer.println("아이디 : " + id + "<br />");
		writer.println("비밀번호 : " + pwd + "<br />");
		writer.println("경로 : " + path + "<br />");
		writer.println("web.xml에 설정한 servlet parameter" + "<br />");
		writer.println("부서 : " + dept + "<br />");
		writer.println("주소 : " + addr + "<br />");
		writer.println("</body></html>");
		
		writer.close();
		
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
