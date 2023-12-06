package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.ProductDAO;

@WebServlet("*.do")
public class Frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductDAO pdao;
    public Frontcontroller() {
        pdao = new ProductDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String command= uri.substring(uri.lastIndexOf("/"));
		
		String nextpage ="";
		if(command.equals("/list.do")) {
			
			List<String> list = pdao.list();
			
			
			request.setAttribute("list",list);
			nextpage="/product/list.jsp";
		}
		if(command.equals("/cart.do")) {
			
			
			
			nextpage="/product/cart.jsp";
		}
		
		
		RequestDispatcher ds = request.getRequestDispatcher(nextpage);
			ds.forward(request, response);
			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
		
	}

}
