<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>预警指标</title>
</head>
<body>
	<div align="center" class="main_body">
		<span style="color:red;font-weight:bold"> <s:actionmessage />
			<s:actionerror /> <s:property value="succMsg" /> </span>
		<h3>当前所有可用预警指标</h3><a href="mgrWCon.action" class="links">新增</a>
		<form name="formWCon" action="" method="post">
		<table border="1" width="80%" cellspacing="0" cellpadding="0">
			<tr>
				<th width="20"><input type="checkbox" id="CheckAll">
				</th>
				<th width="30">ID</th>
				<th>预警指标内容</th>
				<th>预警等级</th>
			</tr>
			<s:iterator value="wcbs">
				<tr>
					<td><input type="checkbox" value="<s:property value='id'/>"
						name="chb" /></td>
					<td><s:property value="id" /></td>
					<td><s:property value="content" /></td>
					<td><s:property value="level" />
				</tr>
			</s:iterator>
		</table>
		</form>
		<!-- 跳转至新增页面 -->
		<p>
			
			<button name="delWCon" id="delWCon" class="links">删除</button>
			<button name="modifyWCon" id="modifyWCon" class="links">修改</button>
		</p>
	</div>
</body>
</html>