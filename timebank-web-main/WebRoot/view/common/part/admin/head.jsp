<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="header">
	<div id="menu">
		<ul>
			<li><a href="/TimeBank/LoginAdmin_view">首页</a></li>
			<li><a href="/TimeBank/admin/HomepageAdmin_view">业务中心</a></li>
			<li><a href="/TimeBank/admin/SearchUser_view">用户管理</a></li>
			<li><a href="/TimeBank/admin/FeedbackAdmin_view">反馈中心</a></li>
			<li><a href="/TimeBank/Article_view">文章</a></li>
			<li><a href="/TimeBank/admin/MessageAdmin_view">消息</a></li>
			<c:if test="${!empty adminLogined}">
				<li>
					<a href="/TimeBank/LoginAdmin_login?message=quit" class="first">退出</a>
				</li>
			</c:if>
		</ul>
	</div>
	<!-- end #menu -->
	<c:if test="${!empty adminLogined}">
		<div id="search">
			<form method="post" action="/TimeBank/admin/SearchUser_search">
				<fieldset>
				<input type="text" name="someInfo" id="search-text" size="15"/>
				<input type="submit" id="search-submit" value="搜索用户" />
				</fieldset>
			</form>
		</div>
	</c:if>
	<!-- end #search -->
</div>