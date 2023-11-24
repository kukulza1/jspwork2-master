<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%request.setCharacterEncoding("utf-8"); %>
    <jsp:useBean id="s2" class="addressbook.AddrBook" scope="application" />
    <jsp:setProperty property="bnum" name="s2"/>
    <jsp:setProperty property="username" name="s2"/>
    <jsp:setProperty property="tel" name="s2"/>
    <jsp:setProperty property="email" name="s2"/>
    <jsp:setProperty property="gender" name="s2"/>
    <jsp:useBean id="ss" class="addressbook.AddrBookDAO" scope="application" />
<%
 ss.update(s2);
response.sendRedirect("addrList.jsp");
%>