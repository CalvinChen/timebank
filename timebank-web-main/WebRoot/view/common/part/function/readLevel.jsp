<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${empty one.level || one.level == 0}">
		（未定）
	</c:when>
	<c:when test="${one.level == 1}">
		普通管理员
	</c:when>
	<c:when test="${one.level == 2}">
		超级管理员
	</c:when>
	<c:otherwise>
		读取出错！
	</c:otherwise>
</c:choose> 