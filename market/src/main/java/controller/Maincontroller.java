package controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Product;
import model.ProductDAO;

@WebServlet("*.do")
public class Maincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductDAO pdao;
    public Maincontroller() {
    	pdao= new ProductDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/"));
		
		
		String nextpage = "";
		if(command.equals("/main.do")) {
			
			nextpage="/main.jsp";
		}
		
		else if(command.equals("/productlist.do")){
			List<Product> plist = pdao.getProductlist();
			request.setAttribute("products", plist);
			nextpage ="/product/list.jsp";
		}else if(command.equals("/productform.do")) {
			
			
			nextpage = "/product/pform.jsp";
			
		}else if(command.equals("/insertproduct.do")){
			

			String realForder ="C:\\jspwork2-master\\market\\src\\main\\webapp\\upload";
			int maxsize = 10*1024*1024; //1000
			String enctype = "utf-8"; //파일이름 한글인코딩
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			
			//5가지인자
			MultipartRequest multi = new MultipartRequest(request,realForder
					  ,maxsize,enctype,policy);
			Enumeration<?> files = multi.getFileNames();
			
			String filename = "";
			while(files.hasMoreElements()) { //파일명이 있는동안반복
				String userfilename = (String) files.nextElement();
			
				//원본파일 이름
				//String originalFilename = multi.getOriginalFileName(userfilename);
				
					//실제저장될 이름
					filename = multi.getFilesystemName(userfilename);
			
			}
			String pid = multi.getParameter("pid");
			String pname = multi.getParameter("pname");
			int price =Integer.parseInt(multi.getParameter("price"));
			String ds = multi.getParameter("description");
			String category= multi.getParameter("category");
			int stock = Integer.parseInt(multi.getParameter("stock"));
			String condition = multi.getParameter("condition");
		
							
			Product p = new Product(); 
			p.setPid(pid);
			p.setPname(pname);
			p.setPrice(price);
			p.setDescription(ds);
			p.setCategory(category);
			p.setStock(stock);
			p.setCondition(condition);
			p.setPimage(filename);
			
			pdao.insertproduct(p);
			nextpage="/productlist.do";
			
		}else if(command.equals("/productinfo.do")) {
			String pid= request.getParameter("pid");
		Product p=	pdao.getoneproduct(pid);
			
			request.setAttribute("product",p);
			
			nextpage="/product/pinfo.jsp";
		}
		if(command.equals("/insertproduct.do")) {
			response.sendRedirect("/productlist.do");
		}else {
		RequestDispatcher rd= request.getRequestDispatcher(nextpage);
		rd.forward(request, response);
		//doGet(request, response);
		}
	}

}
















