<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String userId= request.getParameter("uid");
String userpw= request.getParameter("pww");

//아이디:khit 비번1234
if(userId.equals("khit")&& userpw.equals("1234")){
	//로그인이 성공하면 세션을 발급함(세션이름- "userID")
	session.setAttribute("sbsession",userId);
	out.println("세션이 발급되었습니다");
}else{
	out.println("<script>");
	out.println("alert('아이디나비번이 일치하지 않습니다.')");
	out.println("history.back()");
	out.println("</script>");
}
%>
<p><%=session.getAttribute("sbsession") %>님이 로그인 상태입니다</p>