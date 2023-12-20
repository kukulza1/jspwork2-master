/*package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buyend.BuyendDAO;
import notice.NoticeDAO;

@WebServlet("/login.do")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BuyendDAO bDAO;   
	MemberDAO mDAO;
	NoticeDAO nDAO;
    public logincontroller() {
    	 mDAO = new MemberDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String uri= request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/"));
		String nextPage = "";
		
		HttpSession session = request.getSession();
		
		if(command.equals("/join.do")) { //회원가입페이지로 이동
			nextPage = "/join.jsp";
			
		}else if(command.equals("/loginpage.do")) { //로그인
			
			nextPage="/login/loginpage.jsp";
			
		}else if(command.equals("/login.do")) {
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			MemberVO mv = new MemberVO();
			mv.setId(id);
			mv.setPasswd(passwd);
			
			boolean result = mDAO.checklogin22(mv); //로그인 체크
			if(result) {
				System.out.println("로그인성공");
				session.setAttribute("sessionid", id);
				
				nextPage="/index.jsp";
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
			
			
		
		}else {}
		RequestDispatcher ds= request.getRequestDispatcher(nextPage);
		ds.forward(request, response);
		//doGet(request, response);
	}

}
*/