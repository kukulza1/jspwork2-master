package ajaxtext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/ajax1")
public class ajaxtest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글인코딩처리
		request.setCharacterEncoding("utf-8");
		
		//컨텐츠응답
		response.setContentType("text/html; charset=utf-8");
		
		//메시지받기
		String message = request.getParameter("message");
		PrintWriter out = response.getWriter();
		
		out.print(message);
	}

	

}
