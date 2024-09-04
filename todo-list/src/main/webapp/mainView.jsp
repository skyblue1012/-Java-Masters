<%@page import="web.servlet.model.TodoItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Insert title here</title>

<style type="text/css">
	*{
		box-sizing: border-box;
	}
	html, body {
		background: #E7E8F8;
		width: 100%;
		height: 100%;
		display: flex;
		align-items: center;
	}
	ul {
		list-style: none;
		margin: 0;
		padding-left: 0;
	}
	input, button {
		border: none;
		outline: none;	
	}
	label{
		margin-bottom: 0;
		width: 100%;
		padding: 0 1rem;
	}
	
	.container{
 		background-color: white;
 		width:35%;
		height: 65%;
		box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.2);
 		border-radius: 15px;
 		padding: 0;
 		overflow: hidden;
 		display: flex;
 		justify-content: space-between;
 		flex-direction: column;
 		
	}
	.header {
		display: flex;
		justify-content: flex-end;
		align-items: center;
		gap: 24px;
		font-size: 1.2rem;
		font-weight: bold;
		padding: 20px;

 		background-color: #D3D4EE; 
 		height: 4rem;

	}
	.header>li{
		padding: 0 5px;
		cursor: pointer;
		border-bottom: 2px solid black; 
	}
/* 	.header>li:hover{
		color: white;
		border-bottom: 3px solid white;
	} */
	
	.todoList {
		height: 100%;
		width: 100%;
		overflow-y: scroll;
		padding: 0 1rem;
	}
	.todoList li {
		display: flex;
		justify-content: space-between;
		align-items: center;
		
		
		font-size: 1.2rem;
		margin: 1rem 0;

	}
	.checkbox {
		width: 28px;
		height: 28px;
	}
	
	form{
 		background-color: #F0F1FC; 
		display: flex;
		justify-content: center;
		align-items: center;
		height: 5rem;
 		padding: 1.4rem 1rem;
	}
	
	#addInput, #addBtn{
		padding: 0.7rem 1rem;
	}
	#addInput {
		flex: 1 0 auto;
	}
	#addBtn{
		background-color: #CACBDF;
	}
</style>

<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('.deleteButton').on('click', function(e) {
            e.preventDefault(); // 버튼 클릭 기본 동작 방지
            
            let button = $(this);
            let todoId = button.data('id');
/*             console.log("todoId : " + todoId); */

            $.ajax({
                url: 'DeleteTodo',
                type: 'post',
                data: { id: todoId },
                success: function() {
                    button.closest('li').remove(); // 버튼과 가장 가까운 li 요소 
                },
                error: function() {
                    alert('삭제 실패');
                }
            });
        });
    });
</script>
</head>
<body>
	<div class="container">
		<ul class="header">
			<li>All</li>
<!-- 			<li>Active</li>
			<li>Completed</li> -->
		</ul>
		
		<ul class="todoList">
		    <c:forEach items="${todos}" var="todo">
		        <li>
		            <input type="checkbox" class="checkbox"/>
		            <label>${todo.title}</label>
		            <button class="deleteButton" data-id="${todo.id}">delete</button>
		        </li>
		    </c:forEach> 
		</ul>
	
		<form action="AddTodo" method="post" id="frm">
			<input type="text" placeholder="Add Todo" id="addInput" name="title" /><button id="addBtn">Add</button>
		</form>
	</div>
</body>
</html>