package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import buyend.BuyendDAO;
import buyend.BuyendVO;
import member.MemberDAO;
import member.MemberVO;

@WebServlet("*.do")
public class Maincontroller extends HttpServlet {
	private static final long serialVersionUID = 22L;
    BuyendDAO bdao;   
	MemberDAO mdao;
    public Maincontroller() {
        bdao = new BuyendDAO();
        mdao = new MemberDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String uri= request.getRequestURI();
		System.out.println(uri);
		String command = uri.substring(uri.lastIndexOf("/"));
		String nextPage = "";
		System.out.println(command);
		
		HttpSession session = request.getSession();
		
		
		
		if(command.equals("/buyend.do")) {
			List<BuyendVO> buyend = bdao.getlistAll();
			request.setAttribute("buyend",buyend);
			nextPage="/petshop/buyend.jsp";
		}
			
		if(command.equals("/join.do")) {
			nextPage = "/petshop/join.jsp";
			}else if(command.equals("/memberjoin.do")) {
			
			MemberVO m = new MemberVO();
			
			String id = request.getParameter("id");
			String pw = request.getParameter("passwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String zip_code = request.getParameter("zip_code");	
			String address = request.getParameter("address");
			String address2 = request.getParameter("detailAddress");
			
			m.setId(id);
			m.setPasswd(pw);
			m.setName(name);
			m.setEmail(email);
			m.setPhone(phone);
			m.setZip_code(zip_code);		
			m.setAddress(address);
			m.setDetailAddress(address2);
			
			mdao.insertmember(m);
			nextPage = "/petshop/buyend.jsp";
			
		}else if(command.equals("/loginpage.do")) {
			nextPage="/petshop/loginpage.jsp";
		}else if(command.equals("/login.do")) {
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			MemberVO mv = new MemberVO();
			mv.setId(id);
			mv.setPasswd(passwd);
			
			boolean result = mdao.checklogin22(mv);
			if(result) {
				System.out.println("로그인성공");
				session.setAttribute("sessionid", id);
				
				nextPage="/petshop/buyend.jsp";
			}else {
				System.out.println("로그인실패");
				String error="아이디나 비밀번호를 다시 확인해주세요";
				request.setAttribute("error", error);
				nextPage="/petshop/loginpage.jsp";
				System.out.println("에러");	
			}
					
		}else if(command.equals("/logout.do")) {
			session.invalidate();//모든세션삭제
			nextPage="/index.jsp";
		}
		else {
			
		}
		RequestDispatcher ds= request.getRequestDispatcher(nextPage);
		ds.forward(request, response);
		//doGet(request, response);
		
	}

}
