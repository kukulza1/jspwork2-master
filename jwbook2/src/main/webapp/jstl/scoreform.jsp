<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
  function check(){
	 // alert("test");
	 let form = document.form1;
	 let score = form.score.value;
	 //값이 입력되지 않았을때,문자가 입력되었을때 처리
	
	 if(score == "" || isNaN(score)){
		 alert("숫자를 입력해주시오");
		 score.focus();
		 return false;
	 }else{
		 form.submit();
	 }
	 
  }
</script>
</head>
<body>
    <h3>점수를 입력해주세요</h3>
    <form action="core2.jsp" method="post" name="form1">
       <p>점수<input type="text" name="score">
      
       <input type="button" value="전송" onclick="check()">
       
       </p>
    </form>
</body>
</html>