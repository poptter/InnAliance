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

<title>嘻嘻，粗错啦</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="assets/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<link href='http://fonts.googleapis.com/css?family=Ropa+Sans'
	rel='stylesheet' type='text/css'>
</head>

<body>
	<!--start-wrap--->
	<div class="wrap">
		<!--start-header--->
		<div class="header">
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="left-content">
				<h4>亲！维护ing……</h4>
			</div>
			<div class="right-content">
				<img src="assets/images/banner.png" title="banner-name" />
			</div>
			<div class="clear"></div>
		</div>
		<!--end-header--->
	</div>
	<!--start-wrap--->
</body>
</html>
