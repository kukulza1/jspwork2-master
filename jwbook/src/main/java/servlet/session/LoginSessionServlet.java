package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginsession")
public class LoginSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginSessionServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글인코딩
		request.setCharacterEncoding("utf-8");
		
		//폼에 입력된 데이타 받기
		String id= request.getParameter("uid");
		String pw1= request.getParameter("passwd");
		
		//브라우저로 보내기
		response.setContentType("text/html; charset=utf-8");
		PrintWriter o1 = response.getWriter();
		
		//인증후 세션발급
		HttpSession s1 = request.getSession();
		
		if(id.equals("khit") && pw1.equals("1234")) {
			s1.setAttribute("userSB", id);
			String seid = (String) s1.getAttribute("userSB");
			o1.println(seid+"님이 로그인하셧습니다");
		}else {
			o1.println("<script>");
			o1.println("alert('아이디나 비번이 일치하지 않습니다')");
			o1.println("history.back()");
			o1.println("</script>");
		}
		
		
		//o1.println("아디"+id+"<br>");
		//o1.println("비번"+pw1+"<br>");
	}

}



