<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="https://kit.fontawesome.com/b56be2ad7d.js"
	crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정/삭제</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<!-- 관리자만 수정/삭제 사용됨 -->
	<%-- <c:if test="${empty sessionAdmin}">
		<script type="text/javascript">
			alert("관리자 로그인이 필요합니다.");
			location.href = "/loginform.do"
		</script>
	</c:if> --%>
	<jsp:include page="../header.jsp" />
	<div id="container">
		<section id="">
			<h2>상품 수정/삭제</h2>
			<table>
				<tbody>
					<c:forEach items="${productList}" var="product">
						<tr>
							<td>${product.pno}</td>
							<td>${product.pname}</td>
							<td>${product.price}</td>
							<td>${product.pcontent}</td>
							<td>${product.category}</td>
						</tr>
						<tr>
							<td>
								<div>
									<c:if test="${not empty product.pfilename}">
										<img src="../fileupload/${product.pfilename}" alt="">
									</c:if>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<a href="/updateform.do?pno=${product.pno}"><button type="button">수정</button></a> 
								<a href="/deleteproduct.do?pno=${product.pno}"><button type="button" onclick="return confirm('삭제하시겠습니까?')">삭제</button></a>
							</td>
						</tr>
					</c:forEach>
					<a href="/product/insertproduct.jsp"><button type="submit">상품등록</button></a>
					<a href="/productlist.do"><button type="submit">목록</button></a>
				</tbody>
			</table>
		</section>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>