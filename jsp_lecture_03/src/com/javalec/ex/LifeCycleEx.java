package com.javalec.ex;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleEx
 */
@WebServlet(description = "서블릿의 라이프 사이클을 배우기 위한 예제", urlPatterns = { "/LifeCycleEx" })
public class LifeCycleEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleEx() {
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
	 * Servlet이 최초 요청이 들어왔을때 딱 한번 실행
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init 메소드 실행");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드 실행");
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메소드 실행");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see Servlet#destroy()
	 * Servlet이 수정되거나 서버가 재기동될 때 자원이 해제되어야 할 때, 마지막으로 한 번 실행
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
    	System.out.println("initPostConstruct 메소드 실행");
	}
}
