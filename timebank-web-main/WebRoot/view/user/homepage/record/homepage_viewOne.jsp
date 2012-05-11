<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>查看互助记录</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
	<link href="/TimeBank/CSS/styleTable.css" rel="stylesheet" type="text/css" media="screen" />
	<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
	<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
	<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
	<link href="/TimeBank/CSS/styleHelpRecord.css" rel="stylesheet" type="text/css" media="screen" />
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
				<h2 class="title"><a href="#">查看互助记录</a><c:if test="${!empty message}"> - <span class="warn">${message}</span></c:if></h2>
				<p class="meta">
					<a id="tip" href="#">
						<jsp:include page="${path}/view/common/part/user/sidebar/balance.jsp"/>
						<span id="tip_info">
							温馨提示：1个时间币=1小时服务时间，您可以在本银行存入或提取时间币。
						</span>
					</a>
				</p>
				<div class="entry">
					<!-- 模板
						<div class="rowH clear">
							<div class="partL"></div>
							<div class="partC"></div>
							<div class="partR"></div>
						</div>
					 -->
					<fieldset>
						<div class="fieldset">
							<div class="rowH clear">
							<div class="partL">
								<c:if test="${one.requireBy == 2}">&nbsp;
									<span class="emphasized">(申请人)</span>
								</c:if>
							</div>
							<div class="partC"></div>
							<div class="partR">
								<c:if test="${one.requireBy == 1}">&nbsp;
									<span class="emphasized">(申请人)</span>
								</c:if>
							</div>
							</div>
							<div class="rowH clear">
								<div class="partL">
									<img class="userPicture120" src="${userHelped.picture}" alt="求助者" />
								</div>
								<div class="partC">
									<img src="/TimeBank/CSS/images/arrow.jpg" alt="" />
								</div>
								<div class="partR">
									<img class="userPicture120" src="${userToHelp.picture}" alt="帮助者" />
								</div>
							</div>
							<div class="rowH clear">
								<div class="partL">
									求助者
									<span class="emphasized">
										<c:choose>
											<c:when test="${one.helpedUserId == user.userId}">我</c:when>
											<c:otherwise>${one.helpedUsername}</c:otherwise>
										</c:choose>
									</span>说↓
								</div>
								<div class="partC"></div>
								<div class="partR">
									帮助者
									<span class="emphasized">
										<c:choose>
											<c:when test="${one.toHelpUserId == user.userId}">我</c:when>
											<c:otherwise>${one.toHelpUsername}</c:otherwise>
										</c:choose>
									</span>说↓
								</div>
							</div>
							<div class="rowH clear">
								<div class="partL">
									<fieldset>
										<div class="desc emphasized">
											${one.descriptionHelped}
											<br />
											<br />
											<c:choose>
												<c:when test="${one.statusHelp == 2 || one.statusHelp == 4}">
													<hr />
													我的联系方式：<br/>
													Email：${userHelped.email}<br />
													手机：${userHelped.phoneLong}<br />
													短号：${userHelped.phoneShort}<br/>
													<c:if test="${one.statusHelp == 4}">
														<c:choose>
															<c:when test="${one.userHelpedScore == 0}">
																<hr/>
																尚未提交评价与反馈。
															</c:when>
															<c:otherwise>
																<hr/>
																Ta给的评价是${one.userHelpedScore}颗星<br/>
															</c:otherwise>
														</c:choose>
													</c:if>
												</c:when>
											</c:choose>
										</div>
									</fieldset>
								</div>
								<div class="partC">
									时间：
									<span class="emphasized">
										<c:choose>
											<c:when test="${empty withdrawRecord.theDate}">
												双方商讨日期
											</c:when>
											<c:otherwise>
												${withdrawRecord.theDate}
											</c:otherwise>
										</c:choose>
										|
										<c:choose>
											<c:when test="${one.theTime == 1}">第1、2节</c:when>
											<c:when test="${one.theTime == 2}">第3、4节</c:when>
											<c:when test="${one.theTime == 3}">整个上午</c:when>
											<c:when test="${one.theTime == 4}">第5、6节</c:when>
											<c:when test="${one.theTime == 5}">第7、8节</c:when>
											<c:when test="${one.theTime == 6}">第9、10节</c:when>
											<c:when test="${one.theTime == 7}">整个下午</c:when>
											<c:when test="${one.theTime == 8}">第11、12节</c:when>
											<c:when test="${one.theTime == 9}">整个白天</c:when>
											<c:when test="${one.theTime == 10}">整个晚上</c:when>
											<c:when test="${one.theTime == 11}">一整天</c:when>
											<c:when test="${one.theTime == 12}">其它</c:when>
											<c:when test="${one.theTime == 13}">双方协商时间</c:when>
										</c:choose>
									</span>
									<br />
									地点：
									<span class="emphasized">
										<c:choose>
											<c:when test="${one.zone == 1}">
												启林南
											</c:when>
											<c:when test="${one.zone == 2}">
												启林北
											</c:when>
											<c:when test="${one.zone == 3}">
												五山
											</c:when>
											<c:when test="${one.zone == 4}">
												华山
											</c:when>
											<c:when test="${one.zone == 5}">
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
											<c:when test="${one.range == 1}">知识技能类</c:when>
											<c:when test="${one.range == 2}">休闲娱乐类</c:when>
											<c:when test="${one.range == 3}">体育运动类</c:when>
											<c:when test="${one.range == 4}">劳动修缮类</c:when>
											<c:when test="${one.range == 5}">其它[在详细说明中描述]</c:when>
											<c:otherwise>获取状态出错！</c:otherwise>
										</c:choose>
									</span>
									<br />
									状态：
									<span class="warn">
										<c:choose>
											<c:when test="${one.statusHelp == 1}">
												申请中，待审核
												<br />
												<div class="statusDesc"><span class="tips">请等待管理员的电话审核，谢谢！</span></div>
											</c:when>
											<c:when test="${one.statusHelp == 2}">
												已确认，并通过
												<br />
												<div class="statusDesc"><span class="tips">现在你们可以查看对方的联系方式并和对方取得联系！</span></div>
											</c:when>
											<c:when test="${one.statusHelp == 3}">
												已确认，不通过
												<br />
												原因：
												<br />
												<span>${one.whyVerifyFailure}</span>
											</c:when>
											<c:when test="${one.statusHelp == 4}">
												互助成功
												<br />
												<div class="statusDesc">恭喜你们互助成功！</div>
											</c:when>
											<c:when test="${one.statusHelp == 5}">
												互助失败
												<br />
												<div class="statusDesc"><span class="tips">很遗憾，此次互助失败……</span></div>
											</c:when>
											<c:otherwise>状态获取出错！</c:otherwise>
										</c:choose>
									</span>
									<c:if test="${one.statusHelp == 5}">
										<hr />
										<div>
											失败原因：<br />
											${one.whyFailure}
											<span class="tips">
												(由
												<c:choose>
													<c:when test="${one.failureBy == 1}">
														帮助者
													</c:when>
													<c:when test="${one.failureBy == 2}">
														求助者
													</c:when>
													<c:when test="${one.failureBy == 3}">
														管理员
													</c:when>
												</c:choose>
												提交)
											</span><br />
										</div>
									</c:if>
									<br />
									<c:if test="${one.toHelpUserId == user.userId && 
												 ((one.statusHelp == 2 && one.userToHelpScore == 0) ||
												 (one.statusHelp == 4 && one.userToHelpScore == 0))}">
										<hr />
										<form action="/TimeBank/user/Homepage_toHelpFeedback" method="post"><!-- 帮助者看到的 -->
											<div>
											<input type="hidden" name="one.helpRecordId" value="${one.helpRecordId}"/>
											我们已完成互助，我要为对方的表现评星级：<br/>
											<input type="radio" name="one.userToHelpScore" value="1" id="r1"/>
											<label for="r1">1颗星(很差)</label><br/>
											<input type="radio" name="one.userToHelpScore" value="2" id="r2"/>
											<label for="r2">2颗星(较差)</label><br/>
											<input type="radio" name="one.userToHelpScore" value="3" id="r3" checked="checked"/>
											<label for="r3">3颗星(一般)</label><br/>
											<input type="radio" name="one.userToHelpScore" value="4" id="r4"/>
											<label for="r4">4颗星(较好)</label><br/>
											<input type="radio" name="one.userToHelpScore" value="5" id="r5"/>
											<label for="r5">5颗星(很好)</label><br/>
											另外，我还想反馈[管理员可见]：<br />
											<textarea cols="30" rows="5" name="one.userToHelpFeedback"></textarea><br />
											<input type="submit" class="button" value="提交反馈"/>
											</div>
										</form>
									</c:if>
									<c:if test="${one.helpedUserId == user.userId && 
												 ((one.statusHelp == 2 && one.userHelpedScore == 0) ||
												 (one.statusHelp == 4 && one.userHelpedScore == 0))}">
										<hr />
										<form action="/TimeBank/user/Homepage_helpedFeedback" method="post"><!-- 求助者看到的 -->
											<div>
											<input type="hidden" name="one.helpRecordId" value="${one.helpRecordId}"/>
											我们已完成互助，我要为对方的表现评星级：<br/>
											<input type="radio" name="one.userHelpedScore" value="1" id="r1"/>
											<label for="r1">1颗星(很差)</label><br/>
											<input type="radio" name="one.userHelpedScore" value="2" id="r2"/>
											<label for="r2">2颗星(较差)</label><br/>
											<input type="radio" name="one.userHelpedScore" value="3" id="r3" checked="checked"/>
											<label for="r3">3颗星(一般)</label><br/>
											<input type="radio" name="one.userHelpedScore" value="4" id="r4"/>
											<label for="r4">4颗星(较好)</label><br/>
											<input type="radio" name="one.userHelpedScore" value="5" id="r5"/>
											<label for="r5">5颗星(很好)</label><br/>
											另外，我还想反馈[管理员可见]：<br />
											<textarea cols="30" rows="5" name="one.userHelpedFeedback"></textarea><br />
											<input type="submit" class="button" value="提交反馈"/>
											</div>
										</form>
									</c:if>
									<c:if test="${one.statusHelp == 2}">
										<hr/>
										<form action="/TimeBank/user/Homepage_helpFailed" method="post">
											<div>
												<input type="hidden" name="one.helpRecordId" value="${one.helpRecordId}"/>
												<c:choose>
													<c:when test="${user.userId == one.toHelpUserId}">
														<input type="hidden" name="one.failureBy" value="1"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="one.failureBy" value="2"/>
													</c:otherwise>
												</c:choose>
												<span class="warn">或者……互助最终没有进行？</span><br />
												<span class="tips">请在下方输入原因并提交：</span>
												<textarea cols="30" rows="5" name="one.whyFailure"></textarea><br />
												<input type="submit" class="button" value="提交失败原因"/>
											</div>
										</form>
									</c:if>
								</div>
								<div class="partR">
									<fieldset>
										<div class="desc emphasized">
											${one.descriptionToHelp}
											<br />
											<br />
											<c:choose>
												<c:when test="${one.statusHelp == 2 || one.statusHelp == 4}">
													<hr />
													我的联系方式：<br/>
													Email：${userToHelp.email}<br />
													手机：${userToHelp.phoneLong}<br />
													短号：${userToHelp.phoneShort}<br/>
													<c:if test="${one.statusHelp == 4}">
														<c:choose>
															<c:when test="${one.userToHelpScore == 0}">
																<hr/>
																尚未提交评价与反馈。
															</c:when>
															<c:otherwise>
																<hr/>
																Ta给的评价是${one.userToHelpScore}颗星<br/>
															</c:otherwise>
														</c:choose>
													</c:if>
												</c:when>
											</c:choose>
										</div>
									</fieldset>
								</div>
							</div>
						</div>
					</fieldset>
					 
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