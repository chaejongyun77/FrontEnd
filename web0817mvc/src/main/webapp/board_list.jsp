<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import= "web0817mvc.dto.*" %> 
<%@page import = "java.util.*" %>
	<% 
	List<BoardDto> list =(List)request.getAttribute("list");	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
<style type="text/css">
	a{ text-decoration: none; color: black;}
	a:hover{ text-decoration: underline; color: blue; }
</style>
</head>
<body>
	<h1>게시물 목록</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<% for(BoardDto dto: list){ %>
		<tr>
			<td><a href="detail?no=<%= dto.getNo() %>"><%= dto.getNo() %></a></td>
			<td><a href="detail?no=<%= dto.getNo() %>"><%= dto.getTitle() %></a></td>
			<td><%= dto.getWriter() %></td>
			<td><%= dto.getRegdate() %></td>
		</tr>
		<% }  %>
	</table>

</body>
</html>