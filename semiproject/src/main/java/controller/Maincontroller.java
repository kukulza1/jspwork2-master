package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			String tel = request.getParameter("tel");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String address3 = request.getParameter("address3");
			String address4 = request.getParameter("address4");
			
			m.setId(id);
			m.setPasswd(pw);
			m.setName(name);
			m.setEmail(email);
			m.setTel(tel);
			m.setAddress1(address1);
			m.setAddress2(address2);
			m.setAddress3(address3);
			m.setAddress4(address4);
			mdao.insertmember(m);
			nextPage = "/petshop/buyend.jsp";
		}else {
			
		}
		RequestDispatcher ds= request.getRequestDispatcher(nextPage);
		ds.forward(request, response);
		//doGet(request, response);
	}

}
