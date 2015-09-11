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

<title>商家注册</title>

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
<!-- 引入百度地图API -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/library/CityList/1.2/src/CityList_min.js"></script>

</head>

<body>
	<div class="container">
		<div class="row">
			<div class="span16">
				<form id="J_Form" action="<%=basePath%>updateBdMap" method="post" class="row" enctype="multipart/form-data">
					<div class="span16">
						<div class="well">
							<!-- 注册用户 -->
							<h2 align="center">修改客栈信息</h2>
							<hr>
							<div style="display: none">
								<p align="center">
									<label >客栈编号&nbsp;：</label><input id="innId" name="innId" type="text" value="${requestScope.bdMap.inn.innId }" readonly="readonly" >
								</p>
							</div>
							<p align="center">
								<label>&nbsp;客栈名称&nbsp;：</label> 
								<input id="innName" name="innName" type="text" value="${requestScope.bdMap.inn.innName }" readonly="readonly">
							</p>
							<p align="center">
								<label>&nbsp;身份证号&nbsp;：</label>
								<input id="innIdCard" name="innIdCard" data-rules="{required:true,length:18}" type="text" value="${requestScope.bdMap.inn.innIdCard }">
							</p>
							<p align="center">
								<label>&nbsp;营业执照&nbsp;：</label> 
								<input id="innPrimitId" name="innPrimitId" data-rules="{required:true,minlength:8}" type="text" value="${requestScope.bdMap.inn.innPrimitId }">
							</p>
							<p align="center">
								<label>&nbsp;地&nbsp;&nbsp;址&nbsp;：</label>
								<input id="innAddress" name="innAddress" data-rules="{required:true,minlength:3}" type="text" value="${requestScope.bdMap.inn.innAddress }">
							</p>
							<p align="center">
								<label>&nbsp;简&nbsp;&nbsp;介&nbsp;：</label>
								<textarea id="innIntroduction" name="innIntroduction" rows="3" cols="20" data-rules="{required:true,minlength:20}" value="${requestScope.bdMap.inn.innIntroduction }"></textarea>
							</p>
							<p style ="margin-left:116px">
								<label>&nbsp;照&nbsp;&nbsp;片&nbsp;：</label>
								<s:file name="innPhoto"  data-rules="{required:true}"/>
							</p>
							<br />
							<p align="center">
								客栈位置：<br />
							</p>
							<code>
								<b>注：</b>请在以下地图中选取！
							</code>
							<div style="width: 400px; height: 300px; border: 0px solid gray;"
								id="container"></div>
							<p align="center">
								经度：<input id="mapX" name="mapY" type="text" style="width:80px;" readonly data-rules="{required:true}" value="${requestScope.bdMap.mapX }"/>&nbsp;&nbsp;&nbsp;&nbsp; 
								纬度：<input id="mapY" name="mapX" type="text" style="width:80px;" readonly  data-rules="{required:true}" value="${requestScope.bdMap.mapY }"/><br />
							</p>

							<p align="center">
								<input type="submit" value="修改" class="button button-primary" />&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="清空" class="button button-primary" /><br />
							</p>
							<br />
							<!-- 显示地图 -->
							<p align="center"></p>
							<br />
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

</body>
<!-- 百度地图API 添加标注 -->
<script type="text/javascript">
	var map = new BMap.Map("container");
	map.centerAndZoom(new BMap.Point(${requestScope.bdMap.mapX }, ${requestScope.bdMap.mapY }), 18);
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.ScaleControl());
	map.addControl(new BMap.OverviewMapControl());
	map.addControl(new BMap.MapTypeControl());
	map.enableScrollWheelZoom();

	map.addEventListener("click", function(e) {
		document.getElementById("mapX").value = e.point.lat;
		document.getElementById("mapY").value = e.point.lng;
		map.clearOverlays();
		var pointMarker = new BMap.Point(e.point.lng, e.point.lat); // 创建标注的坐标 
		addMarker(pointMarker);
	});

	function addMarker(point) {
		var myIcon = new BMap.Icon("assets/img/mk_icon.png",
				new BMap.Size(1, 1), {
					offset : new BMap.Size(21, 21),
					imageOffset : new BMap.Size(0, -21)
				});
		var marker = new BMap.Marker(point, {
			icon : myIcon
		});
		map.addOverlay(marker);
	}
</script>
</html>
