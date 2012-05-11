<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>已处理的反馈清单 - 处理反馈</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfHomepage.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleTable.css" rel="stylesheet" type="text/css" media="screen" />
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
					<a href="#">已处理的反馈清单</a>
					<span class="tips">(${allReply}则)</span>
					<span class="warn"><c:if test="${!empty message}"> - ${message}</c:if></span>
				</h2>
				<!-- <p class="meta">
					<a id="tip" href="#">
						最近更新信息时间：${user.updateDate}。
						<span id="tip_info">
							温馨提示：请尽量将您的个人信息保持最新！
						</span>
					</a>
				</p> -->
				<div class="entry">
					<span id="message">${message}</span>
					<fieldset>
							<table id="table">
								<thead id="thead">
									<tr>
										<td>
											<div class="cellHead">用户</div>
										</td>
										<td>
											<div class="cellHead">反馈内容</div>
										</td>
										<td>
											<div class="cellHead">时间状态</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${empty handledFeedbackList}">
											<tr>
												<td colspan="5">暂无反馈历史。</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${handledFeedbackList}" var="one" varStatus="i">
												<tr <c:if test="${i.count % 2 == 0}">class="doubleLine"</c:if>>
															<td>
																<div class="cellUser">
																	<a target="_blank" href="/TimeBank/admin/SearchUser_viewOne?uid=${one.userId}#header">
																		<img class="userPicture60" src="${one.picture}" alt="${one.username}" /><br />
																		<span class="emphasized">${one.username}</span>
																	</a>
																</div>
															</td>
															<td>
																<div class="cellRecord">
																	<div class="cellDesc">
																		<a href="FeedbackAdmin_viewOne?feedbackId=${one.feedbackId}">
																			${one.feedbackTitle}
																		</a>
																	</div>
																	<div class="cellRange tips">${one.feedbackContent}</div>
																</div>
															</td>
															<td>
																<div class="cellTime tips">于<span class="emphasized">${one.createTime}</span>反馈</div>
																<div class="cellZone tips">
																		<c:choose>
																			<c:when test="${one.isAnswered == 1}">
																				<span id="message">于${one.answerTime}回复</span>
																			</c:when>
																			<c:when test="${one.isAnswered == 0}">
																				未回复
																			</c:when>
																		</c:choose>
																</div>
															</td>
														</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
					</fieldset>
					<jsp:include page="${path}/view/common/part/common/pager.jsp"/>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/admin/sidebar/feedback.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>