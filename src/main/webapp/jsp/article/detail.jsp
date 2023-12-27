<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Map<String, Object> articleMap = (Map<String, Object>) request.getAttribute("articleMap");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
</head>
<body>
	<h1><%= articleMap.get("id") %>게시물 상세보기</h1>
	
	<div>번호 : <%= articleMap.get("id") %></div>
	<div>작성일 : <%= articleMap.get("regDate") %></div>
	<div>제목 : <%= articleMap.get("title") %></div>
	<div>내용 : <%= articleMap.get("body") %></div>
	
	<div>
	<a href="../article/list">목록</a>
	</div>
</body>
</html>