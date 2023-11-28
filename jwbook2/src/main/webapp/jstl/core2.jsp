<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점계산프로그램</title>
</head>
<body>
   <!-- 학점점수 변선 선언 -->
   <c:set var="score" value="${param.score}"/>
   <h2>시험점수:${score}</h2>
   <c:choose>
    <c:when test="${score >=90 and score<=100}"><p>A학점</p></c:when>
    <c:when test="${score >=80 and score <90 }"><p>B학점</p></c:when>
    <c:when test="${score >=70 and score <80 }"><p>C학점</p></c:when>
    <c:when test="${score >=60 and score <70 }"><p>D학점</p></c:when>
    <c:otherwise><p>F학점</p></c:otherwise>
   </c:choose>
</body>
</html>