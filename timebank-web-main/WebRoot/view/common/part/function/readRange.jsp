<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${one.range == 1}">知识技能类</c:when>
	<c:when test="${one.range == 2}">休闲娱乐类</c:when>
	<c:when test="${one.range == 3}">体育运动类</c:when>
	<c:when test="${one.range == 4}">劳动修缮类</c:when>
	<c:when test="${one.range == 5}">其它[在详细说明中描述]</c:when>
	<c:otherwise>获取状态出错！</c:otherwise>
</c:choose>