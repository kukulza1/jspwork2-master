package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;

@WebServlet("/member/checkid")


public class checkid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
          MemberDAO mdao = new MemberDAO();
		//컨텐츠응답
		response.setContentType("text/html; charset=utf-8");
		
		//메시지받기
		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter();
		boolean result = mdao.getDuplicatedid(id);
		if(result) { //중복데이타가 있으면
			out.print("notusable");
		}else {
			out.print("usable");
		}
		
		
		
	}

}
