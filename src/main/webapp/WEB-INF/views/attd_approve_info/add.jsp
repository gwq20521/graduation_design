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
	
	<script type="text/javascript">
		var approveType = '${approve_type}';
	</script>
	
</head>
   
<body>
<div class="container-fluid GL-hzs">
	<!--头部内容-->
    <div class="header">
        <ol class="breadcrumb">
            <li><a>首页</a></li>
            <li>></li>
            <li>工作管理</li>
            <li>></li>
            <li class="active">考勤审批申请</li>
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
                    <span class="col-xs-3 glyphicon">* 天数：
                    </span>
                    <div class="col-xs-9 pad-0 row">
                        <input type="text" class="col-xs-12 GL-add-require" id="approveDays" value="">
                    </div>
                </div>
				<div class="col-xs-6 row ie-col-6">
                    <span class="col-xs-3 glyphicon">* 原因：
                    </span>
                    <div class="col-xs-9 pad-0 row">
                        <input type="text" class="col-xs-12 GL-add-require" id="approveContent" value="">
                    </div>
                </div>
				<div class="col-xs-6 row ie-col-6">
                    <span class="col-xs-3 glyphicon">* 备注：
                    </span>
                    <div class="col-xs-9 pad-0 row">
                        <input type="text" class="col-xs-12 GL-add-require" id="approveRemark" value="">
                    </div>
                </div>
                
				<!-- <div class="col-xs-6 row ie-col-6">
                    <span class="col-xs-3 glyphicon">* 审批事件类型 1-请假申请 2-调休申请 3-出差申请：
                    </span>
                    <div class="col-xs-9 pad-0 row">
                        <input type="text" class="col-xs-12 GL-add-require" id="approveType" value="">
                    </div>
                </div> -->
                
				<div class="col-xs-6 row ie-col-6">
                    <span class="col-xs-3 glyphicon">* 开始日期：
                    </span>
                    <div class="col-xs-9 pad-0 row">
                        <input type="text" class="col-xs-12 GL-add-require" id="approveTimeStart" value="">
                    </div>
                </div>
				<div class="col-xs-6 row ie-col-6">
                    <span class="col-xs-3 glyphicon">* 结束日期：
                    </span>
                    <div class="col-xs-9 pad-0 row">
                        <input type="text" class="col-xs-12 GL-add-require" id="approveTimeEnd" value="">
                    </div>
                </div>
        	 	
                
        	 </div>
        </div>
	
	</div>
</div>
</body>

<script type="text/javascript">

//执行一个laydate实例
laydate.render({
	elem: '#approveTimeStart' //指定元素
	,type: 'datetime'
});

laydate.render({
	elem: '#approveTimeEnd' //指定元素
	,type: 'datetime'
});

var attd_approve_infoParam = {};
	attd_approve_infoParam.approveDays;
	attd_approve_infoParam.approveContent;
	attd_approve_infoParam.approveRemark;
	attd_approve_infoParam.approveType;
	attd_approve_infoParam.approveTimeStart;
	attd_approve_infoParam.approveTimeEnd;

	$("#save").click(function(){
		var param = JSON.parse(JSON.stringify(attd_approve_infoParam));
		
					param.approveDays=$("#approveDays").val();
					param.approveContent=$("#approveContent").val();
					param.approveRemark=$("#approveRemark").val();
					param.approveType=approveType;
					param.approveTimeStart=$("#approveTimeStart").val();
					param.approveTimeEnd=$("#approveTimeEnd").val();
				
					//alert(JSON.stringify(param));
					
	    $.ajax({url:'<%=path %>/attd_approve_info/insert',
       		type:'post',
       		cache:false,
       		dataType:'json',
       		data: {jsonParam:JSON.stringify(param)},
       		//contentType: "application/json;charset=UTF-8",
           	success:function(data){
           		if(data.code == "OK"){
           			layer.msg("数据保存成功",{icon:1,time:1500},function(){
           				window.location.href= "<%=path %>/attd_approve_info/show";
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
		window.location.href= "<%=path %>/attd_approve_info/show";
	});

</script>
</html>