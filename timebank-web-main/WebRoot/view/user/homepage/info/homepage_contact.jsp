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
				<h2 class="title"><a href="#">更新联系方式</a></h2>
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
							<input type="hidden" value="${user.userId}" name="user.userId"/>
							<input type="hidden" value="contact" name="target"/>
							<div class="content">
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight">
										<span id="message">${message}&nbsp;</span>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="L1">Email：</label></div>
									<div class="rowRight">
										<input id="L1" type="text" value="${user.email}" name="user.email"/>
									</div>
								</div>
								<div id="c1" style="display: none;">
								   	手机长号或短号，<br />请<span class="warn">选填至少其中一项</span>才可使用银行业务。
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="L2">手机：</label></div>
									<div class="rowRight">
										<input id="L2" class="tipFocus" type="text" value="${user.phoneLong}" name="user.phoneLong" rel="#c1" title="联系方式"/>
										<c:if test="${empty user.phoneShort && empty user.phoneLong}">
											<span id="message">(*)</span>
										</c:if>										
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="L3">短号：</label></div>
									<div class="rowRight">
										<input id="L3" class="tipFocus" type="text" value="${user.phoneShort}" name="user.phoneShort" rel="#c1" title="联系方式"/>
										<c:if test="${empty user.phoneShort && empty user.phoneLong}">
											<span id="message">(*)</span>
										</c:if>
									</div>
								</div>
								<hr/>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="L4">QQ：</label></div>
									<div class="rowRight">
										<input id="L4" type="text" value="${user.qq}" name="user.qq"/>
									</div>
								</div>
								<div id="weibo" style="display: none;">
								   	这里是输入您<span class="warn">微博的主页地址</span>，<br />
								   	如：http://weibo.com/scausjyh<br />
								   	<span class="tips emphasized">(暂时仅限新浪微博或腾讯微博，请以http://weibo.com/或http://t.qq.com/为前缀)</span>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="L5">微博：</label></div>
									<div class="rowRight">
										<input id="L5" title="微博" type="text" value="${user.weibo}" name="user.weibo" rel="#weibo" class="tipFocus"/>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="L6">博客：</label></div>
									<div class="rowRight">
										<input id="L6" type="text" value="${user.blog}" name="user.blog"/>
									</div>
								</div>
								<hr/>
								<div class="oneRow clear">
									<div class="rowLeft"><label for="L7">宿舍地址：</label></div>
									<div class="rowRight">
										<input id="L7" type="text" value="${user.address}" name="user.address"/>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight">
										<input type="submit" value="更新" class="button"/>
									</div>
								</div>
							</div>
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