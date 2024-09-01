<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
	if( session.getAttribute("user")==null){
		response.sendRedirect("index.html");
	}
*/
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
	<h1>주문하기</h1><br>
	<form action="Order" method="post">
		상품번호1<select name="pnum1" id="pnum1" class="select">
	    <option value="001">001-아메리카노</option><option value="002">002-카페라떼</option><option value="003">003-카푸치노</option>
	    <option value="004">004-카페모카</option><option value="005">005-에스프레소</option> <option value="006">006-녹차라떼</option>
	    <option value="007">007-카라멜마끼아또</option><option value="008">008-바닐라라떼</option><option value="010">010-초코크루아상</option>
	    <option value="011">011-블루베리머핀</option><option value="012">012-크림치즈베이글</option><option value="013">013-치즈케이크</option>
	    <option value="014">014-팥앙금빵</option><option value="015">015-플레인요거트</option><option value="016">016-아이스라떼</option>
	    <option value="017">017-호두파이</option><option value="018">018-블루베리스무디</option><option value="019">019-크로크무슈</option>
	    <option value="020">020-딸기라떼</option>
		</select>
		수량<input type="number" name="quantity1" id="quantity1" class="quantity" min="0" value="0">
		가격<input type="number" name="price1" id="price1" readonly="readonly"><br><br>
		
		상품번호2<select name="pnum2" id="pnum2" class="select">
	    <option value="001">001-아메리카노</option><option value="002">002-카페라떼</option><option value="003">003-카푸치노</option>
	    <option value="004">004-카페모카</option><option value="005">005-에스프레소</option> <option value="006">006-녹차라떼</option>
	    <option value="007">007-카라멜마끼아또</option><option value="008">008-바닐라라떼</option><option value="010">010-초코크루아상</option>
	    <option value="011">011-블루베리머핀</option><option value="012">012-크림치즈베이글</option><option value="013">013-치즈케이크</option>
	    <option value="014">014-팥앙금빵</option><option value="015">015-플레인요거트</option><option value="016">016-아이스라떼</option>
	    <option value="017">017-호두파이</option><option value="018">018-블루베리스무디</option><option value="019">019-크로크무슈</option>
	    <option value="020">020-딸기라떼</option>
		</select>
		수량<input type="number" name="quantity2" id="quantity2" class="quantity" min="0" value="0">
		가격<input type="number" name="price2" id="price2" readonly="readonly"><br><br>
		
		상품번호3<select name="pnum3" id="pnum3" class="select">
	    <option value="001">001-아메리카노</option><option value="002">002-카페라떼</option><option value="003">003-카푸치노</option>
	    <option value="004">004-카페모카</option><option value="005">005-에스프레소</option> <option value="006">006-녹차라떼</option>
	    <option value="007">007-카라멜마끼아또</option><option value="008">008-바닐라라떼</option><option value="010">010-초코크루아상</option>
	    <option value="011">011-블루베리머핀</option><option value="012">012-크림치즈베이글</option><option value="013">013-치즈케이크</option>
	    <option value="014">014-팥앙금빵</option><option value="015">015-플레인요거트</option><option value="016">016-아이스라떼</option>
	    <option value="017">017-호두파이</option><option value="018">018-블루베리스무디</option><option value="019">019-크로크무슈</option>
	    <option value="020">020-딸기라떼</option>
		</select>
		수량<input type="number" name="quantity3" id="quantity3" class="quantity" min="0" value="0">
		가격<input type="number" name="price3" id="price3" readonly="readonly"><br><br>
		총가격<input type="number" name="tp" id="tp" readonly="readonly"><br><br>
		<button>주문하기</button>&nbsp <button id="return">돌아가기</button>
	</form>
</body>
<script type="text/javascript">
	$('#return').click(function() {
		event.preventDefault();
		location.href="login_success.jsp"
	})// 돌아가기 버튼
	
	$('.select,.quantity').on("change",function show(){
		//가격 변수 선언
		var price1 = 0;
		var price2 = 0;
		var price3 = 0;
		$('#tp').val(0);
		//quantity 값 받아오기 
		let q1= $('#quantity1').val();
		let q2= $('#quantity2').val();
		let q3= $('#quantity3').val();
		
		//상품번호 값 받아오기
		var pnum = $('#pnum1').val();
		//ajax 사용해서 price받아서 표시하기
		$.ajax({
			url: "GetPrice",
			method: "post",
			data:{ pnum: pnum},
			success: function name(response) {
				price1=response;
				$('#price1').val(price1*q1);
				$('#tp').val(Number($('#price1').val())+Number($('#price2').val()) +Number($('#price3').val()));
			},
			error: function (){
				alert("서버 에러");
			}
		})
		//상품번호 값 받아오기
		pnum = $('#pnum2').val();
		//ajax 사용해서 price받아서 표시하기
		$.ajax({
			url: "GetPrice",
			method: "post",
			data:{ pnum: pnum},
			success: function name(response) {
				price2=response;
				$('#price2').val(price2*q2);
				$('#tp').val(Number($('#price1').val())+Number($('#price2').val()) +Number($('#price3').val()));
			},
			error: function (){
				alert("서버 에러");
			}	
		})
		//상품번호 값 받아오기
		pnum = $('#pnum3').val();
		//ajax 사용해서 price받아서 표시하기
		$.ajax({
			url: "GetPrice",
			method: "post",
			data:{ pnum: pnum},
			success: function name(response) {
				price3=response;
				$('#price3').val(price3*q3);
				$('#tp').val(Number($('#price1').val())+Number($('#price2').val()) +Number($('#price3').val()));
			},
			error: function (){
				alert("서버 에러");
			}
		})
	})//onchange, 가격 자동 표시
</script>
</html>