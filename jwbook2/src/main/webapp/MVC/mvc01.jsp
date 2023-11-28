<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvc 실습</title>
</head>
<body>
    <h3>데이터 받기</h3>
    
    <%-- <p>4계절 ${season[0]}
    --%>
    <c:forEach items="${season}" var="season">
    <p>${season}</p>
    </c:forEach>
    <p>자동차
       브랜드: ${car.brand}<br>
       배기량: ${car.cc}
</body>
</html>