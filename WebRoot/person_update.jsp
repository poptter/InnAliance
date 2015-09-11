<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

<title>修改个人信息</title>

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
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="span16">
				<form id="J_Form" action="<%=basePath%>updateUserInfoBise" method="post" class="row"  enctype="multipart/form-data">
					<div class="span16">
						<div class="well">
							<!-- 修改个人信息 -->
							<h2 align="center">修改个人信息</h2>
							<p align="center">
								<label>用&nbsp;户&nbsp;名&nbsp;：</label>
								<input id="userName" name="userName" type="text" value="${sessionScope.loginUser.userName }" readonly="readonly">
							</p align="center">
							<p align="center">
								<label>&nbsp;手&nbsp;&nbsp;机&nbsp;：</label>
								<input id="userPhone" name="userPhone" data-rules="{number:true,length:11}" type="text" value="${sessionScope.loginUser.userPhone }">
							</p>
							<p align="center">
								<label>&nbsp;电&nbsp;&nbsp;邮&nbsp;：</label>
								<input id="userEmail" name="userEmail" data-rules="{email:true}" type="text" value="${sessionScope.loginUser.userEmail }">
							</p>
							<p align="center">
								<label>&nbsp;&nbsp;Q&nbsp;&nbsp;Q&nbsp;：</label>
								<input id="userQq" name="userQq" data-rules="{number:true,minlength:5}" type="text" value="${sessionScope.loginUser.userQq }">
							</p>
							<p align="center">
								<label>&nbsp;微&nbsp;&nbsp;信&nbsp;：</label>
								<input id="userWeixin" name="userWeixin" data-rules="{minlength:5}" type="text" value="${sessionScope.loginUser.userWeixin }">
							</p>
							<p style ="margin-left:116px">
								<label>&nbsp;头&nbsp;&nbsp;像&nbsp;：</label>
								<s:file name="userPhoto"  data-rules="{required:true}"/>
							</p>
							<br />
							<p align="center">
								<input type="submit" value="修改" class="button button-primary" />&nbsp;&nbsp;&nbsp;&nbsp;
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
