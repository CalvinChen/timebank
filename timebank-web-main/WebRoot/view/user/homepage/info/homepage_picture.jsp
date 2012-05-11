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
				<h2 class="title"><a href="#">头像更新</a></h2>
				<p class="meta">
					<a id="tip" href="#">
						最近更新信息时间：${user.updateTime}。
						<span id="tip_info">
							温馨提示：上传头像尺寸请尽量为120*120像素，或长宽比例为1:1！
						</span>
					</a>
				</p>
				<div class="entry">
					<form action="Homepage_picSubmit" method="post" enctype="multipart/form-data">
						<fieldset>
							<div class="content">
								<div class="oneRow">
									<div class="rowLeft"></div>
									<div class="rowRight"><span id="message">${message}&nbsp;</span></div>
								</div>
								<div style="clear: both;"></div>
								<div class="oneRow">
									<div class="rowLeft">当前头像：</div>
									<div class="rowRight"><img class="userPicture120" src="${user.picture}" alt="头像"/></div>
								</div>
								<div style="clear: both;"></div>
								<div class="oneRow">
									<div class="rowLeft">请选择新头像：</div>
									<div class="rowRight">
										<input type="file" name="picture"/><br />
										<span class="tips">（300KB以内）</span>
									</div>
								</div>
								<div style="clear: both;"></div>
								<div class="oneRow">
									<div class="rowLeft"></div>
									<div class="rowRight"><input type="submit" value="上传" class="button"/></div>
								</div>
							</div>
						</fieldset>
					</form>
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