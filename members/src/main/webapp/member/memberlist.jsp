<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
 <jsp:include page="../header.jsp" />
 <div id="container">
   <section id="memberlist">
    <h2>회원목록</h2>
    <div class="logout">
    <p><a href="/logout.do">[관리자 로그아웃]</a></p>
    </div>
     <table>
      <thead>
        <tr>
          <th>번호</th>
          <th>아이디</th>
          <th>비번</th>
          <th>이름</th>
          <th>이메일</th>
          <th>성별</th>
          <th>가입일</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${ml2}" var="m">
      <tr>
      <!-- m.mno - m.getmno()와같음 -->
       <td>${m.mno}</td>
       <!-- id를클릭하면 상세보기란으로 이동 -->
       <td><a href="/memberview.do?memid=${m.memid}">${m.memid}</a></td>
       <td>${m.pw}</td>
       <td>${m.name}</td>
       <td>${m.email}</td>
       <td>${m.gender}</td>
       <td><fmt:formatDate value="${m.joinDate}"
                   pattern="yyyy-MM-dd HH:mm:ss" /></td>
      </tr>
      </c:forEach>     
      </tbody>
     </table>
     </section>
</div>
 <jsp:include page="../footer.jsp" />
</body>
</html>