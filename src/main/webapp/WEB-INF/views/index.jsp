<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1"> 
    <base href="<%=basePath%>">
    <title>人力资源系统</title>
    <link rel="stylesheet" href="<%=path %>/assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path %>/assets/css/index.css">
    <script src="<%=path %>/assets/js/jquery/jquery-1.11.0.min.js"></script>
    <script src="<%=path %>/assets/js/bootstrap/bootstrap.min.js"></script>
    <script src="<%=path %>/assets/js/echarts/echarts.js"></script>
    <!--[if lt IE 9]>
    <script src="<%=path %>/assets/js/html5shiv.min.js"></script>
    <script src="<%=path %>/assets/js/respond.min.js"></script>
    <![endif]-->
    
    <script src="<%=path %>/assets/js/layer/layer.js"></script>
   	
	<style type="text/css">
		
    #hzsml-menu1 .glyphicon{
		margin-left:35px !important;
	}
		
    #hzsml-menu2 .glyphicon{
		margin-left:35px !important;
	}
	
	</style>
	
</head>
<body>
<!--头部导航栏信息-->
<nav class="navbar navbar-inverse" id="header">
    <div class="container-fluid">
        <div class="navbar-header header-left left">
            <a class="navbar-brad" href="#">
                <span>人力资源系统</span>
            </a>
        </div>
        <div class="header-right right">
            <button onclick="jumpIframe('rest/welcome')">
                <span class="glyphicon glyphicon-home"></span>
            </button>
            <button onclick="location.href='<%=path %>/rest/logoutAction'">
                <span class="glyphicon glyphicon-user"></span>
            </button>
        </div>
    </div>
</nav>
<!--主体部分-->
<div class="container-fluid" id="section">
    <div class="side-left">
        <ul class="nav nav-pills nav-stacked">
            <li role="presentation">
            
				<shiro:hasPermission name="menu01">
                <a href="#ssztgl-menu" class="nav-header" data-toggle="collapse"><span class="glyphicon glyphicon-folder-open"></span><span>人事信息</span></a>
				</shiro:hasPermission>
                
                <ul id="ssztgl-menu" class="nav nav-list collapse in">
				
				<shiro:hasPermission name="department_show">
                    <li><a onclick="jumpIframe('department/show')"><span class="glyphicon glyphicon-menu-right"></span><span>部门信息</span></a></li>
				</shiro:hasPermission>
				
				<shiro:hasPermission name="jobpos_show">
                    <li><a onclick="jumpIframe('jobpos/show')"><span class="glyphicon glyphicon-menu-right"></span><span>职位信息</span></a></li>
				</shiro:hasPermission>
				
				<shiro:hasPermission name="employee_show">
                	<li><a onclick="jumpIframe('employee/show')"><span class="glyphicon glyphicon-menu-right"></span><span>用户信息</span></a></li>
				</shiro:hasPermission>
                	
				<shiro:hasPermission name="contract_show">
                    <li><a onclick="jumpIframe('contract/show')"><span class="glyphicon glyphicon-menu-right"></span><span>合同信息</span></a></li>
				</shiro:hasPermission>
				
                </ul>
            </li>
			<li role="presentation">
			
				<shiro:hasPermission name="menu02">
				<a href="#dsjfx-menu" class="nav-header" data-toggle="collapse"><span class="glyphicon glyphicon-menu-hamburger"></span>工作信息</a>
				</shiro:hasPermission>
				
                <ul id="dsjfx-menu" class="nav nav-list collapse in">
	                
	                <!-- <li><a href="#hzsml-menu" class="nav-header" data-toggle="collapse"><span class="glyphicon glyphicon-triangle-right"></span><span>业务流程部署</span></a></li>
	                <ul id="hzsml-menu" class="nav nav-list collapse in">
	                	<li><a onclick="jumpIframe('activiti_flow/activiti_flow_show')"><span class="glyphicon glyphicon-menu-right"></span><span>请假审批流程</span></a></li>
	                	<li><a onclick="jumpIframe('')"><span class="glyphicon glyphicon-menu-right"></span><span>调休审批流程</span></a></li>
	                	<li><a onclick="jumpIframe('')"><span class="glyphicon glyphicon-menu-right"></span><span>出差审批流程</span></a></li>
	                	<li><a onclick="jumpIframe('')"><span class="glyphicon glyphicon-menu-right"></span><span>工作审批流程</span></a></li>
	                </ul> -->
	                
				<shiro:hasPermission name="menu0201">
	                <li><a href="#hzsml-menu1" class="nav-header" data-toggle="collapse"><span class="glyphicon glyphicon-triangle-right"></span><span>考勤信息</span></a></li>
				</shiro:hasPermission>
				
	                <ul id="hzsml-menu1" class="nav nav-list collapse in">
	                
					<shiro:hasPermission name="attendance_show">
	                	<li><a onclick="jumpIframe('attendance/show')"><span class="glyphicon glyphicon-menu-right"></span><span>考勤数据</span></a></li>
					</shiro:hasPermission>
				
					<shiro:hasPermission name="attd_approve_info_show">
	                	<li><a onclick="jumpIframe('attd_approve_info/show')"><span class="glyphicon glyphicon-menu-right"></span><span>考勤审批</span></a></li>
					</shiro:hasPermission>
					
	                </ul>
	                
	                <!-- <li><a href="#hzsml-menu" class="nav-header" data-toggle="collapse"><span class="glyphicon glyphicon-triangle-right"></span><span>任务</span></a></li>
	                <ul id="hzsml-menu" class="nav nav-list collapse in">
	                	<li><a onclick="jumpIframe('jobs_manage/show')"><span class="glyphicon glyphicon-menu-right"></span><span>任务分配</span></a></li>
	                </ul> -->
	                
	                
				<shiro:hasPermission name="jobs_manage_show">
                    <li><a onclick="jumpIframe('jobs_manage/show')"><span class="glyphicon glyphicon-menu-right"></span><span>任务分配</span></a></li>
				</shiro:hasPermission>
					
                    
				<shiro:hasPermission name="menu0203">
	                <li><a href="#hzsml-menu2" class="nav-header" data-toggle="collapse"><span class="glyphicon glyphicon-triangle-right"></span><span>业务流程</span></a></li>
				</shiro:hasPermission>
				
	                <ul id="hzsml-menu2" class="nav nav-list collapse in">
	                
					<shiro:hasPermission name="activiti_flow_showTask">
	                	<li><a onclick="jumpIframe('activiti_flow/showTask')"><span class="glyphicon glyphicon-menu-right"></span><span>执行任务</span></a></li>
					</shiro:hasPermission>
	                	
					<shiro:hasPermission name="activiti_flow_show">
	                	<li><a onclick="jumpIframe('activiti_flow/show')"><span class="glyphicon glyphicon-menu-right"></span><span>流程部署</span></a></li>
					</shiro:hasPermission>
					
	                </ul>
	                
                </ul>
			</li>
			
			<!-- <li role="presentation">
				<a class="nav-header" onclick="jumpIframe('emp_friend/show')" target = "plc-iframe"><span class="glyphicon glyphicon-folder-open"></span>通讯</a>
			</li> -->
			
        </ul>
    </div>
    <div class="side-right" style="overflow:hidden;">
        <Iframe src="<%=path %>/rest/welcome" width="100%" height="99.5%" frameborder="0" id="plc-iframe" onload="iframeonload()"></Iframe>
        <%-- <Iframe src="<%=path %>/activiti_flow/showTask" width="100%" height="99.5%" frameborder="0" id="plc-iframe" onload="iframeonload()"></Iframe> --%>
    </div>

</div>
<script type="text/javaScript">
	//定义全局变量
	window.gloData = {};
	(function resize(){
		$("#section").height($("body").height() - 120);
	})();
	
	//判断页面有无权限方法
    function iframeonload() {
		var childiframe = document.frames ? document.frames["plc-iframe"].document
				: document.getElementById("plc-iframe").contentDocument;
		if (null != childiframe.getElementById("hiddenLoginPage")) {
			window.location.href = '<%=path %>/rest/login';
		}
	}
	
	//跳转到主页方法
    function jumpIframe(src){
    	$("#plc-iframe").attr('src','<%=path %>/'+src);
    }
    
	//主页提示操作成功或者失败方法
	function bcsPromptInfo(vals){
		var _html = '<div id="bcsAlert">';
			_html += '<div>'+vals+'!</div>';
			_html += '</div>';
		if($("#bcsAlert")){$("#bcsAlert").remove()};
		$("body").append(_html);
		setTimeout(function(){
			$("#bcsAlert").remove();
		},2000);
	}
    
</script>

</body>

</html>
