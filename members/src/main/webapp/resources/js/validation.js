/**
 * 
 */
function checkmember(){
	//alert("test!");
	//input의 name속성을 변수에 할당
	let form = document.member;  
	let id = form.id.value;    
	let pw1= form.passwd.value;  // name속성 id 속성둘다가능
	let pw2 = form.passwd2.value;
	let name = form.name.value;
	let btnchk = form.btnChk.value;
	//정규표현식
	//비번
	let regexpw1 = /[0-9]+/; //숫자
	let regexpw2 = /[a-zA-Z]+/; //영문자
	let regexpw3 = /[~!@#$%^&*()_+]+/; //특수문자
	//이름
	let regexname = /^[가-힣]+$/ //한글만
	
	
	if(id.length < 4 || id.length>15){
		alert("아이디는4~15자 까지입력가능합니다");
		id.select();
		return false;
	}else if(pw1.length<8 || !regexpw1.test(pw1) ||
			!regexpw2.test(pw1) || !regexpw3.test(pw1) ){
		alert("비밀번호는 영문자숫자 특수문자포함해서 8자이상입력가능합니다.");
		pw1.select();
		return false;
	}else if(pw1 != pw2){
		alert("비밀번호를 동일하게 입력해주세요")
		pw2.select();
	}else if(!regexname.test(name)){
		alert("이름은 한글로입력해주세요")
		name.select();
	}else if(!regexname.test(name)){
		 alert("이름은 한글로 입력해주세요")
		 name.select();
	}else if(btnchk == 'N'){
		alert("아이디 중복체크해주세요");
	}
	else{
		form.submit(); //오류가 없으면 폼을 메인컨트롤러로 전송
	}
  }
  
  
  
  
function checkId(){
    	  if(id.value == ""){
    		  alert("아이디를 입력해주세요");
    		  id.focus();
    		  return false;
    	  }
    	 // alert("테스트");
    	 $.ajax({
    		 type:"get",
    		 dataType:"text",
    		 url:"/member/checkid",//http://localhost:8080/test/checkid
    		 data:{id: $("#id").val()},//id속성 이서버로 전달됨
    		 success:function(data){
    			 if(data == "usable"){
					 $("#btnChk").attr("value","Y"); //버튼 value값을 "Y"로설정
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