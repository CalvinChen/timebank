<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>注册银行账户</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfLogin.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleLogin.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<jsp:include page="${path}/view/common/plugin/partClueTip.jsp"/>
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
				<h2 class="title"><a href="#">注册银行账户</a></h2>
				<p class="meta">
					<a id="tip" href="#">
						目前本银行暂时只服务华南农业大学全日制本科生。
						<span id="tip_info">
							温馨提示：内测阶段只服务启林区学生！
						</span>
					</a>
				</p>
				<div class="entry">
					<div id="loginForm">
						<form method="post" action="Register_verifySubmit">
							<fieldset>
								<legend>第一步：验证真实信息</legend>
								
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight"><span id="message">${message}&nbsp;</span></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										<label for="labelName"><span id="login-key">真实姓名：</span></label>
									</div>
									<div class="rowRight">
										<input id="labelName" type="text" name="user.name" value="${user.name}" 
										class="login-text tipFocus" size="15" rel="#loadName" title="真实姓名"/>
										<div id="loadName" style="display: none;">
											 为了能够正常使用时间银行的功能，请如实填写，我们会为您保密。<br />
											（2-10个字符）
										</div>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										<label for="labelId"><span id="login-key">学号：</span></label>
									</div>
									<div class="rowRight">
										<input id="labelId" type="text" name="user.studentId" value="${user.studentId}" 
										class="login-text tipFocus" size="15" title="学号" rel="#loadId"/>
										<div id="loadId" style="display: none;">
											请填写您在华南农业大学的学号，我们会根据此验证您的身份。<br />
											（12个字符）
										</div>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight">
										<input type="submit" value="验证" class="button"/>
										<button type="button" class="button" onclick="history.go(-1);">返回</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/user/sidebar/document.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>