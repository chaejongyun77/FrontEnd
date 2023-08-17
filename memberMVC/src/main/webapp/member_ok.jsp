<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>맴버 리스트</h1>
	<p>메시지 : <%= request.getAttribute("msg") %> </p> 
	<p>메시지 : ${msg} </p> 
	
	
	
	
	<hr>
	<a href="list">맴버 목록</a>
</body>
</html>