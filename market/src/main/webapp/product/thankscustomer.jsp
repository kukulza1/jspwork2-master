<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문완료</title>

</head>
<body>
<%@ include file="../header.jsp" %>
<div class ="container my-3">
<h2>주문완료</h2>
 <h3>주문해주셔서 감사합니다!</h3>
 <p>주문은 ${shipping_sdate}에 배송될 예정입니다</p>
 <p>주문번호: ${shipping_shiid}</p>
 <p><a href="/productlist.do" class="btn btn-secodary">
         상품목록</a></p>
 </div>
<%@ include file="../footer.jsp" %>
</body>
</html>