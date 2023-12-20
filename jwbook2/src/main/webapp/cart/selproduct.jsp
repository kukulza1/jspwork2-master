<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
   #content{width:800px; margin:0 auto; text-align: center;}
</style>
</head>
<body>
<%
  request.setCharacterEncoding("utf-8");

   String uname =   request.getParameter("uname");
   session.setAttribute("sessionname", uname);
%>
<div id="content">
   <h2>상품선택</h2>
   <hr>
     <p><%=session.getAttribute("sessionname") %>님이 로그인한 상태입니다 </p>
     <form action="addproduct.jsp" method="post" name="form1">
     <select name="product" id="product" onchange="sp()">
       <option>-- 상품선택 --</option>
      <option value="사과">사과</option>
      <option value="바나나">바나나</option>
      <option value="토마토">토마토</option>
     </select>
       <!--<input type="submit" value="추가"> -->
     </form>
     <p><button onclick="location.href='cart.jsp'">장바구니</button></p>
  </div>
  <script>
 /* let sp =  function(){ //익명함수
    	let product = document.getElementById("product").value; //select 태그 선택
    	//alert(product+ "가 선택 되었습니다.");
    	document.form1.submit(); //폼의 내용이 전송
    }*/
    let sp = () => {
    	let product = document.getElementById("product").value; //select 태그 선택
    	//alert(product+ "가 선택 되었습니다.");
    	document.form1.submit(); //폼의 내용이 전송
    }
    
  </script>

</body>
</html>