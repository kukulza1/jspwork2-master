<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ȿ�� �˻�2</title>
<script type="text/javascript">
  function checkForm(){
	  //�ڹٽ�ũ��Ʈ �Լ� - focus(),select(),submit()
	  //������ ���̸� ���ϴ� �Ӽ� - length
	  //���̸�����  - name �Ӽ��� ����
	 let form =   document.loginForm;
	  let id = form.uid.value;
	  let pw = form.passwd.value;
	  
	  if(id == ""){
		  alert("���̵� �Է����ּ���");
		  form.uid.focus();
		  return false;
	  }else if(pw == "" || form.passwd.value.length <8){
		  alert("��й�ȣ�� 8���̻� �Է����ּ���");
		  form.passwd.select();
		  return false;
	  }else{
		  form.submit(); //�ڹٽ�ũ��Ʈ���� ���� �����ϴ� �޼���
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
				<label for="uid">���̵� </label>
				<input type="text" id="uid" name="uid">
			</li>
			<li>
				<label for="passwd">��й�ȣ </label>
				<input type="password" id="passwd" name="passwd">
			</li>
			<li>
			
				<button type="submit" onclick="checkForm()">�α���</button>
			</li>
		</ul>
	</form>
</body>
</html>