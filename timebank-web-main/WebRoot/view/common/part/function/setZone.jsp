<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select name="user.zone" id="L8">
	<option value="1" <c:if test="${user.zone == 1}">selected="selected"</c:if>>启林南</option>
	<option value="2" <c:if test="${user.zone == 2}">selected="selected"</c:if>>启林北</option>
	<option value="3" <c:if test="${user.zone == 3}">selected="selected"</c:if>>五山</option>
	<option value="4" <c:if test="${user.zone == 4}">selected="selected"</c:if>>华山</option>
	<option value="5" <c:if test="${user.zone == 5}">selected="selected"</c:if>>其它</option>
</select>