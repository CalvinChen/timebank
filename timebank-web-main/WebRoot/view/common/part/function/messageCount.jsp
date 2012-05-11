<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p class="meta">
	<a id="tip" href="#">
		<c:choose>
			<c:when test="${count == 0}">
				您已阅读所有消息。
			</c:when>
			<c:otherwise>
				你还有${count}条未读消息。
			</c:otherwise>
		</c:choose>
		<span id="tip_info">
			温馨提示：请仔细阅读我们发的每一则消息，关注时间银行的动态！
		</span>
	</a>
</p>