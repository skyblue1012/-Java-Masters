<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Page</title>

</head>
<body>
	<div class="book"></div>
    <div class="main">
        <h2>회원가입</h2>
        <form action="controller?command=signUp" method="post" id="frm">
           ID : <input type="text" value="ID" name="id"><br><br>
           Password : <input type="text" value="Password" name="pass"><br><br>
           name : <input type="text" value="name" name="name"><br><br>
           category : <input type="text" value="category" name="category"><br><br>
           <input type="submit" value="회원가입">
        </form>
    </div>
</body>
</html>