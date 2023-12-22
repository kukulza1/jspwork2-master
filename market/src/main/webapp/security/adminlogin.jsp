<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자로그인</title>
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container mt-5" align="center">

    <div class="col-4">
     <h3>로그인</h3>
     
     
     <form action="/j_security_check" method="post">
     <div class="form-group my-3">        
          <input type="text" id="id" name="j_username" 
           class="form-control" placeholder="id" autofocus required>
        </div>
        
     <div class="form-group my-3">
          <input type="password" id="passwd" name="j_password" 
           class="form-control" placeholder="passwd" required>
         </div>
      <%
       String error = request.getParameter("error");
      if(error != null){
    	  out.println("<div class='alert alert-danger'>");
    	  out.println("관리자전용메뉴입니다<br>일반로그인해주세요");
    	  out.println("</div>");
      }
      %>
      <div class="error">${errora}</div>
      <div class="d-grid my-3 ">
       <button type="submit" class="btn btn-success p-2">로그인</button>
       
      </div>
      
     </form>
     </div>
    
     
    </div>
 
   <%@ include file="../footer.jsp" %>
</body>
</html>