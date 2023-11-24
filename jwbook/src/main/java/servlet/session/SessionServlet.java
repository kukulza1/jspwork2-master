package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session1")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션사용하기
		HttpSession s1= request.getSession();
		System.out.println("세션아디:"+s1.getId());
		System.out.println("세션최초생성시각"+ new Date(s1.getCreationTime()));
		System.out.println("세션최초생성시각"+s1.getMaxInactiveInterval());
		//세션 유효시간 변경
		s1.setMaxInactiveInterval(10*60);
		System.out.println("세션유효시간"+s1.getMaxInactiveInterval());
		
		//브라우저에 text/html 보내기
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("세션아디:"+s1.getId()+"<br>");
		out.println("세션최초생성시각"+ new Date(s1.getCreationTime())+"<br>");
		out.println("세션유효시간"+s1.getMaxInactiveInterval()+"초");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}



