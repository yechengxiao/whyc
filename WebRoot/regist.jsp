<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<script type="text/javascript" src="js/prototype-1.4.0.js" ></script>
<script type="text/javascript" src="js/json.js" ></script>
<script type="text/javascript" src="js/util.js"  ></script>

</head>
<body>
	<center>
		<h3>请注册</h3>
		<s:actionmessage />
		<s:actionerror />
		<span id="tip" style="color:red;font-weight:bold"></span>

		<s:form action="proRegist.action">
			<s:textfield id="name" name="name" label="用户名"
				onblur="validateName()" />
			<s:password name="pass" label="密码" />
			<s:password name="pass2" label="再次输入密码" />
			<s:select list="#{'1':'管理员','2':'专家','3':'员工' }" name="level"
				label="用户等级" />
			<s:textfield name="email" label="电邮" />
			<s:textfield name="vercode" label="验证码" value="" />
			
			<s:submit value="注册"  />
		</s:form>

		验证码如图： <img src="authImg" id="authImg" />看不清？ <a href="#"
			onClick="refresh()">单击此处刷新</a>
	</center>
</body>
</html>