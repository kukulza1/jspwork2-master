package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Member;
import member.MemberDAO;

@WebServlet("*.do")
public class Maincontroller extends HttpServlet {
	private static final long serialVersionUID = 10L;
      MemberDAO mdao;
    public Maincontroller() {
    	  mdao = new MemberDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //한글인코딩
		request.setCharacterEncoding("utf-8");
		
		//경로설정
		//uri= context(/)+파일경로(.do)
		String uri= request.getRequestURI();
		System.out.println(uri);
		String command = uri.substring(uri.lastIndexOf("/"));
		System.out.println(command);
		
		String nextPage = "";
		
		if(command.equals("/memberlist.do")) {
			//회원정보를 db에서조회
			List<Member> ml= mdao.getAllmember();
			
			request.setAttribute("ml2",ml);
			
			//이동할페이지
			nextPage = "/member/memberlist.jsp";
			
		}else if(command.equals("/memberjoin.do")) {
			nextPage = "/member/memberjoin.jsp";
		}else if(command.equals("/insertmember.do")) {
			//빈회원 객체 생성
			Member m = new Member();
			//폼 데이터 받기
			String id = request.getParameter("id");
			String pw = request.getParameter("passwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			
			m.setMemid(id);
			m.setPw(pw);
			m.setName(name);
			m.setEmail(email);
			m.setGender(gender);
			mdao.insertmember(m);
			nextPage = "index.jsp";
			
			
		}
		
		
		RequestDispatcher ds= request.getRequestDispatcher(nextPage);
		ds.forward(request, response);
		
	}

}
