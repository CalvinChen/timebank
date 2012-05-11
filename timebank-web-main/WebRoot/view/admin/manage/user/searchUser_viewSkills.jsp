<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>技能储备 - 用户管理</title>
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
				<h2 class="title"><a href="#">技能储备</a></h2>
				<div class="entry">
					<fieldset>
						<div class="content">
							<div class="oneRow clear">
								<div class="rowLeft"></div>
								<div class="rowRight">
									<h2 class="emphasized">技能储备总览</h2>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft">已填写的用户有</div>
								<div class="rowRight">
									<span class="emphasized">
										${countHaveSkills}
									</span>
									人，
									<a href="/TimeBank/admin/SearchUser_viewSkillMen" class="button">看看都有谁</a>
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft">已提交的技能有</div>
								<div class="rowRight">
									<span class="emphasized">
										${countSkills}
									</span>
									项，平均每人有
									<span class="emphasized">
										<fmt:formatNumber type="number" value="${countSkills / countHaveSkills}" maxFractionDigits="2"/>
									</span>
									项技能储备！
								</div>
							</div>
							<div class="oneRow clear">
								<div class="rowLeft">按照技能储备搜索</div>
								<div class="rowRight">
									<form action="SearchUser_searchSkillMen" method="post">
										<div>
											<input type="text" name="someInfo" class="inputText"/>
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