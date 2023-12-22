<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품수정</title>
<script src="../resources/js/validation.js"></script>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class ="row">
<h2>상품수정</h2>
<form action="/updateproduct.do" method="post" enctype="multipart/form-data"
       name="newp">
 
   <div class="form-group row my-3">
      <label class="col-2">상품코드</label>
      <div class="col-3">
      <input type="text" id="pid" name="pid" class="form-control"
       value="${product.pid}" readonly>
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">상품명</label>
      <div class="col-3">
      <input type="text" id="pname" name="pname" class="form-control"
      value="${product.pname}">
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">상품가격</label>
      <div class="col-3">
      <input type="text" id="price" name="price" class="form-control"
      value="${product.price}">
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">상품설명</label>
      <div class="col-3">
      <textarea rows="3" cols="40" name="description" class="form-control"
          >${product.description}</textarea>
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">카테고리</label>
      <div class="col-3">
      <input type="text" name="category" class="form-control"
      value="${product.category}">
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">재고수</label>
      <div class="col-3">
      <input type="text" id="stock" name="stock" class="form-control"
      value="${product.stock}">
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">상태</label>
      <div class="col-3">
      <c:if test="${product.condition eq 'new'}">
     <label> <input type="radio" name="condition" value="new" checked>신상품</label>
     <label> <input type="radio" name="condition" value="old">중고품</label>
     </c:if>
      <c:if test="${product.condition eq 'old'}">
   
     <label> <input type="radio" name="condition" value="new" >신상품</label>
       <label> <input type="radio" name="condition" value="old" checked>중고품</label>
     </c:if>
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">이미지</label>
      <div class="col-3">
      <input type="file" name="pimage" class="form-control"
      value="${product.pimage}">
      </div>
   </div>
   
   <div class="form-group row my-3">
    
      <div class="col-3">
       <input type="button" value="등록" onclick="checkproduct()">
      </div>
   </div>


</form>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>