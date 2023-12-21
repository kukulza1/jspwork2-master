<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품편집</title>
</head>
<body>
<%@ include file="../header.jsp" %>
  
  <c:if test="${empty products}">
  </c:if>
   <div class ="container my-3">
    <h2>상품편집</h2>
   <div class="row" align="center">
   
   
   <c:forEach items="${products}" var="p">
    <div class="col-4">
    <c:if test="${not empty p.pimage }">
     <img src="../upload/${p.pimage}">
     </c:if>
     <h3>${p.pname}</h3>
     <p><fmt:formatNumber value="${p.price}" pattern="#,##0"/>원</p>
     <p>${p.category}</p>
     <p>${p.regDate}</p>
     <p>
     <c:if test="${edit eq 'update'}">
     <a href="/updateform.do?pid=${p.pid}"
       class="btn btn-primary">
       상품정보수정 &raquo;</a>
     </c:if>
     <c:if test="${edit eq 'delete'}">
     <a href="/deletep.do?pid=${p.pid}" onclick="return confirm('정말로삭제하시겠습니까?')"
       class="btn btn-danger">
       상품삭제 &raquo;</a>
     </c:if>
     
       </p>
   </div>
    </c:forEach>
   
   
   
   </div>
   </div>
   <%@ include file="../footer.jsp" %>
</body>
</html>