<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>公司OA系统</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<%=path %>/assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path %>/assets/css/iframe.css">
    <link rel="stylesheet" href="<%=path %>/assets/css/pagination.css">
    
    <link rel="stylesheet" href="<%=path %>/assets/css/common.css">
    
    <script type="text/javascript" src="<%=path %>/assets/js/jquery/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="<%=path %>/assets/js/jquery/jquery.pagination.js"></script>
    <script type="text/javascript" src="<%=path %>/assets/js/bootstrap/bootstrap.min.js"></script>
	
    <script type="text/javascript" src="<%=path %>/assets/js/layer/laydate.js"></script>
	
    <script src="<%=path %>/assets/js/layer/layer.js"></script>
   	
    <style type="text/css">
		.amap-sug-result{
			z-index:100000;
		}
		
		#fieldHidden{
			display: none;
		}
	</style>
	
</head>
   
<body>
<div class="container-fluid GL-hzs">
	<!--头部内容-->
    <div class="header">
        <ol class="breadcrumb">
            <li><a>首页</a></li>
            <li>></li>
            <li><a>***</a></li>
            <li>></li>
            <li><a>***</a></li>
            <li>></li>
            <li class="active">**新增</li>
        </ol>
    </div>
    <!--提示必填项部分-->
	<div class="filter panel panel-default">
		<div class="panel-heading" style="border-bottom:0px;">
			<span>温馨提示：带*的为必填部分，请核对完成后点击保存</span>
			
	<span type = "button" id ="save" class="save">保存</span>
	<span type = "button" id= "back" class="back">返回</span>
	
		</div>
	</div>
	
	<div class="filter panel panel-default">
		<div class="panel-heading">
            <span>基础信息</span>
            <div class="GL-danger-info" id="GLDangerInfo">
				
            </div>
        </div>
        <div class="panel-body pad-tb-25" id="jcxx">
        	 <div class="row">
				<div class="col-xs-6 row ie-col-6">
                    <span class="col-xs-3 glyphicon">* 主键：
                    </span>
                    <div class="col-xs-9 pad-0 row">
                        <input type="text" class="col-xs-12 GL-add-require" id="id" value="">
                    </div>
                </div>
				<div class="col-xs-6 row ie-col-6">
                    <span class="col-xs-3 glyphicon">* 用户关系表述1：
                    </span>
                    <div class="col-xs-9 pad-0 row">
                        <input type="text" class="col-xs-12 GL-add-require" id="empId1" value="">
                    </div>
                </div>
				<div class="col-xs-6 row ie-col-6">
                    <span class="col-xs-3 glyphicon">* 用户关系表述2：
                    </span>
                    <div class="col-xs-9 pad-0 row">
                        <input type="text" class="col-xs-12 GL-add-require" id="empId2" value="">
                    </div>
                </div>
				<div class="col-xs-6 row ie-col-6">
                    <span class="col-xs-3 glyphicon">* 关系状态 0-正常 1-屏蔽：
                    </span>
                    <div class="col-xs-9 pad-0 row">
                        <input type="text" class="col-xs-12 GL-add-require" id="friState" value="">
                    </div>
                </div>
				<div class="col-xs-6 row ie-col-6">
                    <span class="col-xs-3 glyphicon">* 创建时间：
                    </span>
                    <div class="col-xs-9 pad-0 row">
                        <input type="text" class="col-xs-12 GL-add-require" id="createTime" value="">
                    </div>
                </div>
				<div class="col-xs-6 row ie-col-6">
                    <span class="col-xs-3 glyphicon">* 修改时间：
                    </span>
                    <div class="col-xs-9 pad-0 row">
                        <input type="text" class="col-xs-12 GL-add-require" id="updateTime" value="">
                    </div>
                </div>
        	 	
                
        	 </div>
        </div>
	
	</div>
</div>
</body>

<script type="text/javascript">

var emp_friendParam = {};
	emp_friendParam.id;
	emp_friendParam.empId1;
	emp_friendParam.empId2;
	emp_friendParam.friState;
	emp_friendParam.createTime;
	emp_friendParam.updateTime;

	$("#save").click(function(){
		var param = JSON.parse(JSON.stringify(emp_friendParam));
		
					param.id=$("#id").val();
					param.empId1=$("#empId1").val();
					param.empId2=$("#empId2").val();
					param.friState=$("#friState").val();
					param.createTime=$("#createTime").val();
					param.updateTime=$("#updateTime").val();
				
	    $.ajax({url:'<%=path %>/emp_friend/insert',
       		type:'post',
       		cache:false,
       		dataType:'json',
       		data: JSON.stringify(param),
       		contentType: "application/json;charset=UTF-8",
           	success:function(data){
           		if(data.code == "OK"){
           			layer.msg("数据保存成功",{icon:1,time:1500},function(){
                   		window.location.href= "<%=path %>/emp_friend/show";
           			});
           		} else {
           			layer.msg(data.msg,{icon:2,time:3000});
           		}
           	},
           	error : function() {
           		layer.msg("异常！",{icon:2,time:3000});
           	}
       });
	});
	
	$("#back").click(function(){
		window.location.href= "<%=path %>/emp_friend/show";
	});

</script>
</html>