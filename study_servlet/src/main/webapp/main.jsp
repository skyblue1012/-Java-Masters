<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        width: 900px;
      }
      .item {
        width: 270px;
        height: 350px;
      }
      .item-info {
        display: flex;
        flex-direction: column;
        padding: 7px 10px;
      }
      .item-info * {
        margin-bottom: 5px;
      }
      img {
        width: 270px;
        height: 270px;
        object-fit: cover;
      }
      .item-row {
        display: flex;
        justify-content: space-between;
        margin-bottom: 70px;
      }
      .modal-bg {
        position: fixed;
        display: none;

        top: 0;
        left: 0;

        width: 100%;
        height: 100%;

        background-color: rgba(0, 0, 0, 0.35);

        z-index: 888;
      }
      .modal_box {
        position: fixed;

        padding: 100px;

        text-align: center;

        background: white;
        border-radius: 10px;
        border: 2px solid tomato;
        box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);

        top: 50%;
        left: 50%;
        z-index: 999;
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
      #wellcomeMsg{
      	margin-bottom: 40px;
      }
    </style>

    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
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

    <c:choose>
    	<c:when test="${user!=null}">
    		<div id="wellcomeMsg">
    			<h4>🧸 ${user.nickname} 님, 농담곰과 함께 좋은 하루 되세요. 🧸</h4>
    		</div>
    	</c:when>
    	
    	<c:otherwise>
    		<div id="wellcomeMsg">
    			<h4></h4>
    		</div>
    	</c:otherwise>
    </c:choose>
    

    <div id="content">
      <div class="item-row">
        <div class="item">
          <div class="item-image">
            <img src="./image/images_1.jpg" />
          </div>
          <div class="item-info">
            <b class="item-name">농담곰 인형</b>
            <b class="item-price">30,000</b>
            <button>장바구니 담기</button>
          </div>
        </div>

        <div class="item">
          <div class="item-image">
            <img src="./image/images_1.jpg" />
          </div>
          <div class="item-info">
            <b class="item-name">농담곰 인형</b>
            <b class="item-price">30,000</b>
            <button>장바구니 담기</button>
          </div>
        </div>

        <div class="item">
          <div class="item-image">
            <img src="./image/images_1.jpg" />
          </div>
          <div class="item-info">
            <b class="item-name">농담곰 인형</b>
            <b class="item-price">30,000</b>
            <button>장바구니 담기</button>
          </div>
        </div>
      </div>
      <!-- item-row -->

      <div class="item-row">
        <div class="item">
          <div class="item-image">
            <img src="./image/images_1.jpg" />
          </div>
          <div class="item-info">
            <b class="item-name">농담곰 인형</b>
            <b class="item-price">30,000</b>
            <button>장바구니 담기</button>
          </div>
        </div>

        <div class="item">
          <div class="item-image">
            <img src="./image/images_1.jpg" />
          </div>
          <div class="item-info">
            <b class="item-name">농담곰 인형</b>
            <b class="item-price">30,000</b>
            <button>장바구니 담기</button>
          </div>
        </div>

        <div class="item">
          <div class="item-image">
            <img src="./image/images_1.jpg" />
          </div>
          <div class="item-info">
            <b class="item-name">농담곰 인형</b>
            <b class="item-price">30,000</b>
            <button>장바구니 담기</button>
          </div>
        </div>
      </div>
      <!-- item-row -->

      <div class="item-row">
        <div class="item">
          <div class="item-image">
            <img src="./image/images_1.jpg" />
          </div>
          <div class="item-info">
            <b class="item-name">농담곰 인형</b>
            <b class="item-price">30,000</b>
            <button>장바구니 담기</button>
          </div>
        </div>

        <div class="item">
          <div class="item-image">
            <img src="./image/images_1.jpg" />
          </div>
          <div class="item-info">
            <b class="item-name">농담곰 인형</b>
            <b class="item-price">30,000</b>
            <button>장바구니 담기</button>
          </div>
        </div>

        <div class="item">
          <div class="item-image">
            <img src="./image/images_1.jpg" />
          </div>
          <div class="item-info">
            <b class="item-name">농담곰 인형</b>
            <b class="item-price">30,000</b>
            <button>장바구니 담기</button>
          </div>
        </div>
      </div>
      <!-- item-row -->
    </div>

    <div class="modal-bg">
      <div
        class="modal-box"
        style="
          background: white;
          width: 300px;
          height: 200px;
          padding: 80px 60px;
          border-radius: 10px;
          top: 50%;
          left: 50%;
          transform: translate(200%, 200%);
        "
      >
        <h2>장바구니에 쏘옥</h2>
      </div>
    </div>
  </body>
</html>

<script>
  $("button").on("click", function () {
    $(".modal-bg").fadeIn(1000);
    $(".modal-box").fadeIn(1000);
  });

  $(".modal-bg").on("click", function () {
    $(".modal-bg").fadeOut(1000);
    $(".modal-box").fadeOut(1000);
  });
</script>
