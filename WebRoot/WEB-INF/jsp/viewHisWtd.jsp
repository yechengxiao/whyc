<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>历史预警记录</title>
</head>
<body>
	<center>
		<h3>历史预警详情</h3>
		<table border="1" width="80%" cellspacing="0" cellpadding="0">
			<tr>
				<th width="30">ID</th>
				<th>预警名称</th>
				<th>监测类型</th>
				<th>预警内容</th>

			</tr>
			<s:iterator value="wtodos">
				<tr>
					<td><s:property value="id" />
					</td>
					<td><a href="#'<s:property value="id"/>'"> <s:property
								value="name" /> </a></td>
					<td width="60px"><s:property value="kind" />
					</td>
					<td><s:property value="warn" />
					</td>
				</tr>
			</s:iterator>
		</table>
		<span style="color:red;font-weight:bold"><s:actionmessage />
		</span>
	</center>
</body>
</html>