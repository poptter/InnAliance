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

<title>欢迎</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
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
<!--小帅哥
<script src="weather/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="weather/2013-0121.js" type="text/javascript"></script>
-->
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span4">
				<h2>客栈联盟 简介</h2>
				<br />

				<!--  系统时间 -->
				<div id="page_begin_html" >
					<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
						codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0"
						width="100" height="50" id="honehoneclock" align="center">
						<param name="allowScriptAccess" value="always">
						<param name="movie" value="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_tr.swf">
						<param name="quality" value="high">
						<param name="bgcolor" value="#99ffffff">
						<param name="wmode" value="transparent">
						<embed wmode="transparent"
							src="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_tr.swf"
							quality="high" bgcolor="#ffffff" width="400" height="200"
							name="honehoneclock" align="center" allowscriptaccess="always"
							type="application/x-shockwave-flash"
							pluginspage="http://www.macromedia.com/go/getflashplayer">
					</object>
				</div>

			</div>
			<div class="span20"></div>
		</div>
		<br><br><br><br><br><br><br><br>
		<div class="row">
			<div class="span24">
				<h4>版权声明</h4>
				<ul>
					<li>本项目由 云南师范大学文理学院 信息工程学院 11计科 杨志 编写 仅用于个人毕业设计！</li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="assets/js/bui-min.js"></script>
	<script type="text/javascript" src="assets/js/config-min.js"></script>
	<script type="text/javascript">
		BUI.use('common/page');
	</script>
<body>
</html>
