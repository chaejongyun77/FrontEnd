<%@page import="BE_WS_02.dto.ParameterDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
     ParameterDto dto  =(ParameterDto)request.getAttribute("dto");// object->memberDto 다운캐스팅
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    table {
        width: 80%; /* 원하는 가로 폭을 설정하세요 */
        border-collapse: collapse; /* 테이블 테두리 합치기 */
        margin: auto; /* 가운데 정렬 */
    }
</head>
<body>
<table border="1">
    <tr>
        <th>Name</th>
        <td><%= dto.getName() %></td>
    </tr>
    <tr>
        <th>Email</th>
        <td><%= dto.getEmail() %></td>
    </tr>
    <tr>
        <th>Gender</th>
        <td><%= dto.getGender() %></td>
    </tr>
    <tr>
        <th>Hobby</th>
        <td><%= dto.getHobby() %></td>
    </tr>
    <tr>
        <th>Favorite</th>
        <td><%= dto.getFavorite() %></td>
    </tr>
    <tr>
        <th>Description</th>
        <td><%= dto.getDesc() %></td>
    </tr>
</table>

	
</body>
</html>