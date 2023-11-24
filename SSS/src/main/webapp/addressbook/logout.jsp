<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //모든세션삭제 -로그아웃
  session.invalidate();
        
       //로그아웃 후 인덱스페이지로 이동
       response.sendRedirect("../index.jsp");
%>