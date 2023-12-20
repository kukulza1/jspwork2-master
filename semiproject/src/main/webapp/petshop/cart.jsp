<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>장바구니</h1>
<hr>
<form action="/cart.do">

<c:forEach items="${cart}" var="c">
 <p>${c.pname}</p><p> ${c.price}</p>
 
</c:forEach>


</form>

</body>
</html>