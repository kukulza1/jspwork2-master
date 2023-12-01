<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<header>
  <div id="logo">
    <h1><a href="/">KH</a></h1>
  </div>
  <nav>
  <c:choose>
  <c:when test="${empty sbsession}">
	  <ul id="topmenu">
	  <li><a href="/loginform.do">로그인</a></li>
	  <li><a href="/memberjoin.do">회원가입</a></li>
	  <li><a href="/boardlist.do">게시판</a></li>
	  <li><a href="memberlist.do">회원목록</a></li>
	  </ul> 
  </c:when>
  <c:otherwise>
	  <ul id="topmenu">
	  <li><a href="/logout.do">(${sbsession}님)로그아웃</a></li>
	  <li><a href="/memberview.do?memid=${sbsession}">${sbsession}의정보</a></li>
	  <li><a href="/boardlist.do">게시판</a></li>
	  <li><a href="memberlist.do">회원목록</a></li>
	  </ul> 
  </c:otherwise>
  </c:choose>
  </nav>
</header>