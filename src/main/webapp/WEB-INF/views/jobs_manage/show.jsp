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
    <title>公司OA系统</title>
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
    
	<style type="text/css">
		span.glyphicon{
			height:30px;
			line-height:30px;
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
            <li>****管理</li>
            <li>></li>
            <li class="active">***管理</li>
        </ol>
    </div>
    <!--过滤条件-->
    <div class="filter panel panel-default">
        <div class="panel-heading">
            <span class="glyphicon glyphicon-search"></span>
            <span>过滤条件</span>
        </div>
        <div class="panel-body pad-tb-25">
            <span>***：</span>
	        <input type="text" placeholder="请输入***" id="searchSelect">
	        <button class="chaxun-bottom" id="jobs_manage_chaxun">查询</button>
        </div>
        
        <div class="panel panel-default">
        	<div class="panel-heading">
            <span class="iconstate left bg-filter"></span>
            <span class="left bg-filter">***数据表</span>
			<shiro:hasPermission name="jobs_manage_insert">
            <button class="tianjia-button right bg-filter" id="jobs_manage_plus"><span class="glyphicon glyphicon-plus"></span> 添加</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="jobs_manage_update">
			<button class="tianjia-button right bg-filter" id="jobs_manage_edit"><span class="glyphicon glyphicon-edit"></span> 修改</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="jobs_manage_delete">
			<button class="tianjia-button right bg-filter" id="jobs_manage_remove"><span class="glyphicon glyphicon-remove"></span> 删除</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="jobs_manage_export">
			<button class="tianjia-button right bg-filter" id="jobs_manage_file"><span class="glyphicon glyphicon-file"></span> 导出</button>
			</shiro:hasPermission>
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
	var jobs_manageParam = {};
	jobs_manageParam.id;
	jobs_manageParam.createUserId;
	jobs_manageParam.workUserId;
	jobs_manageParam.jobInfo;
	jobs_manageParam.jobState;
	jobs_manageParam.createTime;
	jobs_manageParam.updateTime;
	jobs_manageParam.jobWorkInfo;

	$(function(){
		var GridParam = JSON.parse(JSON.stringify(jobs_manageParam));
		$("#GRIDTABLE").jqGrid({
            //caption:'权限管理',
            url: '<%=path %>/jobs_manage/select',
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
            //multiselect: true,//定义多选选择框
            //multiboxonly : true,//单选框
            colNames: [
				"",
			"创建领导",
			"指定分配员工",
			"工作描述",
			"工作状态 0-新建 1-进行中 2-已解决 3-已关闭 4-已驳回",
			"创建时间",
			"修改时间",
			"工作具体小结"
			],
            colModel: [
				{name: "id", index: "id", sortable: false, width: 60, align: "center", hidden:true},
			{name: "createUserId", index: "createUserId", sortable: false, width: 60, align: "center"},
			{name: "workUserId", index: "workUserId", sortable: false, width: 60, align: "center"},
			{name: "jobInfo", index: "jobInfo", sortable: false, width: 60, align: "center"},
			{name: "jobState", index: "jobState", sortable: false, width: 60, align: "center"},
			{name: "createTime", index: "createTime", sortable: false, width: 60, align: "center"},
			{name: "updateTime", index: "updateTime", sortable: false, width: 60, align: "center"},
			{name: "jobWorkInfo", index: "jobWorkInfo", sortable: false, width: 60, align: "center"}
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
	
	var searchGridParam = JSON.stringify(jobs_manageParam);
	
    //查询
	$("#jobs_manage_chaxun").click(function(){
		var param = JSON.parse(searchGridParam);
		
		//为param 赋值
		var GridParam = JSON.stringify(param);
		searchFun(GridParam);
	});

	function searchFun(GridParam){
		$("#GRIDTABLE").jqGrid("setGridParam",{
			url:"<%=path %>/jobs_manage/select",
			postData:{GridParam:GridParam},
			page:1
		}).trigger("reloadGrid");
	}

    //新增
	$("#jobs_manage_plus").click(function(){
		window.location.href= "<%=path %>/jobs_manage/add";
	});
    
    //修改 - 判定只能修改一条数据
	$("#jobs_manage_edit").click(function(){
		var ids = $("#GRIDTABLE").jqGrid("getGridParam","selarrrow");
		if(ids.length == 0){
			alert("先选择一条数据");
			return;
		} else if(ids.length > 1){
			alert("请您只选择一条需要修改的数据");
			return;
		} else {
			if (confirm("确认修改当前选中数据的信息吗？")) {
				//暂时不涉及经纬度的信息加载 - 暂不涉及相关网格码的修改
				window.location.href= "<%=path %>/jobs_manage/edit?id="+ids;
			}
		}
	});
    
    /*
    删除 - 支持批量选中的删除 - 支持联动删除别的表中的数据
    */
    $("#jobs_manage_remove").click(function(){
		var ids = $("#GRIDTABLE").jqGrid("getGridParam","selarrrow");
		if(ids == ""){
			alert("先选择一条数据");
			return;
		} else {
			if (confirm("确认删除当前选中数据吗？")) {
				$.ajax({url:'<%=path %>/jobs_manage/deleteBatch',
		       		type:'post',
		       		cache:false,
		       		dataType:'json',
		       		data:{
		       			ids:ids+""
		       		},
		           	success:function(data){
		           		if(data.code == "OK"){
		           			alert("数据删除成功");
		           			window.location.reload();
		           		} else {
		           			alert(data.msg);
		           		}
		           	}, 
		           	error : function() {
		           		alert("异常！");
		           	}
		        });
			}
		}
	});
    
    //导入
    $("#jobs_manage_import").click(function(){
		alert("jobs_manage_import");
	});
    
    //导出
    $("#cjobs_manage_export").click(function(){
    	var ids = $("#GRIDTABLE").jqGrid("getGridParam","selarrrow");
		if(ids.length == 0){
			if (confirm("确认导出当前表中的全部数据吗？")) {
				window.location.href= "<%=path %>/jobs_manage/export?page=1&rows=5&json={}";
			}
		} else if(ids.length > 0){
			if (confirm("确认导出当前选中数据吗？")) {
				window.location.href= "<%=path %>/jobs_manage/export?page=1&rows=5&json={}";
			}
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