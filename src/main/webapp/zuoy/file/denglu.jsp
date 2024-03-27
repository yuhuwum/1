<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ZuoyFileDengluok" method="post">
	<h1>登录</h1>
	用户名：<input name="name" >
	密码：<input name="pas" type="password">
	<input type="submit" value="登录">
	</form>
	<form action="ZuoyFileZhuc" enctype="multipart/form-data" method="post">
	<h1>注册</h1>
	用户名：<input name="name" >
	密码：<input name="pas" type="password">
	电话：<input name="phone" >
	地址：<input name="diz" >
	头像：<input name="tx" type="file">
	<input type="submit" value="注册">
	</form>
	<h1>${ok}</h1>
</body>
</html>