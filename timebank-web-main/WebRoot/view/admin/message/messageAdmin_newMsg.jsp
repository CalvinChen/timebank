<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>发布新通知 - 消息</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script type="text/javascript" src="/TimeBank/JS/nicEdit/nicEdit.js"></script>
<script type="text/javascript" src="/TimeBank/JS/nicEdit/custom.js"></script>
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
				<h2 class="title"><a href="#">发布新通知</a></h2>
				<div class="entry">
					<form action="MessageAdmin_submitNewNotice" method="post">
						<fieldset>
							<input type="hidden" name="one.type" value="3"/>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight"><span id="message">${message}</span></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">发送者</div>
									<div class="rowRight emphasized">
										<input type="text" name="one.sender" 
											   <c:choose>
											   	<c:when test="${!empty one.sender}">value="${one.sender}"</c:when>
											   	<c:otherwise>value="${adminLogined.username}"</c:otherwise>
											   </c:choose>
											   class="titleRow"/>
											   
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">接收者</div>
									<div class="rowRight emphasized">
										所有时间银行用户
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">标题</div>
									<div class="rowRight">
										<input type="text" name="one.title" value="${one.title}" class="titleRow"/>
										<span class="tips">（2-20字）</span>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										内容<br/>
										<span class="tips">(2-5000字)</span>
									</div>
									<div class="rowRight">
										<textarea cols="60" rows="12" name="one.content" id="area1">${one.content}</textarea>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight"><input type="submit" value="嗯，填写完毕，发布！" class="button"/></div>
								</div>
						</fieldset>
					</form>
					<hr/>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/admin/sidebar/message.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>