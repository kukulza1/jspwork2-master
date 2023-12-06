<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
<link rel ="stylesheet"    href="../resource/css/loginstyle.css">
</head>
<body>
 <div id="container">
        <div id="top">
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
                        <li><a href="">LOG IN</a></li>
                        <li><a href="">MY PAGE</a></li>
                        <li><a href="">BASKET</a></li>
                        <li><a href="">ORDER INQUIRY</a></li>
                        <li><a href="">BOARD</a></li>
                        <li><input type="text" id="search"> 🔍</li> <!-- 상단 검색창 -->
                    </ul>
                </div>
            </div>  

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

        <div id="mid">
            <h3>LOG IN</h3>
            <div id="login">
                <form action="/login.do" id="mid_form">
                    <table class="login_tb">
                        <tr class="login_tr">
                            <td class="td_text"><span onclick="">ID</span></td>
                            <td class="td_input"><input type="text" class="login_input"></td>
                            <td rowspan="2" class="td_btn"><button class="login_btn">Log In</button></td>
                        </tr>
                        <tr class="login_tr">
                            <td class="td_text"><span>PW</span></td>
                            <td class="td_input"><input type="password" class="login_input"></td>
                        </tr>
                    </table>
                </form>
                <div id="find_account">
                    <p>
                        <a href="#" class="find_id">Find ID</a>
                        | <a href="#" class="find_pw">Find PW</a>
                    </p>    
                </div>
                <div class="join_account">
                    <p>💌 Become a member <br> and Enjoy the benefits!</p>
                    <a href="#"><button class="join_account_btn">JOIN!</button></a>
                </div>
            </div>
        </div>

        <div id="bottom">
            <div class="cst-center">
                <h3>CUSTOMER CENTER</h3>
                <p>
                    TEL 010-0000-0000 <br>
                    Kakao team_2 <br>
                    AM 10 ~ PM 6 <br>
                    Closed ~ Weekend, Holiday
                </p>
            </div>
            <div class="bank-info">
                <h3>BANK INFO</h3>
                <p>
                    농협 123-1234-1234-12 <br>
                    국민 123456-12-123456 <br>
                    예금주 : (주)team_2
                </p>
            </div>
            <div class="btm-icon">
                <ul class="btm-icon-list">
                    <li><a href=""><img class="icon" src="" alt="">o</a></li>
                    <li><a href=""><img class="icon" src="" alt="">o</a></li>
                    <li><a href=""><img class="icon" src="" alt="">o</a></li>
                    <li><a href=""><img class="icon" src="" alt="">o</a></li>
                    <li><a href=""><img class="icon" src="" alt="">o</a></li>
                </ul>
            </div>
        </div>
        
        <footer id="footer">
            <div class="footer-info">
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
</body>
</html>