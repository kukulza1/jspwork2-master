package controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession sst = request.getSession();
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
			
		}else if(command.equals("/editproduct.do")) {
			String edit = request.getParameter("edit");
			
			List<Product> product = pdao.getProductlist();
			
			request.setAttribute("products", product);
			request.setAttribute("edit", edit);
			
			nextpage="/product/edit.jsp";
		}else if(command.equals("/deletep.do")) {
			String pid = request.getParameter("pid");
			
			
			Product product = pdao.getoneproduct(pid);
			pdao.deleteproduct(pid);
			
			request.setAttribute("product", product);
			
			nextpage="/editproduct.do?edit=delete";
			
			
			
			
		}else if(command.equals("/updateform.do")) {
			String pid = request.getParameter("pid");
			Product product = pdao.getoneproduct(pid);
			request.setAttribute("product", product);
			nextpage="/product/updateform.jsp";
			
			
			
			
		}else if(command.equals("/updateproduct.do")) {
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
					
				if(filename != null) {
		            pdao.updatep(p);
				}else {
					pdao.updatepNoimg(p);
					}
			
		}
			nextpage="/editproduct.do?edit=update";
		}
		
		
		
		else if(command.equals("/addcart.do")) {
			String pid = request.getParameter("pid");
			List<Product> goodslist = pdao.getProductlist();
			Product goods = new Product();
			//목록에서 추가한상품찾기
			
			for(int i=0; i<goodslist.size(); i++) {
				goods = goodslist.get(i);
				if(goods.getPid().equals(pid)) {
					break;
				}
			}
			List<Product> list= (ArrayList<Product>) sst.getAttribute("cartlist"); //세션유지용 부여
			if(list == null) {
				list = new ArrayList<>(); //어레이 리스트로 사용
				sst.setAttribute("cartlist", list); //세션생성
			}
			
			//요청 아이디의 상품이 기존에 장바구니에 있으면 수량을 1로정함
			int cnt = 0; //장바구니에 추가한 횟수			
			Product goodsQnt = new Product();
			
			for(int i=0; i<list.size(); i++) {
				goodsQnt = list.get(i);
				if(goodsQnt.getPid().equals(pid)) {
					cnt++;
			  //int orderQuantity = goodsQnt.getQuantity()+1; //추가주문된상품객체
			  goodsQnt.setQuantity(goodsQnt.getQuantity()+1);
				}
			}
			//기존에 장바구니에 없는 품목은 수량을 1로정함
			if(cnt ==0) {
				goods.setQuantity(1);
				list.add(goods);
			}
			
			//nextpage="productinfo.do?pid=" + pid;
		}else if(command.equals("/cart.do")) {
			//상품세션유지
			List<Product> cartlist= (ArrayList<Product>) sst.getAttribute("cartlist");
			if(cartlist == null) {
				cartlist = new ArrayList<>();
			}
			//합계
			int sum = 0; //모든상품총합계
			int unit_sum = 0; //품목별 합계 = 가격*수량
			for(int i=0; i<cartlist.size(); i++) {
				Product product = cartlist.get(i);
				unit_sum = product.getPrice()* product.getQuantity();
				
				sum+= unit_sum;
			}
			
			String cartid = sst.getId();
			
			request.setAttribute("cartlist", cartlist);
			request.setAttribute("sum", sum);
			request.setAttribute("cartid", cartid);
			
			nextpage="/product/cart.jsp";
		}else if(command.equals("/deletecart.do")) {
			//장바구니 품목 전체삭제(세션삭제)
			sst.invalidate();

		}else if(command.equals("/removecart.do")) {
			String pid = request.getParameter("pid");
			List<Product> cartlist= (ArrayList<Product>) sst.getAttribute("cartlist");
			for(int i=0; i<cartlist.size(); i++) {
				Product product = cartlist.get(i);
				if(product.getPid().equals(pid)) {
					cartlist.remove(i);
				}
			}
			
		}else if(command.equals("/shippingform.do")) {
		 String cartid = sst.getId();
			
			request.setAttribute("cartid", cartid);
			
			nextpage="/product/shippingform.jsp";
		}else if(command.equals("/shippinginfo.do")){
			
			Cookie shiid = new Cookie("shipping_shiid", 
					 URLEncoder.encode(request.getParameter("cartid"),"utf-8"));
			Cookie sname = new Cookie("shipping_sname", 
					 URLEncoder.encode(request.getParameter("sname"),"utf-8"));
			Cookie sdate = new Cookie("shipping_sdate", 
					 URLEncoder.encode(request.getParameter("sdate"),"utf-8"));
			Cookie zipcode = new Cookie("shipping_zipcode", 
					 URLEncoder.encode(request.getParameter("zipcode"),"utf-8"));
			Cookie address = new Cookie("shipping_address", 
					 URLEncoder.encode(request.getParameter("address"),"utf-8"));
		
			sname.setMaxAge(24*60*60);
			shiid.setMaxAge(24*60*60);
			zipcode.setMaxAge(24*60*60);
			address.setMaxAge(24*60*60);
			sdate.setMaxAge(24*60*60);

			
			response.addCookie(sname);
			response.addCookie(shiid);
			response.addCookie(zipcode);
			response.addCookie(address);
			response.addCookie(sdate);
			
			//쿠키정보를 가져와서 
			
			String shipping_sname = "";
			String shipping_shiid = "";
			String shipping_zipcode = "";
			String shipping_address = "";
			String shipping_sdate = "";
			
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(int i=0; i<cookies.length; i++) {
					Cookie cookie = cookies[i];  //인덱스별로 쿠키를 생성
					String cname = cookie.getName(); //쿠키이름 가져옴
					//한글 복호화(디코딩 문자열로 변환)
					
					if(cname.equals("shipping_sname")) 
						shipping_sname = URLDecoder.decode(cookie.getValue(),"utf-8");
					
					if(cname.equals("shipping_shiid")) 
						shipping_shiid = URLDecoder.decode(cookie.getValue(),"utf-8");
					
					if(cname.equals("shipping_zipcode")) 
						shipping_zipcode = URLDecoder.decode(cookie.getValue(),"utf-8");
					
					if(cname.equals("shipping_address")) 
						shipping_address = URLDecoder.decode(cookie.getValue(),"utf-8");
					
					if(cname.equals("shipping_sdate")) 
						shipping_sdate = URLDecoder.decode(cookie.getValue(),"utf-8");
				}
			}
			int sum = 0; //모든상품총합계
			int unit_sum = 0; //품목별 합계 = 가격*수량
			List<Product> cartlist= (ArrayList<Product>) sst.getAttribute("cartlist");
			for(int i=0; i<cartlist.size(); i++) {
				Product product = cartlist.get(i);
				unit_sum = product.getPrice()* product.getQuantity();
				
				sum+= unit_sum;
			}
			//모델로만들기
			request.setAttribute("shipping_sname", shipping_sname);
			request.setAttribute("shipping_shiid", shipping_shiid);
			request.setAttribute("shipping_zipcode", shipping_zipcode);
			request.setAttribute("shipping_address", shipping_address);
			request.setAttribute("shipping_sdate", shipping_sdate);
			
			request.setAttribute("sum", sum);
			
			nextpage="/product/orderconfirm.jsp";
			
		}else if(command.equals("/thankscustomer.do")) {
			
			String shipping_shiid = "";
			String shipping_sdate = "";
		
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(int i=0; i<cookies.length; i++) {
					Cookie cookie = cookies[i]; 
					String cname = cookie.getName(); 
														
					if(cname.equals("shipping_shiid")) 
						shipping_shiid = URLDecoder.decode(cookie.getValue(),"utf-8");				
					
					if(cname.equals("shipping_sdate")) 
						shipping_sdate = URLDecoder.decode(cookie.getValue(),"utf-8");
					
				}
				
				request.setAttribute("shipping_shiid", shipping_shiid);
				request.setAttribute("shipping_sdate", shipping_sdate);
			    sst.invalidate();
				if(cookies != null) {
					for(int i=0; i<cookies.length; i++) {
						Cookie cookie = cookies[i]; 
						String cname = cookie.getName(); 
						if(cname.equals("shipping_sname")) 
							cookie.setMaxAge(0);
						if(cname.equals("shipping_shiid")) 
							cookie.setMaxAge(0);
						if(cname.equals("shipping_zipcode")) 
							cookie.setMaxAge(0);
						if(cname.equals("shipping_address")) 
							cookie.setMaxAge(0);
						if(cname.equals("shipping_sdate")) 
							cookie.setMaxAge(0);							
					}
				}
			nextpage="/product/thankscustomer.jsp";
		}
		}
		
		if(command.equals("/insertproduct.do")) {
			response.sendRedirect("/productlist.do");
		}else if(command.equals("/addcart.do")) {
			String pid = request.getParameter("pid");
			
			response.sendRedirect("/productinfo.do?pid=" + pid);
		}
		else if(command.equals("/deletecart.do") || command.equals("/removecart.do")) {
			response.sendRedirect("/cart.do");
		}
		else {
		RequestDispatcher rd= request.getRequestDispatcher(nextpage);
		rd.forward(request, response);
		//doGet(request, response);
		}
	}

}
















