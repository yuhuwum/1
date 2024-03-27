<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">		
		<title>登录</title>		
		<style>			
		*{				
			margin: 0;
			padding: 0;			
		}			
		#box{			
			height:  100vh;			
			background-image: url('../img/logoBg.jpg');				
			background-repeat: no-repeat; 				
			background-size: 100% 100%;			
		}			
		.wz{			
			color: white;				
			position: absolute;				
			top:45%;				
			left: 16%;			
		}			
		#form{			
			border-radius: 10px;				
			position: absolute;				
			top:20%;				
			right: 10%;				
			background-color: white;				
			width: 332px;				
			height: 270px;				
			padding: 30px 10px;			
		}			
		input{				
			border: 1px black solid;				
			border-radius: 10px;				
			height: 40px;				
			width: 280px;			
		}			
		h2{			
			margin: 0 auto;				
			width: 100px;				
			text-align: center;			
		}			
		#dlu{				
			color: white;				
			background-color: #409EFF;				
			width: 330px;			
		}			
		#dlubox{			
			width: 330px;				
			margin: 0 auto;			
		}			
		#zhbox{				
			margin-top: 20px;				
			height: 63px;			
		}			
		#mmbox{				
			height: 63px;				
			margin-top: 20px;				
			margin-bottom: 20px;			
		}		
		span{			
			display: none;				
			color: red;				
			margin-left: 48px;				
			font-size: 12px;			
		}		
	</style>		
	<script>			
		function jz(){			
			var sub=document.querySelector("#dlu");				
			sub.onclick=function(){					
				var zh=document.querySelector("#zh").value;					
				var mm=document.querySelector("#mm").value;					
				if(zh==""){					
					document.querySelector("#zhpd").style.display="block";						
					return false;					
				}else{					
					document.querySelector("#zhpd").style.display="none";					
				}					
				if(mm==""){					
					document.querySelector("#mmpd").style.display="block";						
					return false;					
				}else{					
					document.querySelector("#mmpd").style.display="none";					
				}				
			}			
		}					
		</script>	
	</head>	
	<body onload="jz()">		
		<div id="box">		
			<div class="wz">			
				<h1>停车云&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;智慧停车管理系统</h1>			
			</div>			
			<div id="form">			
				<h2>登录</h2>				
				<form>				
					<div id="zhbox">						
						账号：<input type="text" name="zh" id="zh"/><br/>						
						<span id="zhpd">账号不能为空</span>					
					</div>					
					<div id="mmbox">					
						密码：<input type="password" name="mm" id="mm"/><br/>						
						<span id="mmpd">密码不能为空</span>					
					</div>										
					<div id="dlubox">					
						<input type="submit" value="登录" id="dlu"/>					
					</div>				
				</form>							
			</div>		
		</div>	
	</body>	
</html>