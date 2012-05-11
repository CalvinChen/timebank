<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>联系我们</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
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
			<jsp:include page="${path}/view/common/part/user/head.jsp"/>
	<div id="page">
	<div id="page-bgtop">
		<a name="flag"></a>
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">联系我们</a></h2>
				<p class="meta">
					<a id="tip" href="#">
						时间银行，真诚期待与您的联系交流！
						<span id="tip_info">
							温馨提示：请尽量在上班时间与我们联系，谢谢！
						</span>
					</a>
				</p>
				<div class="entry">
					<form action="Feedback_submit" method="post">
						<fieldset>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight"><span id="message">${message}</span></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight"><img width="150px" src="/TimeBank/CSS/images/ygtdPic.jpg"/></div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft"></div>
									<div class="rowRight"><img width="180px" src="/TimeBank/CSS/images/ygtdText.jpg"/></div>
								</div>
								<hr/>
								<div class="oneRow clear">
									<div class="rowLeft">
										时间银行总部
									</div>
									<div class="rowRight">
										<span class="emphasized">华南农业大学启林南社区服务站</span><br />
										<span class="tips">华农启林南宿舍区36栋楼下</span>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										热线电话
									</div>
									<div class="rowRight">
										<span class="emphasized">15011836004（短号676004）</span><br />
										<span class="tips">
											此手机及短号为社区服务站工作使用，放置于启林南社区服务站前台，敬请拨打或短信！<br />
											添加飞信好友请注明身份，谢谢！
										</span>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										值班时间
									</div>
									<div class="rowRight">
										<span class="emphasized">
											<span class="tips">星期一至星期日</span> 
											|
											<span class="tips">上午</span> 08：00-12：00
											|
											<span class="tips">下午</span> 14：00-17：30
											|
											<span class="tips">晚上</span> 17: 30-21: 00
										</span>
									</div>
								</div>
								<hr/>
								<div class="oneRow clear">
									<div class="rowLeft">
										新浪微博
									</div>
									<div class="rowRight">
										华南农业大学时间银行
										<iframe width="63" height="24" frameborder="0" allowtransparency="true" 
											marginwidth="0" marginheight="0" scrolling="no" frameborder="No" border="0" 
											src="http://widget.weibo.com/relationship/followbutton.php?width=63&height=24&uid=2363782117&style=1&btn=red&dpc=1">
										</iframe>
										<br />
										华南农业大学阳光团队
										<iframe width="63" height="24" frameborder="0" allowtransparency="true" 
											marginwidth="0" marginheight="0" scrolling="no" frameborder="No" border="0" 
											src="http://widget.weibo.com/relationship/followbutton.php?width=63&height=24&uid=1822044287&style=1&btn=red&dpc=1">
										</iframe>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										QQ
									</div>
									<div class="rowRight">
										2309345383
										<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=2309345383&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:2309345383:41" alt="时间银行，欢迎联系我们咨询！" title="时间银行，欢迎联系我们咨询！"></a>
									</div>
								</div>
								<div class="oneRow clear">
									<div class="rowLeft">
										Email
									</div>
									<div class="rowRight">
										<a href="mailto:scautime@qq.com" target="_BLANK">scautime@qq.com</a>
									</div>
								</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/user/sidebar/contact.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>