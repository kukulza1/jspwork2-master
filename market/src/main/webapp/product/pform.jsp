<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class ="row">
<h2>상품등록</h2>
<form action="/insertproduct.do" method="post" enctype="multipart/form-data">

   <div class="form-group row my-3">
      <label class="col-2">상품코드</label>
      <div class="col-3">
      <input type="text" name="pid" class="form-control">
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">상품명</label>
      <div class="col-3">
      <input type="text" name="pname" class="form-control">
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">상품가격</label>
      <div class="col-3">
      <input type="text" name="price" class="form-control">
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">상품설명</label>
      <div class="col-3">
      <textarea rows="3" cols="40" name="description" class="form-control"></textarea>
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">카테고리</label>
      <div class="col-3">
      <input type="text" name="category" class="form-control">
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">재고수</label>
      <div class="col-3">
      <input type="text" name="stock" class="form-control">
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">상태</label>
      <div class="col-3">
     <label> <input type="radio" name="condition" value="new" checked>신상품</label>
     <label> <input type="radio" name="condition" value="old">중고품</label>
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">이미지</label>
      <div class="col-3">
      <input type="file" name="pimage" class="form-control">
      </div>
   </div>
   
   <div class="form-group row my-3">
    
      <div class="col-3">
       <input type="submit" value="등록">
      </div>
   </div>


</form>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>