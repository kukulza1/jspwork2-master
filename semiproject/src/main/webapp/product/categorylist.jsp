<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고양이 상품</title>
<link rel="stylesheet" href="../resources/css/product.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id="mid">
		<div class="mid_container">
			<div class="dog_tap">
				<div class="menu_subject">
					<a href="/categorylist.do?category=강아지">
						<h3>멍뭉</h3>
					</a>
					<div class="sub_taps">
						<a href="/categorylist.do?category=강아지"><span>먹거리</span></a> | <a href="/categorylist.do?category=강아지"><span>용품</span></a>
					</div>
				</div>
			</div>
			<div class="cat_tap">
				<div class="menu_subject">
					<a href="/categorylist.do?category=고양이">
						<h3>꼬냥</h3>
					</a>
					<div class="sub_taps">
						<a href="/categorylist.do?category=고양이"><span>먹거리</span></a> | <a href="/categorylist.do?category=고양이"><span>용품</span></a>
					</div>
				</div>
			</div>
			<div class="hamster_tap">
				<div class="menu_subject">
					<a href="/categorylist.do?category=햄스터">
						<h3>햄찌</h3>
					</a>
					<div class="sub_taps">
						<a href="/categorylist.do?category=햄스터"><span>먹거리</span></a> | <a href="/categorylist.do?category=햄스터"><span>용품</span></a>
					</div>
				</div>
			</div>
			<div class="event_tap">
				<div class="menu_subject">
					<a href="/categorylist.do?category=이벤트">
						<h3>이벤트</h3>
					</a>
					<div class="sub_taps">
						<a href="/categorylist.do?category=이벤트"><span>기간 할인</span></a> | <a href="/categorylist.do?category=이벤트"><span>신상품</span></a>
						| <a href="/categorylist.do?category=이벤트"><span>한정판</span></a>
					</div>
				</div>
			</div>
		</div>
		<c:forEach items="${categoryList}" var="product">
				<td><a href="/productview.do?pno=${product.pno}">${product.pno}</a></td>
				<td>${product.pname}</td>
				<td>${product.price}</td>
				<td>${product.pcontent}</td>
				<td>${product.category}</td>
		</c:forEach>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>