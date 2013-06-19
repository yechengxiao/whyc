<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><decorator:title default="whyc" /></title>
<decorator:head />
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="decorator/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/js/util.js"></script>	
</head>
<body>
	<div id="wrapper">
		<div id="header-wrapper">
			<div id="header">
				<div id="logo">
					<h1>文化遗产监测预警系统</h1>
				</div>
			</div>
		</div>
		<!-- end #header -->
		<div id="menu">
			<ul>
				<li><a href="homepage.action">首页</a></li>
				<li><a href="viewAllWCons.action">预警指标</a></li>
				<li><a href="viewAllIndis.action">监测指标</a></li>
				<li><a href="viewAvailWorks.action">任务处置</a></li>
				<li><a href="viewAvailWtodos.action">预警处置</a></li>
				<li><a href="viewHisWtd.action">历史预警记录</a></li>
				<li><a href="viewAvailWstodos.action">事件管理</a></li>
				<li><a href="logout.action">退出</a>
				</li>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="page">
			<div id="page-bgtop">
				<div id="page-bgbtm">
					<div id="content">
						<div class="post">
							<h1 class="title">
								<a href="#">欢迎使用</a>
							</h1>
							<p class="meta">
								&bull;&nbsp;Posted by <a href="#">yechengxiao</a> on April 24, 2013
								&nbsp;
							</p>
							<div class="entry">
								<decorator:body />
							</div>
						</div>
						<div style="clear: both;">&nbsp;</div>
					</div>
					<!-- end #content -->
					<div id="sidebar">
					<div id="search">
						<form name="formDeco" method="post"  action="">
							<fieldset>
							<input type="text" name="s" id="search-text" size="15" value="搜索" />
							<button id="search-submit"  class="links">GO</button>
							</fieldset>
						</form>
					</div>
					<div id="sidecontent">
						<ul>
							<li>
								<h2>友情链接：</h2>
								<ul>
									<li><a href="http://www.zjut.edu.cn">浙江工业大学</a></li>
									<li><a href="http://www.software.zjut.edu.cn/">浙工大
											计算机科学与技术学院</a></li>
									<li><a
										href="https://plus.google.com/117134075686861601945/posts">找到我</a>
									</li>
								</ul>
							</li>
							<li>
								<h2>感谢：</h2>
								<p>浙江工业大学</p>
							</li>
						</ul>
						</div>
					</div>
					<!-- end #sidebar -->
					<div style="clear: both;">&nbsp;</div>
				</div>
			</div>
		</div>
		<!-- end #page -->
	</div>
	<div id="footer-wrapper">
		<div id="footer">
			<p>
				Copyright (c) 2013 YeChengxiao. All rights reserved. Search by <a
					href="http://www.google.com/">Google</a>.
			</p>
		</div>
		<!-- end #footer -->
	</div>
</body>
</html>
