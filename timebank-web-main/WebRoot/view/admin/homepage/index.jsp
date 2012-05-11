<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理中心</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
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
				<h2 class="title"><a href="#">管理中心</a></h2>
				<!-- <p class="meta">
					<a id="tip" href="#">
						最近更新信息时间：${user.updateDate}。
						<span id="tip_info">
							温馨提示：请尽量将您的个人信息保持最新！
						</span>
					</a>
				</p> -->
				<div class="entry">
					<fieldset>
						<legend>银行信息概览</legend>
						<div class="content">
							<ul>
								<li>
									网站访问量：
									<script language="javascript" type="text/javascript" src="http://quote.51.la/?id=5581497&amp;mb=3"></script><br />
									<span class="tips">更详细信息查看方法：【点击以上链接】  - 【查看详细统计报表】 - 【网站概况】</span><br />
								</li>
							</ul>
						</div>
					</fieldset>
					<hr/>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/admin/sidebar/homepage_index.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>