<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../resources/js/jquery-3.7.1.js"></script>
<script>
  //파일이 실행되면 제목이 파랑색으로 바뀜
  $(document).ready(function(){
	// alert("test");
	$("h3").css("color","blue");  
  });
  //버튼클릭후 메세지박스에 메시지실행
  function fnprocess(){
	  //ajax로 구현함
	  //자바스크립트객체(key:value)
	  //서블릿에 요청(매핑주소)
	  $.ajax({  
		 type:"get",             //전송방식
		 dataType:"text",        //데이터유형
		 url:"http://localhost:8080/jwbook2/ajax/ajax1",
		 data:{message: "<p>hello~ajax!!</p>"}, //메세지속성이서블릿에 전송됨
		 success:function(data){  //서블릿에서 응답이오면 데이터출력
			 $("#message").append(data).css("margin-top", "10px");
		 },
		 error: function(){
			 alert("에러발생!");
		 }
		  
	  });
  }
</script>
</head>
<body>
   <h3>ajax(에이젝스)</h3>
   <button type="button" onclick="fnprocess()">전송</button>
   <div id="message"></div>
</body>
</html>