
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function () {
	$.getJSON("select",{},function(v){
		for(var i=0;i<v.length;i++){
			var tr=$("<tr id='tr'>");
			var tdname=$("<td>");
			tdname.html(v[i].name);
			tr.append(tdname);
			var tdphone=$("<td>");
			tdphone.html(v[i].phone);
			tr.append(tdphone);
			var tddiz=$("<td>");
			tddiz.html(v[i].diz);
			tr.append(tddiz);
			var tdcaozuo=$("<td>");
			var span=$("<span id='id'>");
			span.html(v[i].id);
			var shanchu=$("<button id='sc'>");
			shanchu.html("删除");
			tdcaozuo.append(shanchu);
			tdcaozuo.append(span);
			tr.append(tdcaozuo);
			tr.appendTo($("tbody"));
		}
	})
	$(document).on('click','button[id="sc"]', function () {
		var id=$(this).next().html();
		$(this).parent().parent().parent().empty();
		$.getJSON("select?id="+id,{},function(v){
			for(var i=0;i<v.length;i++){
				var tr=$("<tr id='tr'>");
				var tdname=$("<td>");
				tdname.html(v[i].name);
				tr.append(tdname);
				var tdphone=$("<td>");
				tdphone.html(v[i].phone);
				tr.append(tdphone);
				var tddiz=$("<td>");
				tddiz.html(v[i].diz);
				tr.append(tddiz);
				var tdcaozuo=$("<td>");
				var span=$("<span id='id'>");
				span.html(v[i].id);
				var shanchu=$("<button id='sc'>");
				shanchu.html("删除");
				tdcaozuo.append(shanchu);
				tdcaozuo.append(span);
				tr.append(tdcaozuo);
				tr.appendTo($("tbody"));
			}
		})
    })
})
</script>
</head>
<body>
	<table id="tab">
	<thead>
		<tr>
			<th>用户名</th>
			<th>电话</th>
			<th>地址</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
	
	</tbody>
	</table>
</body>
</html>