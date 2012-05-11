<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>新建管理员 - 用户管理</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfHomepage.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleLogin.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<jsp:include page="${path}/view/common/part/common/logo.jsp"/>
	<hr />
			<jsp:include page="${path}/view/common/part/admin/head.jsp"/>
	<div id="page">
	<div id="page-bgtop">
		<div id="content">
			<div class="post">
				<h2 class="title">
					<a href="#">新建管理员</a>
					<span class="warn"><c:if test="${!empty message}"> - ${message}</c:if></span>
				</h2>
				<div class="entry">
					<div id="loginForm">
						<form method="post" action="AdminManager_submitCreateOne">
							<fieldset>
								<legend>注册信息</legend>
								<div class="oneRow clear">
									<div class="rowLeft">
										<label for="labelName"><span id="login-key">管理员昵称：</span></label>
									</div>
									<div class="rowRight">
										<input rel="#tips1" title="管理员昵称" id="labelName" type="text" name="one.username" class="login-text tipFocus" size="10"/>
										<div id="tips1">
											登陆后台用，2-10个字符。
										</div>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										<label for="labelName1"><span id="login-key">姓名：</span></label>
									</div>
									<div class="rowRight">
										<input rel="#tips21" title="姓名" id="labelName1" type="text" name="one.name" class="login-text tipFocus" size="10"/>
										<div id="tips21">
											建议取实际操作人的姓名，只对后台显示，记录操作痕迹，普通用户看不到，2-10个字符。
										</div>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										<label for="labelP1"><span id="login-key">输入密码：</span></label>
									</div>
									<div class="rowRight">
										<input rel="#tips2" title="密码" id="labelP1" type="password" name="one.password" class="login-text tipFocus" size="15"/>
										<div id="tips2">推荐数字、字母、其它符号等混合，2-20个字符。</div>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="labelP2"><span id="login-key">确认密码：</span></label></div>
									<div class="rowRight">
										<input rel="#tips3" title="重复密码" id="labelP2" type="password" name="passwordConfirm" class="login-text tipFocus" size="15"/>
										<div id="tips3">请重复以上密码。</div>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="labelP21"><span id="login-key">对用户显示为：</span></label></div>
									<div class="rowRight emphasized">
										<input type="hidden" name="one.nameToUser" value="阳光团队"/>
										阳光团队
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">权限：</div>
									<div class="rowRight">
										<c:choose>
											<c:when test="${adminLogined.level == 1}">
												<input type="hidden" name="one.level" value="1"/>
												普通管理员
											</c:when>
											<c:when test="${adminLogined.level == 2}">
												<select name="one.level">
													<option value="1">普通管理员</option>
													<option value="2">超级管理员</option>
												</select>
											</c:when>
										</c:choose>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight">
										<input type="submit" value="提交" class="button"/>
										<input type="reset" value="重置" class="button"/>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/admin/sidebar/search_user.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>