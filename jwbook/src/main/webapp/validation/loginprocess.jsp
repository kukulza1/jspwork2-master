<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
   String id = request.getParameter("uid");
   String pww = request.getParameter("passwd");


%>
<p>�α��� ����</p>
<p>���̵�: <%=id %>
<p>���: <%=pww %>