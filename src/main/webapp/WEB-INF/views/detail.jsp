<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="title" /></title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/themes/easyui/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/themes/easyui/default/datagrid.css">
<script type="text/javascript" src="${ctx}/scripts/jquery.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery.easyui.js"></script>
</head>
<script language="JavaScript">
$(function(){
});
</script>
<body>
	<div><a href="${ctx}/home">返回</a></div>
</body>
</html>