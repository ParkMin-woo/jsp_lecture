package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HW")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * HttpServletRequest request : Tomcat(Web Server)에서 제공해주는 클라이언트의 요청처리객체
	 * HttpServletResponse response : Tomcat(Web Server)에서 제공해주는 클라이언트의 응답처리객체
	 * GET 방식 : URL값으로 정보가 전송되어 보안에 약함.(html이나 jsp 파일에서 Form 태그 메소드 속성값 = get으로 설정됨)
	 * 웹 브라우저의 주소창을 이용하여 servlet(서버 자원(?))을 요청한 경우에도 호출 됩니다.(예 : 도메인 주소의 ? 뒤에 id=abcdefg로 입력해서 보안 사이트 접속)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = response.getWriter();	// 웹 브라우저에 출력하기 위한 스트림
		
		writer.print("<html>");
		writer.print("<head>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h1>HelloWorld</h1>");
		writer.print("</body>");
		writer.print("</html>");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * POST 방식 : HEADER를 이용해 정보가 전송되어 보안에 강함.(html이나 jsp 파일에서 Form 태그 메소드 속성값 = post으로 설정됨)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		System.out.println("id =>" + id);
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		
		writer.print("<html>");
		writer.print("<head>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h1>");
		writer.print("index.html에서 받은 id값 => " + id);
		writer.print("</h1>");
		writer.print("</body>");
		writer.print("</html>");
		
		writer.close();
	}

}
