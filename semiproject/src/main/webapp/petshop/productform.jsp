<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Input Form</title>
</head>
<body>

    <form action="pinput.do" method="post">

       <input type="text" name="cc" ><br>

        <label for="pname">상품명:</label>
        <input type="text" name="pname" id="pname" required><br>

        <label for="price">가격:</label>
        <input type="text" name="price" id="price" required><br>

        <label for="pfilename">Product Filename:</label>
        <input type="text" name="pfilename" id="pfilename"><br>

        <input type="submit" value="Submit">
    </form>
 <a href="/cart.do">
                   <button>장바구니</button>
                </a> 
</body>
</html>