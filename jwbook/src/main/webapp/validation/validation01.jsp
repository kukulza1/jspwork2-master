<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ȿ�� �˻�</title>
<script type="text/javascript">
  function checkForm(){
	  //���̸�����
	  
	 let form =   document.loginForm;
	  alert("���̵�"+form.uid.value+ "\n"+ "���:" +form.passwd.value)
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
				<label for="uid">���̵� </label>
				<input type="text" id="uid" name="uid">
			</li>
			<li>
				<label for="passwd">��й�ȣ </label>
				<input type="password" id="passwd" name="passwd">
			</li>
			<li>
				<!-- <input type="submit" value="�α���"> -->
				<button type="button" onclick="checkForm()">�α���</button>
			</li>
		</ul>
	</form>
</body>
</html>