<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增预警指标</title>
</head>
<body>
	<center>
		<span style="color:red;font-weight:bold"><s:actionerror />
		</span>
		<s:form action="proAddWarncontent.action">
			<!-- 防重复提交 token -->
			<s:token>
				<s:textarea name="content" label="预警内容" />
				<s:select name="levelId" list="wls" listKey="id" listValue="level"
					emptyOption="true" label="预警等级" />
				<s:submit value="确认新增" />
			</s:token>
		</s:form>
	</center>
</body>
</html>