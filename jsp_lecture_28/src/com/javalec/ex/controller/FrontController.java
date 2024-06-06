package com.javalec.ex.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dto.LoginMemberDTO;
import com.javalec.ex.service.MembersAllService;
import com.javalec.ex.service.Service;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(description = "Command Pattern의 이해", urlPatterns = { "*.do" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
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
		
		if(command.equals("/membersAll.do")) {
			System.out.println("membersAll");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head><body>");
			
			Service service = new MembersAllService();
			try {
				ArrayList<LoginMemberDTO> allLoginMemberList = service.execute(request, response);
				
				for(LoginMemberDTO loginMember : allLoginMemberList) {
					int seq = loginMember.getSeq();
					String id = loginMember.getId();
					String pwd = loginMember.getPwd();
					String name = loginMember.getName();
					String address = loginMember.getAddress();
					String graduatedAcademy = loginMember.getGraduatedAcademy();
					String major = loginMember.getMajor();
					String hobby = loginMember.getHobby();
					String gender = loginMember.getGender();
					
					writer.println("seq : " + seq + ", id : " + id + ", pwd : " + pwd + ", name : " + name + ", address : " + address + ", graduatedAcademy : " + graduatedAcademy + ", major : " + major + ", hobby : " + hobby + ", gender : " + gender + "<br />");
				}
				writer.println("</body></html>");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
