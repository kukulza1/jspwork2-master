package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Data")
public class DataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DataController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //데이터
		String[] season={"가을","봄","여름","겨울"};
		//hashmap자료 key:value
		Map<String,Object> car = new HashMap<>();
		car.put("brand","sonata");
		car.put("cc", 3000);
		
		//모델(model)
		request.setAttribute("season", season);
		request.setAttribute("car", car);
		
		
		//모델전송 - 화면페이지로 전송
		RequestDispatcher dd = 
				request.getRequestDispatcher("/MVC/mvc01.jsp");
		dd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
