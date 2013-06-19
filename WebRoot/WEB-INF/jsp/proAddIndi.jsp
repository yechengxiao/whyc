<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>新增监测指标</title>
</head>
<body>
	<center>
		<span style="color:red;font-weight:bold"><s:actionerror /> </span>
		<s:form action="proAddIndi.action">
			<s:token>
				<s:textfield name="name" label="指标名称"  />
				<!-- 下拉菜单 -->
				<s:select list="kinds" listKey="id" listValue="name" name="kind"
					emptyOption="false" label="监测类型"  />
				<s:select list="#{'1':'一天','2':'一周','3':'半个月','4':'一个月' }"
					name="period" emptyOption="false" label="监测重复周期"  />
				<s:textfield name="method" label="监测方法"  />
				<s:textarea name="content" label="监测内容"  />
				<s:textfield name="note" label="备注"  />
				<s:submit value="确认新增" />
			</s:token>
		</s:form>
	</center>
</body>
</html>