<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Find WiFi | Load Data</title>

    <style>
        div {
            text-align: center;
        }
    </style>

</head>
<body>
<div> 데이터를 불러오는 중입니다. 잠시만 기다려주세요. </div>
    <%
        ApiController.AddWifi();
    %>
<div> </div>
    <div> <%=ApiController.TotalCnt() %>개의 와이파이 정보를 불러왔습니다. </div>

<div>
    <a href="${pageContext.request.contextPath}/main.jsp">홈으로 가기</a>
</div>
</body>
</html>