<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글수정</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
  
 <div id="container">
   <section id="writeform">
    <h2>게시글수정</h2>
    <form action="/updateboard.do" method="post">
    <!-- ui를 만들지않고 데이터만 숨겨서 보낼때사용 -->
     <input type="hidden" name="bno" value="${b.bno}">
    <table>
      <tbody>
          <tr>
          <td><input type="text" name="title"
              value="${b.title}"></td>
          </tr>      
          <tr>
           <td><textarea rows="7" cols="100" name="content"
              placeholder="글내용">${b.content}</textarea></td>
          </tr>
          <tr>
           <td>
            <button type="submit">저장</button>
            <button type="reset">취소</button>
           </td>
          </tr>
      </tbody>
    </table>
    
    </form>
     </section>
</div>
 <jsp:include page="../footer.jsp" />
</body>
</html>