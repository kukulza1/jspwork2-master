<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<a href=""><button class="arrow"></button></a>
                    <a href=""><button>1</button></a>
                    <a href=""><button>2</button></a>
                    <a href=""><button>3</button></a>
                    <a href=""><button>4</button></a>
                    <a href=""><button class="arrow">></button></a>

<a href="/">
                   <button id="toList" >메인으로</button>
                </a> 
</body>
</html>

<!--else if(command.equals("/pinput.do")) {
			
			String cart = request.getParameter("cc");
			
			session.setAttribute("sessionId", cart);
			ProductVO pv = new ProductVO();
			String pname=	request.getParameter("pname");
			int price = Integer.parseInt(request.getParameter("price"));
			String pfilename =	request.getParameter("pfilename");
			ArrayList<ProductVO> cart1 = new ArrayList<>();
		    
			pv.setPname(pname);
			pv.setPrice(price);
			pv.setPfilename(pfilename);
			 cart1.add(pv);
			nextPage="/petshop/productform.jsp";	
		}
		
		else if(command.equals("/cart.do")){
		session.getAttribute("sessionId");
		
				
			ArrayList<ProductVO> cart = (ArrayList<ProductVO>)session.getAttribute("sessionId");
		     
		      for(int i=0; i<cart.size(); i++) {
		    	  
		    	  out.println(cart.get(i));
		    	 request.setAttribute("cart", cart.get(i));
		    	  
		      } 		     
			
			
			
			nextPage="/petshop/cart.jsp";	
		}-->