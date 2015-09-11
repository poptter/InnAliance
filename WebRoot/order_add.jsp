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

<title>提交订单</title>

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
	var ADDTIME = 15;//15天以内
	var min = new Date();
	var max = new Date(parseInt((Date.parse(min) + ADDTIME * 24 * 3600 * 1000).toString()));

	//var minday = min.getFullYear() + "-" + (min.getMonth() + 1) + "-"+ min.getDate();
	//var maxday = max.getFullYear() + "-" + (max.getMonth() + 1) + "-"+ max.getDate();

	var minday = date2str(min, "yyyy-MM-dd");
	var maxday = date2str(max, "yyyy-MM-dd");
	function date2str(x, y) {
		var z = {
			M : x.getMonth() + 1,
			d : x.getDate(),
			h : x.getHours(),
			m : x.getMinutes(),
			s : x.getSeconds()
		};
		y = y.replace(/(M+|d+|h+|m+|s+)/g, function(v) {
			return ((v.length > 1 ? "0" : "") + eval('z.' + v.slice(-1))).slice(-2)
		});
		return y.replace(/(y+)/g, function(v) {
			return x.getFullYear().toString().slice(-v.length)
		});
	}
</script>
</head>

<body>
	<ifrom allowtransparency="true" frameborder="0" width="875" height="98"
		scrolling="no"
		src="http://tianqi.2345.com/plugin/widget/index.htm?s=2&z=1&t=1&v=0&d=5&bd=0&k=000000&f=&q=1&e=0&a=0&c=56651&w=875&h=98&align=right"></ifrom>
	<div class="container">
		<div class="row">
			<div class="span16">
				<hr>
				<form id="J_Form" action="<%=basePath%>addOrderRoom" method="post"
					class="row">
					<div class="span16">
						<div class="well">
							<div style="display:none">
								<label>客栈编号：</label> <input id="orderRoom.inn.innId"
									name="orderRoom.inn.innId" data-rules="{required:true}"
									type="text" value="${requestScope.room.inn.innId }"
									readonly="readonly" style="width:240px;"> <label>客房编号：</label>
								<input id="orderRoom.room.roomId" name="orderRoom.room.roomId"
									data-rules="{required:true}" type="text"
									value="${requestScope.room.roomId }" readonly="readonly"
									style="width:240px;">
							</div>
							<h2 align="center">客房预定</h2>
							<table align='center'>
								<tr>
									<td><label>客栈名称：</label></td>
									<td><input name="a" data-rules="{required:true}"
										type="text" value="${requestScope.room.inn.innName }"
										readonly="readonly" style="width:240px;"></td>
								</tr>
								<tr>
									<td><label>客房名称：</label></td>
									<td><input name="g" data-rules="{required:true}"
										type="text" value="${requestScope.room.roomName }"
										readonly="readonly" style="width:240px;"></td>
								</tr>
								<tr>
									<td><label>客房类型：</label></td>
									<td><input name="g" data-rules="{required:true}"
										type="text" value="${requestScope.room.roomType.roomTypeName}"
										readonly="readonly" style="width:240px;"></td>
								</tr>
								<tr>
									<td><label>报价(天)：</label></td>
									<td><input id="orderRoom.orderRoomPrice"
										name="orderRoom.orderRoomPrice" data-rules="{required:true}"
										type="text" value="${requestScope.room.roomRates }"
										readonly="readonly" style="width:240px;"></td>
								</tr>
								<tr>
									<td><label>预定日期：</label></td>
									<td>
										<div id="group" class="bui-form-group">
											<input id="orderRoomBeginTime" name="orderRoomBeginTime"
												class="calendar" type="text"
												data-rules="{required:true,minDate:minday}"
												style="width:110px;"> <label>- </label> <input
												id="orderRoomEndTime" name="orderRoomEndTime"
												class="calendar" type="text"
												data-rules="{required:true,maxDate:maxday}"
												style="width:110px;">
										</div>
									</td>
								</tr>
								<tr>
									<td><label>入住人数：</label></td>
									<td><input id="orderRoom.orderRoomPeopleNumber"
										name="orderRoom.orderRoomPeopleNumber"
										data-rules="{required:true,max:8}" type="text"
										style="width:240px;"></td>
								</tr>
							</table>
							<p align="center">
								<input type="submit" value="预定" class="button button-primary" />&nbsp;&nbsp;&nbsp;&nbsp;
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
		BUI
				.use(
						'bui/form',
						function(Form) {
							new Form.Form(
									{
										srcNode : '#J_Form',
										//联合校验起始日期
										validators : {
											'#group' : function(record) {//根据分组的id 
												if (record.orderRoomBeginTime > record.orderRoomEndTime) {
													return '日期错误！';
												}
											}
										}
									}).render();
						});
	</script>
<body>
</html>
