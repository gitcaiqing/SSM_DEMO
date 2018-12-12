<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>用户列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<%@ include file="/WEB-INF/common/common.jsp"%>
</head> 
<body>
<div class="page-container">
   <!--/content-inner-->
	<div class="left-content">
	   <div class="mother-grid-inner">
		<!-- 头部start -->
		<%@include file="/WEB-INF/common/header.jsp" %>
		<!-- 头部end -->

		<!-- 导航条start -->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="${base }/ssm/home">主页</a><i class="fa fa-angle-right"></i>用户列表</li>
		</ol>
		<!-- 导航条end -->

		<!-- 查询 -->
	    <div class="grid-form1">
			<form class="form-inline" id="myform">
			  <div class="form-group">
			    <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
			  </div>
			  <div class="form-group">
			    <input type="text" class="form-control" id="realname" name="realname" placeholder="真实姓名">
			  </div>
			  <button id="btn_search" onclick="onSearch()" type="button" class="btn btn-success" style="margin-left:10px;margin-right:10px;">
	          	<span class="fa fa-search" aria-hidden="true" class="btn-icon-space"></span> 查询
	          </button>
	          <button id="btn_add" onclick="onAdd()" type="button" class="btn btn-primary">
	          	<span class="fa fa-plus" aria-hidden="true" class="btn-icon-space"></span> 新增
	          </button>
			</form> 
		</div>

		<!-- 列表start -->
		<table id="table"></table>
		<!-- 列表end -->

		<!--copy rights start -->
		<%@include file="/WEB-INF/common/copyright.jsp" %>
		<!--copy rights end -->
	</div>
</div>

<!-- 菜单start -->
<%@include file="/WEB-INF/common/menu.jsp" %>
<!-- 菜单end -->
<div class="clearfix"></div></div>
 
<!--js -->
<script src="${base }/static/js/jquery.nicescroll.js"></script>
<script src="${base }/static/js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${base }/static/js/bootstrap.min.js"></script>
<!-- /Bootstrap Core JavaScript -->	   
<script type="text/javascript">
$(function(){
	initTable();
});

/**
 * 获取分页数据
 */
function initTable(){
	//根据url或分页数据，返回的格式如：
	<!-- 
	var data = {
		    "page": 1,
		    "rows": [
		        {"id":1,"username": "lisi","realname": "456","age": "12","utype": 0},
				{"id":2,"username": "lisi2","realname": "456","age": "12","utype": 1}
		    ],
		    "total": 2
		};
	-->
	$("#table").bootstrapTable({
		url:"${base}/ssm/basicUser/users",
		
		//请求方式get,修改tomcat编码格式为UTF-8,参数带中文可能出现乱码
		//<Connector connectionTimeout="20000" port="7079" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>
		method:"get",
		//请求方式post,解决了中文乱码，可能会接收不到参数，需要指定contentType:"application/x-www-form-urlencoded"
		//method: "post",
        //contentType:"application/x-www-form-urlencoded",
		
		datatype:"json",
		striped: true,//设置为 true 会有隔行变色效果
		pagination: true, //分页showToggle: "true",//是否显示 切换试图（table/card）按钮
        /* showColumns: "true",//是否显示 内容列下拉框 */
        pageNumber: 1,//如果设置了分页，首页页码
        // showPaginationSwitch:true,//是否显示 数据条数选择框
        pageSize: 5,//如果设置了分页，页面数据条数
        pageList: [5, 10, 20, 50,100],	//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
        paginationPreText: '<<',//指定分页条中上一页按钮的图标或文字,这里是<
        paginationNextText: '>>',//指定分页条中下一页按钮的图标或文字,这里是>
        // singleSelect: false,//设置True 将禁止多选
        search: false, //显示搜索框
        data_local: "zh-US",//表格汉化
        sidePagination: "server", //服务端处理分页
        sortable: true,//是否启用排序
        sortOrder: "desc",//排序方式
        queryParams: function (params) {//自定义查询参数和分页参数，传给后台
        	var temp = $("#myform").serializeJsonObject();
        	temp.start = params.offset;//从数据库第几条记录开始
        	temp.pageSize = params.limit;//从数据库第几条记录开始
        	temp.sort = params.sort;  //排序列名  
        	temp.order = params.order; //排位命令（desc，asc） 
            return temp;
        	 /* return {//这里的params是table提供的
             	start: params.offset,//从数据库第几条记录开始
                 pageSize: params.limit//找多少条
             }; */
        },
        idField: "id",//指定主键列
        columns: [
        	//表的列名,json数据中rows数组中的属性名,水平居中
        	{title: '序号',align: 'center',width: "10%",
        		formatter: function (value, row, index) {
                    //var options = $table.bootstrapTable('getOptions');
                    //return options.pageSize * (options.pageNumber - 1) + index + 1;
                    return index+1;
        		},
        		/* cellStyle:{
        			css:{"background-color":"red"}
        		} */
        	},
            {title: '用户名',field: 'username',align: 'center',width: "15%"},
            {title: '真实姓名',field: 'realname',align: 'center',width: "15%"},
            {title: '年龄',field: 'age',align: 'center',width: "15%"},
            {title: '用户类型',field: 'utype', align: 'center',width: "15%",
                formatter: function (value, row, index) {
                	//自定义显示，这三个参数分别是：value该行的属性，row该行记录，index该行下标
                    return row.utype == 0 ? "管理员" : "普通用户";
                }
            },
            {title: '操作',field: 'id',align: 'center',width: "30%",
                formatter: function (value, row, index) {
                    return [
                        '<button type="button" onclick="onDetail(\''+row.id+'\')" class="btn btn-info" style="margin-right:10px;"><span class="fa fa-eye" aria-hidden="true" class="btn-icon-space"></span> 详细</button>',
                        '<button type="button" onclick="onUpdate(\''+row.id+'\')" class="btn btn-warning" style="margin-right:10px;"><span class="fa fa-edit" aria-hidden="true" class="btn-icon-space"></span> 修改</button>',
                        '<button type="button" onclick="onDelete(\''+row.id+'\')" class="btn btn-danger" style="margin-right:10px;"><span class="fa fa-minus-circle" aria-hidden="true" class="btn-icon-space"></span> 删除</button>'
                        ].join('');
                }
            }
        ],
        onLoadSuccess: function () {
        	console.log("加载成功");
        },
        onLoadError: function () {
        	console.log("加载失败");
        },
    });
}
	
/**
 * 查询
 */
function onSearch(){
	$('#table').bootstrapTable('refreshOptions',{pageNumber:1,pageSize:5});
}
//自定义函数处理queryParams的批量增加
$.fn.serializeJsonObject = function () {
    var json = {};
    var form = this.serializeArray();
    $.each(form, function () {
        if (json[this.name]) {
            if (!json[this.name].push) {
                json[this.name] = [json[this.name]];
            }
            json[this.name].push();
        } else {
            json[this.name] = this.value || '';
        }
    });
    return json;
}

</script>
</body>
</html>