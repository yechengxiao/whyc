<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>监测指标详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="decorator/jsp.css"  type="text/css"  rel="stylesheet"/>
</head>
<body>
	<br>
	<center>
		<h3>监测指标详情</h3>
		<table border="1" width="80%" cellspacing="0" cellpadding="0">
			<tr>
				<td><b>ID：</b> <s:property value="ib.id" /></td>
				<td><b>指标名称：</b> <s:property value="ib.name" />
				</td>
			</tr>
			<tr>
				<td><b>监测类型：</b> <s:property value="ib.kind" />
				</td>
				<td><b>监测方法：</b> <s:property value="ib.method" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><b>监测内容：</b> <s:property value="ib.content" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><b>备注：</b> <s:property value="ib.note" /></td>
			</tr>
		</table>
		<!-- 需要选择的预警指标 -->
		<table width="60%">
			<s:form action="pubWork.action">
				<tr>
					<td><s:checkboxlist name="wcIds" label="请选择预警指标"
							labelposition="top" list="wcbs" listKey="id" listValue="content" />
					</td>
				</tr>
				<tr>
					<td>
					<input type="hidden" name="ibId" value="<s:property value='ib.id'/>" /> 
					<s:submit value="发布"  align="center"   /></td>
				</tr>
			</s:form>
		</table>
		<!-- 发布成功后显示的message -->

		<br>
	</center>
</body>
</html>