<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <h3>세션유효시간 변경전</h3>
<% 
  //server > web.xml> session-timeout :30분
   int time = session.getMaxInactiveInterval();
   out.println(time+"초<br>");
   
   time = session.getMaxInactiveInterval()/60;
   out.println(time+"분<br>");
%>



   <h3>세션유효시간 변경후</h3>
<% 
  //2분으로 설정
  session.setMaxInactiveInterval(2*60);
  
   time = session.getMaxInactiveInterval();
   out.println(time+"초<br>");
   
   time = session.getMaxInactiveInterval()/60;
   out.println(time+"분<br>");
%>