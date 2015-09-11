<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN">
<jsp>
<head>
<base href="<%=basePath%>">

<title>客栈联盟</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta http-equiv="Content-Type" content="text/jsp; charset=utf-8" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<!--小帅哥-->
	<script type="text/javascript" src="weather/js/jquery.min.js"></script>
	<script type="text/javascript" src="weather/js/spig.js"></script>
	<link rel="stylesheet" href="weather/css/spigPet.css" type="text/css"/>
	<script type="text/javascript">
		var isindex = true;
		var visitor = "${loginUser.userName }";
	</script>
	<div id="spig" class="spig">
	    <div id="message">正在加载中……</div>
	    <div id="mumu" class="mumu"></div>
	</div>

	<div class="header">
		<div class="dl-title">
			<span class="lp-title-port">客栈</span><span class="dl-title-text">联盟</span>
		</div>
		<c:if test="${sessionScope.loginUser.userNo!=null }">
			<div class="dl-log">欢迎您，<span class="dl-log-user">${loginUser.userName }</span>
				<a href="<%=basePath%>loginOut" title="退出系统" class="dl-log-quit">[退出系统]</a>
			</div>
		</c:if>
	</div>
	<div class="content">
		<div class="dl-main-nav">
			<div class="dl-inform">
				<div class="dl-inform-title">
					贴心小秘书<s class="dl-inform-icon dl-up"></s>
				</div>
			</div>
			<ul id="J_Nav" class="nav-list ks-clear">
				<li class="nav-item dl-selected"><div class="nav-item-inner nav-home">首页</div></li>
				<c:if test="${sessionScope.loginUser.userNo!=null }">
					<li class="nav-item"><div class="nav-item-inner nav-supplier">客栈</div></li>
					<!-- 管理员不管理客房信息 -->
					<c:if test="${sessionScope.loginUser.role.roleId!='1' }">
						<li class="nav-item"><div class="nav-item-inner nav-inventory">客房</div></li>
					</c:if>
					<li class="nav-item"><div class="nav-item-inner nav-order">系统</div></li>
				</c:if>
			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten">
		</ul>
	</div>
	<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="assets/js/bui.js"></script>
	<script type="text/javascript" src="assets/js/config.js"></script>

	<script>
		BUI.use('common/main', function() {
			var config = [];
			
			//登陆前界面
			<c:if test="${sessionScope.loginUser.userNo==null }">
				config = [{
					id : 'menu1',
					homePage : 'menu1_1',
					menu : [ {
						text : '欢迎',
						items : [ 
						          {id : 'menu1_1',text : '本站简介',href : 'welcome.jsp',closeable : false} 
						        ]
					}, {
						text : '登录',
						items : [ 
						          {id : 'menu1_2',text : '用户登录',href : 'login.jsp'},
						          {id : 'menu1_3',text : '找回密码',href : 'forgetPwd.jsp'}
								]
					}, {
						text : '注册',
						items : [ 
						          {id : 'menu1_4',text : '旅客注册',href : 'guest_register.jsp'}, 
						          {id : 'menu1_5',text : '商家注册',href : 'inn_register.jsp'} 
						        ]
					}]
				}];
		</c:if>
		
		//登陆后界面
		<c:if test="${sessionScope.loginUser.userNo!=null }">
			//管理员界面
			<c:if test="${sessionScope.loginUser.role.roleId=='1' }">
			config = [{
				id : 'menu1',
				homePage : 'menu1_1',
				menu : [ {
					text : '欢迎',
					items : [ 
					          {id : 'menu1_1',text : '本站简介',href : 'welcome.jsp',closeable : false} 
					        ]
				}]
			}, {
				id : 'menu2',
				homePage : 'menu2_4',
				menu : [{
					text : '客栈评论',
					items : [ 
					          {id : 'menu2_4',text : '审核评论',href : '<%=basePath%>queryAllEvaluate'} 
					        ]
				}, {
					text : '客栈管理',
					items : [ 
					          {id : 'menu2_5',text : '审核店家',href : '<%=basePath%>queryInnInNotExamine'}, 
					          {id : 'menu2_6',text : '管理客栈信息',href : '<%=basePath%>innManager'} 
					        ]
				} ]
			}, {
				id : 'menu4',
				homePage : 'menu4_1',
				menu : [ {
					text : '高级管理',
					items : [ 
					          {id : 'menu4_1',text : '用户管理',href : '<%=basePath%>queryAllUserInfo'}, 
					          {id : 'menu4_2',text : '订单管理',href : '<%=basePath%>queryAllOrderRoomForManager'}
					]
				}, {
					text : '系统设置',
					items : [
					         {id : 'menu4_3',text : '修改个人信息',href : 'person_update.jsp'}, 
					         {id : 'menu4_4',text : '修改密码',href : 'password_update.jsp'} 
					        ]
				} ]
			}];
			</c:if>
			//店家界面
			<c:if test="${sessionScope.loginUser.role.roleId==2 }">
			config = [{
				id : 'menu1',
				homePage : 'menu1_1',
				menu : [ {
					text : '欢迎',
					items : [ 
					          {id : 'menu1_1',text : '本站简介',href : 'welcome.jsp',closeable : false} 
					        ]
				}]
			}, {
				id : 'menu2',
				homePage : 'menu2_1',
				menu : [{
					text : '客栈信息',
					items : [
					         {id : 'menu2_1',text : '浏览客栈',href : '<%=basePath%>queryAllInn'}, 
					         {id : 'menu2_2',text : '修改客栈信息',href : '<%=basePath%>queryBdMapByUserInfoId'}
					        ]
				}, {
					text : '客栈评论',
					items : [ 
					          {id : 'menu2_3',text : '浏览评论',href : '<%=basePath%>queryAllPassEvaluate'}
					        ]
				}]
			}, {
				id : 'menu3',
				homePage : 'menu3_2',
				menu : [ {
					text : '客房信息',
					items : [ 
					          {id : 'menu3_2',text : '客房管理',href : '<%=basePath%>queryAllRoom'} 
					        ]
				}, {
					text : '订单',
					items : [ 
					          {id : 'menu3_4',text : '修改订单',href : '<%=basePath%>queryAllOrderRoomByInnId'} 
					        ]
				} ]
			}, {
				id : 'menu4',
				homePage : 'menu4_3',
				menu : [{
					text : '系统设置',
					items : [
					         {id : 'menu4_3',text : '修改个人信息',href : 'person_update.jsp'}, 
					         {id : 'menu4_4',text : '修改密码',href : 'password_update.jsp'} 
					        ]
				} ]
			}];
			</c:if>
			//用户界面
			<c:if test="${sessionScope.loginUser.role.roleId==3 }">
			config = [{
				id : 'menu1',
				homePage : 'menu1_1',
				menu : [ {
					text : '欢迎',
					items : [ 
					          {id : 'menu1_1',text : '本站简介',href : 'welcome.jsp',closeable : false} 
					        ]
				}]
			}, {
				id : 'menu2',
				homePage : 'menu2_1',
				menu : [{
					text : '客栈信息',
					items : [
					         {id : 'menu2_1',text : '浏览客栈',href : '<%=basePath%>queryAllInn'}
					        ]
				}, {
					text : '客栈评论',
					items : [ 
					          {id : 'menu2_3',text : '浏览评论',href : '<%=basePath%>queryAllPassEvaluate'}
					        ]
				}]
			}, {
				id : 'menu3',
				homePage : 'menu3_1',
				menu : [ {
					text : '客房信息',
					items : [ 
					          {id : 'menu3_1',text : '浏览客房',href : '<%=basePath%>queryAllAvailableRoom'}
					        ]
				}, {
					text : '订单',
					items : [ 
					          {id : 'menu3_3',text : '我的订单',href : '<%=basePath%>queryAllOrderRoom'}
					        ]
				} ]
			}, {
				id : 'menu4',
				homePage : 'menu4_3',
				menu : [ {
					text : '系统设置',
					items : [
					         {id : 'menu4_3',text : '修改个人信息',href : 'person_update.jsp'}, 
					         {id : 'menu4_4',text : '修改密码',href : 'password_update.jsp'} 
					        ]
				} ]
			}];
			</c:if>
	</c:if>
	new PageUtil.MainPage({modulesConfig : config});
	});
	</script>
</body>
</jsp>
