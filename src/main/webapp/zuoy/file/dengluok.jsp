<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>欢迎！${list.get(0).getName()}</h1>
	<img alt="" src="../../images/${list.get(0).getTx() }"> <br/>
	${list.get(0).getName()}<br/>
	地址：${list.get(0).getDiz()}<br/>
	电话：${list.get(0).getPhone()}<br/>
	<form action="ZuoyXougaiTx" enctype="multipart/form-data" method="post">
	<input style="display: none;" name="id" value="${list.get(0).getId() }">
		更换头像：<input type="file" name="tx">
		<input type="submit" value="确定更换">
	</form>
	<h1>${no}</h1>
</body>
</html>