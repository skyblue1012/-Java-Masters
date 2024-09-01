<%@page import="web.http.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
User user=null;
if(session.getAttribute("user")!=null){
user = (User)session.getAttribute("user");
session.invalidate(); 
}
else{
	response.sendRedirect("index.html");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=user.getName() %>로그아웃 되셨습니다.</h1>
	<a href="index.html">로그인하러 가기</a>
</body>
</html>