<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="article">
	<span id="message">${messageArticle}</span>
	<h2>${one.articleTitle}</h2>
	<div class="articleInfo clear">
		[
		<c:choose>
			<c:when test="${one.articleType == 1}">通知通告</c:when>
			<c:when test="${one.articleType == 2}">新闻快讯</c:when>
			<c:when test="${one.articleType == 3}">时间银行</c:when>
		</c:choose>
		]
		${one.author}于${one.createTime}发布。
	</div>
	<div class="articleContent clear">
		${one.articleContent}
	</div>
	<div class="clickCount clear">
		<span class="button" onclick="history.go(0)">点击数：${one.articleClickCount}</span>
		<c:choose>
			<c:when test="${!empty adminLogined}">
				<a class="button" href="admin/ArticleAdmin_modifyOne?articleId=${one.articleId}">修改</a>
				<a class="button" href="admin/ArticleAdmin_deleteOneSubmit?articleId=${one.articleId}">删除</a>
			</c:when>
		</c:choose>
	</div>
</div>