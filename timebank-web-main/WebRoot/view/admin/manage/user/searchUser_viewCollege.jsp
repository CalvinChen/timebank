<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>学院纵览 - 用户管理</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfHomepage.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleInfo.css" rel="stylesheet" type="text/css" media="screen" />
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
				<h2 class="title"><a href="#">学院纵览</a></h2>
				<div class="entry">
					<fieldset>
						<div class="content">
							<div class="oneRow clear">
								<div class="rowLeft"></div>
								<div class="rowRight">
									<h2>
										各个学院用户人数纵览
										<span class="tips">
											(验证/总)
										</span>
									</h2>
								</div>
							</div>
							<hr/>
							<div class="infoAll clear">
										<div class="infoLeft">
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=10" class="radio">
														林学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[10]}
													/
													${collegesUsed[10]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=1" class="radio">
														农学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[1]}
													/
													${collegesUsed[1]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=8" class="radio">
														园艺学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[8]}
													/
													${collegesUsed[8]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=9" class="radio">
														食品学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[9]}
													/
													${collegesUsed[9]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=3" class="radio">
														生命科学学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[3]}
													/
													${collegesUsed[3]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=12" class="radio">
														理学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[12]}
													/
													${collegesUsed[12]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=13" class="radio">
														信息学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[13]}
													/
													${collegesUsed[13]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=5" class="radio">
														工程学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[5]}
													/
													${collegesUsed[5]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=16" class="radio">
														水利与土木学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[16]}
													/
													${collegesUsed[16]}
												</div>
											</div>
										</div>
										<div class="infoRight">
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=11" class="radio">
														人文与法学学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[11]}
													/
													${collegesUsed[11]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=2" class="radio">
														资源环境学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[2]}
													/
													${collegesUsed[2]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=6" class="radio">
														动物科学学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[6]}
													/
													${collegesUsed[6]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=7" class="radio">
														兽医学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[7]}
													/
													${collegesUsed[7]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=14" class="radio">
														艺术学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[14]}
													/
													${collegesUsed[14]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=15" class="radio">
														外国语学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[15]}
													/
													${collegesUsed[15]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=17" class="radio">
														公共管理学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[17]}
													/
													${collegesUsed[17]}
												</div>
											</div>
											<div class="pair clear">
												<div class="key">
													<a href="SearchUser_byCollege?cid=4" class="radio">
														经济管理学院
													</a>
												</div>
												<div class="value">
													${collegesVerified[4]}
													/
													${collegesUsed[4]}
												</div>
											</div>
										</div>
									</div>
								<hr />
							<div class="oneRow clear">
								<div class="rowLeft"></div>
								<div class="rowRight tips">
									（点击学院名称可查看具体有哪些人）
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