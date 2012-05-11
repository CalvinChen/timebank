<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>我的消息 - 个人中心</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfHomepage.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleFeedback.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleTableMessage.css" rel="stylesheet" type="text/css" media="screen" />
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
					<a href="#">我的消息</a>
					<span class="warn"><c:if test="${!empty message}"> - ${message}</c:if></span>
				</h2>
				<jsp:include page="${path}/view/common/part/function/messageCount.jsp"/>
				<div class="entry">
						<fieldset class="fieldset">
							<table id="table">
								<thead id="thead">
									<tr>
										<td>
											<div class="cellHead">类型</div>
										</td>
										<td>
											<div class="cellHead">标题</div>
										</td>
										<td>
											<div class="cellHead">时间</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${empty myMessages}">
											<tr>
												<td colspan="5">暂无消息。</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${myMessages}" var="one" varStatus="i">
													<tr <c:if test="${i.count % 2 == 0}">class="doubleLine"</c:if>>
															<td>
																<div class="cellAdmin">
																	[
																	<c:choose>
																		<c:when test="${one.type == 1}">消息</c:when>
																		<c:when test="${one.type == 2}">私信</c:when>
																		<c:when test="${one.type == 3}">通知</c:when>
																		<c:when test="${one.type == 4}">粉丝</c:when>
																		<c:otherwise>错误！发现此提示请联系管理员修正！</c:otherwise>
																	</c:choose>
																	]
																</div>
															</td>
															<td>
																<div class="cellInfo">
																		
																	<div class="cellBig<c:if test="${one.isRead == 0}"> unReadRow</c:if>">
																		<a href="Homepage_viewOneMsg?mid=${one.messageId}">
																			${one.title}
																		</a>
																		<c:if test="${one.isRead == 0}">
																			<span class="warn">
																				(未读)
																			</span>
																		</c:if>
																	</div>
																	<div class="cellSmall">
																		来自[${one.sender}]
																	</div>
																</div>
															</td>
															<td>
																<div class="cellTime tips">
																	<span class="tips">${one.updateTime}</span>
																</div>
																<div class="cellZone tips">
																</div>
															</td>
														</tr>
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
		<jsp:include page="${path}/view/common/part/user/sidebar/homepage.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>