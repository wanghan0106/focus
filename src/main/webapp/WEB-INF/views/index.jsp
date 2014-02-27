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
	$('#btnSearch').click(function() {
		$('.easyui-datagrid').datagrid('load',getFormParams('form'));
	});
});
</script>
<body>
	<h1>
		<spring:message code="title" />
	</h1>
	<form id="form" method="post">
		<div>
			<span>用户名:</span>&nbsp;&nbsp;<input type="text" name="queryParams[0].value" value="${params.queryParams[0].value}" style="width: 100px;" /> 
			<input type="hidden" name="queryParams[0].name" value="name" />
			<input type="button" id="btnSearch" value="查询" />
			<a href="${ctx}/detail">详情</a>
		</div>
	</form>
	<div></div>
	<table class="easyui-datagrid" title="用户列表" style="width: 700px;"
		data-options="singleSelect:false,queryParams:getFormParams('form'),collapsible:false,pagination:true,rownumbers:true,pageSize:${params.rows},pageNumber:${params.page},<c:if test="${params.sort!=null}">sortName:'${params.sort}',</c:if><c:if test="${params.sort!=null}">sortOrder:'${params.order}',</c:if>url:'${ctx}/home/list'">
		<thead>
			<tr>
				<th data-options="field:'name',width:80,sortable:true">用户名</th>
				<th data-options="field:'number',width:100,sortable:true">编号</th>
			</tr>
		</thead>
	</table>

</body>
</html>