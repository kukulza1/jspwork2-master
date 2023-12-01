<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
 <jsp:include page="../header.jsp" />
 <div id="container">
   <section id="memberview">
    <h2>회원정보</h2>
     <table>
      <tbody>
      <tr>
        <td><label for="memid">아이디</label></td>
        <td>${onem1.memid}</td>
      </tr>
      <tr>
        <td><label for="pw">비밀번호</label></td>
        <td>${onem1.pw}</td>
      </tr>
      <tr>
        <td><label for="name">이름</label></td>
        <td>${onem1.name}</td>
      </tr>
      <tr>
        <td><label for="email">이메일</label></td>
        <td>${onem1.email}</td>
      </tr>
      <tr>
        <td><label for="gender">성별</label></td>
        <td>${onem1.gender}</td>
      </tr>
      <tr>
        <td><label for="joinDate">가입일</label></td>
        <td>${onem1.joinDate}</td>
        
      </tr>
      <tr>
      <td colspan="2">
      
      <c:if test="${sbsession eq onem1.memid}">  
      <a href="/">
      <button>수정</button></a>
      <a href="/.do">
      <button>삭제</button></a>
      </c:if>
      
      <a href="/memberlist.do">
      <button>목록</button></a>
      
      </td>
      </tr>
      </tbody>  
     </table>
     </section>
</div>
 <jsp:include page="../footer.jsp" />
</body>
</html>