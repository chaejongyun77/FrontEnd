<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<h1>상세보기</h1>
	<table>
		<tr>
			<th>아이디</th><td>${dto.id }</td>
		</tr>
		<tr>
			<th>이름</th><td>${dto.name}</td>
		</tr>
		<tr>
			<th>비밀번호</th><td>${dto.passwd}</td>
		</tr>
		<tr>
			<th>상태</th><td>${dto.status}</td>
		</tr>
		
	</table>
	<a href="list">목록</a>
	<a href="update_form?id=${dto.id}">수정</a>
	<a href="delete_form?id=${dto.id}">삭제</a>
	
	
</body>
</html>