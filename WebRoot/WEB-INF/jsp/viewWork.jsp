<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>任务处置详情</title>
</head>
<body>
	<div align="center">
		<h3>任务详情</h3>
		<table border="1" width="80%" cellspacing="0" cellpadding="0">
			<tr>
				<td><b>ID：</b> <s:property value="work.id" />
				</td>
				<td><b>任务名称：</b> <s:property value="work.name" />
				</td>
			</tr>
			<tr>
				<td><b>监测类型：</b> <s:property value="work.kind" />
				</td>
				<td><b>监测方法：</b> <s:property value="work.method" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><b>任务内容：</b> <s:property value="work.content" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><b>备注：</b> <s:property value="work.note" />
				</td>
			</tr>
		</table>
		<!-- 处理任务时，根据实情勾选当前任务下的预警指标-->
		<!-- 表单，button等无用内容不要写在<form>中，不然可能出错。method="post"，有用的。 -->
		<form  name="formDoWork" action=""  method="post">
			<table>
				<s:iterator value="wcbs">
					<tr>
						<td width="10"><input type="checkbox" value="<s:property value='id'/>"  name="chb" />
						</td>
						<td><s:property value="content" />
						</td>
					</tr>
				</s:iterator>
			</table>
		</form>
			<!--处理后，跳转至ViewWorkAction.java。需要id属性。  --> 
			<input type="hidden"  name="id" value="<s:property value='work.id'/>" /> 
			<button name="updateWork" id="updateWork">无预警，完成任务</button>
			<button name="createWarn" id="createWarn">生成预警！！</button>
	</div>
</body>
</html>