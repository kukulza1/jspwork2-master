<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	ul li{list-style: none; margin: 10px;}
</style>
</head>
<body>
   <h3>회원가입EL</h3>
   <form action="member02process.jsp" method="post" name="member">
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
				<!-- <input type="submit" value="로그인"> -->
				<button type="submit">가입</button>
				<button type="reset">취소</button>
			</li>
		</ul>
	</form>
</body>
</html>