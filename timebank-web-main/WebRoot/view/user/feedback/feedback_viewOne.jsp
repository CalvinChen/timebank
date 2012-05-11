<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>反馈</title>
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
			<jsp:include page="${path}/view/common/part/user/head.jsp"/>
	<div id="page">
	<div id="page-bgtop">
		<a name="flag"></a>
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">反馈</a></h2>
				<p class="meta">
					<a id="tip" href="#">
						这里的反馈包括您对我们时间银行的意见、建议、求助、鼓励、批评等等，请畅所欲言！
						<span id="tip_info">
							温馨提示：我们的值班人员会在24小时之内回复您的反馈，感谢您。
						</span>
					</a>
				</p>
				<div class="entry">
					<form action="Feedback_submit" method="post">
						<fieldset>
								<div class="oneRow">
									<div class="rowLeft"></div>
									<div class="rowRight"><span id="message">${message}&nbsp;</span></div>
								</div>
								<div style="clear: both;"></div>
								<div class="oneRow">
									<div class="rowLeft"></div>
									<div class="rowRight"><img class="userPicture120" src="${user.picture}"/></div>
								</div>
								<div style="clear: both;"></div>
								<div class="oneRow">
									<div class="rowLeft">用户：</div>
									<div class="rowRight"><span class="emphasized">${user.username}</span></div>
								</div>
								<div style="clear: both;"></div>
								<div class="oneRow">
									<div class="rowLeft">反馈主题：</div>
									<div class="rowRight"><span class="emphasized">${feedback.feedbackTitle}</span></div>
								</div>
								<div style="clear: both;"></div>
								<div class="oneRow">
									<div class="rowLeft">详细内容：</div>
									<div class="rowRight">
										<span class="emphasized">${feedback.feedbackContent}</span>
										<c:if test="${!empty feedback.feedbackPicture}">
											<a href="${feedback.feedbackPicture}" target="_BLANK">
												<img class="picture90per" src="${feedback.feedbackPicture}" alt="" />
											</a>
										</c:if>
									</div>
								</div>
								<div style="clear: both;"></div>
								<c:choose>
									<c:when test="${feedback.isAnswered == 1}">
										<div class="oneRow">
											<div class="rowLeft">管理员回复：</div>
											<div class="rowRight"><span id="message">${feedback.answerContent}</span></div>
										</div>
									</c:when>
									<c:when test="${feedback.isAnswered == 0}">
										<div class="oneRow">
											<div class="rowLeft">管理员回复：</div>
											<div class="rowRight">尚未</div>
										</div>
									</c:when>
								</c:choose>
								
								
						</fieldset>
						<!-- <fieldset id="messageBoard">
							<legend>留言板</legend>
							<p id="close">留言功能暂不开放，敬请期待。</p>
						</fieldset> -->
					</form>
					<hr/>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/user/sidebar/feedback.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>