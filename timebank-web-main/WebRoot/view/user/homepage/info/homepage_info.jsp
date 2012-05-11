<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>个人中心</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfHomepage.css" rel="stylesheet" type="text/css" media="screen" />
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
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">更新详细信息</a></h2>
				<p class="meta">
					<a id="tip" href="#">
						最近更新信息时间：${user.updateTime}。
						<span id="tip_info">
							温馨提示：请尽量将您的个人信息保持最新！
						</span>
					</a>
				</p>
				<div class="entry">
					<form action="Homepage_infoSubmit" method="post">
						<fieldset>
							<input type="hidden" value="info" name="target"/>
							<div class="content">
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight"><span id="message">${message}&nbsp;</span></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">账号</div>
									<div class="rowRight">
										<input type="hidden" value="${user.username}" name="user.username" />
										<span class="emphasized">
											${user.username}
										</span>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="L1">学号</label></div>
									<div class="rowRight">
										<span class="emphasized">
											${user.studentId}
										</span>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="L2">真实姓名</label></div>
									<div class="rowRight">
										<span class="emphasized">
											${user.name}
										</span>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										<label for="L3">
											性别
										</label>
									</div>
									<div class="rowRight">
										<span class="emphasized">
											<jsp:include page="${path}/view/common/part/function/readSex.jsp" />
										</span>
									</div>
								</div>
								<hr/>
								<div class="oneRow clear">
									<div class="rowLeft">
										<label for="L4">学院</label>
									</div>
									<div class="rowRight emphasized">
										<jsp:include page="${path}/view/common/part/function/readCollege.jsp" />
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										<label for="L5">年级</label>
									</div>
									<div class="rowRight emphasized">
										${user.grade}
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="L6">专业</label></div>
									<div class="rowRight emphasized">
										${user.major}
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										<label for="L7">班级</label>
									</div>
									<div class="rowRight emphasized">
										${user.classId}
									</div>
								</div>
								<hr />
								<div class="oneRow clear">
									<div class="rowLeft">
										<label for="L8">居住区域</label>
									</div>
									<div class="rowRight">
										<jsp:include page="${path}/view/common/part/function/setZone.jsp" />
									</div>
								</div>
								<div class="oneRow">
									<div class="rowLeft"></div>
									<div class="rowRight">
										<input type="submit" value="更新" class="button"/><br />
										<span class="tips">
											学生固有信息暂时不允许自由更改。
										</span><br />
										<a href="Contact_view">转专业？转学院？点击此处联系我们让我们帮你更改吧！</a>
									</div>
								</div>
							</div>
						</fieldset>
						<hr/>
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