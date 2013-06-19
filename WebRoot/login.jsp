<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<script type="text/javascript" src="js/util.js"></script>
</head>

<body>
	<center>
		<h3>请输入用户名和密码来登陆</h3>
		如果还没有注册，单击此处<a href="regist.jsp">注册</a>
		<s:actionmessage />
		<s:actionerror />
		
		<s:form action="proLogin.action">
			<s:textfield name="name" label="用户名" />
			<s:password name="pass" label="密码" />
			<s:textfield name="vercode" label="验证码" />
			<s:submit value="登陆" />
		</s:form>

		验证码如图：<img src="authImg" id="authImg" />看不清？<a href="#"
			onClick="refresh()">单击此处刷新</a>
	</center>
</body>
</html>