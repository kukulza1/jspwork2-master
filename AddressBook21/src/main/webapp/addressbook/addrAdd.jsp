<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 등록처리</title>
<link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<jsp:useBean id="addrBook" class="addressbook.AddrBook"></jsp:useBean>
<jsp:setProperty property="*" name="addrBook"/>
<jsp:useBean id="adDAO" class="addressbook.AddrBookDAO" scope="application"/>
<%
    adDAO.addadr(addrBook); //주소추가
    //세션명에 유저이름넣어서 발급하기
    session.setAttribute("sbsession",addrBook.getUsername());
%>
  <div id="container">
	<h2>등록 내용</h2>
	<hr>
	<p>이름: <%=addrBook.getUsername() %> </p>
	<p>전화번호: <%=addrBook.getTel() %> </p>
	<p>이메일: <%=addrBook.getEmail() %> </p>
	<p>성별: <%=addrBook.getGender() %> </p>
	<hr>
	<p><a href="addrList.jsp">목록 보기</a></p>
</div>
</body>
</html>