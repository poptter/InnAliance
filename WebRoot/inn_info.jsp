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
    
    <title>浏览客栈列表</title>
    
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
	  <div class="container" align='center'>
	  	<form id="J_Form" action="<%=basePath%>queryAllInnByName" method="post">
			<div class="span16">
				<!-- 快速查询 -->
				<label><b>&nbsp;&nbsp;快&nbsp;速&nbsp;查&nbsp;询：&nbsp;&nbsp;</b></label>
				<input name="innName" id="innName" data-rules="{required:true,minlength:1}" type="text">
				<input type="submit" value="查询" class="label label-warning" />&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</form>
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
				{title : '客栈编号',dataIndex :'inn_id'},
				{title : '名称',dataIndex :'inn_name'},
	            {title : '简介',dataIndex :'inn_Introduction'},
	            {title : '地址',dataIndex :'inn_address'},
	            {title : '好评',dataIndex :'inn_valuation'}
	            <c:if test="${loginUser.role.roleId==3 }">,
					{title : '操作',dataIndex :'option',width:50}
	            </c:if>
	          ];
	      //默认的数据
			data = [];
			<c:forEach items="${requestScope.inns}" var="inn">
				data.push(
						{
							inn_id:'${inn.innId}',
							inn_name:'${inn.innName}',
							inn_Introduction:'${inn.innIntroduction}',
							inn_address:'${inn.innAddress}',
							inn_valuation:'${inn.innValuation}星'
							<c:if test="${loginUser.role.roleId==3 }">,
								option:"<a href='queryBdMapByInnId?innId=${inn.innId}'><i class='icon-search'></i>详情</a>"
							</c:if>
						}
				);
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
	<script type="text/javascript">
		BUI.use('bui/form', function(Form) {
			new Form.Form({
				srcNode : '#J_Form'
			}).render();
		});
	</script>
	<body>
</html>
