<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>文章中心</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleArticle.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfLogin.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<jsp:include page="${path}/view/common/part/common/logo.jsp"/>
	<hr />
	<c:choose>
		<c:when test="${!empty adminLogined}">
			<jsp:include page="${path}/view/common/part/admin/head.jsp"/>
		</c:when>
		<c:otherwise>
			<jsp:include page="${path}/view/common/part/user/head.jsp"/>
		</c:otherwise>
	</c:choose>
	<div id="page">
	<div id="page-bgtop">
		<a name="flag"></a>
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">查看文章</a></h2>
				<div class="entry">
					<form action="ArticleAdmin_addOneSubmit" method="post">
						<fieldset>
							<jsp:include page="${path}/view/common/part/body/article_one.jsp"/>
						</fieldset>
					</form>
					<hr/>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<c:choose>
			<c:when test="${!empty adminLogined}">
				<jsp:include page="${path}/view/common/part/admin/sidebar/article.jsp"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="${path}/view/common/part/user/sidebar/article.jsp"/>
			</c:otherwise>
		</c:choose>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>