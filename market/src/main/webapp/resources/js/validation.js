/**
 * 상품코드는 p와숫자를 조합하여 5~12자로 입력
 * 상품명은 4~20자로제한
 * 가격및 재고수는 숫자만 입력가능
 */

 let checkproduct = function(){
	 //alert("테스트");
	 let pid = document.getElementById("pid");
	 let pname = document.getElementById("pname");
	 let price = document.getElementById("price");
	 let stock = document.getElementById("stock");
	 
	 //정규표현식
	 let regexpid= /p[0-9]{4,11}/
	 let pp = /[0-9]/
	 
	 if(!regexpid.test(pid.value)){
		 alert("상품코드는 p와숫자를 조합하여 5~12자로 입력해주세요");
		 pid.select();
		 return false;
	 }else if(pname.value.length <4 || pname.value.length>20){
		  alert("상품명은 4~20자로 입력해주세요");
		  pname.select();
	 }else if(price.value.length == 0 || isNaN(price.value)||
	                 price.value < 0 ){
		   alert("상품가격은 숫자만입력해주세요");
		   price.select();
	 }else if(stock.value.length == 0 ||!pp.test(stock.value)){
		 alert("재고수는 숫자만입력해주세요");
		 stock.select();
	 }    
	 else{
		 document.newp.submit();
	 }
	 
 }