<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

	<div class="menu">
		
	
		<ul id="menu" >
			<!-- 普通用户列表 -->
			<li><a href="${base }/ssm/basicUser/listPage"><i class="fa fa-table"></i>  <span>用户列表</span><div class="clearfix"></div></a></li>
		
		
			<li><a href="index.html"><i class="fa fa-tachometer"></i> <span>Dashboard</span><div class="clearfix"></div></a></li>
			 <li id="menu-academico" ><a href="inbox.html"><i class="fa fa-envelope nav_icon"></i><span>Inbox</span><div class="clearfix"></div></a></li>
		<li><a href="gallery.html"><i class="fa fa-picture-o" aria-hidden="true"></i><span>Gallery</span><div class="clearfix"></div></a></li>
		<li id="menu-academico" ><a href="charts.html"><i class="fa fa-bar-chart"></i><span>Charts</span><div class="clearfix"></div></a></li>
		 <li id="menu-academico" ><a href="#"><i class="fa fa-list-ul" aria-hidden="true"></i><span> Short Codes</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
			   <ul id="menu-academico-sub" >
			   <li id="menu-academico-avaliacoes" ><a href="icons.html">Icons</a></li>
				<li id="menu-academico-avaliacoes" ><a href="typography.html">Typography</a></li>
				<li id="menu-academico-avaliacoes" ><a href="faq.html">Faq</a></li>
			  </ul>
			</li>
		<li id="menu-academico" ><a href="errorpage.html"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i><span>Error Page</span><div class="clearfix"></div></a></li>
		  <li id="menu-academico" ><a href="#"><i class="fa fa-cogs" aria-hidden="true"></i><span> UI Components</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
			   <ul id="menu-academico-sub" >
			   <li id="menu-academico-avaliacoes" ><a href="button.html">Buttons</a></li>
				<li id="menu-academico-avaliacoes" ><a href="grid.html">Grids</a></li>
			  </ul>
			</li>
		 <li><a href="tabels.html"><i class="fa fa-table"></i>  <span>Tables</span><div class="clearfix"></div></a></li>
		<li><a href="maps.html"><i class="fa fa-map-marker" aria-hidden="true"></i>  <span>Maps</span><div class="clearfix"></div></a></li>
	       <li id="menu-academico" ><a href="#"><i class="fa fa-file-text-o"></i>  <span>Pages</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
			 <ul id="menu-academico-sub" >
				<li id="menu-academico-boletim" ><a href="calendar.html">Calendar</a></li>
				<li id="menu-academico-avaliacoes" ><a href="signin.html">Sign In</a></li>
				<li id="menu-academico-avaliacoes" ><a href="signup.html">Sign Up</a></li>
				
	
			  </ul>
		</li>
		<li><a href="#"><i class="fa fa-check-square-o nav_icon"></i><span>Forms</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
		  	<ul>
				<li><a href="input.html"> Input</a></li>
				<li><a href="validation.html">Validation</a></li>
			</ul>
		</li>
	  </ul>
	</div>
	
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