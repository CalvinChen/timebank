<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>个人中心</title>
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
			<jsp:include page="${path}/view/common/part/user/head.jsp"/>
			<div id="page">
				<div id="page-bgtop">
					<div id="content">
						<div class="post">
							<h2 class="title">
								<a href="#">我的信息概览</a>
							</h2>
							<p class="meta">
								<a id="tip" href="#"> 最近更新信息时间：${user.updateTime} <span
									id="tip_info"> 温馨提示：请尽量将您的个人信息保持最新！ </span> </a>
							</p>
							<div class="entry">
								<fieldset>
									<div class="picInfoAll clear">
										<div class="picInfoLeft clear">
											<a href="/TimeBank/user/Homepage_viewPic">
												<img class="userPicture120" src="${user.picture}" alt="头像" />
											</a>
										</div>
										<div class="picInfoRight clear">
											<h2>
												${user.username}
												(
													<c:choose>
														<c:when test="${userLogined.isVerified == 0}">
															<div id="m1" style="display: none;">
																是指您虽然成功注册了账号，但是您的身份还未得到我们的验证。<br />
																<hr />
																这是我们为了保障所有华农学生的身份不被顶替所采取的措施，所有用户必须验证之后才可以使用<span class="emphasized">存储时间</span>和<span class="emphasized">提取时间</span>功能。<br />
																<hr />
																请您点击链接查看具体验证方式。
															</div>
															<span class="supertips" title="未验证身份？" rel="#m1">
																<a href="../Article_viewOne?articleId=5#flag" title="" id="message">
																	未验证身份
																	<img src="/TimeBank/CSS/images/tip.png" alt="" class="pictureTip"/>
																</a>
															</span>
														</c:when>
														<c:when test="${userLogined.isVerified == 1}">
															已通过验证
														</c:when>
														<c:otherwise>出错！</c:otherwise>
													</c:choose>
												)
											</h2>
											<span class="emphasized">${user.name}</span>
											|
											<span class="emphasized">${user.email}</span>
											<br />
											<c:if test="${!empty user.phoneLong}">
												<span>手机</span>
												|
												<span class="emphasized">${user.phoneLong}</span>
												<br />
											</c:if>
											<c:if test="${!empty user.phoneShort}">
												<span>短号</span>
												|
												<span class="emphasized">${user.phoneShort}</span>
												<br/>
											</c:if>
											<c:if test="${empty user.phoneShort && empty user.phoneLong}">
												<div id="m2" style="display: none;">
													电话联系是您使用时间银行时间存取业务时，互助双方以及时间银行工作人员之间联系的主要方式。<br />
													请您如实填写，以便进行方便、快捷的联系，谢谢！
												</div>
												<span class="supertips" title="手机号码" rel="#m2">
													<a href="/TimeBank/user/Homepage_viewContact" id="message">
														请填写您的手机长号或短号至少一个。
														<img src="/TimeBank/CSS/images/tip.png" alt="" class="pictureTip"/>
													</a>
												</span>
											</c:if>
										</div>
										<div class="picInfoRight1 clear">
											我的账户上还有
											<span class="bigNum">
												${balance}
											</span>
											个时间币！
											<img src="/TimeBank/CSS/images/coin.png" alt="时间币" class="pic40"/>
											
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
														<c:choose>
															<c:when test="${user.grade == 0 || empty user.grade}">
																（未填）
															</c:when>
															<c:otherwise>
																${user.grade}级
															</c:otherwise>
														</c:choose>
													</span>
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													学院：
												</div>
												<div class="value">
													<span class="emphasized">
														<jsp:include page="${path}/view/common/part/function/readCollege.jsp" />
													</span>
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													专业：
												</div>
												<div class="value">
													<span class="emphasized">
														<c:choose>
															<c:when test="${empty user.major}">
																（未填）
															</c:when>
															<c:otherwise>
																${user.major}
															</c:otherwise>
														</c:choose>
													</span>
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													班级：
												</div>
												<div class="value">
													<span class="emphasized">
														<c:choose>
															<c:when test="${user.classId == 0 || empty user.classId}">
																（未填）
															</c:when>
															<c:otherwise>
																${user.classId}班
															</c:otherwise>
														</c:choose>
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
														<jsp:include page="${path}/view/common/part/function/readSex.jsp" />
													</span>
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													学号：
												</div>
												<div class="value">
													<span class="emphasized">
														<c:choose>
															<c:when test="${empty user.studentId}">
																（未填）
															</c:when>
															<c:otherwise>
																${user.studentId}
															</c:otherwise>
														</c:choose> 
													</span>
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													居住区域：
												</div>
												<div class="value">
													<span class="emphasized"> 
														<jsp:include page="${path}/view/common/part/function/readZone.jsp" />
													</span>
												</div>
											</div>
										</div>
									</div>
									<hr/>
									<div class="infoAll clear">
										<div class="infoLeft">
											<div class="pair clear">
												<div class="key">
													QQ：
												</div>
												<div class="value">
													<span class="emphasized">
														<c:choose>
															<c:when test="${empty user.qq}">
																（未填）
															</c:when>
															<c:otherwise>
																${user.qq}
															</c:otherwise>
														</c:choose>
													</span>
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													微博：
												</div>
												<div class="value">
													<span class="emphasized">
														<c:choose>
															<c:when test="${empty user.weibo}">
																（未填）
															</c:when>
															<c:otherwise>
																<a href="${user.weibo}" target="_BLANK">@${user.username}的微博</a>
															</c:otherwise>
														</c:choose>
													</span>
												</div>
											</div>
										</div>
										<div class="infoRight">
											<div class="pair clear">
												<div class="key">
													博客：
												</div>
												<div class="value">
													<span class="emphasized">
														<c:choose>
															<c:when test="${empty user.blog}">
																（未填）
															</c:when>
															<c:otherwise>
																${user.blog}
															</c:otherwise>
														</c:choose>
													</span>
												</div>
											</div>
											<div class="pair">
												<div class="key">
													宿舍地址：
												</div>
												<div class="value">
													<span class="emphasized">
														<c:choose>
															<c:when test="${empty user.address}">
																（未填）
															</c:when>
															<c:otherwise>
																${user.address}
															</c:otherwise>
														</c:choose>
													</span>
												</div>
											</div>
										</div>
									</div>
								</fieldset>
								<hr />
							</div>
						</div>
					</div>
					<!-- end #content -->
		<jsp:include page="${path}/view/common/part/user/sidebar/homepage.jsp"/>
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