<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입페이지</title>
<link rel="stylesheet" href="resources/css/style.css">

<script src="../resources/js/jquery-3.7.1.js"></script>
<script src="../resources/js/validation.js"></script>
</head>
<body>
 <jsp:include page="../header.jsp" />
 <div id="container">
   <section id="join">
    <h2>회원가입</h2>
     <form action="/insertmember.do" method="post" name="member">
      <fieldset>
         <ul>
         <li>
          <label for="id">아이디</label>
          <input type="text" id="id" name="id"  required
                placeholder="아이디는4~15자 까지입력가능.">
                <button type="button" id="btnChk" value="N"
             class="btn_check" onclick="checkId()">아이디중복</button>
             <p id="message"></p>
         </li>
         
         <li>
          <label for="passwd">비번</label>
          <input type="text" id="passwd" name="passwd" required
             placeholder="비밀번호는 영문자숫자 특수문자포함해서 8자이상입력가능.">
             
         </li>
         
         <li>
          <label for="passwd2">비번확인</label>
          <input type="text" id="passwd2" name="passwd2" 
           placeholder="비밀번호를 동일하게 입력해주세요">
         </li>
         
         <li>
          <label for="name">이름</label>
          <input type="text" id="name" name="name" required
            placeholder="이름은한글로만입력해주세요">
         </li>
         
         <li>
          <label for="email">이메일</label>
          <input type="text" id="email" name="email" required>
         </li>
         
         <li>
          <label for="gender">성별</label>
          <input type="radio" id="gender" name="gender" value="남">남
          <input type="radio" id="gender" name="gender" value="여">여
         </li>
         </ul>
      </fieldset>
      <div class="button">
       <button type="button" onclick="checkmember()">가입</button>
       <button type="reset">취소</button>
      </div>
     </form>
     </section>
</div>
 <jsp:include page="../footer.jsp" />
</body>
</html>