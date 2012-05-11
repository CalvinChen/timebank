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
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfHomepage.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleTableHelp.css" rel="stylesheet" type="text/css" media="screen" />
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
						处理互助
						<c:if test="${!empty message}">
							<span id="message"> - ${message}</span>
						</c:if>
					</a>
				</h2>
				<div class="entry">
					<fieldset>
						<legend class="emphasized">
							<a href="HomepageAdmin_recordUnhandled" <c:if test="${count1 != 0}">class="warn"</c:if>>
								未处理的互助申请
								<span class="tips">(${count1}条)</span>
							</a>
						</legend>
						<table id="tableHelp">
	<thead id="thead">
		<tr>
			<td>
				<div class="cellHead">求助者</div>
			</td>
			<td>
				<div class="cellHead">帮助者</div>
			</td>
			<td>
				<div class="cellHead">互助内容</div>
			</td>
			<td>
				<div class="cellHead">时间地点</div>
			</td>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty unhandleRecordList}">
				<tr>
					<td colspan="5">暂无数据。</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${unhandleRecordList}" var="one" varStatus="i">
							<tr <c:if test="${i.count % 2 == 0}">class="doubleLine"</c:if>>
								<td>
									<div class="cellUser">
										<a target="_blank" href="/TimeBank/admin/SearchUser_viewOne?uid=${one.helpedUserId}#header">
											<img class="userPicture60" src="${one.helpedPicture}" alt="${one.helpedUsername}" /><br />
											<span class="emphasized">${one.helpedUsername}</span>
										</a>
									</div>
								</td>
								<td>
									<div class="cellUser">
										<a target="_blank" href="/TimeBank/admin/SearchUser_viewOne?uid=${one.toHelpUserId}#header">
											<img class="userPicture60" src="${one.toHelpPicture}" alt="${one.toHelpUsername}" /><br />
											<span class="emphasized">${one.toHelpUsername}</span>
										</a>
									</div>
								</td>
								<td>
									<div class="cellRecord">
										<span id="message">
											<c:choose>
												<c:when test="${one.statusHelp == 1}">
													申请中，待审核
												</c:when>
												<c:when test="${one.statusHelp == 2}">
													已确认，并通过（可查看双方联系方式）
												</c:when>
												<c:when test="${one.statusHelp == 3}">
													已确认，不通过
												</c:when>
												<c:when test="${one.statusHelp == 4}">
													互助成功
												</c:when>
												<c:when test="${one.statusHelp == 5}">
													互助失败
												</c:when>
												<c:otherwise>状态获取出错！</c:otherwise>
											</c:choose>
										</span>
										<div class="cellDesc">
											<a href="HomepageAdmin_singleRecord?helpRecordId=${one.helpRecordId}">
												<c:choose>
													<c:when test="${one.range == 1}">知识技能类</c:when>
													<c:when test="${one.range == 2}">休闲娱乐类</c:when>
													<c:when test="${one.range == 3}">体育运动类</c:when>
													<c:when test="${one.range == 4}">劳动修缮类</c:when>
													<c:when test="${one.range == 5}">其它[在详细说明中描述]</c:when>
													<c:otherwise>获取状态出错！</c:otherwise>
												</c:choose>
											</a>
										</div>
										<div class="cellRange tips">
											<c:choose>
												<c:when test="${one.requireBy == 1}">
													（由
													<span class="emphasized">
														<c:choose>
															<c:when test="${one.toHelpUserId == user.userId}">
																我
															</c:when>
															<c:otherwise>
																${one.toHelpUsername}
															</c:otherwise>
														</c:choose>
													</span>
													申请于${one.createTime}）
												</c:when>
												<c:when test="${one.requireBy == 2}">
													（由
													<span class="emphasized">
														<c:choose>
															<c:when test="${one.helpedUserId == user.userId}">
																我
															</c:when>
															<c:otherwise>
																${one.helpedUsername}
															</c:otherwise>
														</c:choose>
													</span>
													申请于${one.createTime}）
												</c:when>
											</c:choose>
										</div>
									</div>
								</td>
								
															<td>
																<div class="cellTime tips">
																	日期：
																	<span class="emphasized">
																		<c:choose>
																			<c:when test="${empty one.theDate}">双方协商</c:when>
																			<c:otherwise>${one.theDate}</c:otherwise>
																		</c:choose>
																	</span>
																</div>
																<div class="cellTime tips">
																	时间：
																	<span class="emphasized">
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
																			<c:when test="${one.theTime == 13}">双方协商</c:when>
																		</c:choose>
																	</span>
																</div>
																<div class="cellZone tips">
																	地点：
																	<span class="emphasized">
																		<c:choose>
																			<c:when test="${one.zone == 1}">启林南</c:when>
																			<c:when test="${one.zone == 2}">启林北</c:when>
																			<c:when test="${one.zone == 3}">五山</c:when>
																			<c:when test="${one.zone == 4}">华山</c:when>
																			<c:when test="${one.zone == 5}">其它</c:when>
																			<c:otherwise>状态获取出错！</c:otherwise>
																		</c:choose>
																	</span>
																</div>
															</td>
														</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
					</fieldset>
					<fieldset>
						<legend class="emphasized">
							<a href="HomepageAdmin_recordToFeedback">
								待反馈的互助记录
								<span class="tips">(${count2}条)</span>
							</a>
						</legend>
					</fieldset>
					<fieldset>
						<legend class="emphasized">
							<a href="HomepageAdmin_recordVerifiedFailure">
								不合格的互助申请
								<span class="tips">(${count3}条)</span>
							</a>
						</legend>
					</fieldset>
					<fieldset>
						<legend class="emphasized">
							<a href="HomepageAdmin_recordSuccess">
								已实现的互助记录
								<span class="tips">(${count4}条)</span>
							</a>
						</legend>
					</fieldset>
					<fieldset>
						<legend class="emphasized">
							<a href="HomepageAdmin_recordFailure">
								已失败的互助记录
								<span class="tips">(${count5}条)</span>
							</a>
						</legend>
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