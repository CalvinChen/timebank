<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select name="one.range" id="L8">
	<option value="1" <c:if test="${one.range == 1}">selected="selected"</c:if>>知识技能类</option>
	<option value="2" <c:if test="${one.range == 2}">selected="selected"</c:if>>休闲娱乐类</option>
	<option value="3" <c:if test="${one.range == 3}">selected="selected"</c:if>>体育运动类</option>
	<option value="4" <c:if test="${one.range == 4}">selected="selected"</c:if>>劳动修缮类</option>
	<option value="5" <c:if test="${one.range == 5}">selected="selected"</c:if>>其它[在详细说明中描述]</option>
</select>