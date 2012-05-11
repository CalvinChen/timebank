<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select name="user.sex" id="L8">
	<option value="0"></option>
	<c:choose>
		<c:when test="${user.sex == 1}">
			<option value="1" selected="selected">男</option>
		</c:when>
		<c:otherwise>
			<option value="1">男</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.sex == 2}">
			<option value="2" selected="selected">女</option>
		</c:when>
		<c:otherwise>
			<option value="2">女</option>
		</c:otherwise>
	</c:choose>
</select>