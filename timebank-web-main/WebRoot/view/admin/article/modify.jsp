<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>修改文章</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script type="text/javascript" src="/TimeBank/JS/nicEdit/nicEdit.js"></script>
<script type="text/javascript" src="/TimeBank/JS/nicEdit/custom.js"></script>
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleFeedback.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<jsp:include page="${path}/view/common/part/common/logo.jsp"/>
	<hr />
			<jsp:include page="${path}/view/common/part/admin/head.jsp"/>
	<div id="page">
	<div id="page-bgtop">
		<a name="flag"></a>
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">修改文章</a></h2>
				<div class="entry">
					<form action="ArticleAdmin_modifyOneSubmit" method="post">
						<fieldset>
								<input type="hidden" name="one.articleId" value="${one.articleId}"/>
								<input type="hidden" name="one.adminId" value="${one.adminId}"/>
								<input type="hidden" name="one.updateTime" value="${one.updateTime}"/>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight"><span id="message">${messageArticle}</span></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">类别：</div>
									<div class="rowRight">
										<select name="one.articleType">
											<option value="1" 
												<c:if test="${one.articleType == 1}">selected="selected"</c:if>>
												通知通告
											</option>
											<option value="2" 
												<c:if test="${one.articleType == 2}">selected="selected"</c:if>>
												新闻快讯
											</option>
											<option value="3" 
												<c:if test="${one.articleType == 3}">selected="selected"</c:if>>
												时间银行
											</option>
										</select>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">标题：</div>
									<div class="rowRight">
										<input type="text" name="one.articleTitle" class="titleRow" value="${one.articleTitle}"/>
										<span class="tips">（2-20字）</span>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">用户：</div>
									<div class="rowRight"><input type="text" name="one.author" value="${one.author}" class="titleRow"/></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										内容：<br/>
										<span class="tips">（2-5000字）</span>
									</div>
									<div class="rowRight"><textarea cols="68" rows="10" name="one.articleContent" id="area1">${one.articleContent}</textarea></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										点击数：
									</div>
									<div class="rowRight"><input type="text" name="one.articleClickCount" value="${one.articleClickCount}" class="titleRow"/><span class="tips">（请不要设置得太离谱……）</span></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight"><input type="submit" value="更新" class="button"/></div>
								</div>
						</fieldset>
					</form>
					<hr/>
				</div>
			</div>
		</div>
		<!-- end #content -->
				<jsp:include page="${path}/view/common/part/admin/sidebar/article.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>