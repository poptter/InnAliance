<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>浏览客房</title>
    
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
   		<script type="text/jscript">
			function quickQuery(){
				var str;
				var innId=document.getElementById("innId").value;
				str="<%=basePath%>queryAllAvailableRoomByInnId?innId="+innId;		
				window.location.href=str;
			}
		</script>
  </head>
  
<body>
  <div class="container" >
  	<div align="center" class="bui-form-group-select" data-type="inns">
		<label><b>&nbsp;&nbsp;快&nbsp;速&nbsp;查&nbsp;询：&nbsp;&nbsp;</b></label>
		<select class="input-small"  id="innId" name="innId" value="0" onchange="quickQuery()">
			<option id="0">--请选择--</option>
			<c:forEach items="${requestScope.inns}" var="inn">
				<option value="${inn.innId}">${inn.innName}</option>
			</c:forEach>
		</select>
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
			{title : '客栈',dataIndex :'inn_innName'},
            {title : '客房',dataIndex :'room_roomName'},
            {title : '类型',dataIndex :'room_roomType'},
            {title : '价位（元）',dataIndex :'room_roomRates'},
			{title : '操作',dataIndex :'option',width:50}
          ];
      //默认的数据
      data = [];
      <c:forEach items="${requestScope.rooms }" var="room">
	      data.push(
	    		  {
	          		inn_innName:"<a href='queryBdMapByInnId?innId=${room.inn.innId}'>${room.inn.innName }</a>",
	          		room_roomName:'${room.roomName }',
	          		room_roomType:'${room.roomType.roomTypeName }',
	          		room_roomRates:'${room.roomRates }',
	          		option:"<a href='queryRoomByRoomIdForAddOrder?roomId=${room.roomId }'><i class='icon-time'></i>预定</a>"
	          	} 
	      	);
      </c:forEach>
      store = new Data.Store({
        data:data
      }),
      editing = new Grid.Plugins.DialogEditing({
        contentId : 'content',
        triggerCls : 'btn-edit'
      }),
      grid = new Grid.Grid({
        render : '#grid',
        columns : columns,
        width : 700,
        forceFit : true,
        store : store,
        plugins : [editing]
      });
    grid.render();
    var logEl = $('#log');
    $('#btnSave').on('click',function(){

      var records = store.getResult();
      logEl.text(BUI.JSON.stringify(records));
    });
  });
</script>
<body>
</html>
