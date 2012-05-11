<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${one.theTime == 1}">第1、2节</c:when>
	<c:when test="${one.theTime == 2}">第3、4节</c:when>
	<c:when test="${one.theTime == 3}">整个上午</c:when>
	<c:when test="${one.theTime == 4}">第5、6节</c:when>
	<c:when test="${one.theTime == 5}">第7、8节</c:when>
	<c:when test="${one.theTime == 6}">第9、10节</c:when>
	<c:when test="${one.theTime == 7}">整个下午</c:when>
	<c:when test="${one.theTime == 8}">第11、12节</c:when>
	<c:when test="${one.theTime == 9}">整个白天</c:when>
	<c:when test="${one.theTime == 10}">整个晚上</c:when>
	<c:when test="${one.theTime == 11}">一整天</c:when>
	<c:when test="${one.theTime == 12}">其它</c:when>
</c:choose>