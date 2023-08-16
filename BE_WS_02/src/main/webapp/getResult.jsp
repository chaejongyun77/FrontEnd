<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Map<String, String> dataMap = (Map<String, String>) request.getAttribute("dataMap");
    String name = (String) dataMap.get("job");
    String pageNo = (String) dataMap.get("pageNo");
    String searchWord = (String) dataMap.get("searchWord");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Name: <%= name %></h1>
<h1>Age: <%= pageNo %></h1>
<h1>searchWord: <%= searchWord %></h1>
</body>
</html>