<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客栈详细信息</title>
    
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
			body{
				margin:0;
				padding:0;
				background-image: URL(<%=basePath%>innPhoto/${requestScope.bdMap.inn.userInfo.userNo }.jpg);
				background-size:cover; 
				background-position: center;
				background-repeat: no-repeat;
				background-attachment: fixed;
			} 
			code {
			  padding: 0px 4px;
			  color: #d14;
			  background-color: #f7f7f9;
			  border: 1px solid #e1e1e8;
			}
			#map{
				position:absolute;
				left:600px;
				top:180px;
				width:400px;
				height:300px;
				z-index:5;
				filter:alpha(Opacity=90);
				opacity: 0.9;
				background-color: #f5f5f5;
				border: 1px solid rgba(238, 238, 238, 0.9);
				-webkit-border-radius: 3px;
				-moz-border-radius: 3px;
				border-radius: 3px;
				-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.5);
				-moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.5);
				box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.5);
			}
		 </style>

		<!--引用百度地图API-->
		<style type="text/css">
			html,body{margin:0;padding:0;}
			.iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
			.iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
		</style>
		<script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true">
		</script>
  </head>
  
  <body>
  	<div id="map">
  		<div id="dituContent" style="width: 95%; height: 95%; border: 0.5px solid gray;margin: 10px auto" ></div>
  	</div>
	<div class="container">
	    <div class="row">
	      <div class="span16"> 
	        <form id="J_Form" action="<%=basePath%>queryAllAvailableRoomByInnId" method="post" class="row">
	          <div class="span16">
				<div class="well"><!-- 注册用户 -->
					<h1 align="left">${requestScope.bdMap.inn.innName }&nbsp;&nbsp;详细信息</h1>
					<table >
						<div style="display: none">
							<p align="center">
								<label >客栈编号：</label><input id="innId" name="innId" type="text" value="${requestScope.bdMap.inn.innId }" readonly="readonly" >
							</p>
						</div>
						<tr>
							<td>客栈名称：</td>
							<td>${requestScope.bdMap.inn.innName }</td>
						</tr>
						<tr>
							<td>营业执照：</td>
							<td>${requestScope.bdMap.inn.innPrimitId }</td>
						</tr>
						<tr>
							<td>介绍：</td>
							<td width="200px">${requestScope.bdMap.inn.innIntroduction }</td>
						</tr>
						<tr>
							<td>地址：</td>
							<td>${requestScope.bdMap.inn.innAddress }</td>
						</tr>
					</table>
					<hr>
					<h1 align="left">${requestScope.inn.innName }&nbsp;&nbsp;联系方式</h1>
					<table>
						<tr>
							<td>店主：</td>
							<td>${requestScope.bdMap.inn.userInfo.userName }</td>
							<td rowspan="4" style="margin:auto;">
								<img alt="扫一扫" width="160px" height="160px" src="<%=basePath%>userPhoto/RQCode/${requestScope.bdMap.inn.userInfo.userNo }.jpg">
							</td>
						</tr>
						<tr>
							<td>手机：</td>
							<td>${requestScope.bdMap.inn.userInfo.userPhone }</td>
						</tr>
						<tr>
							<td>&nbsp;Q&nbsp;Q：</td>
							<td>${requestScope.bdMap.inn.userInfo.userQq }</td>
						</tr>
						<tr>
							<td>微信：</td>
							<td>${requestScope.bdMap.inn.userInfo.userWeixin }</td>
						</tr>
						<tr>
							<td>电邮：</td>
							<td>${requestScope.bdMap.inn.userInfo.userEmail }</td>
						</tr>
					</table>
					<hr>
					<p align="center">
						<input type="submit" value="查看客房" class="button button-primary" />
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
	  BUI.use('bui/form',function (Form) {
	    new Form.Form({
	      srcNode : '#J_Form'
	    }).render();
	  });
	</script>
	<!-- 百度地图JS -->
	<script type="text/javascript">
	    //创建和初始化地图函数：
	    function initMap(){
	        createMap();//创建地图
	        setMapEvent();//设置地图事件
	        addMapControl();//向地图添加控件
	        addMarker();//向地图中添加marker
	    }
	    
	    //创建地图函数：
	    function createMap(){
	        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
	        var point = new BMap.Point(${requestScope.bdMap.mapX },${requestScope.bdMap.mapY });//定义一个中心点坐标
	        map.centerAndZoom(point,18);//设定地图的中心点和坐标并将地图显示在地图容器中
	        window.map = map;//将map变量存储在全局
	    }
	    
	    //地图事件设置函数：
	    function setMapEvent(){
	        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
	        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
	        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
	        map.enableKeyboard();//启用键盘上下左右键移动地图
	        map.enableInertialDragging();// 开启惯性拖拽效果
	        //map.addControl(new BMap.MapTypeControl());//地图类型
	    }
	    
	    //地图控件添加函数：
	    function addMapControl(){
	        //向地图中添加缩放控件
			var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
			map.addControl(ctrl_nav);
	        //向地图中添加缩略图控件
			var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:0});
			map.addControl(ctrl_ove);
	        //向地图中添加比例尺控件
			var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
			map.addControl(ctrl_sca);
	    }
	    
	    //标注点数组
	    var markerArr = [
		{
			title:"${requestScope.bdMap.inn.innName }",
			content:"<b>联系电话：</b>${requestScope.bdMap.inn.userInfo.userPhone }<br><b>地址：</b>${requestScope.bdMap.inn.innAddress }",
			point:"${requestScope.bdMap.mapX }|${requestScope.bdMap.mapY }",
			isOpen:0,//开启标记
			icon:{w:23,h:25,l:46,t:21,x:9,lb:12}} 
		];
	    //创建marker
	    function addMarker(){
	        for(var i=0;i<markerArr.length;i++){
	            var json = markerArr[i];
	            var p0 = json.point.split("|")[0];
	            var p1 = json.point.split("|")[1];
	            var point = new BMap.Point(p0,p1);
				var iconImg = createIcon(json.icon);
	            var marker = new BMap.Marker(point,{icon:iconImg});
				var iw = createInfoWindow(i);
				var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
				marker.setLabel(label);
	            map.addOverlay(marker);
	            label.setStyle({
	                        borderColor:"#808080",
	                        color:"#333",
	                        cursor:"pointer"
	            });
				
				(function(){
					var index = i;
					var _iw = createInfoWindow(i);
					var _marker = marker;
					_marker.addEventListener("click",function(){
					    this.openInfoWindow(_iw);
				    });
				    _iw.addEventListener("open",function(){
					    _marker.getLabel().hide();
				    })
				    _iw.addEventListener("close",function(){
					    _marker.getLabel().show();
				    })
					label.addEventListener("click",function(){
					    _marker.openInfoWindow(_iw);
				    })
					if(!!json.isOpen){
						label.hide();
						_marker.openInfoWindow(_iw);
					}
				})()
	        }
	    }
	    //创建InfoWindow
	    function createInfoWindow(i){
	        var json = markerArr[i];
	        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
	        return iw;
	    }
	    //创建一个Icon
	    function createIcon(json){
	        var icon = new BMap.Icon("http://app.baidu.com/map/images/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
	        return icon;
	    }
	    
	    initMap();//创建和初始化地图
	</script>
  </body>
</html>
