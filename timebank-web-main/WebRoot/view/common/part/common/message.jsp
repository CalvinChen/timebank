<%@ page language="java" pageEncoding="UTF-8"%>
<c:if test="${!empty message}">
	<c:choose>
		<c:when test="${message.status == 1}">
			<div class="alert alert-success">
  				<a class="close" data-dismiss="alert" href="#">×</a>
				<h3>${message.info}</h3>
			</div>
		</c:when>
		<c:when test="${message.status == 0}">
			<div class="alert alert-error">
  				<a class="close" data-dismiss="alert" href="#">×</a>
				<h3>${message.info}</h3>
			</div>
		</c:when>
	</c:choose>
</c:if>