<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page session="true" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>세션</title>
</head>
<body>
<h2>세션생성</h2>
<!-- session:내장객체임 -->
<p>세션내장객체:<%=session %></p>
<!-- JsessionID -->
<p>세션 아이디:<%=session.getId() %></p>

</body>
</html>