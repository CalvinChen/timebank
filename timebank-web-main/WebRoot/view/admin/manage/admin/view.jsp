<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>查看管理员 - 用户管理</title>
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
					<a href="#">
						查看管理员
						[
						${one.username}
						<c:if test="${!empty one.name}">
							(${one.name})
						</c:if>
						]
					</a>
					<span class="warn"><c:if test="${!empty message}"> - ${message}</c:if></span>
				</h2>
				<div class="entry">
					<div id="loginForm">
						<form method="post" action="AdminManager_submitModifyOne">
							<fieldset>
								<div class="oneRow clear">
									<input type="hidden" name="aid" value="${one.adminId}"/>
									<div class="rowLeft">
										<label for="labelName"><span id="login-key">管理员昵称：</span></label>
									</div>
									<div class="rowRight">
										<c:choose>
											<c:when test="${adminLogined.adminId == one.adminId || adminLogined.level == 2}">
												<input rel="#tips1" title="管理员昵称" id="labelName" type="text" 
														name="one.username" value="${one.username}" class="login-text tipFocus" size="10"/>
												<div id="tips1" style="display: none;">
													登陆后台用，2-10个字符。
												</div>
											</c:when>
											<c:otherwise>
												<input type="hidden" name="one.username" value="${one.username}"/>
												<span class="emphasized">${one.username}</span>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										<label for="labelName1"><span id="login-key">姓名：</span></label>
									</div>
									<div class="rowRight">
										<c:choose>
											<c:when test="${adminLogined.adminId == one.adminId || adminLogined.level == 2}">
												<input rel="#tips21" title="姓名" id="labelName1" type="text" 
														name="one.name" value="${one.name}" class="login-text tipFocus" size="10"/>
												<div id="tips21" style="display: none;">
													建议取实际操作人的姓名，只对后台显示，记录操作痕迹，普通用户看不到，2-10个字符。
												</div>
											</c:when>
											<c:otherwise>
												<input type="hidden" name="one.name" value="${one.name}"/>
												<span class="emphasized">${one.name}</span>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
								<c:if test="${adminLogined.adminId == one.adminId || adminLogined.level == 2}">
									<div class="oneRow clear">
										<div class="rowLeft">
											<label for="labelP1"><span id="login-key">输入新密码：</span></label>
										</div>
										<div class="rowRight">
											<input rel="#tips2" title="密码" id="labelP1" type="password" name="one.password" class="login-text tipFocus" size="15"/>
											<div id="tips2" style="display: none;">留空为不修改。推荐数字、字母、其它符号等混合，2-20个字符。</div>
										</div>
									</div>
									<div class="oneRow clear">
										<div class="rowLeft"><label for="labelP2"><span id="login-key">确认新密码：</span></label></div>
										<div class="rowRight">
											<input rel="#tips3" title="重复密码" id="labelP2" type="password" name="passwordConfirm" class="login-text tipFocus" size="15"/>
											<div id="tips3" style="display: none;">请重复以上密码。</div>
										</div>
									</div>
								</c:if>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="labelP21"><span id="login-key">对用户显示为：</span></label></div>
									<div class="rowRight emphasized">
										<c:choose>
											<c:when test="${adminLogined.level == 2}">
												<input rel="#tips31" title="对用户显示的名称" id="labelP21" type="text" 
													   name="one.nameToUser" value="${one.nameToUser}" class="login-text tipFocus" size="15"/>
												<div id="tips31" style="display: none;">一般情况下请保持为【阳光团队】，除非有其它用途。</div>
											</c:when>
											<c:otherwise>
												<input type="hidden" name="one.nameToUser" value="${one.nameToUser}"/>
												${one.nameToUser}
											</c:otherwise>
										</c:choose>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">权限：</div>
									<div class="rowRight">
										<c:choose>
											<c:when test="${adminLogined.level == 1}">
												<input type="hidden" name="one.level" value="${one.level}"/>
												<c:choose>
													<c:when test="${empty one.level || one.level == 0}">
														（未定）
													</c:when>
													<c:when test="${one.level == 1}">
														普通管理员
													</c:when>
													<c:when test="${one.level == 2}">
														超级管理员
													</c:when>
													<c:otherwise>
														读取出错！
													</c:otherwise>
												</c:choose> 
											</c:when>
											<c:when test="${adminLogined.level == 2}">
												<select name="one.level">
													<option value="1" <c:if test="${one.level == 1}">selected="selected"</c:if>>普通管理员</option>
													<option value="2" <c:if test="${one.level == 2}">selected="selected"</c:if>>超级管理员</option>
												</select>
											</c:when>
										</c:choose>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">绑定用户名</div>
									<div class="rowRight">
										<c:choose>
											<c:when test="${one.linkedUserId == 0}">
												暂无绑定任何用户。
											</c:when>
											<c:otherwise>
												<a href="/TimeBank/admin/SearchUser_viewOne?uid=${one.linkedUserId}#header" class="emphasized">
													${one.linkedName}
												</a>
												<c:if test="${adminLogined.level == 2}">
													<a href="AdminManager_removeLink?aid=${one.adminId}#header" class="button">解除绑定</a>
												</c:if>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
								<hr />
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight">
										<c:if test="${adminLogined.adminId == one.adminId || adminLogined.level == 2}">
											<input type="submit" value="修改" class="button"/>
										</c:if>
										<c:if test="${adminLogined.level == 2}">
											<a href="AdminManager_delete?aid=${one.adminId}#header" class="button">删除</a>
										</c:if>
										<a class="button" href="AdminManager_view#header">返回</a>
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