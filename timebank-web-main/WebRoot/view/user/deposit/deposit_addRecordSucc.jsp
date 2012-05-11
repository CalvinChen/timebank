<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>存储时间</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleTable.css" rel="stylesheet" type="text/css" media="screen" />
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
											<h2 id="message">恭喜您，提交成功！</h2>
											接下来我们的工作人员将会联系你们做最终的确认，<br />
											确认完成之后会把你们的联系方式公布给对方。<br />
											请寻求帮助的人主动打电话给提供帮助者，<br />
											预祝你们双方互助愉快，感谢您。
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
												<a href="/TimeBank/user/Homepage_viewRecords">我所有的互助记录；</a><br />
												<a href="/TimeBank/user/Homepage_view">我的个人中心。</a>
											</li>
										</ul>
									</div>
								</div>
						</fieldset>
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