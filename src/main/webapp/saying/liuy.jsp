<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		font-size: 14px;
	}
	.tab{
		border: 1px solid black;
		border-collapse: collapse;
		width: 400px;
	}
	.tab tr td{
		padding: 10px;
	}
	.tab tr td:first-child {
	text-align: center;
	}
	.tab tr td:nth-child(3) {
	text-align: center;
}
</style>
</head>
<body>
	<h1>所有留言</h1>
	<a href="add.jsp">新留言</a>
	
		<c:forEach items="${list }" var="s">
		<table border="1" class="tab">
			<tr>
				<td>留言人</td>
				<td>${s.name }</td>
				<td>留言时间</td>
			<td>${s.stime } </td>
			</tr>
			<tr>
				<td>留言内容</td>
				<td colspan="3">${s.content }</td>
			</tr>
			</table>
		</c:forEach>
	
</body>
</html>