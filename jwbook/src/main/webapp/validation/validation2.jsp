<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>유효성 검사2</title>
<script type="text/javascript">
  function checkForm(){
	  //자바스크립트 함수 - focus(),select(),submit()
	  //글자의 길이를 정하는 속성 - length
	  //폼이름선택  - name 속성을 선택
	 let form =   document.loginForm;
	  let id = form.uid.value;
	  let pw = form.passwd.value;
	  
	  if(id == ""){
		  alert("아이디를 입력해주세요");
		  form.uid.focus();
		  return false;
	  }else if(pw == "" || form.passwd.value.length <8){
		  alert("비밀번호는 8자이상 입력해주세요");
		  form.passwd.select();
		  return false;
	  }else{
		  form.submit(); //자바스크립트에서 폼을 전송하는 메서드
	  }
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
			
				<button type="submit" onclick="checkForm()">로그인</button>
			</li>
		</ul>
	</form>
</body>
</html>