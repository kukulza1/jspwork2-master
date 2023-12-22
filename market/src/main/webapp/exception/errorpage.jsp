<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container mt-5">
   <div class="text-center">
   <h1 class="alert-danger">내부서버 오류로 인한 장애 입니다.</h1>
   </div>
   </div>
   <p><a href="/productlist.do" class="btn btn-secondery" >&laquo;상품목록</a> </p>
   <%@ include file="../footer.jsp" %>
</body>
</html>