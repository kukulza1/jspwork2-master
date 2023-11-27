<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>EL언어실습</h2>
   <h3>문자 ,숫자 데이터 표기</h3>
   ${100}<br>
   ${"안녕"}<br>
   ${100+1}
   
   <h3>산술연산</h3>
   ${10+4}
   ${10-4}
   ${10*4}
   ${10/4}
   ${10%4}
   
   <h3>비교연산</h3>
   ${12==12} ,${12eq 12}<br>
   ${12!=12},${not (12==12)}<br>
   ${12>13}, ${12 gt 13}<br>
   ${12<13}, ${12 lt 13}
   
   <h3>논리연산</h3>
   ${not(12==12) }<br>
   ${(12==12) && (12>13)}, ${(12==12) and (12>13)}<br>
   ${(12==12) || (12>13)}, ${(12==12) or (12>13)}<br>
   
</body>
</html>




















