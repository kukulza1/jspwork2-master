<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");
  //상품을 저장할 어레이리스트 생성
  ArrayList<String> plist = (ArrayList)session.getAttribute("sessionlist");
  if(plist == null){
	
	  plist = new ArrayList<>();
	  session.setAttribute("sessionlist", plist);
  }
  //상품을 파라메다로 전달받기
  String product = request.getParameter("product");
  
  plist.add(product);
  

%>
<script>
   alert("<%=product %>가 추가되었습니다.");
   history.back();
</script>