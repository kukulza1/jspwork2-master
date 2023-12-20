<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
   Cookie[] cookies = request.getCookies();
   out.println("현재쿠키의수" + cookies.length +"<br>");
   
   for(int i=0; i<cookies.length; i++){
	   out.println("쿠키속성의 이름" + cookies[i].getName() + "<br>");
	   out.println("쿠키속성값" + cookies[i].getValue() + "<br>");
	   out.println("==============================================<br>");
   }
%>