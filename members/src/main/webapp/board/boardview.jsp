<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세보게</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
  <c:if test="${empty sbsession}">
  <script type="text/javascript">
  alert('로그인이필요합니다.');
  location.href="/loginform.do";
  </script>
  </c:if>
 <jsp:include page="../header.jsp" />
 <div id="container">
   <section id="boardview">
    <h2>글보기</h2>
    
    <table>
      <tbody>
          <tr>
          <td><input type="text" name="title" value="${bb1.title}" readonly></td>
          </tr>      
          <tr>
          <td><textarea rows="7" cols="100" name="content" readonly>${bb1.content}</textarea></td>
          </tr>      
          
          <tr>
           <td>
           <c:if test="${sbsession eq bb1.memid}">
           <a href="/updateboardform.do?bno=${bb1.bno}"><button type="button">수정</button></a>
           <a href="/deleteboard.do?bno=${bb1.bno}"
             onclick="return confirm('정말로삭제하시겠습니까?')"><button type="button">삭제</button></a>
           </c:if>
           <a href="/boardlist.do"><button type="button">목록으로</button></a>
       
           </td>
          </tr>
      </tbody>
    </table>
    <!-- 댓글영역  -->
    <h3>댓글</h3>
     <c:forEach items="${rl1}" var="r">
     <div class="reply">
         <p>${r.rcontent}</p>
         <p>작성자:${r.replyer}(작성일:${r.rdate})
         <p>
         <c:if test="${sbsession eq r.replyer}">
          <a href="/updaterely.do?bno=${bb1.bno}&rno=${r.rno}">수정</a>
          :<a href="/deletereply.do?bno=${bb1.bno}&rno=${r.rno}"
             onclick="return confirm('정말로삭제하시겠습니까?')">삭제</a>
             </c:if>
         </p>
     </div>
         </c:forEach>
     
     <!-- 댓글등록 -->
     <form action="insertreply.do" method="post" id="replyform">
     <input type="hidden" name="bno" value="${bb1.bno}">
     <input type="hidden" name="replyer" value="${sbsession}">
     <p>
      <textarea rows="4" cols="50" name="rcontent" placeholder="댓글"
      ></textarea>
     </p>
     <button type="submit">등록</button>
     <!-- 로그인한 사용자만 댓글등록가능 -->
     <h3><i class="fa-solid fa-pen"></i></h3>
     <c:if test="${empty sbsession}">
     <div class="replylogin">
       <a href="/loginform.do">로그인한 사용자만 댓글등록이가능합니다.</a>
     </div>
     </c:if>
     </form>
     </section>
</div>
 <jsp:include page="../footer.jsp" />
</body>
</html>










