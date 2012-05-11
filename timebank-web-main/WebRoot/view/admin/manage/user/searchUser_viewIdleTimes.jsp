<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>时间储备 - 用户管理</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfHomepage.css" rel="stylesheet" type="text/css" media="screen" />
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
				<h2 class="title"><a href="#">时间储备</a></h2>
				<div class="entry">
					<fieldset>
						<div class="content">
							<div class="oneRow clear">
								<div class="rowLeft"></div>
								<div class="rowRight">
									<h2 class="emphasized">时间储备总览</h2>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft">已填写的用户有</div>
								<div class="rowRight">
									<span class="emphasized">
										${countHaveIdleTimes}
									</span>
									人，
									<a href="/TimeBank/admin/SearchUser_viewIdleTimeMen" class="button">看看都有谁</a>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft">已提交的时间有</div>
								<div class="rowRight">
									<span class="emphasized">
										${countIdleTimes}
									</span>
									项，平均每人有
									<span class="emphasized">
										<fmt:formatNumber type="number" value="${countIdleTimes / countHaveIdleTimes}" maxFractionDigits="2"/>
									</span>
									项时间储备！
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft">按照时间储备搜索</div>
								<div class="rowRight">
									<form action="SearchUser_searchIdleTimeMen" method="post">
										<div>
											<select name="idleTime.idleDay">
												<option value="星期一">星期一</option>
												<option value="星期二">星期二</option>
												<option value="星期三">星期三</option>
												<option value="星期四">星期四</option>
												<option value="星期五">星期五</option>
												<option value="星期六">星期六</option>
												<option value="星期天">星期天</option>
											</select>
											<select name="idleTime.idleHour">
												<option value="第01-02节">第01-02节</option>
												<option value="第03-04节">第03-04节</option>
												<option value="第05-06节">第05-06节</option>
												<option value="第07-08节">第07-08节</option>
												<option value="第09-10节">第09-10节</option>
												<option value="第11-12节">第11-12节</option>
												<option value="整个上午">整个上午(第01-04节)</option>
												<option value="整个下午">整个下午(第07-10节)</option>
												<option value="整个白天">整个白天(第01-10节)</option>
												<option value="整天">整天(第01-12节)</option>
											</select>
											<input type="submit" value="GO" class="button"/>
										</div>
									</form>
								</div>
							</div>
						</div>
					</fieldset>
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