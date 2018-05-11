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
    
    <script src="<%=path %>/assets/js/layer/layer.js"></script>
   	
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
	        <button class="chaxun-bottom" id="emp_friend_info_chaxun">查询</button>
        </div>
        
        <div class="panel panel-default">
        	<div class="panel-heading">
            <span class="iconstate left bg-filter"></span>
            <span class="left bg-filter">***数据表</span>
			<shiro:hasPermission name="emp_friend_info_insert">
            <button class="tianjia-button right bg-filter" id="emp_friend_info_plus"><span class="glyphicon glyphicon-plus"></span> 添加</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="emp_friend_info_update">
			<button class="tianjia-button right bg-filter" id="emp_friend_info_edit"><span class="glyphicon glyphicon-edit"></span> 修改</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="emp_friend_info_delete">
			<button class="tianjia-button right bg-filter" id="emp_friend_info_remove"><span class="glyphicon glyphicon-remove"></span> 删除</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="emp_friend_info_export">
			<button class="tianjia-button right bg-filter" id="emp_friend_info_file"><span class="glyphicon glyphicon-file"></span> 导出</button>
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
	var emp_friend_infoParam = {};
	emp_friend_infoParam.id;
	emp_friend_infoParam.empFriId;
	emp_friend_infoParam.empId;
	emp_friend_infoParam.chatInfo;
	emp_friend_infoParam.createTime;

	$(function(){
		var GridParam = JSON.parse(JSON.stringify(emp_friend_infoParam));
		$("#GRIDTABLE").jqGrid({
            //caption:'权限管理',
            url: '<%=path %>/emp_friend_info/select',
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
			"关联交互身份信息主键",
			"聊天记录的发送者",
			"聊天内容 - 不能为空",
			"聊天记录生成时间"
			],
            colModel: [
				{name: "id", index: "id", sortable: false, width: 60, align: "center", hidden:true},
			{name: "empFriId", index: "empFriId", sortable: false, width: 60, align: "center"},
			{name: "empId", index: "empId", sortable: false, width: 60, align: "center"},
			{name: "chatInfo", index: "chatInfo", sortable: false, width: 60, align: "center"},
			{name: "createTime", index: "createTime", sortable: false, width: 60, align: "center"}
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
	
	var searchGridParam = JSON.stringify(emp_friend_infoParam);
	
    //查询
	$("#emp_friend_info_chaxun").click(function(){
		var param = JSON.parse(searchGridParam);
		
		//为param 赋值
		var GridParam = JSON.stringify(param);
		searchFun(GridParam);
	});

	function searchFun(GridParam){
		$("#GRIDTABLE").jqGrid("setGridParam",{
			url:"<%=path %>/emp_friend_info/select",
			postData:{GridParam:GridParam},
			page:1
		}).trigger("reloadGrid");
	}

    //新增
	$("#emp_friend_info_plus").click(function(){
		window.location.href= "<%=path %>/emp_friend_info/add";
	});
    
    //修改 - 判定只能修改一条数据
	$("#emp_friend_info_edit").click(function(){
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
				
				//暂时不涉及经纬度的信息加载 - 暂不涉及相关网格码的修改
				window.location.href= "<%=path %>/emp_friend_info/edit?id="+ids;
			}, function(index) {
				layer.close(index);
			});
		}
	});
    
    /*
    删除 - 支持批量选中的删除 - 支持联动删除别的表中的数据
    */
    $("#emp_friend_info_remove").click(function(){
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
				
				$.ajax({url:'<%=path %>/emp_friend_info/deleteBatch',
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