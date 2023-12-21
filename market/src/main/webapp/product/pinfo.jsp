<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<script>
 function addToCart(){
	 if(confirm("상품을 주문하시겠습니까?")){
		 document.addform.submit();
	 }else{
		 document.addform.reset();
	 }
 }

</script>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class ="container my-3">
<h2>상품정보</h2>
 <div class="row">
   <div class="col-5">
   <img src="../upload/${product.pimage}" alt="" style="width:100%">
   </div>
   <div class="col-6">
<p><b>상품코드:</b><span class="badge bg-dark">${product.pid}</span></p>
<p>상품명:${product.pname}</p>
<p>상품가격:<fmt:formatNumber value="${product.price}" pattern="#,##0"/></p>
<p>상품설명:${product.description}</p>
<p>상품분류:${product.category}</p>
<p>재고수:${product.stock}</p>

<form action="/addcart.do?pid=${product.pid}" method="post" name="addform">
<!-- 상품주문 버튼을 클릭하면 폼이 전송되어야함 -->
   <a href="#" onclick="addToCart()" class="btn btn-success">상품주문</a>
   <a href="/cart.do" class="btn btn-warning">장바구니</a>
   <button><a href="/productlist.do">목록으로</a></button>
</form>
</div>
</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>