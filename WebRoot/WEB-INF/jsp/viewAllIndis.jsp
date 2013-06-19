<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>监测指标</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<!--样式、JS在deco.jsp页面引入 -->
</head>

<body>
	<div align="center" class="main_body">
		<span style="color:red;font-weight:bold"> <s:actionmessage />
			<s:actionerror /> <s:property value="succMsg" /> </span>
		<h3>点击指标名称进行发布工作</h3><a href="mgrIndi.action" class="links">新增</a>
		<!-- 显示所有预警指标 -->
		<form name="formIndi" action="" method="post">
			<table width="80%" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<th width="20"><input type="checkbox" id="CheckAll">
					</th>
					<th width="30">ID</th>
					<th>指标名称</th>
					<th>监测方法</th>
					<th>监测类型</th>
				</tr>
				<!-- IndicatorBean -->
				<s:iterator value="ibs">
					<tr>
						<td><input type="checkbox" value="<s:property value='id'/>"
							name="chb" /></td>
						<td><s:property value="id" /></td>
						<td><a href='viewIndi.action?ibId=<s:property value="id"/>'>
								<s:property value="name" /> </a></td>
						<td><s:property value="method" /></td>
						<td><s:property value="kind" /></td>
					</tr>
				</s:iterator>
			</table>
		</form>
		<!-- 跳转至新增页面 -->
		<p>
			<button name="delIndi" id="delIndi" class="links">删除</button>
			<button name="modifyIndi" id="modifyIndi" class="links">修改</button>
		</p>
	</div>
</body>
</html>