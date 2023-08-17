<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="insert_action" method="post"> <!--  상대경로때문에 board가 2번 생김 -->
		아이디: <input name ="id"><br>
		이름:<input name="name"> <br>
		비밀번호:<input name="passwd"> <br>
		상태:<input name="status"> <br>
		
		
		<input type= "submit" value="맴버등록">
	</form>

</body>
</html>