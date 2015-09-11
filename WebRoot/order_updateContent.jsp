<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
</head>

<body>
	<div class="container" >
		<div class="row" >
			<div class="span16" >
				<form id="J_Form" action="<%=basePath%>updateOrderRoom" method="post" class="row">
					<div class="span16" >
						<div class="well">
							<div style="display:none">
									<label>订单编号：</label>
									<input id="orderRoomId" name="orderRoomId" type="text" value="${requestScope.orderRoom.orderRoomId }" readonly="readonly" style="width:240px;color:#0000ff">
									<label>客栈编号：</label>
									<input id="innId" name="innId" type="text" value="${requestScope.orderRoom.inn.innId }" readonly="readonly" style="width:240px;color:#0000ff">
									<label>客房编号：</label>
									<input id="roomId" name="roomId" type="text" value="${requestScope.orderRoom.room.roomId }" readonly="readonly" style="width:240px;color:#0000ff">
							</div>
							<h2 align="center">订单修改</h2>
							<table align='center'>
								<tr>
									<td><label>客栈名称：</label></td>
									<td>
										<input id="innName" name="innName" type="text" value="${requestScope.orderRoom.inn.innName }" readonly="readonly" style="width:240px;color:#0000ff">
									</td>
								</tr>
								<tr>
									<td><label>客房名称：</label></td>
									<td>
										<input id="roomName" name="roomName" type="text" value="${requestScope.orderRoom.room.roomName }" readonly="readonly" style="width:240px;color:#0000ff">
									</td>
								</tr>
								<tr>
									<td><label>客房类型：</label></td>
									<td>
										<input id="roomTypeName" name="roomTypeName" type="text" value="${requestScope.orderRoom.room.roomType.roomTypeName}" readonly="readonly" style="width:240px;color:#0000ff">
									</td>
								</tr>
								<tr>
									<td><label>实价(天)：</label></td>
									<td>
										<input id="orderRoomPrice" name="orderRoomPrice" data-rules="{required:true}" type="text" value="${requestScope.orderRoom.orderRoomPrice }" style="width:240px;">
									</td>
								</tr>
								<tr>
									<td><label>预定日期：</label></td>
									<td>
										<div id="group" class="bui-form-group">
											<input id="orderRoomBeginTime" name="orderRoomBeginTime" class="calendar" type="text" data-rules="{required:true}" value="${fn:substring(orderRoom.orderRoomBeginTime,0,10)}" readonly="readonly" style="width:110px;">
											<label>- </label>
											<input id="orderRoomEndTime" name="orderRoomEndTime" class="calendar" type="text" data-rules="{required:true}"  value="${fn:substring(orderRoom.orderRoomEndTime,0,10)}" readonly="readonly" style="width:110px;">
										</div>
									</td>
								</tr>
								<tr>
									<td><label>入住人数：</label></td>
									<td>
										<input id="orderRoomPeopleNumber" name="orderRoomPeopleNumber" data-rules="{required:true,max:8}" type="text" style="width:200px;" value="${requestScope.orderRoom.orderRoomPeopleNumber }">
									</td>
								</tr>
							</table>
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
		//var now = (new Date()).toLocaleString();
		BUI.use('bui/form', function(Form) {
			new Form.Form({
				srcNode : '#J_Form',
				//联合校验起始日期
				validators : {
					'#group' : function(record) {//根据分组的id 
						/* 
						//日期不小于当前系统时间
						if (record.start < now) {
							return '昨日已逝！！';
						}
						*/
						if (record.start < record.end) {
							return '日期有误！';
						}
					}
				}
			}).render();
		});
	</script>
<body>
</html>
