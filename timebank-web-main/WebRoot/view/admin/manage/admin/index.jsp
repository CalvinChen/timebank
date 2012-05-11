<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理员 - 用户管理</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfHomepage.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleTableAdmin.css" rel="stylesheet" type="text/css" media="screen" />
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
				<h2 class="title"><a href="#">管理员<span class="tips">(${count}人)</span></a>
				<c:if test="${!empty message}"> - <span id="message">${message}</span></c:if>
				 </h2>
				<div class="entry">
					<c:if test="${adminLogined.level == 2}">
						<fieldset>
							<div class="rowOne clear">
								<div class="rowLeft"></div>
								<div class="rowRight emphasized">
									<h2>新建管理员，我可以</h2>
								</div>
							</div>
							<div class="rowOne clear">
								<div class="rowLeft">1.</div>
								<div class="rowRight">
									搜索用户，将指定用户提升为管理员，实现管理员与用户绑定。<span class="warn">(推荐)</span>
									<br />
									<form method="post" action="/TimeBank/admin/SearchUser_search">
										<div>
										<input type="text" name="someInfo" size="15"/>
										<input type="submit" value="搜索用户" class="button"/>
										</div>
									</form>
								</div>
							</div>
							<div class="rowOne clear">
								<div class="rowLeft">2.</div>
								<div class="rowRight">
									不与用户绑定，直接<a class="button" href="/TimeBank/admin/AdminManager_createOne">新建管理员</a>。
								</div>
							</div>
							<div class="rowOne clear">
								<div class="rowLeft"></div>
								<div class="rowRight"></div>
							</div>
						</fieldset>
					</c:if>
					<jsp:include page="${path}/view/common/part/body/adminList.jsp"/>
					<div class="pages">
						<a class="button" href="AdminManager_viewList">更多</a>
					</div>
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