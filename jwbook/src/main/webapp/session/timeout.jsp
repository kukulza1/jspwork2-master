<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <h3>������ȿ�ð� ������</h3>
<% 
  //server > web.xml> session-timeout :30��
   int time = session.getMaxInactiveInterval();
   out.println(time+"��<br>");
   
   time = session.getMaxInactiveInterval()/60;
   out.println(time+"��<br>");
%>



   <h3>������ȿ�ð� ������</h3>
<% 
  //2������ ����
  session.setMaxInactiveInterval(2*60);
  
   time = session.getMaxInactiveInterval();
   out.println(time+"��<br>");
   
   time = session.getMaxInactiveInterval()/60;
   out.println(time+"��<br>");
%>