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
	<h1>������ ���</h1>
    <select id="category" onchange="changeFn()">
		<option name="category" value="�����">�����</option>
		<option name="category" value="������">������</option>
		<option name="category" value="�ֺ�">�ֺ�</option>
        <option name="category" value="Ȩ��Ƽ">Ȩ��Ƽ</option>
</select>
<p>������</p>


<input type="button" value="���ƿ�"> <input type="button" value="�Ⱦ��">
<input type="button" value="�ڷΰ���"> <input type="button" value="������ �߰�">
</body>
</html>