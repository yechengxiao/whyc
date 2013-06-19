<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
</head>
<body>
	<center>
		<h2>
			<h2>当前报警数</h2>
		</h2>
		<table>
			<s:iterator value="map">
				<tr>
					<td><s:property value="key" />：</td>
					<td>报警<s:property value="value" />次</td>
				</tr>
			</s:iterator>
		</table>
	</center>
</body>
</html>