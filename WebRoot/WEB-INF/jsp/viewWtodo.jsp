<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>预警处置详情</title>
</head>
<body>
	<center>
		<h3>预警处置详情</h3>
		<table border="1" width="80%" cellspacing="0" cellpadding="0">
			<tr>
				<td><b>ID：</b> <s:property value="wtdb.id" />
				</td>
				<td><b>预警名称：</b> <s:property value="wtdb.name" /></td>
				<td><b>预警类型：</b> <s:property value="wtdb.kind" /></td>
			</tr>
			<tr>
				<td colspan="3"><b>预警内容：</b><br> <s:property
						value="wtdb.warn" />
				</td>
			</tr>
		</table>
		<s:form action="doneWtodo.action">
			<input type="hidden" name="id" value="<s:property value='wtdb.id'/>" />
			<s:textarea name="content" label="请输入处理意见" />
			<s:submit value="消除预警" />
		</s:form>
	</center>
</body>
</html>