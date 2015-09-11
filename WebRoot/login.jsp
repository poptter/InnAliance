<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>用户登录</title>

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
	<script type="text/javascript">
		window.onload=function(){
		    var verifyObj = document.getElementById("Verify");
		    verifyObj.onclick=function(){
		        this.src="SecurityCodeImageAction?timestamp="+new Date().getTime();
		    };
		}
	</script>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="span16">
				<form id="J_Form" action="<%=basePath%>login" method="post" class="row">
					<div class="span16">
						<div class="well">
							<!-- 注册用户 -->
							<h2 align="center">用户登录</h2>
							<br />
							<p align="center">
								<label>用&nbsp;户&nbsp;名：</label>
								<input name="userInfo.userNo" id="userInfo.userNo"data-rules="{required:true,minlength:6}" type="text">
							</p>
							<p align="center">
								<label>&nbsp;密&nbsp; 码&nbsp;：</label>
								<input id="userInfo.userPwd" name="userInfo.userPwd" id="userInfo.userNo" type="password" data-rules="{minlength:6}">
							</p>
							<p align="center">
								<label>验&nbsp;证&nbsp;码：</label>
								<input type="text" id="securityCode" name="securityCode" data-rules="{required:true,length:4}" style="width:60px;"/>
  								<img src="Security/SecurityCodeImageAction" id="Verify"  style="cursor:hand;" alt="看不清，换一张"/>
							</p>
							<br />
							<p align="center">
								<input type="submit" value="登录" class="button button-primary" />&nbsp;&nbsp;&nbsp;&nbsp;
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
  <script type="text/javascript">
		$(function () {  
		    //点击图片更换验证码
		    $("#Verify").click(function(){
		        $(this).attr("src","SecurityCodeImageAction?timestamp="+new Date().getTime());
		    });
		});
	</script>
</html>
