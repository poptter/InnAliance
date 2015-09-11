<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>旅客注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/page-min.css" rel="stylesheet" type="text/css" />
<!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
<link href="assets/css/prettify.css" rel="stylesheet" type="text/css" />
<style type="text/css">
code {
	padding: 0px 4px;
	color: #d14;
	background-color: #f7f7f9;
	border: 1px solid #e1e1e8;
}
</style>
<script type="text/javascript" src="<%=basePath%>js/ajax.js"></script>
<script type="text/javascript">
	function checkUserNo(){
		var userNo = document.getElementById("guest.userInfo.userNo").value;
		var url = "<%=basePath%>cheakUserNo";
		var params = "userNo=" + userNo;
		sendByPost(url,params,returnMessage);
	}
	
	function returnMessage(){
		if(request.readyState == 4){
			var message = request.responseText;
			if(message=="err"){
				alert("咦！该用户名已被其他用户注册，请重新输入！");
				document.getElementById("guest.userInfo.userNo").value = "";
			}
		}
	}
</script>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="span16">
				<form id="J_Form" action="<%=basePath%>addGuest" method="post" class="row"  enctype="multipart/form-data">
					<div class="span16">
						<div class="well">
							<!-- 注册用户 -->
							<h2 align="center">旅客注册</h2>
							<p align="center">
								<label>用&nbsp;户&nbsp;名&nbsp;：</label><input id="guest.userInfo.userNo" name="guest.userInfo.userNo"
									data-rules="{required:true,minlength:6}" type="text" onblur="checkUserNo()">
							</p>
							<p align="center">
								<label>&nbsp;密&nbsp;&nbsp;码&nbsp;：</label><input id="userPwd"
									name="userPwd" type="password" data-rules="{minlength:6}">
							</p>
							<p align="center">
								<label>确认&nbsp;密码&nbsp;：</label><input id="guest.userInfo.userPwd" name="guest.userInfo.userPwd" type="password"
									data-rules="{equalTo:'#userPwd'}">
							</p>
							<p align="center">
								<label>真实&nbsp;姓名&nbsp;：</label><input id="guest.userInfo.userName" name="guest.userInfo.userName"
									data-rules="{required:true,minlength:2}" type="text">
							</p>
							<p align="center">
								<label>&nbsp;手&nbsp;&nbsp;机&nbsp;：</label><input id="guest.userInfo.userPhone" name="guest.userInfo.userPhone"
									data-rules="{number:true,length:11}" type="text">
							</p>
							<p align="center">
								<label>&nbsp;电&nbsp;&nbsp;邮&nbsp;：</label><input id="guest.userInfo.userEmail" name="guest.userInfo.userEmail"
									data-rules="{required:true,email:true}" type="text">
							</p>
							<p align="center">
								<label>&nbsp;Q&nbsp;&nbsp;Q&nbsp;&nbsp;：</label><input
									id="guest.userInfo.userQq" name="guest.userInfo.userQq" data-rules="{number:true,minlength:5}" type="text">
							</p>
							<p align="center">
								<label>&nbsp;微&nbsp;&nbsp;信&nbsp;：</label><input id="guest.userInfo.userWeixin" name="guest.userInfo.userWeixin"
									data-rules="{minlength:5}" type="text">
							</p>
							<s:actionerror />
							<s:fielderror />
							<p style ="margin-left:116px">
								<label>&nbsp;头&nbsp;&nbsp;像&nbsp;：</label>
								<s:file name="userPhoto" data-rules="{required:true}"/>
							</p>
							<br />
							<p align="center">
								<input type="submit" value="提交" class="button button-primary" />&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="清除" class="button button-primary" /><br />
							</p>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="assets/js/bui-min.js"></script>
	<script type="text/javascript" src="assets/js/config-min.js"></script>
	<script type="text/javascript">
		BUI.use('common/page');
	</script>
	<!-- 仅仅为了显示代码使用，不要在项目中引入使用-->
	<script type="text/javascript" src="assets/js/prettify.js"></script>
	<script type="text/javascript">
		$(function() {
			prettyPrint();
		});
	</script>
	<script type="text/javascript">
		BUI.use('bui/form', function(Form) {
			new Form.Form({
				srcNode : '#J_Form'
			}).render();
		});
	</script>
<body>
</html>
