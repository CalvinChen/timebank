<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理中心</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHelpRecord.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleOperation.css" rel="stylesheet" type="text/css" media="screen" />
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
				<h2 class="title">
					<a href="#">
						查看互助记录信息
					</a>
					<span class="warn"><c:if test="${!empty message}"> - ${message}</c:if></span>
				</h2>
				<div class="entry">
						
						<fieldset>
						<div class="fieldset">
							<!-- 第一行 双方姓名信息 -->
							<div class="rowH clear">
								<div class="partL">
									<c:if test="${singleRecord.requireBy == 2}">&nbsp;
										<span class="emphasized">(申请人)</span><br/>
										<span class="tips">
											于
											${singleRecord.createTime}
											申请
										</span>
									</c:if>
								</div>
								<div class="partC"></div>
								<div class="partR">
									<c:if test="${singleRecord.requireBy == 1}">&nbsp;
										<span class="emphasized">(申请人)</span><br/>
										<span class="tips">
											于
											${singleRecord.createTime}
											申请
										</span>
									</c:if>
								</div>
							</div>
							<!-- 第二行 双方头像 -->
							<div class="rowH clear">
								<div class="partL">
									<a target="_blank" href="/TimeBank/admin/SearchUser_viewOne?uid=${singleRecord.helpedUserId}#header">
										<img class="userPicture120" src="${singleRecord.helpedPicture}" alt="求助者" />
									</a>
								</div>
								<div class="partC">
									<img src="/TimeBank/CSS/images/arrow.jpg" alt="" />
								</div>
								<div class="partR">
									<a target="_blank" href="/TimeBank/admin/SearchUser_viewOne?uid=${singleRecord.toHelpUserId}#header">
										<img class="userPicture120" src="${singleRecord.toHelpPicture}" alt="帮助者" />
									</a>
								</div>
							</div>
							
							<!-- 第三行 -->
							<div class="rowH clear">
								<div class="partL">
									求助者
									<span class="emphasized">
										<a target="_blank" href="/TimeBank/admin/SearchUser_viewOne?uid=${singleRecord.helpedUserId}#header">
											${singleRecord.helpedUsername}
										</a>
									</span>说↓
								</div>
								<div class="partC"></div>
								<div class="partR">
									帮助者
									<span class="emphasized">
										<a target="_blank" href="/TimeBank/admin/SearchUser_viewOne?uid=${singleRecord.toHelpUserId}#header">
											${singleRecord.toHelpUsername}
										</a>
									</span>说↓
								</div>
							</div>
							
							<!-- 第四行 信息、描述与反馈 -->
							<div class="rowH clear">
								<div class="partL">
									<fieldset>
										<div class="desc emphasized">
											${singleRecord.descriptionHelped}
											<br />
											<br />
											<c:if test="${singleRecord.statusHelp == 4}">
												<c:choose>
													<c:when test="${singleRecord.userHelpedScore == 0}">
														<hr/>
														尚未提交评价与反馈。
													</c:when>
													<c:otherwise>
														<hr/>
														Ta给的评价是${singleRecord.userHelpedScore}颗星<br/>
																<c:choose>
																	<c:when test="${!empty singleRecord.userHelpedFeedback}">
																		并说：${singleRecord.userHelpedFeedback}
																	</c:when>
																	<c:otherwise>
																		没有反馈内容。
																	</c:otherwise>
																</c:choose>
													</c:otherwise>
												</c:choose>
											</c:if>
										</div>
									</fieldset>
								</div>
								<div class="partC">
									时间：
									<span class="emphasized">
										<c:choose>
											<c:when test="${empty singleRecord.theDate}">双方协商</c:when>
											<c:otherwise>${singleRecord.theDate}</c:otherwise>
										</c:choose>
										|
										<c:choose>
											<c:when test="${singleRecord.theTime == 1}">第1、2节</c:when>
											<c:when test="${singleRecord.theTime == 2}">第3、4节</c:when>
											<c:when test="${singleRecord.theTime == 3}">整个上午</c:when>
											<c:when test="${singleRecord.theTime == 4}">第5、6节</c:when>
											<c:when test="${singleRecord.theTime == 5}">第7、8节</c:when>
											<c:when test="${singleRecord.theTime == 6}">第9、10节</c:when>
											<c:when test="${singleRecord.theTime == 7}">整个下午</c:when>
											<c:when test="${singleRecord.theTime == 8}">第11、12节</c:when>
											<c:when test="${singleRecord.theTime == 9}">整个白天</c:when>
											<c:when test="${singleRecord.theTime == 10}">整个晚上</c:when>
											<c:when test="${singleRecord.theTime == 11}">一整天</c:when>
											<c:when test="${singleRecord.theTime == 12}">其它</c:when>
											<c:when test="${singleRecord.theTime == 13}">双方协商</c:when>
										</c:choose>
									</span>
									<br />
									地点：
									<span class="emphasized">
										<c:choose>
											<c:when test="${singleRecord.zone == 1}">
												启林南
											</c:when>
											<c:when test="${singleRecord.zone == 2}">
												启林北
											</c:when>
											<c:when test="${singleRecord.zone == 3}">
												五山
											</c:when>
											<c:when test="${singleRecord.zone == 4}">
												华山
											</c:when>
											<c:when test="${singleRecord.zone == 5}">
												其它
											</c:when>
											<c:otherwise>
												读取出错！
											</c:otherwise>
										</c:choose> 
									</span>
									<br />
									范围：
									<span class="emphasized">
										<c:choose>
											<c:when test="${singleRecord.range == 1}">知识技能类</c:when>
											<c:when test="${singleRecord.range == 2}">休闲娱乐类</c:when>
											<c:when test="${singleRecord.range == 3}">体育运动类</c:when>
											<c:when test="${singleRecord.range == 4}">劳动修缮类</c:when>
											<c:when test="${singleRecord.range == 5}">其它[在详细说明中描述]</c:when>
											<c:otherwise>获取状态出错！</c:otherwise>
										</c:choose>
									</span>
									<br />
									状态：
									<span class="warn">
										<c:choose>
											<c:when test="${singleRecord.statusHelp == 1}">
												申请中，待审核
												<br />
												<div class="statusDesc"><span class="tips">等待管理员的电话审核</span></div>
											</c:when>
											<c:when test="${singleRecord.statusHelp == 2}">
												已确认，并通过
												<br />
												<div class="statusDesc"><span class="tips">可以查看对方的联系方式并和对方取得联系</span></div>
											</c:when>
											<c:when test="${singleRecord.statusHelp == 3}">
												已确认，不通过
												<br />
											</c:when>
											<c:when test="${singleRecord.statusHelp == 4}">
												互助成功
												<br />
											</c:when>
											<c:when test="${singleRecord.statusHelp == 5}">
												互助失败
												<br />
											</c:when>
											<c:otherwise>状态获取出错！</c:otherwise>
										</c:choose>
									</span>
									<c:if test="${singleRecord.statusHelp == 5}">
										<hr />
										<div>
											失败原因：<br />
											${singleRecord.whyFailure}
											<span class="tips">
												(由
												<c:choose>
													<c:when test="${singleRecord.failureBy == 1}">
														帮助者
													</c:when>
													<c:when test="${singleRecord.failureBy == 2}">
														求助者
													</c:when>
													<c:when test="${singleRecord.failureBy == 3}">
														管理员
													</c:when>
												</c:choose>
												提交)
											</span><br />
										</div>
									</c:if>
									<br />
									<c:if test="${singleRecord.statusHelp != 1}">
										(由
										${singleRecord.verifier}
										于
										${singleRecord.verifiedTime}
										审核)
										<br />
									</c:if>
									
								</div>
								<div class="partR">
									<fieldset>
										<div class="desc emphasized">
											${singleRecord.descriptionToHelp}
											<br />
											<br />
													<c:if test="${singleRecord.statusHelp == 4}">
														<c:choose>
															<c:when test="${singleRecord.userToHelpScore == 0}">
																<hr/>
																尚未提交评价与反馈。
															</c:when>
															<c:otherwise>
																<hr/>
																Ta给的评价是${singleRecord.userToHelpScore}颗星<br/>
																<c:choose>
																	<c:when test="${!empty singleRecord.userToHelpFeedback}">
																		并说：${singleRecord.userToHelpFeedback}
																	</c:when>
																	<c:otherwise>
																		没有反馈内容。
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
													</c:if>
										</div>
									</fieldset>
								</div>
							</div>
							<hr />
							<!-- 管理员处理栏 -->
									<c:if test="${singleRecord.statusHelp == 1}">
										<div class="oneRow clear">
											<div class="rowLeft">1.</div>
											<div class="rowRight">
												<a class="button" href="HomepageAdmin_handleHelpRecord?select=2&helpRecordId=${singleRecord.helpRecordId}">审核完毕，通过申请！</a>
											</div>
										</div>
										<div class="oneRow clear">
											<div class="rowLeft">2.</div>
											<div class="rowRight">
												<hr />
												因为以下原因：<br />
												<form action="HomepageAdmin_handleHelpRecord" method="post">
													<div>
														<input type="hidden" name="select" value="3"/>
														<input type="hidden" name="helpRecordId" value="${singleRecord.helpRecordId}"/>
														<textarea rows="5" cols="50" name="whyVerifyFailure"></textarea><br />
														<input type="submit" value="所以审核不通过！" class="button"/>
													</div>
												</form>
											</div>
										</div>
									</c:if>
									<c:if test="${singleRecord.statusHelp == 3}">
										<div class="oneRow clear">
											<div class="rowLeft"></div>
											<div class="rowRight">
												<hr />
												因为以下原因而审核不通过：<br />
												<span class="emphasized">${singleRecord.whyVerifyFailure}</span>
											</div>
										</div>
									</c:if>
						</div>
					</fieldset>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/admin/sidebar/homepage.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>