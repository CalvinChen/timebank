<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>个人中心</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfHomepage.css" rel="stylesheet" type="text/css" media="screen" />
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
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">修改密码</a></h2>
				<p class="meta">
					<a id="tip" href="#">
						最近更新信息时间：${user.updateTime}。
						<span id="tip_info">
							温馨提示：请尽量将您的个人信息保持最新！
						</span>
					</a>
				</p>
				<div class="entry">
					<form action="Homepage_infoSubmit" method="post">
						<fieldset>
							<input type="hidden" value="${user.userId}" name="user.userId"/>
							<input type="hidden" value="PSW" name="target"/>
							<div class="content">
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight"><span id="message">${message}&nbsp;</span></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="L1">旧密码：</label></div>
									<div class="rowRight"><input id="L1" type="password" name="oldPassword"/></div>
								</div>
								<hr />
								<div class="oneRow clear">
									<div class="rowLeft"><label for="L2">新密码：</label></div>
									<div class="rowRight"><input id="L2" type="password" name="newPassword"/></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="L3">重复密码：</label></div>
									<div class="rowRight"><input id="L3" type="password" name="newPasswordConfirm"/></div>
								</div>
								<div class="oneRow">
									<div class="rowLeft"></div>
									<div class="rowRight"><input type="submit" value="更新" class="button"/></div>
								</div>
							</div>
						</fieldset>
					</form>
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