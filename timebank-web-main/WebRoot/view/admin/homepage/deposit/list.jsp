<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>处理存储 - 业务中心</title>
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
			<jsp:include page="${path}/view/common/part/admin/head.jsp"/>
	<div id="page">
	<div id="page-bgtop">
		<div id="content">
			<div class="post">
				<h2 class="title">
					<a href="#">
						处理存储
					</a>
					<span class="warn"><c:if test="${!empty message}"> - ${message}</c:if></span>
				</h2>
				<div class="entry">
					<fieldset>
						<legend>
							<a href="HomepageAdmin_dUnmatched" <c:if test="${count6 != 0}">class="warn"</c:if>>
								未配对的存储申请
								<span class="tips">(${count6}条)</span>
							</a>
						</legend>
							<table id="table">
								<thead id="thead">
									<tr>
										<td>
											<div class="cellHead">志愿用户</div>
										</td>
										<td>
											<div class="cellHead">提供的帮助内容</div>
										</td>
										<td>
											<div class="cellHead">时间地点</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${empty unmatchedDepositList}">
											<tr>
												<td colspan="5">暂无数据。</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${unmatchedDepositList}" var="one" varStatus="i">
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
																		<a href="/TimeBank/admin/HomepageAdmin_viewDeposit?did=${one.depositId}#flag">
																			<span class="warn">
																				<c:choose>
																					<c:when test="${one.status == 6}">
																						尚未配对完
																					</c:when>
																					<c:when test="${one.status == 7}">
																						已过期
																						（
																						于
																						<span class="bigNum">
																							${one.expireDate}
																						</span>
																						时
																						）
																					</c:when>
																					<c:when test="${one.status == 8}">
																						已达匹配次数
																						（
																						共
																						<span class="bigNum">
																							${one.seekNumber}
																						</span>
																						次
																						）
																					</c:when>
																					<c:otherwise>状态获取出错！</c:otherwise>
																				</c:choose>
																			</span>
																			<br />
																			${one.description}
																		</a>
																	</div>
																	<div class="cellRange tips">
																		<c:choose>
																			<c:when test="${one.mode == 1}">
																				Ta还可以提供
																				<span class="bigNum">
																					${one.seekLeft}
																				</span>
																				人次这样的帮助
																			</c:when>
																			<c:when test="${one.mode == 2}">
																				将在
																				<span class="bigNum">
																					${one.expireDate}
																				</span>
																				过期
																			</c:when>
																			<c:when test="${one.mode == 3}">
																				Ta还可以提供
																				<span class="bigNum">
																					${one.seekLeft}
																				</span>
																				人次这样的帮助，并在
																				<span class="bigNum">
																					${one.expireDate}
																				</span>
																				过期
																			</c:when>
																		</c:choose>
																	</div>
																</div>
															</td>
															<td>
																<div class="cellTime tips">
																	类别：
																	<c:choose>
																		<c:when test="${one.rangeDeposit == 1}">知识技能类</c:when>
																		<c:when test="${one.rangeDeposit == 2}">休闲娱乐类</c:when>
																		<c:when test="${one.rangeDeposit == 3}">体育运动类</c:when>
																		<c:when test="${one.rangeDeposit == 4}">劳动修缮类</c:when>
																		<c:when test="${one.rangeDeposit == 5}">其它</c:when>
																		<c:otherwise>获取状态出错！</c:otherwise>
																	</c:choose>
																	<hr />
																	日期：
																	<span class="emphasized">
																		<c:choose>
																			<c:when test="${empty one.theDate}">双方协商</c:when>
																			<c:otherwise>${one.theDate}</c:otherwise>
																		</c:choose>
																	</span>
																	<br />
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
																			<c:when test="${one.zoneDeposit == 0 || empty one.zoneDeposit}">
																				（未填）
																			</c:when>
																			<c:when test="${one.zoneDeposit == 1}">
																				启林南
																			</c:when>
																			<c:when test="${one.zoneDeposit == 2}">
																				启林北
																			</c:when>
																			<c:when test="${one.zoneDeposit == 3}">
																				五山
																			</c:when>
																			<c:when test="${one.zoneDeposit == 4}">
																				华山
																			</c:when>
																			<c:when test="${one.zoneDeposit == 5}">
																					其它
																			</c:when>
																			<c:otherwise>
																				读取出错！
																			</c:otherwise>
																		</c:choose> 
																	</span>
																	<br />
																	(于${one.createTime}申请)
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
						<legend>
							<a href="HomepageAdmin_dSeeked">
								已达匹配次数的存储申请
								<span class="tips">(${count1}条)</span>
							</a>
						</legend>
					</fieldset>
					<fieldset>
						<legend>
							<a href="HomepageAdmin_dExpired">
								已过期的存储申请
								<span class="tips">(${count2}条)</span>
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