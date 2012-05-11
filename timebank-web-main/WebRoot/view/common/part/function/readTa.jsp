<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${user.sex == 0 || empty user.sex}">
		Ta
	</c:when>
	<c:when test="${user.sex == 1}">
		他
	</c:when>
	<c:when test="${user.sex == 2}">
		她
	</c:when>
	<c:otherwise>
		读取出错！
	</c:otherwise>
</c:choose> 