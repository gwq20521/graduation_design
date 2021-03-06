<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>人力资源管理系统</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
	
    <link rel="stylesheet" href="<%=path %>/assets/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="<%=path %>/assets/css/iframe.css">
	
    <link rel="stylesheet" href="<%=path %>/assets/css/ui.jqgrid.css">
	
    <script type="text/javascript" src="<%=path %>/assets/js/jquery/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="<%=path %>/assets/js/jquery/grid.locale-cn.js"></script>
    <script type="text/javascript" src="<%=path %>/assets/js/jquery/jquery.jqGrid.min.js"></script>
    <script type="text/javascript" src="<%=path %>/assets/js/bootstrap/bootstrap.min.js"></script>

    <script src="<%=path %>/assets/js/user_common.js"></script>
    
    <script type="text/javascript" src="<%=path %>/assets/js/layer/laydate.js"></script>
	
    <script src="<%=path %>/assets/js/layer/layer.js"></script>
   	
	<style type="text/css">
		span.glyphicon{
			height:30px;
			line-height:30px;
		}
		
		#attendance_add{
			margin-left: 100px;
		}
	</style>
	
</head>

<body>
<div class="container-fluid GL-hzs">
    <!--头部内容-->
    <div class="header">
        <ol class="breadcrumb">
            <li>工作管理</li>
            <li>></li>
            <li class="active">考勤数据统计</li>
	        <button class="chaxun-bottom" id="attendance_onDuty">签到【早9点上班】</button>
	        <button class="chaxun-bottom" id="attendance_offDuty">下班【晚6点下班】</button>
	        <button class="chaxun-bottom" id="attendance_add">补卡</button>
        </ol>
    </div>
    <!--过滤条件-->
    <div class="filter panel panel-default">
        <div class="panel-heading">
            <span class="glyphicon glyphicon-search"></span>
            <span>过滤条件</span>
        </div>
        <div class="panel-body pad-tb-25">
            <span>用户名：</span>
	        <input type="text" placeholder="请输入用户名" id="searchSelectRealname">
            <span>考勤日期：</span>
	        <input type="text" placeholder="请输入日期" id="searchSelectCreateTime">
	        <button class="chaxun-bottom" id="attendance_chaxun">查询</button>
        </div>
        
        <div class="panel panel-default">
        	<div class="panel-heading">
            <span class="iconstate left bg-filter"></span>
            <span class="left bg-filter">考勤数据统计</span>
            
            <!-- <button class="tianjia-button right bg-filter" id="attendance_plus"><span class="glyphicon glyphicon-plus"></span>添加</button> -->
            
			<button class="tianjia-button right bg-filter" id="attendance_edit"><span class="glyphicon glyphicon-edit"></span> 修改</button>
			<button class="tianjia-button right bg-filter" id="attendance_remove"><span class="glyphicon glyphicon-remove"></span> 删除</button>
			
        	</div>
        </div>
        <div class="panel-body">
            <table id="GRIDTABLE" style="border-collapse: collapse"></table>
            <div id="GRIDPAGE"></div>
        </div>
    </div>
</div>   
</body>

<script type="text/javascript">

//执行一个laydate实例
laydate.render({
	elem: '#searchSelectCreateTime' //指定元素
});

	var attendanceParam = {};
	attendanceParam.id;
	attendanceParam.empId;
	attendanceParam.attdState;
	attendanceParam.createTime;

	$(function(){
		var GridParam = JSON.parse(JSON.stringify(attendanceParam));
		$("#GRIDTABLE").jqGrid({
            //caption:'权限管理',
            url: '<%=path %>/attendance/selectRelationData',
            styleUI: 'Bootstrap',//设置jqgrid的全局样式为bootstrap样式
            datatype: "json", //数据类型
            mtype: "post",//提交方式
            postData: {GridParam: JSON.stringify(GridParam)},
            //width: $(".jqGrid_wrapper").css("width"),
            autowidth: true,//自动宽
            //shrinkToFit: true,
            height: '70%',//高度，表格高度。可为数值、百分比或'auto'
            sortorder: 'asc',
            viewrecords: true,//是否在浏览导航栏显示记录总数
            altRows: true,//设置为交替行表格,默认为false
            //rownumbers : true,//是否显示行号
            //rownumWidth : '80px', //设置行号的宽度
            multiselect: true,//定义多选选择框
            multiboxonly : true,//单选框
            colNames: [
				"",
			"所属员工",
			"考勤状态",
			"考核日期"
			],
            colModel: [
				{name: "id", index: "id", sortable: false, width: 60, align: "center", hidden:true},
			{name: "realname", index: "realname", sortable: false, width: 60, align: "center"},
			{name: "attd_state", index: "attd_state", sortable: false, width: 60, align: "center",formatter:function(value,options,rowData){
				var attdStateStr = "";
				switch(value){  //1 缺勤(全天旷工) - 2 半天旷工 - 3 正常上班 - 4 正常下班 - 5 迟到 - 6 早退 - 7 请假 - 8 调休 - 9 出差
				    case 0:attdStateStr = "未知状态";break;  
				    case 1:attdStateStr = "缺勤";break;  
				    case 2:attdStateStr = "旷工半天";break;  
				    case 3:attdStateStr = "正常上班";break;
				    case 4:attdStateStr = "正常下班";break;
				    case 5:attdStateStr = "迟到";break;
				    case 6:attdStateStr = "早退";break;
				    case 7:attdStateStr = "请假";break;
				    case 8:attdStateStr = "调休";break;
				    case 9:attdStateStr = "出差";break;
				    
				    //早退 - ……
				    
				}
				return attdStateStr;
			}},
			{name: "create_time", index: "create_time", sortable: false, width: 60, align: "center",formatter:function(value,options,rowData){
				return getFormatDate(value);
			}}
            ],
            rowNum:15, 
    		rowList:[15,30,50], 
    		//loadonce: true, 
    		jsonReader : {  
    			root:"root", //结果集
    			page: "page", //第几页
    			total: "total", //总页数
    			records: "records", //数据总数
    			repeatitems: false
    			},
            pager: "#GRIDPAGE"
        });
        $("#GRIDPAGE").css("height", "45px");
	});
	
	var searchGridParam = JSON.stringify(attendanceParam);
	
    //查询
	$("#attendance_chaxun").click(function(){
		var param = JSON.parse(searchGridParam);

		var empRealname = $("#searchSelectRealname").val();

		var selectCreateTime = $("#searchSelectCreateTime").val();
		param.createTime = selectCreateTime+ " 00:00:00";
		
		//为param 赋值
		var GridParam = JSON.stringify(param);
		searchFun(GridParam, empRealname);
	});

	function searchFun(GridParam, empRealname){
		$("#GRIDTABLE").jqGrid("setGridParam",{
			url:"<%=path %>/attendance/selectRelationDataByEmpRealname",
			postData:{GridParam:GridParam, empRealname:empRealname},
			page:1
		}).trigger("reloadGrid");
	}

    //签到【早9点上班】
	$("#attendance_onDuty").click(function(){
	    $.ajax({url:'<%=path %>/attendance/insertByOnDuty',
       		type:'post',
       		cache:false,
       		contentType: "application/json;charset=UTF-8",
           	success:function(data){
           		if(data.code == "OK"){
           			layer.msg("打卡成功",{icon:1,time:1500},function(){
           				window.location.href= "<%=path %>/attendance/show";
           			});
           		} else {
           			layer.msg(data.msg,{icon:2,time:3000});
           		}
           	},
           	error : function() {
           		layer.msg("打卡异常！",{icon:2,time:3000});
           	}
       });
	});

    //下班【晚6点下班】
	$("#attendance_offDuty").click(function(){
	    $.ajax({url:'<%=path %>/attendance/insertByOffDuty',
       		type:'post',
       		cache:false,
       		contentType: "application/json;charset=UTF-8",
           	success:function(data){
           		if(data.code == "OK"){
           			layer.msg("打卡成功",{icon:1,time:1500},function(){
           				window.location.href= "<%=path %>/attendance/show";
           			});
           		} else {
           			layer.msg(data.msg,{icon:2,time:3000});
           		}
           	},
           	error : function() {
           		layer.msg("打卡异常！",{icon:2,time:3000});
           	}
       });
	});

    //补卡 - 新增
	$("#attendance_add").click(function(){
		window.location.href= "<%=path %>/attendance/add";
	});
    
    //修改 - 判定只能修改一条数据
	$("#attendance_edit").click(function(){
		var ids = $("#GRIDTABLE").jqGrid("getGridParam","selarrrow");
		if(ids.length == 0){
			layer.msg("先选择一条数据",{icon:0,time:3000});
			return;
		} else if(ids.length > 1){
			layer.msg("请您只选择一条需要修改的数据",{icon:0,time:3000});
			return;
		} else {
			layer.confirm('确认修改当前选中数据的信息吗？',{
				title : '确认修改',
				icon:3,
				btn:['是','否'],
			}, function(index) {
				layer.close(index);
				window.location.href= "<%=path %>/attendance/edit?id="+ids;
			}, function(index) {
				layer.close(index);
			});
		}
	});
    
    /*
    删除 - 支持批量选中的删除 - 支持联动删除别的表中的数据
    */
    $("#attendance_remove").click(function(){
		var ids = $("#GRIDTABLE").jqGrid("getGridParam","selarrrow");
		if(ids == ""){
			layer.msg("先选择一条数据",{icon:0,time:3000});
			return;
		} else {
			layer.confirm('确认删除当前选中数据吗？',{
				title : '确认删除',
				icon:3,
				btn:['是','否'],
			}, function(index) {
				layer.close(index);
				$.ajax({url:'<%=path %>/attendance/deleteBatch',
		       		type:'post',
		       		cache:false,
		       		dataType:'json',
		       		data:{
		       			ids:ids+""
		       		},
		           	success:function(data){
		           		if(data.code == "OK"){
		           			layer.msg("数据删除成功",{icon:1,time:1500},function(){
		           				window.location.reload();
		           			});
		           		} else {
		           			layer.msg(data.msg,{icon:2,time:3000});
		           		}
		           	}, 
		           	error : function() {
		           		layer.msg("异常！",{icon:2,time:3000});
		           	}
		        });
			}, function(index) {
				layer.close(index);
			});
		}
	});
    
    //表格自适应屏幕
    $(function(){
    	$(window).resize(function(){
    		$('#GRIDTABLE').setGridWidth($(window).width()*0.9);
    		$('#GRIDTABLE').setGridWidth(document.body.clientWidth*0.9);
    		$("GRIDTABLE").setGridHeight($(window).height()*0.9);
    		$("GRIDTABLE").setGridHeight($(window).height()*0.9);
    	})
    });
    
</script>
</html>