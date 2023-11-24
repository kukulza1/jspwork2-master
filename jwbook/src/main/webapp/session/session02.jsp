<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //세션 정보얻기 -발급한 세션이름으로 가져옴
     String id = (String)session.getAttribute("sbsession");

  out.println("설정된 세션의 속성값:"+id+"<br>");
  out.println("세션의아이디값:"+session.getId());
%>