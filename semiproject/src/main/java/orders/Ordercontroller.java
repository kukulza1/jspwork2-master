/*package orders;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Ordercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       OrderDAO oDAO;
    public Ordercontroller() {
        oDAO= new OrderDAO();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String uri= request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/"));
		String nextPage = "";
		
		  if(command.equals("order.do")) {
	      
	        int orderPrice = Integer.parseInt(request.getParameter("orderPrice"));
	        String cardCompany = request.getParameter("cardCompany");
	        int count = Integer.parseInt(request.getParameter("count"));
	        int pno = Integer.parseInt(request.getParameter("pno"));
	        String id = request.getParameter("id");

	        // 주문 객체 생성
	        OrdersVO ov = new OrdersVO();

	       ov.setOrderPrice(orderPrice);
	       ov.setCardCompany(cardCompany);
	       ov.setCount(count);
	       ov.setPno(pno);
	       ov.setId(id);
           
	       oDAO.insertOrder(ov);
	        response.getWriter().println("주문이 완료되었습니다.");
		
		  }
		  RequestDispatcher ds= request.getRequestDispatcher(nextPage);
			ds.forward(request, response);
		//doGet(request, response);
	}

}
*/