<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
   String id = request.getParameter("uid");
   String pww = request.getParameter("passwd");


%>
<p>로그인 성공</p>
<p>아이디: <%=id %>
<p>비번: <%=pww %>