<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>时间储备 - 个人中心</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleTable.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleFeedback.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<jsp:include page="${path}/view/common/part/common/logo.jsp"/>
	<hr />
			<jsp:include page="${path}/view/common/part/user/head.jsp"/>
	<div id="page">
	<div id="page-bgtop">
		<a name="flag"></a>
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">时间储备</a><span class="warn"><c:if test="${!empty message}"> - ${message}</c:if></span></h2>
				<jsp:include page="${path}/view/common/part/user/tips/tipIdleTime.jsp"/>
				<div class="entry">
					<form action="IdleTime_update" method="post">
						<fieldset class="fieldset">
							<c:choose>
								<c:when test="${count == 0}">
									<div class="oneRow clear">
										<div class="rowLeft emphasized"></div>
										<div class="rowRight">
											<h2>
											<span class="emphasized">
												您共有……
												<span class="warn">
													${count}
												</span>
												段【时间储备】？！
											</span>
											</h2>
											有点少哦！
											<a href="IdleTime_form" class="button">点击这里</a>
											增加！
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="oneRow clear">
										<div class="rowLeft emphasized"></div>
										<div class="rowRight">
											<h2>
											<span class="emphasized">
												您共有
												<span class="warn">
													${count}
												</span>
												段【时间储备】，哎哟，还不错哦！
											</span>
											</h2>
											什么？还有更多呢？！
											<a href="IdleTime_form" class="button">点击这里</a>
											增加！
										</div>
									</div>
									<hr/>
									<jsp:include page="${path}/view/common/part/function/read7Days.jsp" />
									<div class="oneRow clear">
										<div class="rowLeft emphasized"></div>
										<div class="rowRight tips">
											（删除请点击条目后面的“X”即可）
										</div>
									</div>
								</c:otherwise>
							</c:choose>
						</fieldset>					
					</form>
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