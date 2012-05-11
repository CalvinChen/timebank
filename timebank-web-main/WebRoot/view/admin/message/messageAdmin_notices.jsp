<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>【通知】所有会员 - 消息</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfHomepage.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleTable.css" rel="stylesheet" type="text/css" media="screen" />
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
				<h2 class="title"><a href="#">【通知】所有会员</a></h2>
				<div class="entry">
						<fieldset>
							<div class="content">
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight"><span id="message">${message}</span></div>
								</div>
								<div class="oneRow clear"><a href="MessageAdmin_newMsg" class="button">发布新通知</a></div>
								<div>
									这里的【通知】是指发给所有时间银行用户的消息，无论该用户是什么时候注册的，只要注册之后一登录，都可以看见这里发布的所有通知信息。<br />
									因此这里存放的通知不宜过多，一些时效已过的通知应当及时删除。<br />
									<span id="message">【提醒】这里的通知一经发出，将无法修改！请发送之前务必再三核对！</span>
								</div>
								<c:choose>
									<c:when test="${empty list}">
										<div class="oneRow clear">
											<div class="rowLeft"></div>
											<div class="rowRight" id="message">【暂时还没有通知哦。】</div>
										</div>
									</c:when>
									<c:otherwise>
										
										<table id="table">
								<thead id="thead">
									<tr>
										<td>
											<div class="cellHead">类别</div>
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
										<c:when test="${empty list}">
											<tr>
												<td colspan="5">暂无数据。</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${list}" var="one" varStatus="i">
														<tr <c:if test="${i.count % 2 == 0}">class="doubleLine"</c:if>>
															<td>
																<div class="cellUser">
																	[
																	通知
																	]
																</div>
															</td>
															<td>
																<div class="cellRecord">
																	<div class="cellDesc">
																		<a href="MessageAdmin_modifyNotice?nid=${one.messageId}">
																			${one.title}
																		</a>
																	</div>
																</div>
															</td>
															<td>
																<div class="cellTime tips">
																	<span class="tips">${one.createTime}</span>
																</div>
																<div class="cellZone tips"></div>
															</td>
														</tr>
													
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
									</c:otherwise>
								</c:choose>
							</div>
						</fieldset>
						<hr/>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/admin/sidebar/message.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>