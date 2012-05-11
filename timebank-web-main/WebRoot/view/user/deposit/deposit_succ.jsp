<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>存储时间</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
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
				<h2 class="title"><a href="#">存入时间</a></h2>
				<p class="meta">
					<a id="tip" href="#">
						每存入一个有效的、帮助到别人的时间，你收获到的不仅仅是一枚时间币！
						<span id="tip_info">
							温馨提示：您可以在存入时间界面填写完整的描述信息，填写得越完整越有可能帮助到别人。
						</span>
					</a>
				</p>
				<div class="entry">
						<fieldset>
							<div class="oneRow">
								<div class="rowLeft"></div>
								<div class="rowRight">
									<ul>
										<li>
											<div id="hh2" style="display: none;">
												时间预存入是指您已经向银行提交了您的志愿服务时间，
												但只有等到您切实利用这段时间帮助到别人了，才算是存入了时间。
												<hr />
												<span class="warn">时间预存入不会增加时间币，只有真正存入了（即切实帮助到别人）才增加时间币。</span>
											</div>
											<h2 id="message" class="supertips" title="预存入？" rel="#hh2">
												恭喜您，此时间预存入成功！
												<img src="/TimeBank/CSS/images/tip.png" alt="" class="pictureTip"/>
											</h2>
											接下来您的此条存储记录将会对时间银行所有会员展示，<br />
											如果有符合您帮助要求的求助者申请得到您的帮助，<br />
											则我们的工作人员会与您电话联系做最后的确认，<br />
											双方都同意之后会互相交换你们的联系方式。<br />
											感谢您存入的时间。
										</li>
									</ul>
								</div>
							</div>
							<div class="oneRow">
								<div class="rowLeft"></div>
								<div class="rowRight">
									<ul>
										<li>
											您现在可以选择查看：<br />
											<a href="/TimeBank/deposit/Deposit_viewList">我所有存储的时间清单；</a><br />
											<a href="/TimeBank/withdraw/Withdraw_selectSubmit?select=1">别人存储的空闲时间；</a><br />
											<a href="/TimeBank/deposit/Deposit_selectSubmit?select=1">别人求助的空闲时间；</a><br />
											<a href="/TimeBank/user/Homepage_view">我的个人中心。</a>
										</li>
									</ul>
								</div>
							</div>
						</fieldset>
					<hr/>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/user/sidebar/deposit.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>