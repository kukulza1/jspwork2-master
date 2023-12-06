<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
   <jsp:include page="header.jsp" />
  
	   <div id="container">
	   <section id="main">
	   <h1>안녕하세요. KH-IT커뮤니티입니다</h1>
	   <div class="main_img">
	    <img src="resources/img/fff.jpg" alt="배경">
	   </div>
	   <!-- 최신게시글박스 -->
	   <div class="newboard">
	      <h3>최신 게시글</h3>
	      <c:forEach items="${bl1}" var="bb">
	      <p><a href="/boardlsit.do?bno=${bb.bno}">${bb.title}</a>(글쓴이: ${bb.memid},작성일:)
	      <fmt:formatDate value="${bb.createdate}"
                       pattern="yyyy-MM-dd HH:mm:ss"/>
	      </p>
	      <p>${bb.content}</p>
	      <p>${bb.memid}</p>
	      </c:forEach>
	    
	      
	   </div>
   </section>
   
   </div>
    <jsp:include page="footer.jsp" />
</body>
</html>