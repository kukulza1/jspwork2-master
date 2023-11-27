<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드</title>
</head>
<body>
   <form action="file01process.jsp" method="post" enctype="multipart/form-data">
   
      <p>회원이름: <input type="text" name="username"></p>
      <p>파일제목: <input type="text" name="title"></p>
      <p>파일이름: <input type="file" name="fname"></p>
      <input type="submit" value="파일전송">
   </form>
</body>
</html>