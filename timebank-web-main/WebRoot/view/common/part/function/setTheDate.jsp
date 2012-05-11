<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select name="one.theDate">
	<c:forEach items="${days}" var="one" varStatus="i">
		<option value="${one}" <c:if test="${one == withdrawRecord.theDate}">selected="selected"</c:if>>${one}</option>
	</c:forEach>
</select>