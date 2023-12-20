<%@page import="java.util.ArrayList"%>
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

<div id="content">
   <h2>장바구니</h2>
   <h3>선택한상품목록</h3>
   <hr>
     <%
     //세션유지
      ArrayList<String> plist = (ArrayList)session.getAttribute("sessionlist");
     if(plist != null){
      for(String product : plist){
    	  out.println(product+"<br>");
      }
     }else{
    	 out.print("장바구니가 비어있습니다.");
     }
     %>
  </div>

</body>
</html>