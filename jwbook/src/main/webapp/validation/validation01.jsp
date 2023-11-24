<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>유효성 검사</title>
<script type="text/javascript">
  function checkForm(){
	  //폼이름선택
	  
	 let form =   document.loginForm;
	  alert("아이디"+form.uid.value+ "\n"+ "비번:" +form.passwd.value)
  }
</script>
<style type="text/css">
	ul li{list-style: none; margin: 10px;}
</style>
</head>
<body>
	<form action="loginprocess.jsp" method="post" name="loginForm">
		<ul>
			<li>
				<label for="uid">아이디 </label>
				<input type="text" id="uid" name="uid">
			</li>
			<li>
				<label for="passwd">비밀번호 </label>
				<input type="password" id="passwd" name="passwd">
			</li>
			<li>
				<!-- <input type="submit" value="로그인"> -->
				<button type="button" onclick="checkForm()">로그인</button>
			</li>
		</ul>
	</form>
</body>
</html>