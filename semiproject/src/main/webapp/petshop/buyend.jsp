<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매내역페이지</title>
<link rel="stylesheet" href="resource/css/stylebuyend.css">
</head>
<body>
<jsp:include page="../header.jsp" />
        

        <div id="mid">
            <h3>구매내역</h3>
            <section id="buyend">
               <table>
                    <thead>
                        <tr>
                            <th class="col"><p>상품정보</p></th>
                            <th class="col"><p>주문일자</p></th>
                            <th class="col"><p>주문번호</p></th>
                            <th class="col"><p>주문금액</p></th> 
                        </tr>
                    </thead>
         <c:forEach items="${buyend}" var="be">
                    <tbody>
                        
                        <tr>
                            <td><p><img src="resource/img/sss.png"></p> <p>${be.product}</p></td>
                            <td><fmt:formatDate value="${be.orderdate}"
                                   pattern="yyyy-MM-dd HH:mm" /></td>
                            <td><p>${be.ordernum}</p></td>
                            <td><p>${be.price}</p></td>
                        </tr>
                        
                         </c:forEach>    
                    </tbody>
                </table> 
                <div id="page">
                    <a href=""><button class="arrow"><</button></a>
                    <a href=""><button>1</button></a>
                    <a href=""><button>2</button></a>
                    <a href=""><button>3</button></a>
                    <a href=""><button>4</button></a>
                    <a href=""><button class="arrow">></button></a>
                </div>
                <c:forEach var="i" begin="1" end="${endp}">
				<c:if test="${page == i}">
					<a href="/boardlist.do?pageNum=${i}"><b>${i}</b></a>
				</c:if>
				<c:if test="${page != i}">
					<a href="/boardlist.do?pageNum=${i}">${i}</a>
				</c:if>
			</c:forEach>
                

                <a href="/">
                   <button id="toList" >목록으로</button>
                </a> 
            </section>
        </div>
  <jsp:include page="../footer.jsp" />  
</body>
    <script src="script.js"></script>

</html>