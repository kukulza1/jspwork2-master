<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조인폼</title>
<script type="text/javascript">
  function checkForm(){
	  //1.아이디는 문자로만 시작해주세요 2.비밀번호는숫자만가능 3.이름은 한글만가능
	  let form = document.member;
	  let id = form.uid.value;
	  let pw = form.passwd.value;
	  let name = form.uname.value;
	  let phone = form.phone1.value + "-" + form.phone2.value + "-" + form.phone3.value;
	  
	  let regexId = /^[a-zA-Z가-힣]/;
	  let regexpw = /^[0-9]+$/ ;//숫자 1개이상
	  let regexname = /^[가-힣]+$/ ;//한글1자이상
	  let regexphone = /\d{2,3}-\d{3,4}-\d{4}/ ;
	 // let regexen = /^[a-zA-Z]+/ //영문1자이상
		  
	  if(!regexId.test(id)){
		  alert("아이디는 문자로 시작해주세요");
		  form.uid.select();
		  return false;
	  }else if(!regexpw.test(pw)){
		  alert("비번은 숫자만입력해주세요");
		  form.passwd.select();
		  return false;
	  }else if(!regexname.test(name) ){
		  alert("이름은 한글만입력하세요");
		  form.name.select();
		  return false;
	  }else if(!regexphone.test(phone) ){
		  alert("연락처 입력을 확인하세요");
		  form.phone.select();
		  return false;
	  }else{
		  form.submit();
	  }
	  
	  
	  
  }
</script>
<style type="text/css">
	ul li{list-style: none; margin: 10px;}
</style>
</head>
<body>
	<form action="joinprocess.jsp" method="post" name="member">
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
				<label for="uname">이름 </label>
				<input type="text" id="uname" name="uname">
			</li>
			<li>
				<label for="phone">연락처 </label>
				<select name="phone1">
				 <option value="010">010</option>
				 <option value="02">02</option>
				 <option value="031">031</option>
				</select>-<input type="text" name="phone2" maxlength=4 size=4>-<input type="text" name="phone3" maxlength=4 size=4>
			</li>
			<li>
				<!-- <input type="submit" value="로그인"> -->
				<button type="button" onclick="checkForm()">가입</button>
			</li>
		</ul>
	</form>
</body>
</html>