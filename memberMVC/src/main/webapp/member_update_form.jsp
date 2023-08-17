<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맴버 수정 폼</title>
</head>
<body>

	<h1> 맴버 정보 수정</h1>
	<form action ="update_action" method="post"> 
		<input type="hidden" name="id" value="${dto.id}"> <!--  보이면 안되기때문에 hidden -->
		이름: <input name ="name" value="${dto.name}"><br>
		비밀번호:<input name="passwd"value="${dto.passwd}"> <br>
		상태:<input name="status"value="${dto.status}"> <br>
		
		<br>
		
		<input type= "submit" value="맴버수정">
	</form>
</body>
</html>