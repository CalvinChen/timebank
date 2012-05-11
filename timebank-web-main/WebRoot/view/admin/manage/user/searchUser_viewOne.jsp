<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>查看或修改${user.username}(${user.name})的详细信息 - 用户管理</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet"
			type="text/css" media="screen" />
		<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet"
			type="text/css" media="screen" />
		<link href="/TimeBank/CSS/styleSidebarOfHomepage.css" rel="stylesheet"
			type="text/css" media="screen" />
		<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet"
			type="text/css" media="screen" />
		<link href="/TimeBank/CSS/styleInfo.css" rel="stylesheet"
			type="text/css" media="screen" />
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
									查看或修改
									<span class="emphasized">${user.username}</span>(${user.name})
									的详细信息</a>
								<c:if test="${!empty message}">
									<span class="warn"> - ${message}</span>
								</c:if>
							</h2>
							<p class="meta">
								<a id="tip" href="#"> 最近更新信息时间：${user.updateTime} </a>
							</p>
							<div class="entry">
								<form 
									<c:choose>
										<c:when test="${user.isUsed == 0}">action="SearchUser_register"</c:when>
										<c:when test="${user.isUsed == 1}">action="SearchUser_submit"</c:when>
									</c:choose> 
									method="post">
								<fieldset>
									<input type="hidden" name="user.userId" value="${user.userId}"/>
									<div class="picInfoAll clear">
										<div class="picInfoLeft">
											<img class="userPicture120" src="${user.picture}" alt="头像" />
											<br />
											<c:if test="${user.isUsed == 1}">
												<a href="SearchUser_resetPsw?uid=${user.userId}" class="button">重置密码</a>
											</c:if>
										</div>
										<div class="picInfoRight">
											<h2>
											<span class="tips">
											用户名|
											</span>
											<input type="text" name="user.username" value="${user.username}"/>
											</h2>
											姓名
											|
											<span class="emphasized">
												<input type="text" name="user.name" value="${user.name}"/>
											</span>
											<br />
											电邮
											|
											<span class="emphasized">
												<input type="text" name="user.email" value="${user.email}"/>
											</span>
											<br />
											<c:if test="${user.isUsed == 1}">
												<span>手机</span>
												|
												<span class="emphasized">
													<input type="text" name="user.phoneLong" value="${user.phoneLong}"/>
												</span>
												<br />
												<span>短号</span>
												|
												<span class="emphasized">
													<input type="text" name="user.phoneShort" value="${user.phoneShort}"/>
												</span>
												<br/>
											</c:if>
											<br/>
										</div>
										<div class="picInfoRight1">
											<c:choose>
												<c:when test="${user.isUsed == 1}">
													(
														已通过验证：
														<span>
															<input type="radio" name="user.isVerified" value="1" id="r1" 
																<c:if test="${user.isVerified == 1}">checked="checked"</c:if>
															/>													
															<label for="r1" <c:if test="${user.isVerified == 1}">class="warn"</c:if>>
																是
															</label>
															<input type="radio" name="user.isVerified" value="0" id="r0" 
																<c:if test="${user.isVerified == 0}">checked="checked"</c:if>
															/>
															<label for="r1" <c:if test="${user.isVerified == 0}">class="warn"</c:if>>
																否
															</label>
														</span>
													)
												</c:when>
												<c:when test="${user.isUsed == 0}">
													(未注册)
												</c:when>
											</c:choose>
											<c:if test="${adminLogined.level == 2 && user.isUsed != 0}">
												<a class="button supertips" href="AdminManager_promote?uid=${user.userId}" title="提拔？" rel="#tiba">
													提拔为管理员
												</a>
												<div id="tiba" style="display: none;">
													点击此按钮后此用户将可以使用Ta原来的账号与密码登陆后台！
												</div>
											</c:if>
										</div>
									</div>
									<div class="infoAll clear">
										<div class="infoLeft">
											<div class="pair clear">
												<div class="key">
													年级：
												</div>
												<div class="value">
													<span class="emphasized">
														<input type="text" name="user.grade" value="${user.grade}"/>
													</span>
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													学院：
												</div>
												<div class="value">
													<span class="emphasized">
														<jsp:include page="${path}/view/common/part/function/setCollege.jsp" />
													</span>
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													专业：
												</div>
												<div class="value">
													<span class="emphasized">
														<input type="text" name="user.major" value="${user.major}"/>
													</span>
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													班级：
												</div>
												<div class="value">
													<span class="emphasized">
														<input type="text" name="user.classId" value="${user.classId}"/>
													</span>
												</div>
											</div>
										</div>
										<div class="infoRight">
											<div class="pair clear">
												<div class="key">
													性别：
												</div>
												<div class="value">
													<span class="emphasized">
														<jsp:include page="${path}/view/common/part/function/setSex.jsp" />
													</span>
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													学号：
												</div>
												<div class="value">
													<span class="emphasized">
														<input type="text" name="user.studentId" value="${user.studentId}"/>
													</span>
												</div>
											</div>
											<c:if test="${user.isUsed == 1}">
											<div class="pair clear">
												<div class="key">
													居住区域：
												</div>
												<div class="value">
													<span class="emphasized"> 
														<jsp:include page="${path}/view/common/part/function/setZone.jsp" />
													</span>
												</div>
											</div>
											</c:if>
										</div>
									</div>
									<c:if test="${user.isUsed == 1}">
									<hr/>
									<div class="infoAll clear">
										<div class="infoLeft">
											<div class="pair clear">
												<div class="key">
													QQ：
												</div>
												<div class="value">
													<span class="emphasized">
														<input type="text" name="user.qq" value="${user.qq}"/>
													</span>
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													微博：
												</div>
												<div class="value">
													<span class="emphasized">
														<input type="text" name="user.weibo" value="${user.weibo}"/>
														<c:if test="${!empty user.weibo}">
															<br/>
															<a href="${user.weibo}" target="_BLANK">@${user.username}的微博</a>
														</c:if>
													</span>
												</div>
											</div>
										</div>
										<div class="infoRight">
											<div class="pair clear">
												<div class="key">
													宿舍地址：
												</div>
												<div class="value">
													<span class="emphasized">
														<input type="text" name="user.address" value="${user.address}"/>
													</span>
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													博客：
												</div>
												<div class="value">
													<span class="emphasized">
														<input type="text" name="user.blog" value="${user.blog}"/>
														<c:if test="${!empty user.blog}">
															<br/>
															<a href="${user.blog}" target="_BLANK">${user.username}的博客</a>
														</c:if>
													</span>
												</div>
											</div>
										</div>
									</div>
									</c:if>
									<div class="infoAll clear">
										<div class="infoLeft clear">
											<div class="pair clear">
												<div class="key">&nbsp;
												</div>
												<div class="value">
													<c:choose>
														<c:when test="${user.isUsed == 0}">
															<input class="button" type="submit" value="补全用户名及Email，代为注册！"/>
														</c:when>
														<c:when test="${user.isUsed == 1}">
															<input type="submit" value="修改好信息了，点击更新！" class="button"/>
														</c:when>
													</c:choose>
												</div>
											</div>
										</div>
										<div class="infoRight clear">
											<div class="pair clear">
												<div class="key">&nbsp;
												</div>
												<div class="value">
												<c:if test="${user.isUsed == 1}">
													<a href="SearchUser_downloadUser?uid=${user.userId}" class="button" target="_blank">使用此用户账号！</a>
												</c:if>
												</div>
											</div>
										</div>
									</div>
								</fieldset>
								<fieldset>
									<legend>技能储备</legend>
									<div class="oneRow clear">
										<div class="rowLeft emphasized"></div>
										<div class="rowRight">
											<h2>
											<span class="emphasized">
												Ta共有
												<span class="warn">
													${count}
												</span>
												项【技能储备】。
											</span>
											</h2>
										</div>
									</div>
									<c:if test="${count != 0}">
										<hr/>
										<jsp:include page="${path}/view/common/part/function/read15RangesAdmin.jsp" />
									</c:if>
								</fieldset>
								<fieldset>
									<legend>时间储备</legend>
									<div class="oneRow clear">
										<div class="rowLeft emphasized"></div>
										<div class="rowRight">
											<h2>
											<span class="emphasized">
												Ta共有
												<span class="warn">
													${count1}
												</span>
												项【时间储备】。
											</span>
											</h2>
										</div>
									</div>
									<c:if test="${count1 != 0}">
										<hr/>
										<jsp:include page="${path}/view/common/part/function/read7DaysAdmin.jsp" />
									</c:if>
								</fieldset>
								</form>
							</div>
						</div>
					</div>
					<!-- end #content -->
		<jsp:include page="${path}/view/common/part/admin/sidebar/search_user.jsp"/>
					<div style="clear: both;">
						&nbsp;
					</div>
				</div>
			</div>
			<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
		</div>
	</body>
</html>