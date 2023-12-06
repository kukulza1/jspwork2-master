<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디중복검사</title>
<script src="../resources/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
      $(function(){
    	  $("h3").css("color","red");
      });
      
      
      function checkId(){
    	  if(t_id.value == ""){
    		  alert("아이디를 입력해주세요");
    		  t_id.focus();
    		  return false;
    	  }
    	 // alert("테스트");
    	 $.ajax({
    		 type:"get",
    		 dataType:"text",
    		 url:"/test/checkid",//http://localhost:8080/test/checkid
    		 data:{id: $("#t_id").val()},//id속성 이서버로 전달됨
    		 success:function(data){
    			 if(data == "usable"){
    				 $("#message").text("사용할수있는id입니다");
    			 }else{
    				 $("#message").text("이미가입된id입니다");
    			 }
    		 },
    		 error:function(){
    			 alert("에러발생")
    		 }
    	 });
      }
 </script>


</head>
<body>
    <h3>id중복검사</h3>
    <p><input type="text" id="t_id">
    <input type="button" value="id중복" onclick="checkId()"></p>
    <div id="message"></div>
</body>
</html>