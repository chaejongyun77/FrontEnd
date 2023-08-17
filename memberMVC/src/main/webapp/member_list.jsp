<%@page import="memberMVC.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import= "memberMVC.*" %> 
<%@page import = "java.util.*" %>
	<% 
	List<MemberDto> list =(List)request.getAttribute("list");	
	
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
	<h1>맴버 목록</h1>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>상태</th>
		</tr>
		<% for(MemberDto dto: list){ %>
		<tr>
			<td><a href="detail?id=<%= dto.getId() %>"><%= dto.getId() %></a></td>
			<td><%= dto.getName() %></td>
			<td><%= dto.getPasswd() %></td>
			<td><%= dto.getStatus() %></td>
		</tr>
		<% }  %>
	</table>

</body>
</html>