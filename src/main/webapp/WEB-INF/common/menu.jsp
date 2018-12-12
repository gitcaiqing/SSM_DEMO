<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<!--//content-inner-->
<!--/sidebar-menu-->
<div class="sidebar-menu">
	<!-- logo start  -->
	<header class="logo1">
		<a href="${base }/ssm/home" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> 
	</header>
	<div style="border-top:1px ridge rgba(255, 255, 255, 0.15)"></div>

	<!-- 菜单start -->
	<div class="menu">
		<ul id="menu" >
			<!-- 用户列表 -->
			<li><a href="${base }/ssm/basicUser/listPage"><i class="fa fa-table"></i><span>用户列表</span><div class="clearfix"></div></a></li>
	  	</ul>
	</div>
	<!-- 菜单end -->
</div>
<script>
var toggle = true;
$(".sidebar-icon").click(function() {                
  if (toggle){
	$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
	$("#menu span").css({"position":"absolute"});
  }else
  {
	$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
	setTimeout(function() {
	  $("#menu span").css({"position":"relative"});
	}, 400);
  }
  toggle = !toggle;
});
</script>
</body>
</html>