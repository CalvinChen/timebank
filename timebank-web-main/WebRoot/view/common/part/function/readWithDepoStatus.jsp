<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${one.status == 1}">
		申请中，待审核
	</c:when>
	<c:when test="${one.status == 2}">
		已确认，并通过
	</c:when>
	<c:when test="${one.status == 3}">
		已确认，不通过
	</c:when>
	<c:when test="${one.status == 4}">
		互助成功
	</c:when>
	<c:when test="${one.status == 5}">
		互助失败
	</c:when>
	<c:when test="${one.status == 6}">
		尚未配对
	</c:when>
	<c:otherwise>状态获取出错！</c:otherwise>
</c:choose>