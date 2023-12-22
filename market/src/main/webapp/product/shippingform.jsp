<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송정보</title>
<script src="../resources/js/validation.js"></script>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class ="row">
<h2>배송정보</h2>
<form action="/shippinginfo.do" method="post" >
<input type="hidden" name="cartid" value="${cartid}">
   <div class="form-group row my-3">
      <label class="col-2">성명</label>
      <div class="col-3">
      <input type="text"  name="sname" class="form-control">
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">배송일</label>
      <div class="col-3">
      <input type="text"  name="sdate" class="form-control">
      </div>
   </div>
   
   <div class="form-group row my-3">
      <label class="col-2">우편번호</label>
      <div class="col-3">
      <input type="text"  name="zipcode" class="form-control">
      </div>
   </div>
   
   
   
   <div class="form-group row my-3">
      <label class="col-2">주소</label>
      <div class="col-3">
      <input type="text" name="address" class="form-control">
      </div>
   </div>
   
   
   
   <div class="form-group row my-3">
    
      <div class="col-3">
       <input type="submit" value="등록" >
      </div>
   </div>


</form>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>