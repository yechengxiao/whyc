<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>预警处置</title>
</head>
<body>
	<center>
		<h3>当前所有预警</h3>
		<table border="1" width="80%" cellspacing="0" cellpadding="0">
			<tr>
				<th width="30">ID</th>
				<th>预警名称</th>
				<th>监测类型</th>
			</tr>
			<s:iterator value="wtodos">
				<tr>
					<td><s:property value="id" /></td>
					<td><a href='viewWtodo.action?id=<s:property value="id"/>'>
							<s:property value="name" /> </a></td>
					<td><s:property value="kind" /></td>
				</tr>
			</s:iterator>
		</table>
	</center>
</body>
</html>