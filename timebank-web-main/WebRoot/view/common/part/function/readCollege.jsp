<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${user.college == 0 || empty user.college}">
		（未填）
	</c:when>
	<c:when test="${user.college == 1}">
		农学院
	</c:when>
	<c:when test="${user.college == 2}">
		资源环境学院
	</c:when>
	<c:when test="${user.college == 3}">
		生命科学学院
	</c:when>
	<c:when test="${user.college == 4}">
		经济管理学院
	</c:when>
	<c:when test="${user.college == 5}">
		工程学院
	</c:when>
	<c:when test="${user.college == 6}">
		动物科学学院
	</c:when>
	<c:when test="${user.college == 7}">
		兽医学院
	</c:when>
	<c:when test="${user.college == 8}">
		园艺学院
	</c:when>
	<c:when test="${user.college == 9}">
		食品学院
	</c:when>
	<c:when test="${user.college == 10}">
		林学院
	</c:when>
	<c:when test="${user.college == 11}">
		人文与法学学院
	</c:when>
	<c:when test="${user.college == 12}">
		理学院
	</c:when>
	<c:when test="${user.college == 13}">
		信息学院
	</c:when>
	<c:when test="${user.college == 14}">
		艺术学院
	</c:when>
	<c:when test="${user.college == 15}">
		外国语学院
	</c:when>
	<c:when test="${user.college == 16}">
		水利与土木工程学院
	</c:when>
	<c:when test="${user.college == 17}">
		公共管理学院
	</c:when>
	<c:otherwise>
		读取出错！
	</c:otherwise>
</c:choose>