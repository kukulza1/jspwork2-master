<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매내역페이지(new)</title>
<link rel="stylesheet" href="/resources/css/buyliststyle.css">
</head>
<body>

	<div id="container">
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
         			
                    <tbody>
                    <c:forEach items="${buyend}" var="be">
                        <tr>
                        
                            <td>
                            <div>
                            <c:if test="${not empty be.filename }">
                             <img src="../upload/${be.filename}" alt="">
                            </c:if>
                            </div>
                            <p>${be.pname}</p>
                            </td>
                            
                            <td><fmt:formatDate value="${be.orderDate}"
                                   pattern="yyyy-MM-dd HH:mm" /></td>
                                   
                            <td><p>${be.orderNo}</p></td>
                            
                            <td><p>${be.orderPrice}</p></td>
                            
                        </tr>
                      </c:forEach>  
                    </tbody>
                        
                </table> 
                
                
                <div id="page">
                    
             
                <c:forEach var="i" begin="1" end="${endp}">
					<c:if test="${page == i}">
						<a href="/buyList.do?pageNum=${i}"><b>${i}</b></a>
					</c:if>
					<c:if test="${page != i}">
						<a href="/buyList.do?pageNum=${i}">${i}</a>
					</c:if>
				</c:forEach>
                   </div>
                   <a href="/">
                   <button id="toList" >메인으로</button>
                </a> 
                
            </section>
            
        </div>
        
  <jsp:include page="../footer.jsp" />  
  </div>
  
</body>
    <script src="script.js"></script>
</html>