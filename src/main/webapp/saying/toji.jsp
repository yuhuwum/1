<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.c{
		height: 25px;
		background: red;
		margin-bottom: 10px;
		color: white;
	}
</style>
</head>
<body>
	<c:forEach items="${list }" var="a">
		<div style="width: ${400*a.count/total}px" class="c">
		${a.date}(${a.count}条)
		</div>
	</c:forEach>
</body>
</html>