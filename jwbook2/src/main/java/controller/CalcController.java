package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Calc")
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CalcController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//폼에입력한 데이터를 받음
		int n = Integer.parseInt(request.getParameter("n1"));
		String op = request.getParameter("op");
		int n2 = Integer.parseInt(request.getParameter("n2"));
		double result=0;
		
		//계산하기
		switch(op) {
		case "+": result = (n+n2); break;
		case "-": result = (n-n2); break;
		case "x": result = (n*n2); break;
		case "÷": result = (double)(n/n2); break;
		}
		/*out.append("<html><body><h2>계산기</h2><hr>")
		        .append("<p>계산 결과:"+result);*/
		
		//계산결과-Model:첫번쨰 인자 문자열이 view패이지로 맵핑됨
		request.setAttribute("result", result);
		//계산결과를 보내기
		RequestDispatcher did= request.
			getRequestDispatcher("/MVC/calcresult.jsp");
		did.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
