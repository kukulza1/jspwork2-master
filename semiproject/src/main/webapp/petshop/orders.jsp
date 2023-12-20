<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>주문 정보 입력 폼</title>
</head>
<body>

<form action="/orders.do" method="post"  enctype="multipart/form-data">
 
  <label for="orderprice">주문 가격:</label>
  <input type="number" id="orderprice" name="orderPrice"><br>

  <label for="cardcompany">카드 회사:</label>
  <input type="text" id="cardcompany" name="cardCompany" maxlength="30"><br>

  <label for="count">수량:</label>
  <input type="number" id="count" name="count"><br>

  <label for="id">아이디:</label>
  <input type="text" id="id" name="id" maxlength="20" required><br>

  <label for="pname">제품 이름:</label>
  <input type="text" id="pname" name="pname" maxlength="40" required><br>
  
         <label for="file">파일첨부:</label>
          <input type="file" name="filename">         
          

 
  <input type="submit" value="주문 추가">
</form>

</body>
</html>

