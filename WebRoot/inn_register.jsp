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
<script type="text/javascript" src="<%=basePath%>js/ajax.js"></script>
<script type="text/javascript">
	function checkInnUserNo(){
		var userNo = document.getElementById("bdMap.inn.userInfo.userNo").value;
		var url = "<%=basePath%>cheakInnUserNo";
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
<!-- 引入百度地图API -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/CityList/1.2/src/CityList_min.js"></script>

</head>

<body>
	<div class="container">
		<div class="row">
			<div class="span16">
				<form id="J_Form" action="<%=basePath%>addBdMap" method="post" class="row"   enctype="multipart/form-data">
					<div class="span16">
						<div class="well">
							<!-- 注册用户 -->
							<h2 align="center">店家信息</h2>
							<br />
							<p align="center">
								<label>用&nbsp;户&nbsp;名&nbsp;：</label> 
								<input id="bdMap.inn.userInfo.userNo" name="bdMap.inn.userInfo.userNo" data-rules="{required:true,minlength:6}" type="text" onblur="checkInnUserNo()">
							</p>
							<p align="center">
								<label>&nbsp;密&nbsp;&nbsp;码&nbsp;：</label> <input id="password"
									name="password" type="password" data-rules="{minlength:6}">
							</p>
							<p align="center">
								<label>确认&nbsp;密码&nbsp;：</label> <input id="bdMap.inn.userInfo.userPwd"
									name="bdMap.inn.userInfo.userPwd" type="password"
									data-rules="{equalTo:'#password'}">
							</p>
							<p align="center">
								<label>真实&nbsp;姓名&nbsp;：</label><input id="bdMap.inn.userInfo.userName"
									name="bdMap.inn.userInfo.userName"
									data-rules="{required:true,minlength:2}" type="text">
							</p>
							<p align="center">
								<label>&nbsp;手&nbsp;&nbsp;机&nbsp;：</label> <input
									id="bdMap.inn.userInfo.userPhone" name="bdMap.inn.userInfo.userPhone"
									data-rules="{number:true,length:11}" type="text">
							</p>
							<p align="center">
								<label>&nbsp;电&nbsp;&nbsp;邮&nbsp;：</label> <input
									id="inn.userInfo.userEmail" name="bdMap.inn.userInfo.userEmail"
									data-rules="{email:true}" type="text">
							</p>
							<p align="center">
								<label>&nbsp;&nbsp;Q&nbsp;&nbsp;Q&nbsp;：</label> <input
									id="bdMap.inn.userInfo.userQq" name="bdMap.inn.userInfo.userQq"
									data-rules="{number:true,minlength:5}" type="text">
							</p>
							<p align="center">
								<label>&nbsp;微&nbsp;&nbsp;信&nbsp;：</label> <input
									id="bdMap.inn.userInfo.userWeixin" name="bdMap.inn.userInfo.userWeixin"
									data-rules="{minlength:5}" type="text">
							</p>
							<p style ="margin-left:116px">
								<label>&nbsp;照&nbsp;&nbsp;片&nbsp;：</label>
								<s:file name="photos"  data-rules="{required:true}"/>
							</p>
							<br>
							<hr>
							<br>
							<h2 align="center">客栈信息</h2>
							<br />
							<p align="center">
								<label>客栈名称&nbsp;：</label> <input id="bdMap.inn.innName" name="bdMap.inn.innName"
									data-rules="{required:true,minlength:1}" type="text">
							</p>
							<p align="center">
								<label>身份证号&nbsp;：</label><input id="bdMap.inn.innIdCard"
									name="bdMap.inn.innIdCard" data-rules="{required:true,length:18}"
									type="text">
							</p>
							<p align="center">
								<label>营业执照&nbsp;：</label> <input id="bdMap.inn.innPrimitId"
									name="bdMap.inn.innPrimitId" data-rules="{required:true,minlength:8}"
									type="text">
							</p>
							<p align="center">
								<label>&nbsp;地&nbsp;&nbsp;址&nbsp;：</label> <input
									id="bdMap.inn.innAddress" name="bdMap.inn.innAddress"
									data-rules="{required:true,minlength:3}" type="text">
							</p>
							<p align="center">
								<label>&nbsp;简&nbsp;&nbsp;介&nbsp;：</label>
								<textarea id="bdMap.inn.innIntroduction" name="bdMap.inn.innIntroduction"
									rows="3" cols="20" data-rules="{required:true,minlength:20}"></textarea>
							</p>
							<p style ="margin-left:116px">
								<label>&nbsp;照&nbsp;&nbsp;片&nbsp;：</label>
								<s:file name="photos"/>
							</p>
							<br />

							<!-- <p align="center">
								客栈位置：<br />
							</p> -->
							<code>
								<b>注：</b>请在以下地图中选取！
							</code>
							<div style="width: 400px; height: 300px; border: 0px solid gray;" id="container"></div>
							<p align="center">
								经度：<input id="bdMap.mapX" name="bdMap.mapY" type="text" style="width:80px;" readonly data-rules="{required:true}" />&nbsp;&nbsp;&nbsp;&nbsp; 
								纬度：<input id="bdMap.mapY" name="bdMap.mapX" type="text" style="width:80px;" readonly  data-rules="{required:true}"/><br />
							</p>
							<p align="center">
								<input type="submit" value="注册" class="button button-primary" />&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="清空" class="button button-primary" /><br />
							</p>
							<br />
							<!-- 显示地图 -->
							<p align="center">
								<!--<div style="width: 400px; height: 300px; border: 1px solid gray; float: left;" id="container"></div>-->
							</p>
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
	map.centerAndZoom(new BMap.Point(100.240562, 26.881109), 18);
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.ScaleControl());
	map.addControl(new BMap.OverviewMapControl());
	map.addControl(new BMap.MapTypeControl());
	map.enableScrollWheelZoom();

	map.addEventListener("click", function(e) {
		document.getElementById("bdMap.mapX").value = e.point.lat;
		document.getElementById("bdMap.mapY").value = e.point.lng;
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
