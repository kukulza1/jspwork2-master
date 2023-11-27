<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 프로세스</title>
<style>
  table, th, td{
    border: 1px solid #ccc;
    border-collapse:collapse;
    padding:10px
  }
</style>
</head>
<%
 request.setCharacterEncoding("utf-8");
//회원가입폼에 입력된 데이터 받기
  String id = request.getParameter("uid");
  String pw=request.getParameter("passwd");
  String uname =request.getParameter("uname");
%>
<body>
    <h2>회원정보</h2>
    <hr>
    <table>
    <tr>
       <th>아이디</th><th>비번</th><th>이름</th>
    </tr>
    <tr>
    <td><%=id %></td>
    <td><%=pw %></td>
    <td><%=uname %></td>
    </tr>
    </table>

</body>
</html>