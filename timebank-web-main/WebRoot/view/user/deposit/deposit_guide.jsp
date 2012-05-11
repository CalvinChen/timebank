<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>存储时间</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleLogin.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
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
				<h2 class="title"><a href="#">时间存储向导</a></h2>
				<p class="meta">
					<a id="tip" href="#">
						本向导可帮助你向时间银行存储进更为宝贵有效的时间。
						<span id="tip_info">
							温馨提示：向时间银行存储进一枚时间币，意即在时间银行的中介作用下，有效地帮助了别人一次！
						</span>
					</a>
				</p>
				<div class="entry">
					<div id="loginForm">
						<form method="post" action="Deposit_selectSubmit#flag">
							<fieldset>
								<div id="fieldset">
									<div class="oneRow clear">
										<div class="rowLeft"></div>
										<div class="rowRight">
											<span id="message">${message}</span>
										</div>
									</div>
									<div class="oneRow clear">
										<div class="rowLeft"></div>
										<div class="rowRight"><h2>我想帮助别人！那么我可以……</h2></div>
									</div>
									<hr />
									<div class="oneRow clear">
										<div class="rowLeft">
											<input id="L1" type="radio" value="1" name="select" checked="checked"/>
											<span class="emphasized">【主动寻找】</span>
										</div>
										<div class="rowRight">
											<label for="L1">
												有谁需要帮助呢？我来看看！
											</label>
										</div>
									</div>
									<div class="oneRow clear">
										<div class="rowLeft">
											<input id="L2" type="radio" value="2" name="select"/>
											<span class="emphasized">【被动等待】</span>
										</div>
										<div class="rowRight">
											<label for="L2">
												1，写下我觉得OK的时间、地点和我可以提供的帮助；<br />
												2，等待其他人来找我帮忙！
											</label>
										</div>
									</div>
									<hr />
									<div class="oneRow clear">
										<div class="rowLeft"></div>
										<div class="rowRight">
											<input type="submit" value="下一步" class="button"/>
										</div>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
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