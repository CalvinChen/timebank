<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fieldset>
	<div class="content">
		<span id="message">${messageArticle}</span>
		<ul>
			<c:choose>
				<c:when test="${empty list}">
					<li>尚无发布任何文章。</li>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list}" var="one">
						<li>
							[
							<c:choose>
								<c:when test="${one.articleType == 1}">通知通告</c:when>
								<c:when test="${one.articleType == 2}">新闻快讯</c:when>
								<c:when test="${one.articleType == 3}">时间银行</c:when>
							</c:choose>
							]
							<span class="emphasized">
								<a href="/TimeBank/Article_viewOne?articleId=${one.articleId}#flag" target="_BLANK">
									${one.articleTitle}
								</a>
							</span>
							<span class="tips">${one.updateTime}</span>
						</li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</fieldset>