<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경로(path)알아보기</title>
</head>
<body>
    <%
    String uri= request.getRequestURI();
    String context = request.getContextPath();
    StringBuffer url = request.getRequestURL();
    
    %>
    <p>URi(컨텍스트+파일경로):<%=uri %>
    <p>context(프로젝트):<%=context %>
    <p>url(전체경로):<%=url %>
</body>
</html>