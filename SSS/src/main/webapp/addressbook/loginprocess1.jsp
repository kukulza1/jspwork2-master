<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="ab1" class="addressbook.AddrBookDAO" scope="application"/>
<%
  String email = request.getParameter("email");
  boolean result = ab1.checkLogin(email);
  
  if(result){//이메일이 있으면 세션발급 (세션명-sbsession)
	  session.setAttribute("sbsession",email);
       response.sendRedirect("addrList.jsp"); //주소록 목록으로 이동
  }else{
	  out.println("<script>");
	  out.println("alert('이메일이 틀립니다')");
	  out.println("history.go(-1)") ;
	  out.println("</script>");
  }
%>