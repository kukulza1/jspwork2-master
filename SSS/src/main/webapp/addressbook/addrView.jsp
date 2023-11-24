<%@ page import="addressbook.AddrBook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 정보</title>
<link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
	<jsp:useBean id="abDAO" class="addressbook.AddrBookDAO" scope="application" />
	<% 
		//username으로 찾은 객체를 생성
		int bnum = Integer.parseInt (request.getParameter("bnum"));
		AddrBook addrBook = abDAO.getone(bnum);
	%>
	<div id="container">
		<h2>주소 정보</h2>
		<hr>
	    <table id="tbl_view">
	    <tr>
	    		<td class="mm">번호</td>
	    		<td><%=addrBook.getBnum() %> </td>
	    	</tr>
	    	<tr>
	    		<td class="mm">이름</td>
	    		<td><%=addrBook.getUsername() %> </td>
	    	</tr>
	    	<tr>
	    		<td class="mm">전화번호</td>
	    		<td><%=addrBook.getTel() %> </td>
	    	</tr>
	    	<tr>
	    		<td class="mm">이메일</td>
	    		<td><%=addrBook.getEmail() %> </td>
	    	</tr>
	    	<tr>
	    		<td class="mm">성별</td>
	    		<td><%=addrBook.getGender() %> </td>
	    	</tr>
	    	<tr>
	    		<td class="mm">등록일</td>
	    		<td><%=addrBook.getRegdate() %> </td>
	    	</tr>
	    	<tr>
	    		<td colspan="2">
	    		<%
	    		String ss =(String)session.getAttribute("sbsession");
	    		String aa = addrBook.getEmail();
	    		if(ss.equals(aa)){  				
	    		%>
	    		<a href="addrupdate.jsp?bnum=<%=addrBook.getBnum() %>">
	    		   <button type="button">수정</button>
	    		   </a>
	    		   <a onclick="return confirm('정말로 해당주소록을 삭제하시겟습니까?')"
	    		    href="addrdelete.jsp?bnum=<%=addrBook.getBnum() %>">
	    		   <button type="button">삭제</button>
	    		   </a>
	    		<%}%>
	    			<a href="addrList.jsp">
	    			<button type="button">목록</button>
                     </a>
	    		</td>
	    	</tr>
	    </table>
	</div>
</body>
</html>