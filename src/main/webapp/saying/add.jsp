<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		font-size: 14px;
	}
	.content{
		width: 400px;
		height: 100px;
	}
</style>
<script type="text/javascript" src="../jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#f").submit(function() {
			if($(".content").val().trim().length>0
					&&$(".name").val().trim().length>0){
				return true;
			}else{
				alert("请输入内容和名称");
				return false;
			}
		})
	})
</script>
</head>
<body>
	<h1>给网站留言</h1>
	<form action="Listpage" method="get" id="f">
	<div>
	内容：
	</div>
		<div>
			<textarea class="content" name="content" rows="20" cols="20"></textarea>
		</div>
		<div>
			留言人:<input name="name" class="name">
		</div>
		<div>
			<input type="submit" value="提交">
		</div>
	</form>
</body>
</html>