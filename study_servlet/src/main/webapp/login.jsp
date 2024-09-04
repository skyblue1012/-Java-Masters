<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>농담 스토어</title>

    <style>
      * {
        /* border: 1px solid gray; */
        box-sizing: border-box;
        margin: 0;
      }
      #header {
        padding: 50px 0;
      }
      #header * {
        text-align: center;
      }
      #content {
        margin: 0 auto;
      }
      #menu {
        margin-bottom: 40px;
        display: flex;
        justify-content: space-between;
        width: 400px;
      }
      #menu a {
        padding: 10px;
      }
      body {
        display: flex;
        flex-direction: column;
        align-items: center;
      }
      #loginFrm {
        display: flex;
        flex-direction: column;
        width: 400px;
        margin: 50px auto;
        border: 2px solid;
        border-radius: 18px;
        padding: 50px;
      }
      .loginFrm-element {
        display: flex;
        justify-content: space-between;
      }
      #loginFrm-submit {
        margin-top: 20px;
        width: 100%;
        display: flex;
        flex-direction: column;
        align-content: space-between;
        height: 70px;
      }
      img {
        width: 200px;
        height: 200px;
        margin: -30px auto 30px;
      }
      #msg{
      	text-align: center;
      	color: red;
      }
      
      
    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script type="text/javascript">
      $(document).ready(function () {
        var msg = "${msg}";
        if (msg != "") {
          alert(msg);
          $("#msg").append("<p>"+msg+"</p>");
        }
      });
    </script>
  </head>

  <body>
    <div id="header">
      <h1>Life without Nongdamgom is So Bad</h1>
      <br />
      <h3>- Albert Einstein -</h3>
      <br /><br />
      <h2>농담 스토어에 오신 것을 환영합니다.</h2>
    </div>

    <div id="menu">
      <a href="main.jsp"><h3>메인화면</h3></a>
      <a href="#"><h3>장바구니</h3></a>
      <a href="login.jsp"><h3>로그인</h3></a>
      <a href="#"><h3>회원가입</h3></a>
    </div>

    <div id="content">
      <form action="front.do?command=login" method="post" id="loginFrm">
        <img src="./image/login.png" alt="login" />
        <div class="loginFrm-element" id="loginFrm-id">
          <p>아이디</p><input type="text" name="id" id="id" />
        </div>
        <br />

        <div class="loginFrm-element" id="loginFrm-pass">
          <p>비밀번호</p><input type="text" name="password" id="password" />
        </div>
        <br />

        <div class="loginFrm-element" id="loginFrm-submit">
          <input type="submit" value="로그인" id="submit" />
          <div id="msg"></div>
        </div>
      </form>
      
      
    </div>
  </body>
</html>
