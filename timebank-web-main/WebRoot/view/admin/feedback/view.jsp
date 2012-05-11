<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>处理反馈</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleFeedback.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<jsp:include page="${path}/view/common/part/common/logo.jsp"/>
	<hr />
			<jsp:include page="${path}/view/common/part/admin/head.jsp"/>
	<div id="page">
	<div id="page-bgtop">
		<a name="flag"></a>
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">处理反馈</a></h2>
				<div class="entry">
					<form action="FeedbackAdmin_submit" method="post">
						<fieldset>
								<input type="hidden" name="feedbackId" value="${feedbackId}"/>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight"><span id="message">${message}</span></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight">
										<a target="_blank" href="/TimeBank/admin/SearchUser_viewOne?uid=${user.userId}#header">
											<img class="userPicture120" src="${user.picture}"/>
										</a>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight">
										<a target="_blank" href="/TimeBank/admin/SearchUser_viewOne?uid=${user.userId}#header">
											<span class="emphasized">${feedback.username}</span>
										</a>
										<span class="tips">（于${feedback.createTime}反馈）</span>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">主题</div>
									<div class="rowRight"><span class="emphasized">${feedback.feedbackTitle}</span></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">内容</div>
									<div class="rowRight">
										<span class="emphasized">${feedback.feedbackContent}</span>
										<c:if test="${!empty feedback.feedbackPicture}">
											<a href="${feedback.feedbackPicture}" target="_BLANK">
												<img class="picture90per" src="${feedback.feedbackPicture}" alt="" />
											</a>
										</c:if>
									</div>
								</div>
								<c:choose>
									<c:when test="${feedback.isAnswered == 1}">
										<div class="oneRow clear">
											<div class="rowLeft">管理员回复</div>
											<div class="rowRight">
												<span class="emphasized">${feedback.answerContent}</span>
												<br />
												<span class="tips">（由${feedback.adminUsername}于${feedback.answerTime}回复）</span>
											</div>
										</div>
									</c:when>
									<c:when test="${feedback.isAnswered == 0}">
										<div class="oneRow clear">
											<div class="rowLeft">管理员回复</div>
											<div class="rowRight"><textarea cols="40" rows="5" name="feedback.answerContent">${feedback.answerContent}</textarea></div>
										</div>
										<div class="oneRow clear">
											<div class="rowLeft"></div>
											<div class="rowRight"><input type="submit" value="回复此条反馈信息" class="button"/></div>
										</div>
									</c:when>
								</c:choose>
								
								
								
						</fieldset>
					</form>
					<hr/>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/admin/sidebar/feedback.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>