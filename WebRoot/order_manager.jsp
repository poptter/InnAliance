<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单管理</title>
    
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
  	<div align="center">
  		<img alt="客栈店家状态分布图" src="<%=basePath%>JFreeChatr\orderManager.jpg">
  	</div>
	<hr>
    <div id="grid" align='center'></div>
    <hr>
	<br><br><br><br><br><br>
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
  BUI.use(['bui/grid','bui/data'],function (Grid,Data) {

    var columns = [
			{title : '预定旅客',dataIndex :'orderPerson',width:80},
			{title : '预定开始时间',dataIndex :'orderRoomBeginTime'},
			{title : '预定结束时间',dataIndex :'orderRoomEndTime'},
            {title : '客房名称',dataIndex :'roomName'},
			{title : '客房类型',dataIndex :'romTypeName'},
            {title : '入住人数',dataIndex :'orderRoomPeopleNumber'},
			{title : '实价（元）',dataIndex :'orderRoomPrice'},
            {title : '操作',dataIndex :'option',width:50}
          ];
      	//默认的数据
		data = [];
		<c:forEach items="${requestScope.orderRooms}" var="orderRoom">
	    	data.push({
	    				orderPerson:'${orderRoom.guest.userInfo.userName}',
	    				orderRoomBeginTime:'${orderRoom.orderRoomBeginTime}'.substring(0, 10) ,
	    				orderRoomEndTime:'${orderRoom.orderRoomEndTime}'.substring(0, 10),
	    				roomName:'${orderRoom.room.roomName}',
	    				romTypeName:'${orderRoom.room.roomType.roomTypeName}',
	    				orderRoomPeopleNumber:'${orderRoom.orderRoomPeopleNumber}',
	    				orderRoomPrice:'${orderRoom.orderRoomPrice}',
	    				option:"<a href='<%=basePath%>deleteOrderRoom?orderRoomId=${orderRoom.orderRoomId}'><i class='icon-remove'></i>删除</a>"
	    			});
    	</c:forEach>
      store = new Data.Store({
        data:data
      }),
      editing = new Grid.Plugins.CellEditing(),
      grid = new Grid.Grid(
		  {
			render : '#grid',
			columns : columns,
			width : 1000,
			forceFit : true,
			store : store
		  }
	  );
    grid.render();

    var logEl = $('#log');
    $('#btnSave').on('click',function(){
      if(editing.isValid()){
        var records = store.getResult();
        logEl.text(BUI.JSON.stringify(records));
      }
    });
  });
</script>
<body>
</html>