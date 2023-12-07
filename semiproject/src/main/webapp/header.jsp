<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
<div id="top">
 <c:choose>
      <c:when test="${empty sessionid}">
    <div class="top-top">

        <div class="mini-shortcut"> <!-- 상단 좌측 링크 아이콘 -->
            <ul class="ms-list">
                <li><a href="">youtube</a></li>
                <li><a href="">instagram</a></li>
                <li><a href="">twitter</a></li>
            </ul>
        </div>
     
        <div class="top-top-menu"> <!-- 상단 미니메뉴 -->
            <ul class="ttm-list">
                <li><a href="">JOIN</a></li>              
                <li><a href="/loginpage.do">LOG IN</a></li>
                <li><a href="#">MY PAGE</a></li>          
                <li><a href="">BASKET</a></li>
                <li><a href="">ORDER INQUIRY</a></li>
                <li><a href="">BOARD</a></li>
                <li><input type="text" id="search"> 🔍</li> <!-- 상단 검색창 -->
            </ul>
        </div>
    </div>  
    </c:when>
<c:otherwise>
<div class="top-top">
        <div class="mini-shortcut"> <!-- 상단 좌측 링크 아이콘 -->
            <ul class="ms-list">
                <li><a href="">youtube</a></li>
                <li><a href="">instagram</a></li>
                <li><a href="">twitter</a></li>
            </ul>
        </div>
     
        <div class="top-top-menu"> <!-- 상단 미니메뉴 -->
            <ul class="ttm-list">
                <li><a href="">JOIN</a></li>              
                <li><a href="/logout.do">LOG OUT</a></li>
                <li><a href="/mypage">MY PAGE</a></li>          
                <li><a href="">BASKET</a></li>
                <li><a href="">ORDER INQUIRY</a></li>
                <li><a href="">BOARD</a></li>
                <li><input type="text" id="search"> 🔍</li> <!-- 상단 검색창 -->
            </ul>
        </div>
    </div>  

  </c:otherwise>
  </c:choose>
    <div class="top-mid">   <!-- 메인 로고, 사진 -->
        <a href=""><img class="logo-pic" src="img/logoimg.jpg" alt=""></a>
    </div>

    <div class="top-btm">   <!-- 사이트 내 각종 메뉴 모음 -->
        <div class="top-btm-menu">
            <ul class="tbm-list">
                <li><a href="">MENU1</a></li>
                <li><a href="">MENU2</a></li>
                <li><a href="">MENU3</a></li>
                <li><a href="">MENU4</a></li>
                <li><a href="">MENU5</a></li>
                <li><a href="">MENU6</a></li>
                <li><a href="">MENU7</a></li>
                <li><a href="">MENU8</a></li>
                <li><a href="">MENU9</a></li>
            </ul>
        </div>
    </div>
</div>
</header>
