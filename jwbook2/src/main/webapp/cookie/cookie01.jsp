<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>로그인</h2>
   <hr>
<form action="process.jsp" method="post">
    <p><label>id:</label>
    <input type="text" name="id"></p>
    <p><label>비번:</label>
    <input type="password" name="pwd"></p>
   
    <input type="submit" value="로그인">
   
</form>

</body>
</html>