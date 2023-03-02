<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Wi-Fi</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/handlebars@latest/dist/handlebars.js"></script>

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');
        .head {
            font-size: large;
            font-family: 'Noto Sans KR', sans-serif;
        }

        body {
            margin-left: 20px;
        }

        #topMenu {
            margin-left: 0;
        }

        #topMenu ul li {
            list-style: none;
            vertical-align: middle;
            text-align: center;
            display: inline-block;
        }

        #topMenu .menuLink {
            text-decoration: none;
        }

        .wifi_info_table thead {
            border: 1px solid gray;
            background-color: #3fc83f;
            text-align: center;
            color: white;
        }

        .wifi_info_table td {
            padding: 0 30px 0 30px;
            min-width: 100px;
            border: 0.1px solid #29e595;
        }

    </style>
</head>

<body>
    <div class="head">
        <h1>와이파이 정보 구하기ㅋㅋㅋㅋ</h1>

        <nav id="topMenu">
            <ul>
                <li>
                    <a class="menuLink" href="${pageContext.request.contextPath}/index.jsp">홈 |</a>
                </li>
                <li>
                    <a class="menuLink" href="/">위치 히스토리 목록 |</a>
                </li>
                <li>
                    <a class="menuLink" href="${pageContext.request.contextPath}/load-data.jsp">Open API 정보 가져오기</a>
                </li>
            </ul>
        </nav>

        <form class="location_form" action="/location" method="POST">
            <label for="y-pos-name">LAT(위도):</label>
            <input type="number" id="y-pos-name" name="y-pos-name"
                   class="input_form" placeholder="0.0"/>

            <label for="x-pos-name">LON(경도):</label>
            <input type="number" id="x-pos-name" name="x-pos-name"
                   class="input_form" placeholder="0.0"/>

            <button type="button" id="locationButton">내 위치 가져오기</button>
            <button type="button" id="wifiButton">근처 WIFI 정보 가져오기</button>
        </form>

        <table class="wifi_info_table">
            <thead>
                <tr>
                    <th>
                        <p>거리 <br> (Km)</p>
                    </th>

                    <th>
                        <p>관리번호</p>
                    </th>

                    <th>
                        <p>자치구</p>
                    </th>

                    <th>
                        <p>와이파이명</p>
                    </th>

                    <th>
                        <p>도로명주소</p>
                    </th>

                    <th>
                        <p>상세주소</p>
                    </th>

                    <th>
                        <p>설치위치(층)</p>
                    </th>

                    <th>
                        <p>설치유형</p>
                    </th>

                    <th>
                        <p>설치기관</p>
                    </th>

                    <th>
                        <p>서비스구분</p>
                    </th>

                    <th>
                        <p>망종류</p>
                    </th>

                    <th>
                        <p>설치년도</p>
                    </th>

                    <th>
                        <p>실내외구분</p>
                    </th>

                    <th>
                        <p>WIFI접속환경</p>
                    </th>

                    <th>
                        <p>X좌표</p>
                    </th>

                    <th>
                        <p>Y좌표</p>
                    </th>

                    <th>
                        <p>작업일자</p>
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td> {{distance}}</td>
                    <td> {{adminNumber}}</td>
                    <td> {{borough}}</td>
                    <td> {{wifiName}}</td>
                    <td> {{loadName}}</td>
                    <td> {{detailAddress}}</td>
                    <td> {{installPosition}}</td>
                    <td> {{installType}}</td>
                    <td> {{installAgency}}</td>
                    <td> {{serviceType}}</td>
                    <td> {{netType}}</td>
                    <td> {{installYear}}</td>
                    <td> {{inOutDoorType}}</td>
                    <td> {{wifiConnEnv}}</td>
                    <td> {{posX}}</td>
                    <td> {{posY}}</td>
                    <td> {{dateTime}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</body>
</html>