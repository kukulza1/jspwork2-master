<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 프로세스EL</title>
<style>
  table, th, td{
    border: 1px solid #ccc;
    border-collapse:collapse;
    padding:10px
  }
</style>
</head>
<jsp:useBean id="M1" class="el.Member"/>
<jsp:setProperty property="uid" name="M1"/>
<jsp:setProperty property="passwd" name="M1"/>
<jsp:setProperty property="uname" name="M1"/>
<%
 request.setCharacterEncoding("utf-8");

%>
<body>
    <h2>회원정보</h2>
    <hr>
    <table>
    <tr>
       <th>아이디</th><th>비번</th><th>이름</th>
    </tr>
    <!-- el 언어표기: ${m1.uid} == m1.getUid() -->
    <tr>
    <td>${m1.uid}</td>
    <td>${m1.passwd}</td>
    <td>${m1.uname}</td>
    
    </tr>
    </table>

</body>
</html>