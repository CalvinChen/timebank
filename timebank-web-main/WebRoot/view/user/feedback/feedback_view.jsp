<%@ page language="java" pageEncoding="UTF-8"%>
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
					<form action="Feedback_submit" method="post" enctype="multipart/form-data">
						<fieldset>
								<div class="oneRow">
									<div class="rowLeft"></div>
									<div class="rowRight"><span id="message">${message}</span></div>
								</div>
								<div style="clear: both;"></div>
								<div class="oneRow">
									<div class="rowLeft"></div>
									<div class="rowRight"><img class="userPicture120" src="${user.picture}"/></div>
								</div>
								<div style="clear: both;"></div>
								<div class="oneRow">
									<div class="rowLeft">用户</div>
									<div class="rowRight emphasized">${user.username}</div>
								</div>
								<div style="clear: both;"></div>
								<div class="oneRow">
									<div class="rowLeft">反馈主题</div>
									<div class="rowRight">
										<input type="text" name="feedback.feedbackTitle" value="${feedback.feedbackTitle}" class="titleRow"/>
										<span class="tips">（2-20字）</span>
									</div>
								</div>
								<div style="clear: both;"></div>
								<div class="oneRow">
									<div class="rowLeft">
										详细内容<br/>
										<span class="tips">（2-5000字）</span>
									</div>
									<div class="rowRight">
										<textarea cols="60" rows="8" name="feedback.feedbackContent">${feedback.feedbackContent}</textarea>
									</div>
								</div>
								<div style="clear: both;"></div>
								<div class="oneRow">
									<div class="rowLeft">
										截图										
									</div>
									<div class="rowRight">
										<input type="file" name="picture"/>
										<span class="tips">(可选,300KB以内)</span>
									</div>
								</div>
								<div style="clear: both;"></div>
								<div class="oneRow">
									<div class="rowLeft"></div>
									<div class="rowRight"><input type="submit" value="嗯，反馈填写完毕！" class="button"/></div>
								</div>
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