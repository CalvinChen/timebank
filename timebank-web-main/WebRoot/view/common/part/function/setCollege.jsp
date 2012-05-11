<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select name="user.college" id="L4">
	<c:choose>
		<c:when test="${user.college == 1}">
			<option value="1" selected="selected">农学院</option>
		</c:when>
		<c:otherwise>
			<option value="1">农学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 2}">
			<option value="2" selected="selected">资源环境学院</option>
		</c:when>
		<c:otherwise>
			<option value="2">资源环境学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 3}">
			<option value="3" selected="selected">生命科学学院</option>
		</c:when>
		<c:otherwise>
			<option value="3">生命科学学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 4}">
			<option value="4" selected="selected">经济管理学院</option>
		</c:when>
		<c:otherwise>
			<option value="4">经济管理学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 5}">
			<option value="5" selected="selected">工程学院</option>
		</c:when>
		<c:otherwise>
			<option value="5">工程学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 6}">
			<option value="6" selected="selected">动物科学学院</option>
		</c:when>
		<c:otherwise>
			<option value="6">动物科学学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 7}">
			<option value="7" selected="selected">兽医学院</option>
		</c:when>
		<c:otherwise>
			<option value="7">兽医学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 8}">
			<option value="8" selected="selected">园艺学院</option>
		</c:when>
		<c:otherwise>
			<option value="8">园艺学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 9}">
			<option value="9" selected="selected">食品学院</option>
		</c:when>
		<c:otherwise>
			<option value="9">食品学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 10}">
			<option value="10" selected="selected">林学院</option>
		</c:when>
		<c:otherwise>
			<option value="10">林学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 11}">
			<option value="11" selected="selected">人文与法学学院</option>
		</c:when>
		<c:otherwise>
			<option value="11">人文与法学学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 12}">
			<option value="12" selected="selected">理学院</option>
		</c:when>
		<c:otherwise>
			<option value="12">理学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 13}">
			<option value="13" selected="selected">信息学院</option>
		</c:when>
		<c:otherwise>
			<option value="13">信息学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 14}">
			<option value="14" selected="selected">艺术学院</option>
		</c:when>
		<c:otherwise>
			<option value="14">艺术学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 15}">
			<option value="15" selected="selected">外国语学院</option>
		</c:when>
		<c:otherwise>
			<option value="15">外国语学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 16}">
			<option value="16" selected="selected">水利与土木工程学院</option>
		</c:when>
		<c:otherwise>
			<option value="16">水利与土木工程学院</option>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${user.college == 17}">
					<option value="17" selected="selected">公共管理学院</option>
				</c:when>
				<c:otherwise>
					<option value="17">公共管理学院</option>
				</c:otherwise>
			</c:choose>
</select>