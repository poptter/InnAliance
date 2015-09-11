<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增客房</title>
    
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
		<link href="assets/css/page-min.css" rel="stylesheet" type="text/css" />   <!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
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
        <form id="J_Form" action="<%=basePath%>updateRoom" method="post" class="row">
          <div class="span16">
			<div class="well"><!-- 注册用户 -->
				<h2 align="center">修改客房</h2>
				<div style="display: none">
					<p align="center"><label>客房编号：</label>
						<input id="roomId"  name="roomId" style="width:90px;height:20px" type="text" data-rules="{required:true}"  readonly="readonly" value="${requestScope.room.roomId }">
					</p>
				</div>
				<p align="center"><label>客房名称：</label>
					<input id="roomName"  name="roomName" style="width:90px;height:20px" type="text" data-rules="{required:true}" readonly="readonly" value="${requestScope.room.roomName }" >
				</p>
				<p align="center">
					<div align="center" class="bui-form-group-select" data-type="roomType">
						<label>客房类型：</label>
						<select class="input-small"  id="roomTypeId" name="roomTypeId" value="${requestScope.room.roomType.roomTypeId }"></select>
					</div>
				</p>
				<p align="center"><label>价位：</label>
					<input id="roomRates"  name="roomRates" style="width:90px;height:20px" type="text" data-rules="{required:true}" value="${requestScope.room.roomRates }">
				</p>
				<p align="center">
					<div align="center" class="bui-form-group-select" data-type="roomState">
						<label>客房状态：</label>
						<select class="input-small" id="roomState" name="roomState"  value="${requestScope.room.roomState }"></select>
					</div>
				</p>
				<p align="center">
					<input type="submit" value="修改" class="button button-primary" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="清除" class="button button-primary" /><br/>
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
    $(function () {
      prettyPrint();
    });
  </script> 
<script type="text/javascript">
	//客房类型的数据
	var roomType = [];
	<c:forEach items="${requestScope.roomTypes}" var="roomType">
		roomType.push(
				{
					"id" : "${roomType.roomTypeId}",
					"text":"${roomType.roomTypeName}"
				}
		);
	</c:forEach>
	BUI.Form.Group.Select.addType('roomType',{
	  data : roomType
	});
	
	//客房状态的数据
	var roomState = [
		            {"id" : "可用","text":"可用"},
		            {"id" : "维护","text":"维护"},
		            {"id" : "停用","text":"停用"}
	            ];
  BUI.Form.Group.Select.addType('roomState',{
    data : roomState
  });
  
  BUI.use('bui/form',function (Form) {
    new Form.Form({
      srcNode : '#J_Form'
    }).render();
  });
</script>
  </body>
</html>
