<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.Yuhuwum2.com/tag" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title></title>
</head>
<link rel="stylesheet" href="css/1.css"/>
<style>
	#guesthelp{
		width: 385px;
		height: 430px;
		background-color: rgb(240, 240, 240);
		position: absolute;
		top: 130px;
		left: 500px;
		display: none;
	}
	#guesttop{
		width: 385px;
		height: 35px;
		display: flex;
		align-items: center;
		margin-bottom: 10px;
		justify-content: center;
		background-color: rgb(40, 54, 67);
		position: relative;
	}
	#guesthelp label {
	  display: flex;
	  align-items: center;
	  text-align: left;
	  margin-bottom: 10px;
	  height: 35px;
	  justify-content: space-evenly;
	}
	#guesthelp label input, #guesthelp select, #guesthelp textarea{
	  height: 25px;
	  width: 190px;
	  
	}
	#guesthelp textarea{
	  height: 40px;
	}
	.sm{
		color: black;
		font-weight: 1000;
	}
	#guestbutton{
		margin-top: 20px;
		margin-right: 45px;
		float: right;
		width: 60px;
		height: 35px;
		border-radius: 4px;
		border: none;
		color: white;
		background-color: rgb(64, 158, 254);
		cursor: pointer;
		
	}
	#guestbutton:hover{
		background-color: rgb(10, 113, 167);
		transition: 0.3s;
	}
	#guestbutton:not(:hover){
		background-color: rgb(64, 158, 254);
		transition: 0.3s;
	}
	#selectedTextContainer {
		margin-right: auto; /* 将此元素向右侧对齐 */
	}
	#guesttop img{
		position: absolute;
		right: 0px;
		cursor: pointer;
	}
	.qrcode{
        width:400px;
        height: 400px;
        float: left;
        margin: 40px 40px;
    }
    .qrcode>img{
		display: block;
		border:5px solid white;
	}
	#formb a{
		cursor:pointer;
	}

	#search th,td{
		height: 30px;
		border: 1px solid black; 
		text-align: center; 
	}
	.state[data-state="待审批"] {
	    color: yellow;
	    border:1px yellow solid;
	    border-radius:3px;
	    padding:3px;
	}
	
	.state[data-state="通过"] {
	    color: green;
	    border:1px green solid;
	    border-radius:3px;
	    padding:3px;
	}
	
	.state[data-state="拒绝"] {
	    color: red;
	    border:1px red solid;
	    border-radius:3px;
	    padding:3px;
	}
	.p {
		float: right;
    	margin-top: 30px;
    	margin-right: 80px;
		font-size:14px;
	}
	
	.p a {
		text-decoration: none;
		margin: 5px 5px;
		padding: 3px 5px;
		border: 1px solid gray;
		font-size: 12px;
	}
	.shuju .yc {
	display: none;
}
</style>
<script src="js/jquery-3.5.1.min.js"></script>
<script>
	$(function(){
	    var flag = false;
	    var offsetLeft = 0,offsetTop = 0;
	    $("#guesthelp").mousedown(function(e){
	        flag = true;
	        offsetLeft = e.pageX - $(this).offset().left;
	        offsetTop = e.pageY - $(this).offset().top;
	    }).mousemove(function(e){
	        if(flag){
	            $(this).css("left",e.pageX-offsetLeft).css("top",e.pageY-offsetTop);
	        }
	    }).mouseup(function(e){ // 将mouseout改为mouseleave
	        flag = false;
	    });
	})
</script>
<body>
    <div class="sidebar">
        <p >访客人员管理</p>
		<p onclick="showguesthelp()">访客申请</p>
    </div>

    <div id="mainContent">
        <div id="head">
			<button id="openButton" onclick="openSidebar()" ></button>
			<h2>访客管理</h2>
			<div id="selectedTextContainer"></div> <!-- 用于显示选择的字 -->
			<div id="tright">
				<h4>当前层级:停车场  管理员:${name}</h4>
			</div>
		</div>
		
		<div id="body">
			<form action="zhu" method="get">
				<div id="formt">
					<label>车牌号&nbsp;&nbsp;<input name="carpai" placeholder="请输入搜索内容"/></label>
					<label>&nbsp;&nbsp;来事访由&nbsp;&nbsp;<input name="reason_text" placeholder="请输入搜索内容"/></label>
					<label>&nbsp;&nbsp;状态 &nbsp;&nbsp;
						<select name="states">
							<option value="待审批">待审批</option>
							<option value="通过">通过</option>
							<option value="拒绝">拒绝</option>
						</select>
					</label>
				</div>
				<div id="formc">
					<label>
						预约时间&nbsp;&nbsp;
						&nbsp;&nbsp;<input type="date" name="start_time">
						&nbsp;&nbsp;到&nbsp;&nbsp;
						&nbsp;&nbsp;<input type="date" name="end_time">
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="sou" style="width: 60px;height: 30px;" type="submit" value="搜索"/>
				</div>
				
				
				<div id="formb">
					<a class="erweima" >访客二维码</a><a href="">访客设置</a><a href="">来事访由管理</a><a href="">批量审核</a><a onclick="showguesthelp()" >访客登记</a>
				</div>
				
			</form>
		</div>
		
		<div id="search">
			<table style="width:95%;border:1px black solid">
				<tr>
					<th><input type="checkbox"></th>
					<th>车牌号</th>
					<th>手机号</th>
					<th>来访事由</th>
					<th>申请时间</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>状态</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${list}" var="p">
					<tr class="shuju">
					
						<td><input type="checkbox" class="cbox"></td>
						<td id="pcarID">${p.cars_number}</td>
						<td id="pphone">${p.visit_phone}</td>
						<td id="pwhy">${p.reason_text}</td>
						<td>${p.reg_time}</td>
						<td id="pstart_time">${p.start_time}</td>
						<td id="pend_time">${p.end_time}</td>
						<td id="pmessage"><span data-state="${p.state}" class="state">${p.state}</span></td>
						<td id="pquanxian">${p.notes}</td>
						<td>
							<form action="delete" method="get">
								<input class="yc" name="visitsId" value="${p.visitsId}">
								<input type="submit" value="删除" name="delete">&nbsp;&nbsp;&nbsp;
							</form>
								
								<input type="button" value="审核" name="shenhe">
						</td>
					
					</tr>
				</c:forEach>
			</table>
			
			<t:page controller="1/zhu" pagesize="5" total="${total}"
				curpage="${curpage}" where="${where}"></t:page>
				
		</div>
		<form id="guesthelp" action="insert" method="get">
			<div id="guesttop">
				<h3 style="color: white;">访客申请</h3>
				<img onclick="chacha()" style="width: 20px;height: 20px;" src="../img/叉叉.png"/>
			</div>
			<label><span class="mm">* <span class="sm">车牌号</span></span><input name="carID" required/></label>
			<label><span class="mm">* <span class="sm">手机号</span></span><input  name="phone" required/></label>
			<label><span class="mm">* <span class="sm">开始时间</span></span><input type="date" name="start-time" required/></label>
			<label><span class="mm">* <span class="sm">结束时间</span></span><input type="date" name="end-time" required /></label>
			<label>来访事由<input name="why" /></label>
			<label>
				进出权限
				<select name="quanxian">
					<option value="国防教育">国防教育</option>
					<option value="有色金属院校">有色金属院校</option>
					<option value="食堂">食堂</option>
					<option value="仓库">仓库</option>
				</select>
			</label>
			<label><span style="line-height: 35px;">备注</span><textarea name="message" rows="4" cols="5" placeholder="请输入文本..."></textarea></label>
			<input id="guestbutton" type="submit" value="确定"/>
		</form>
		
		<div class="qrcode" id="qrcode"></div>
		
    </div>
	
</body>
<script src="js/home.js"></script>
<script src="js/qrcode.js"></script>
<script>
	function jumpPage(url) {
		window.location.href = url;
	}
</script>
<script>
    var carID, phone, start_time, end_time, why, quanxian, message;

	$(".erweima").click(function() {
		$(".cbox").each(function(){
			if($(this).prop("checked")){
				var tr=$(this).parent().parent();
				carID = "车牌号:" + tr.find("#pcarID").text()+ "\n";
				phone = "手机号:" + tr.find("#pphone").text()+ "\n";
				start_time = "开始时间:" + tr.find("#pstart_time").text()+ "\n";
				end_time = "结束时间:" + tr.find("#pend_time").text()+ "\n";
				why = "来事访由:" + tr.find("#pwhy").text()+ "\n";
				quanxian = "权限:" + tr.find("#pquanxian").text() + "\n";
				message = "备注:" + tr.find("#pmessage").text() + "\n";
				
				var info = "BEGIN:VCARD\n" + carID + phone + start_time + end_time + why + quanxian + message + "END:VCARD";
				
				//生成二维码
				var qrcode = new QRCode("qrcode");
						qrcode.makeCode(info);
				

			}
			
		})
		
    })
</script>
<script>
	var guesthelp = false;
	function showguesthelp(){
		var form = document.querySelector("#guesthelp");
		if(guesthelp==false){
			form.style.display = "block";
			guesthelp = true;
		}else{
			form.style.display = "none";
			 guesthelp = false;
		}
	}
	function chacha(){
		
		var form = document.querySelector("#guesthelp");
		if(guesthelp==false){
			form.style.display = "block";
			 guesthelp = true;
		}else{
			form.style.display = "none";
			guesthelp = false;
			//清空input
			var inputs = form.querySelectorAll("input");
			for(var i=0; i<inputs.length; i++){
				inputs[i].value = "";
			}
			var textarea = form.querySelector("textarea");
			textarea.value = "";
			var guestbutton = document.querySelector("#guestbutton");
			guestbutton.value = "确定";
			
			var selectedTextContainer = document.getElementById('selectedTextContainer');
			selectedTextContainer.textContent = "--->访客人员管理";
			form.style.top = 130+"px";
			form.style.left = 500+"px";
		}
	}
	
</script>
</html>