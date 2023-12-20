<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Board</title>
    <link rel="stylesheet" href="Board_style.css">

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
            <h3>Notice / Event</h3>
            <div class="Board">
                <table id="board_tb">
                    <thead>
                        <tr>
                            <th class="board_no">no</th>
                            <th class="board_title">title</th>
                            <th class="board_writer">writer</th>
                            <th class="board_date">date</th>
                            <th class="board_hit">hit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>notice</td>
                            <td>Notice 1 첫번째 공지사항입니다</td>
                            <td>Notice team</td>
                            <td>2023-11-01</td>
                            <td>12</td>
                        </tr>
                        <tr>
                            <td>notice</td>
                            <td>Notice2 두번째 공지사항입니다</td>
                            <td>Notice team</td>
                            <td>2023-11-23</td>
                            <td>9</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>Event3 리뷰 작성 이벤트!! 리뷰 작성 횟수에 따라 포인트 획득!!</td>
                            <td>Event team</td>
                            <td>2023-11-30</td>
                            <td>21</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Event2 첫 구매고객 이벤트!! 첫 구매시라면~</td>
                            <td>Event team</td>
                            <td>2023-11-16</td>
                            <td>26</td>
                        </tr>
                       
                    </tbody>

                </table>
            </div>
            <div id="page">
                <a href=""><button class="arrow"><</button></a>
                <a href=""><button>1</button></a>
                <a href=""><button>2</button></a>
                <a href=""><button>3</button></a>
                <a href=""><button>4</button></a>
                <a href=""><button class="arrow">></button></a>
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
                    <span>leader : choi hae won</span>
                    <span>member : seok min / dong hyeon / ji seong / je heon / seung beom </span> <br>
                    <span>copyright ⓒ team_2. All rights reserved. Design by team_2.</span>
                </p>
            </div>
        </footer>
    </div>
</body>
</html>