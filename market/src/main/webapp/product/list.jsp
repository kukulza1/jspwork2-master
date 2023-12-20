<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
</head>
<body>
<%@ include file="../header.jsp" %>
  
  <c:if test="${empty products}">
  </c:if>
   <div class ="container my-3">
    <h2>상품목록</h2>
   <div class="row" align="center">
   <c:if test="${empty products }">
    <p>상품이 없습니다</p>
   </c:if>
   
   
   <c:if test="${not empty products }">
   <c:forEach items="${products}" var="p">
    <div class="col-4">
    <c:if test="${not empty p.pimage }">
     <img src="../upload/${p.pimage}">
     </c:if>
     <h3>${p.pname}</h3>
     <p>${p.price}원</p>
     <p>${p.category}</p>
     <p>${p.regDate}</p>
     <a href="/productinfo.do?pid=${p.pid}"
       class="btn btn-secondary">
       상세정보 &raquo;</a>
   </div>
    </c:forEach>
    </c:if>
   </div>
   </div>
   <%@ include file="../footer.jsp" %>
</body>
</html>