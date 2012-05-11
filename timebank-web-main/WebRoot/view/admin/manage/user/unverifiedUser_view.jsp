<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>已注册，未验证 - 用户管理</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfHomepage.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleTable.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
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
				<h2 class="title"><a href="#">已注册，未验证的用户<span class="tips">(${count}人)</span></a></h2>
				<div class="entry">
					<fieldset>
						<table id="table">
								<thead id="thead">
									<tr>
										<td>
											<div class="cellHead">用户</div>
										</td>
										<td>
											<div class="cellHead">个人信息</div>
										</td>
										<td>
											<div class="cellHead">时间状态</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${empty list}">
											<tr>
												<td colspan="5">暂无待验证用户。</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${list}" var="one" varStatus="i">
												<tr <c:if test="${i.count % 2 == 0}">class="doubleLine"</c:if> >
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
																		<a href="SearchUser_viewOne?uid=${one.userId}#header">
																			${one.name}
																			|
																			<c:choose>
																				<c:when test="${one.sex == 0 || empty one.sex}">
																					（未填）
																				</c:when>
																				<c:when test="${one.sex == 1}">
																					男
																				</c:when>
																				<c:when test="${one.sex == 2}">
																					女
																				</c:when>
																				<c:otherwise>
																					读取出错！
																				</c:otherwise>
																			</c:choose> 
																			|
																			tel:
																			<c:choose>
																				<c:when test="${!empty one.phoneLong}">
																					${one.phoneLong}
																				</c:when>
																				<c:otherwise>
																					空
																				</c:otherwise>
																			</c:choose> 
																			(
																			<c:choose>
																				<c:when test="${!empty one.phoneShort}">
																					${one.phoneShort}
																				</c:when>
																				<c:otherwise>
																					空
																				</c:otherwise>
																			</c:choose> 
																			)
																			
																		</a>
																	</div>
																	<div class="cellRange tips">
																		${one.grade}级
																		|
																		<c:choose>
																			<c:when test="${one.college == 0 || empty one.college}">
																				（未填）
																			</c:when>
																			<c:when test="${one.college == 1}">
																				农学院
																			</c:when>
																			<c:when test="${one.college == 2}">
																				资源环境学院
																			</c:when>
																			<c:when test="${one.college == 3}">
																				生命科学学院
																			</c:when>
																			<c:when test="${one.college == 4}">
																				经济管理学院
																			</c:when>
																			<c:when test="${one.college == 5}">
																				工程学院
																			</c:when>
																			<c:when test="${one.college == 6}">
																				动物科学学院
																			</c:when>
																			<c:when test="${one.college == 7}">
																				兽医学院
																			</c:when>
																			<c:when test="${one.college == 8}">
																				园艺学院
																			</c:when>
																			<c:when test="${one.college == 9}">
																				食品学院
																			</c:when>
																			<c:when test="${one.college == 10}">
																				林学院
																			</c:when>
																			<c:when test="${one.college == 11}">
																				人文与法学学院
																			</c:when>
																			<c:when test="${one.college == 12}">
																				理学院
																			</c:when>
																			<c:when test="${one.college == 13}">
																				信息学院
																			</c:when>
																			<c:when test="${one.college == 14}">
																				艺术学院
																			</c:when>
																			<c:when test="${one.college == 15}">
																				外国语学院
																			</c:when>
																			<c:when test="${one.college == 16}">
																				水利与土木工程学院
																			</c:when>
																			<c:when test="${one.college == 17}">
																				公共管理学院
																			</c:when>
																			<c:otherwise>
																				读取出错！
																			</c:otherwise>
																		</c:choose>
																		|
																		<c:choose>
																			<c:when test="${!empty one.major}">
																				${one.major}
																			</c:when>
																			<c:otherwise>
																				空
																			</c:otherwise>
																		</c:choose> 
																		|
																		${one.classId}班
																		<br />
																		学号:${one.studentId}
																	</div>
																</div>
															</td>
															<td>
																<div class="cellTime tips">于<span class="emphasized">${one.createTime}</span>注册</div>
																<div class="cellZone tips">
																		于<span class="emphasized">${one.updateTime}</span>更新<br />
																		<a href="SearchUser_verify?uid=${one.userId}">快速标为“已验证”</a>
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
					<hr/>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/admin/sidebar/search_user.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>