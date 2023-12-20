<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String id =request.getParameter("id");
   String pwd =request.getParameter("pwd");
   
    if(id.equals("khit") &&  pwd.equals("1234")){
    	//쿠키 cookie(쿠키이름,쿠키값)
    	Cookie cid = new Cookie("userid",id);
    	Cookie cpwd = new Cookie("userpw",pwd);
    	
    	//브라우저(로컬컴퓨터)에 응답(보내줌)
    	response.addCookie(cid);
    	response.addCookie(cpwd);
    	
    	out.println("쿠키 생성에 성공하엿습니다");
    }else{
    	out.println("쿠키 생성에 실패하엿습니다");
    }
%>