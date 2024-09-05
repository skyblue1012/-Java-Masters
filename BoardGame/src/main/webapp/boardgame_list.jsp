<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
	<style>
        h1 {
            text-align: center;
        }
        form {
            text-align: right;
            margin-right: 438px;
        }
        table {
            width: 800px;
            margin: 20px auto;
        }
        tr {
            height: 43px;
        }
        th{
            background: #ddd;
        }
        .center{
        	margin-left: 740px;
        	padding-top: 30px;
        }
    </style>

</head>
<body>
	<h1>보드게임 목록</h1>
    <form action="${pageContext.request.contextPath}/front.do?command=showAllBoardGame" id="frm">
    	<input type="hidden" name="command" value="search">
        <select name="searchSelect">
            <option disabled selected>전체</option>
            <option value="title">이름</option>
            <option value="catalogue">난이도</option>
            <option value="author">출판사</option>
        </select>
        <input type="text" name="searchText">
        <input type="submit" value="검색">
    </form>
    <table border="1">
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>난이도</th>
            <th>가격</th>
            <th>디자이너</th>
            <th>출판사</th>
        </tr>
        
        <c:forEach items="${list}" var="boardgame">
			<tr>
				<td>${boardgame.number}</td>
				<td>${boardgame.name}</td>
				<td>${boardgame.level}</td>
				<td>${boardgame.price}</td>
				<td>${boardgame.designer}</td>
				<td>${boardgame.publisher}</td>
			</tr>
		</c:forEach>
    </table>
    <div class="center">
    <a href="./register.jsp">보드게임 등록</a>
    <a href="${pageContext.request.contextPath}/front.do?command=showAllBoardGame">보드게임 목록</a>
	</div>
</body>
</html>