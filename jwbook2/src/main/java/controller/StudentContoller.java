package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import student.Student;
import student.StudentDAO;

@WebServlet("*.do") // '/'루트 경로 아래에 do로끝나는 확장자인 파일이 올수있음
public class StudentContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StudentDAO sdao;
   
    public StudentContoller() {
        sdao=new StudentDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("utf-8");
	   response.setContentType("text/html; charset=utf-8");
		
		//경로(uri) 설정-커멘드 패턴(command)
		//  http://localhost8080/student/studentlist.jsp
		//맨뒤경로 추출 - lastIndexof('/'), subString(5)
		String uri=request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/"));
		System.out.println(uri);
		System.out.println(uri.lastIndexOf("/"));
		System.out.println(command);
		
		//이동할페이지
		String nextPage="";
		
		if(command.equals("/studentlist.do")) {
			List<Student> ss= sdao.getStudentList();
			//모델생성
			request.setAttribute("ss", ss);
			//뷰페이지로 이동
			nextPage="/student/studentlist.jsp";
			
		}else if(command.equals("/studentform.do")) {
			nextPage="/student/studentform.jsp";
		}else if(command.equals("/insertstudent.do")) {
			//폼에입력된 데이터 받기
			String username = request.getParameter("username");
			String univ = request.getParameter("univ");
			String birth = request.getParameter("birth");
			String email = request.getParameter("email");
			
			Student s = new Student();
			s.setUsername(username);
			s.setUniv(univ);
			s.setBirth(birth);
			s.setEmail(email);
			sdao.inserstu(s);
			
			nextPage="/studentlist.do";
		}
		RequestDispatcher ds= request.getRequestDispatcher(nextPage);
		ds.forward(request, response);
	}

}
