<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#container{width:80%; margin:30px auto; text-align:center;}
</style>
</head>
<jsp:useBean id ="p1" class="el.Product"/>
<body>
   <div id="container">
        <h2>상품목록</h2>
        <hr>
        <form action="selProduct.jsp" method="get">
        <select name="select">
        <c:forEach items="${p1.productlist}" var="product">
          <option>${product}</option>
          <option><c:out value="${product}"></c:out></option>
        </c:forEach>
        
        <%-- <%
        /*  for(int i=0;i<p1.getProduct().length; i++){
        	  out.println("<option>"+ p1.getProduct()[i] +"</option>");
          }*/
        for(String a : p1.getProduct()){
        	out.println("<option>"+ a +"</option>");
        }
        
        %> --%>
        <!-- <option value="apple">사과</option>
        <option value="orange">귤</option>
        <option value="tomato">토마토</option> -->
        </select>
        <input type="submit" value="선택">
        </form>
   </div>
</body>
</html>