<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>查看消息 - 个人中心</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleArticle.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<jsp:include page="${path}/view/common/part/common/logo.jsp"/>
	<hr />
			<jsp:include page="${path}/view/common/part/user/head.jsp"/>
	<div id="page">
	<div id="page-bgtop">
		<a name="flag"></a>
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">查看消息</a></h2>
				<jsp:include page="${path}/view/common/part/function/messageCount.jsp"/>
				<div class="article">
						<fieldset>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight"><span id="message">${message}</span></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										[
										<c:choose>
											<c:when test="${oneMsg.type == 1}">消息</c:when>
											<c:when test="${oneMsg.type == 2}">私信</c:when>
											<c:when test="${oneMsg.type == 3}">通知</c:when>
											<c:when test="${oneMsg.type == 4}">粉丝</c:when>
											<c:otherwise>错误！发现此提示请联系管理员修正！</c:otherwise>
										</c:choose>
										]
									</div>
									<div class="rowRight"><h2 class="emphasized">${oneMsg.title}</h2></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">来自</div>
									<div class="rowRight">
										<span class="emphasized">${oneMsg.sender}</span>
										<span class="tips">(${oneMsg.updateTime})</span>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight">
										<span class="articleContent">${oneMsg.content}</span>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight">
										<a class="button" href="Homepage_viewMessage">返回</a>
									</div>
								</div>
						</fieldset>
					<hr/>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/user/sidebar/homepage.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>