<%@page import="web.servlet.model.BoardGame"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<%
	BoardGame vo = (BoardGame)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>BoardGameList</title>
</head>
<body>
	<h2><%= vo.getName() %>등록이 완료되었습니다</h2>
	<p />
	<h4>이름 : <%= vo.getName() %><br>
	난이도 : <%= vo.getLevel() %><br>
	가격 : <%= vo.getPrice() %><br>
	디자이너 : <%= vo.getDesigner() %><br>
	출판사 : <%= vo.getPublisher() %><br></h4>
	<a href="${pageContext.request.contextPath}/front.do?command=showAllBoardGame"><h5>보드게임 목록</h5></a>

</body>
</html>