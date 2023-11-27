<%@page import="el.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품선택</title>
<style>
#container{width:80%; margin:30px auto; text-align:center;}
</style>
</head>
<jsp:useBean id ="p1" class="el.Product"/>
<%
 Product p12= new Product();
%>
<body>
<div id="container">
    <h2>상품선택</h2>
    <hr>
    <p>선택한상품: ${param.select}
    <p>num1+num2 = ${p1.num1+p1.num2}
    <%-- <p>num1+num2 = <%= p12.getNum1()+p12.getNum2() --%>
    </div>
</body>
</html>