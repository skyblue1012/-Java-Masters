<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        h1 {
            font-size: 24px;
            background: #ddd;
            text-align: center;
            padding: 15px;
        }
        .point {
            color: orange;
        }
        #entrance {
            border: 1px solid #ddd;
            width: 700px;
            margin: 10px auto;
        }
        #entrance > p:nth-of-type(1) {
            text-align: right;
            padding: 5px;
        }
        #entrance > p:nth-of-type(2) {
            background: #ddd;
            width: 100%;
            height: 30px;
        }
        #entrance form label{
            border-right: 1px solid #ddd;
            display: inline-block;
            padding: 5px;
            padding-right: 20px;
            margin-left: 20px;
            width: 120px;
        }
        #entrance form span {
           margin-bottom: 8px;
           display: inline-block;
        }
        #entrance form p:nth-of-type(1) input {
            width: 120px;
            padding: 2px;
        }
        #entrance form p:nth-of-type(2) input {
            width: 480px;
            padding: 2px;
        }
        #entrance form p:nth-of-type(3) select {
            width: 200px;
            padding: 2px;
        }
        #entrance form p:nth-of-type(10){
           display: flex;
           justify-content: center;
           background: #ddd;
           align-items: center;
        }
        #entrance form p:nth-of-type(10) input {
            padding: 5px;
            margin: 10px 5px;
            cursor: pointer;
        }       
    </style>
</head>
<body>
    <h1>보드게임 등록 화면</h1>
    <div id="entrance">
        <p><span class="point">*</span> 표시가 된 항목은 필수 입력 항목입니다.</p>
        <p></p>
        <form action="${pageContext.request.contextPath}/front.do?command=register" method="post">
        	<input type="hidden" name="command" value="register">
            <p>
                <label for="name"><span class="point">*</span>이름</label>
                <span><input type="text" name="name" id="name" required></span>
            </p>
            <p>
                <label for="level"><span class="point"></span>난이도</label>
                <span><input type="text" name="level" id="level" required></span>
            </p>
            <p>
                <label for="price">가격</label>
                <span><input type="text" name="price" id="price" required></span>
            </p>
            <p>
                <label for="designer">디자이너</label>
                <span><input type="text" name="designer" id="designer" required></span>
            </p>
            <p>
                <label for="publisher">출판사</label>
                <span><input type="text" name="publisher" id="publisher" required></span>
            </p>
            <p>
                <input type="submit" value="등록">
                <input type="reset" value="취소">
            </p>
        </form>
    </div>    
</body>
</html>