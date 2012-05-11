<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${user.sex == 0 || empty user.sex}">
		（未填）
	</c:when>
	<c:when test="${user.sex == 1}">
		男
	</c:when>
	<c:when test="${user.sex == 2}">
		女
	</c:when>
	<c:otherwise>
		读取出错！
	</c:otherwise>
</c:choose> 