<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="mypage.css">
<title>Insert title here</title>
</head>
<body>
 <div id="container">
        <div id="top">
            <div class="top-top">
                <div class="tt-box">
                    <div class="mini-shortcut"> <!-- 상단 좌측 링크 아이콘 -->
                    </div>
            
                    <div class="top-top-menu"> <!-- 상단 미니메뉴 -->
                        <ul class="ttm-list">
                            <li><a href="#">JOIN</a></li>
                            <li><a href="#">LOG-IN</a></li>
                            <li><a href="#">MY-PAGE</a></li>
                            <li><a href="#">BASKET</a></li>
                            <li><a href="#">ORDER-INQUIRY</a></li>
                            <li><a href="#">BOARD</a></li>
                            <li><input type="text" id="search"> 🔍</li> <!-- 상단 검색창 -->
                        </ul>
                    </div>
                </div>
            </div>  
        
            <div class="top-mid">   <!-- 메인 로고, 사진 -->
                <a href=""><img class="logo-pic" src="/img/logo/01_logo2.2.jpg" alt=""></a>
            </div>
        
            <div id="top-btm"> <!-- 사이트 내 각종 메뉴 모음 -->
                <nav class="top-btm-menu">
                    <ul class="tbm-list">
                        <li class="tbm-list-li"><a href="#"><i class="fa-solid fa-bars"></i> 전체 메뉴</a>
                            <ul class="sub_all_menu">
                                <ul><a href="">강아지 먹거리</a>
                                    <a href=""><li>사료</li></a>
                                    <a href=""><li>간식</li></a>
                                    <a href=""><li>영양제</li></a>
                                </ul>
                                <ul><a href="">강아지 용품</a>
                                    <a href=""><li>강아지 집</li></a>
                                    <a href=""><li>강아지 옷</li></a>
                                    <a href=""><li>강아지 장난감</li></a>
                                    <a href=""><li>강아지 밥그릇</li></a>
                                    <a href=""><li>강아지 산책용품</li></a>
                                </ul>
                                <ul><a href="">고양이 먹거리</a>
                                    <a href=""><li>사료</li></a>
                                    <a href=""><li>간식</li></a>
                                    <a href=""><li>영양제</li></a>
                                </ul>
                                <ul><a href="">고양이 용품</a>
                                    <a href=""><li>고양이 집</li></a>
                                    <a href=""><li>고양이 옷</li></a>
                                    <a href=""><li>고양이 장난감</li></a>
                                    <a href=""><li>고양이 밥그릇</li></a>
                                    <a href=""><li>고양이 방콕용품</li></a>
                                </ul>
                                <ul><a href="">햄스터 먹거리</a>
                                    <a href=""><li>사료</li></a>
                                    <a href=""><li>간식</li></a>
                                    <a href=""><li>영양제</li></a>
                                </ul>
                                <ul><a href="">햄스터 용품</a>
                                    <a href=""><li>햄스터 집</li></a>
                                    <a href=""><li>햄스터 장난감</li></a>
                                    <a href=""><li>햄스터 밥그릇</li></a>
                                    <a href=""><li>햄스터 챗바퀴</li></a>
                                    <a href=""><li>햄스터 이갈이</li></a>
                                </ul>
                                <ul><a href="">이벤트 상품</a>
                                    <a href=""><li>기간 할인 상품</li></a>
                                    <a href=""><li>신상품 할인 이벤트</li></a>
                                    <a href=""><li>시즌 한정 상품</li></a>
                                </ul>
                            </ul>
                        </li>
                        <li class="tbm-list-li"><a href="#">강아지 먹거리</a>
                            <ul class="sub_menu">
                                <a href=""><li>사료</li></a>
                                <a href=""><li>간식</li></a>
                                <a href=""><li>영양제</li></a>
                            </ul>
                        </li>
                        <li class="tbm-list-li"><a href="#">강아지 용품</a>
                            <ul class="sub_menu">
                                <a href=""><li>강아지 집</li></a>
                                <a href=""><li>강아지 옷</li></a>
                                <a href=""><li>강아지 장난감</li></a>
                                <a href=""><li>강아지 밥그릇</li></a>
                                <a href=""><li>강아지 산책용품</li></a>
                            </ul>
                        </li>
                        <li class="tbm-list-li"><a href="#">고양이 먹거리</a>
                            <ul class="sub_menu">
                                <a href=""><li>사료</li></a>
                                <a href=""><li>간식</li></a>
                                <a href=""><li>영양제</li></a>
                            </ul>
                        </li>
                        <li class="tbm-list-li"><a href="#">고양이 용품</a>
                            <ul class="sub_menu">
                                <a href=""><li>고양이 집</li></a>
                                <a href=""><li>고양이 옷</li></a>
                                <a href=""><li>고양이 장난감</li></a>
                                <a href=""><li>고양이 밥그릇</li></a>
                                <a href=""><li>고양이 방콕용품</li></a>
                            </ul>
                        </li>
                        <li class="tbm-list-li"><a href="#">햄스터 먹거리</a>
                            <ul class="sub_menu">
                                <a href=""><li>사료</li></a>
                                <a href=""><li>간식</li></a>
                                <a href=""><li>영양제</li></a>
                            </ul>
                        </li>
                        <li class="tbm-list-li"><a href="#">햄스터 용품</a>
                            <ul class="sub_menu">
                                <a href=""><li>햄스터 집</li></a>
                                <a href=""><li>햄스터 장난감</li></a>
                                <a href=""><li>햄스터 밥그릇</li></a>
                                <a href=""><li>햄스터 챗바퀴</li></a>
                                <a href=""><li>햄스터 이갈이</li></a>
                            </ul>
                        </li>
                        <li class="tbm-list-li"><a href="#">이벤트 상품</a>
                            <ul class="sub_menu">
                                <a href=""><li>기간 할인 상품</li></a>
                                <a href=""><li>신상품 할인 이벤트</li></a>
                                <a href=""><li>시즌 한정 상품</li></a>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        
        <div id="mid">
            <h3>회원정보수정,삭제</h3>

            <div class="mid-top">
                <!-- <div class="member_info">
                    <img src="#" alt="">
                    
                </div>-->
            </div>

            <div class="mid-mid">
                <div class="basic_info">
                    <div class="basic_info_span">
                        <span class="span_title">회원정보수정</span>
                    
                    </div>
                    <form action="/updatemember.do">
                        <table>
                            <tbody>
                               
                                <tr>
                                    <th>이름 </th>
                                    <td><input type="text" size="10" name="name"></td>
                                </tr>
                                <tr>
                                    <th>주소</th>
                                    <td>
                                        <div class="order_address">
                                            <input type="text" size="10" name="zip_code"><button>우편번호 ></button> <br>
                                            <input type="text" size="30" name="address"> 기본주소 <br>
                                            <input type="text" size="30" name="detailaddress"> 나머지주소
                                        </div>
                                    </td>
                                </tr>
                              
                                <tr>
                                    <th>휴대전화</th>
                                    <td>
                                         <input type="tel" id="phone" name="phone" >
                                    </td>
                                </tr>
                               
                                <tr>
                                    <th>이메일</th>
                                    <td>
                                        <input type="text" name="email">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="basic_info_btn">
                            <div class="info_edit">
                               <button type="submit">수정</button>
                                                          
                            </div>
                            <%  String id = (String)session.getAttribute("sessionId"); %>
                              <input type="hidden" name="id" value="<%= id %>">
                        </div>
                    </form>
                </div>
            </div>






        </div>
        <div id="bottom">
            <div class="btm-box">
                <div class="cst-center">
                    <p class="info-title">CUSTOMER CENTER</p><br>
                    <p class="info-content">
                        TEL 010-0000-0000 <br>
                        Kakao team_2 <br>
                        AM 10 ~ PM 6 <br>
                        Closed ~ Weekend, Holiday
                    </p>
                </div>
                <div class="bank-info">
                    <p class="info-title">BANK INFO</p><br>
                    <p class="info-content">
                        <span>농협 123-1234-1234-12</span> / <span>국민 123456-12-123456</span><br>
                        예금주 : (주)team_2
                    </p>
                </div>
                <div class="btm-icon">
                    <ul class="btm-icon-list">
                        <li><a href=""><img class="icon" src="/img/icon/icon_quick1.png" alt=""></a></li>
                        <li><a href=""><img class="icon" src="/img/icon/icon_quick2.png" alt=""></a></li>
                        <li><a href=""><img class="icon" src="/img/icon/icon_quick3.png" alt=""></a></li>
                        <li><a href=""><img class="icon" src="/img/icon/icon_quick4.png" alt=""></a></li>
                        <li><a href=""><img class="icon" src="/img/icon/icon_quick5.png" alt=""></a></li>
                    </ul>
                </div>
            </div>
            
            <footer id="ftr-box">
                <div class="footer-info">
                    <div class="ftr-tags">
                        <a href="">HOME</a> |  <a href="">COMPANY</a> | <a href="">AGREEMENT</a> | <a href="">PRIVACY POLICY</a> | <a href="">GUIDE</a>
                    </div>
                    <p class="span-list">
                        <span>team_2 : KHacademy</span>
                        <span>address : korea seoul</span>
                        <span>tel : 1234-1234</span>
                        <span>e-mail : team_2@naver.com</span> <br>
                        <span>leader : choi jae won</span>
                        <span>member : seok min / dong hyeon / ji seong / je heon / seung beom </span> <br>
                        <span>copyright ⓒ team_2. All rights reserved. Design by team_2.</span>
                    </p>
                </div>
            </footer>
        </div>
    </div>
</body>

</body>
</html>