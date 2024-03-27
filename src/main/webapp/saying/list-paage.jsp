<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.Yuhuwum2.com/tag" prefix="t" %>
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
		width: 800px;
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
<script src="../jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#db").click(function() {
			if(confirm("确定要删除吗?")){
				var p="?";
				$(":checkbox[name=sid]:checked").each(function(idx,v) {
					p+="sid="+$(v).val()+"&";
				});
				location="DeleteServlet"+p;
			}
		})
	})
</script>
</head>
<body>
	<h1>所有留言</h1>
	<a href="add.jsp">新留言</a>
	<a href="javascript:void(0)" id="db">批量删除</a>
		<c:forEach items="${map.liet}" var="s">
		<table border="1" class="tab">
			<tr>
				<td rowspan="2">
					<input type="checkbox" value="${s.sid }" name="sid">
				</td>
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
	<t:page controller="saying/Listpage" pagesize="${pagesize }" total="${map.total }" curpage="${curpage }"></t:page>
</body>
</html>