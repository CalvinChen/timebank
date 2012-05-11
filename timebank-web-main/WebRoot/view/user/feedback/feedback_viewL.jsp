<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>反馈</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleTable.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
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
				<h2 class="title"><a href="#">我的反馈历史</a></h2>
				<p class="meta">
					<a id="tip" href="#">
						这里的反馈包括您对我们时间银行的意见、建议、求助、鼓励、批评等等，请畅所欲言！
						<span id="tip_info">
							温馨提示：我们的值班人员会在24小时之内回复您的反馈，感谢您。
						</span>
					</a>
				</p>
				<div class="entry">
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
										<c:when test="${empty feedbackList}">
											<tr>
												<td colspan="5">暂无反馈历史。</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${feedbackList}" var="one" varStatus="i">
												<c:choose>
													<c:when test="${i.count % 2 == 0}">
														<tr class="doubleLine">
															<td>
																<div class="cellUser">
																	<img class="userPicture60" src="${one.picture}" alt="${one.username}" /><br />
																	<span class="emphasized">${one.username}</span>
																</div>
															</td>
															<td>
																<div class="cellRecord">
																	<div class="cellDesc">
																		<a href="Feedback_viewOne?getFeedbackId=${one.feedbackId}#flag">
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
																				<span id="message">已收到回复</span>
																			</c:when>
																			<c:when test="${one.isAnswered == 0}">
																				未收到回复
																			</c:when>
																		</c:choose>
																</div>
															</td>
														</tr>
													</c:when>
													<c:otherwise>
														<tr>
															<td>
																<div class="cellUser">
																	<img class="userPicture60" src="${one.picture}" alt="${one.username}" /><br />
																	<span class="emphasized">${one.username}</span>
																</div>
															</td>
															<td>
																<div class="cellRecord">
																	<div class="cellDesc">
																		<a href="Feedback_viewOne?getFeedbackId=${one.feedbackId}#flag">
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
																				<span id="message">已收到回复</span>
																			</c:when>
																			<c:when test="${one.isAnswered == 0}">
																				未收到回复
																			</c:when>
																		</c:choose>
																</div>
															</td>
														</tr>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
					</fieldset>
					<hr/>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/user/sidebar/feedback.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>