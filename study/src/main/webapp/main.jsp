<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main Page</title>
    <style>
		body {
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			height: 100vh;
			margin: 0;
		}
        select, p, input {
            margin: 10px 0;
        }
	</style>

</head>
<body>
	<h1>레시피 모아</h1>
    <select id="category" onchange="changeFn()">
		<option name="category" value="자취생">자취생</option>
		<option name="category" value="직장인">직장인</option>
		<option name="category" value="주부">주부</option>
        <option name="category" value="홈파티">홈파티</option>
</select>
<p>레시피</p>


<input type="button" value="좋아요"> <input type="button" value="싫어요">
<input type="button" value="뒤로가기"> <input type="button" value="레시피 추가">
</body>
</html>