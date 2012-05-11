<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pages">
	<c:if test="${p > 1}">
		<a class="button" onclick="window.location.href=(location.toString().substring(0, location.toString().indexOf('?', 0)) + '?p=1')">首页</a>
		<a class="button" onclick="window.location.href=(location.toString().substring(0, location.toString().indexOf('?', 0)) + '?p=${p - 1}')">上一页</a>
	</c:if>
	<a class="button" onclick="window.location.href=(location.toString().substring(0, location.toString().indexOf('?', 0)) + '?p=${p}')">${p}/${pages}</a>
	<c:if test="${p < pages}">
		<a class="button" onclick="window.location.href=(location.toString().substring(0, location.toString().indexOf('?', 0)) + '?p=${p + 1}')">下一页</a>
		<a class="button" onclick="window.location.href=(location.toString().substring(0, location.toString().indexOf('?', 0)) + '?p=${pages}')">尾页</a>
	</c:if>
</div>