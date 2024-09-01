<%@page import="web.http.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	User user =(User)session.getAttribute("user");
    	if(user == null){
    		response.sendRedirect("index.html");
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	body{
		text-align: center;
	}
</style>
</head>
<body>
	<button id="order" onclick="order()">주문하기</button><br><br>
	<button id="show" onclick="show()">주문내역 확인하기</button><br><br>
	
		<button id="logout" onclick="out()">로그아웃</button>
	
	
</body>
<script type="text/javascript">
	function out() {
		location.href="Logout";
	}
	function show() {
		location.href="Show";
	}
	function order() {
		location.href="order.jsp"
	}
</script>
</html>