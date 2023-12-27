<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 스크립틀릿 -->
<%
String inputDan = request.getParameter("dan");
String inputLimit = request.getParameter("limit");
String inputColor = request.getParameter("color");

if (inputDan == null || inputDan.equals("")) {
	inputDan = "1";
}
if (inputLimit == null || inputLimit.equals("")) {
	inputLimit = "1";
}
if (inputColor == null || inputColor.equals("")) {
	inputColor = "black";
}

int dan = Integer.parseInt(inputDan);
int limit = Integer.parseInt(inputLimit);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 20px;
            text-align: center;
        }
        h1 {
            color: <%= inputColor %>;
            margin-bottom: 20px;
        }
        .multiplication {
            margin-bottom: 10px;
            font-size: 18px;
            color: <%= inputColor %>;
        }
        a {
            display: block;
            margin-top: 20px;
            text-decoration: none;
            color: #333;
        }
        a:hover {
            color: #555;
        }
    </style>
</head>
<body>
    <h1><img src="article/image/musinsaLogo.png" alt="무신사 로고" /></h1>

    <div>
        <a href="../article/list">목록</a>
    </div>
</body>
</html>