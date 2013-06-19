<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>异常错误页面</title>
</head>
<body>
	<center>
		<h2>错误提示：</h2>
		<span style="color:red;font-weight:bold"><s:property
				value="errorMsg" /> <s:property value="exception" /> <s:property
				value="msg" /> <s:actionerror />
		</span>
	</center>
</body>
</html>