<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="File" enctype="multipart/form-data" method="post">
			选择照片：<input type="file" name="file">
			照片描述：<input name="desc">
			<input type="submit" value="上传">
	</form>
	<img alt="" src="../images/${photo }">
</body>
</html>