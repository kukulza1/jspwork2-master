<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>

</head>
<body>
<%@ include file="../header.jsp" %>
<div class ="container my-3">
<h2>주문내역</h2>
 <div class="row my-3">
  <div class="col-4" align="left">
    배송주소<br>
    성명: ${shipping_sname }
    우편번호: ${shipping_zipcode }
    주소: ${shipping_address }
    
 </div>
 <div class="col-8" align="right">
   배송일:${shipping_sdate }
 </div>
   
 
     <table class="table table-hover my-3 px-3">
        <thead>
            <tr>
              <th>상품</th>
              <th>가격</th>
              <th>수량</th>
              <th>소계</th>
              <th>비고</th>
            </tr>
        </thead>
        <tbody>
          <c:forEach items="${cartlist}" var="product">
          <tr>
           <td>${product.pid}-${product.pname}</td>
           <td><fmt:formatNumber value="${product.price}" pattern="#,##0"/></td>
           <td>${product.quantity}</td>
           <td><fmt:formatNumber value="${product.price* product.quantity}" pattern="#,##0"/></td>
           <td><a href="/removecart.do?pid=${product.pid}" class="badge bg-dark">삭제</a></td>
          </tr>
          </c:forEach>
        </tbody>
        <tfoot>
           <tr>
             <td></td>
             <td></td>
             <td>총액</td>
             <td><fmt:formatNumber value="${sum}" pattern="#,##0"/></td>
             
           
           </tr>
        </tfoot>
     </table>
     <p class="text-center"><a href="/thankscustomer.do" class="btn btn-success">주문완료</a></p>
   
</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>