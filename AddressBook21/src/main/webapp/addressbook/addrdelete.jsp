<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="ss" class="addressbook.AddrBookDAO" scope="application" />

<%
  int bnum = Integer.parseInt(request.getParameter("bnum"));
   ss.delete(bnum);
   response.sendRedirect("logout.jsp");
%>