<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="web.http.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="web.http.model.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ArrayList<Order> list = (ArrayList<Order>)request.getAttribute("list");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	body{
		text-align: center;
	}
	#order,#logout{
		margin: 10px 40px;
	}
</style>
</head>
<body>
	<h1>주문 목록</h1><br>
	<table class="table table-bordered">
		<tr>
			<th>주문번호</th>
			<th>주문시간</th>
			<th>상품번호</th>
			<th>수량</th>
			<th>총가격</th>
			<th>주문취소</th>
		</tr>
		<%
		for(Order order : list){
			
			%>
			<tr>
				<td class="id"><%= order.getOrderId()%></td>
				<td><%= order.getOrderTime()%></td>
				<td><%for(Map.Entry<Product,Integer> entry : order.getPlist().entrySet()){
					%>
					<%=entry.getKey().getpNum()%>
					<%
				} %></td>
				<td><%for(Map.Entry<Product,Integer> entry : order.getPlist().entrySet()){
					%>
					<%=entry.getValue()%>
					<%
				} %></td>
				<td><%= order.getTotalPrice()%></td>
				<td><button class="cancle">주문취소</button></td>
			</tr>
			<% 
		}
		%>
	</table><br>
	<button id="order">주문하러가기</button> <button id="logout">로그아웃</button>
	
	<script type="text/javascript">
	$('.cancle').on('click',function(){
		let orderid = $(this).closest("tr").find(".id").html();
		$.ajax({
			url: "Cancle",
			method: "post",
			data:{orderid:orderid},
			success: function name() {
				alert("삭제완료");
				location.href="Show";
			},
			error: function name() {
				alert("시스템 에러");
			}
		})
	})//onclick cancle
	
	$('#order').on("click",function(){
		location.href="order.jsp";
		
	});//onclick 주문하러 가기
	
	$('#logout').click(function () {
		location.href="Logout";
	})//click() 로그아웃
	
	</script>
</body>
</html>