<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${one.articleType == 1}">通知通告</c:when>
	<c:when test="${one.articleType == 2}">新闻快讯</c:when>
	<c:when test="${one.articleType == 3}">时间银行</c:when>
</c:choose>