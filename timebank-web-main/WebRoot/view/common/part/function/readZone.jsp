<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${user.zone == 0 || empty user.zone}">
		（未填）
	</c:when>
	<c:when test="${user.zone == 1}">
		启林南
	</c:when>
	<c:when test="${user.zone == 2}">
		启林北
	</c:when>
	<c:when test="${user.zone == 3}">
		五山
	</c:when>
	<c:when test="${user.zone == 4}">
		华山
	</c:when>
	<c:when test="${user.zone == 5}">
			其它
	</c:when>
	<c:otherwise>
		读取出错！
	</c:otherwise>
</c:choose> 