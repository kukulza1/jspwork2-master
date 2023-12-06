/**
 * 
 */
let form = document.member;  
let id = form.uid.value;  
id.focus();
function checkForm(){
let form = document.member;  
let id = form.uid.value;    
let pw1= form.passwd.value;  // name속성 id 속성둘다가능
let name = form.name.value;
let regexname = /[a-zA-Z]+/; 
let regexpw1 = /[0-9]+/; 
let regexpw2 = /[a-zA-Z]+/; 
let regexpw3 = /[~!@#$%^&*()_+]+/; 
 

 if(id.length < 5 || id.length>12){
	 alert("아이디는5~12자 까지입력가능");
	 id.select();
	 return false;
   }else if(pw1.length<7 || !regexpw1.test(pw1) ||
			!regexpw2.test(pw1) || !regexpw3.test(pw1) ){
		       alert("비밀번호는 영문자숫자 특수문자포함해서 7자이상입력가능합니다.");
		        pw1.select();
		           return false;
	  }else if( ! regexname.test(name)){
		alert("영문으로입력하세요")
    }else{  }
	}