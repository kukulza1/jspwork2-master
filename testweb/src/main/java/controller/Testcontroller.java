package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TestDAO;

@WebServlet("*.do") //디렉터리 패턴
public class Testcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TestDAO tdao;
    public Testcontroller() {
    	tdao =new TestDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//http://localhost:8080/testweb/board/list.do
		
		//경로설정
		//uri->컨텍스트+하위경로
		//context->컨텍스트
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		//System.out.println(uri);
		//System.out.println(cPath);
		String nextpage ="";
		//커멘트 패턴
		String command= uri.substring(uri.lastIndexOf("/"));
		System.out.println(command);
		
		if(command.equals("/list.do")) {
			System.out.println("/list.do경로가 요청됫습니다.");
			tdao.list();
			
			
          String message = "hi";
			
			//모델생성후저장
			request.setAttribute("msg", message);
			nextpage="/board/boardlist.jsp";
		}
		
		if(command.equals("/write.do")) {
			System.out.println("//write.do경로가 요청됫습니다.");
			tdao.write();
		}
		if(command.equals("/test.do")) {
			String message = "hi";
			nextpage="/test.jsp";
			
			//모델생성후저장
			request.setAttribute("msg", message);
		}
			//페이지 이동
		
			RequestDispatcher ds = request.getRequestDispatcher(nextpage);
			ds.forward(request, response);
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
