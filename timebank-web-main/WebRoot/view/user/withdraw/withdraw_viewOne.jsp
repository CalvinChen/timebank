<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>提取时间</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleTable.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleMessageBoard.css" rel="stylesheet" type="text/css" media="screen" />
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
				<h2 class="title">
					<a href="#">
						查看提供帮助信息
					</a>
					<span class="warn"><c:if test="${!empty message}"> - ${message}</c:if></span>
				</h2>
				<div class="entry">
					<form action="Withdraw_require" method="post">
						<fieldset>
							<input type="hidden" name="depositRecord.depositId" value="${depositRecord.depositId}"/>
							<input type="hidden" name="depositRecord.userId" value="${depositRecord.userId}"/>
							<div class="oneRow clear">
								<div class="rowLeft rightBorder tips">
									<p>
										<img src="${depositRecord.picture}" alt="头像" class="userPicture120"/>
									</p>
									<p>
										日期：
										<span class="emphasized">
											<c:choose>
												<c:when test="${empty depositRecord.theDate}">
													双方协商
												</c:when>
												<c:otherwise>
													${depositRecord.theDate}
												</c:otherwise>
											</c:choose>
										</span>	
									</p>
									<p>
										时间：
										<span class="emphasized">
										<c:choose>
											<c:when test="${depositRecord.theTime == 1}">第1、2节</c:when>
											<c:when test="${depositRecord.theTime == 2}">第3、4节</c:when>
											<c:when test="${depositRecord.theTime == 3}">整个上午</c:when>
											<c:when test="${depositRecord.theTime == 4}">第5、6节</c:when>
											<c:when test="${depositRecord.theTime == 5}">第7、8节</c:when>
											<c:when test="${depositRecord.theTime == 6}">第9、10节</c:when>
											<c:when test="${depositRecord.theTime == 7}">整个下午</c:when>
											<c:when test="${depositRecord.theTime == 8}">第11、12节</c:when>
											<c:when test="${depositRecord.theTime == 9}">整个白天</c:when>
											<c:when test="${depositRecord.theTime == 10}">整个晚上</c:when>
											<c:when test="${depositRecord.theTime == 11}">一整天</c:when>
											<c:when test="${depositRecord.theTime == 12}">其它</c:when>
											<c:when test="${depositRecord.theTime == 13}">双方协商</c:when>
										</c:choose>
										</span>
									</p>
									<p>
										区域：
										<span class="emphasized">
											<c:choose>
												<c:when test="${depositRecord.zoneDeposit == 1}">启林南</c:when>
												<c:when test="${depositRecord.zoneDeposit == 2}">启林北</c:when>
												<c:when test="${depositRecord.zoneDeposit == 3}">五山</c:when>
												<c:when test="${depositRecord.zoneDeposit == 4}">华山</c:when>
												<c:when test="${depositRecord.zoneDeposit == 5}">其它</c:when>
												<c:otherwise>状态获取出错！</c:otherwise>
											</c:choose>
										</span>
									</p>
									<p>
										范围：
										<span class="emphasized">
											<c:choose>
												<c:when test="${depositRecord.rangeDeposit == 1}">知识技能类</c:when>
												<c:when test="${depositRecord.rangeDeposit == 2}">休闲娱乐类</c:when>
												<c:when test="${depositRecord.rangeDeposit == 3}">体育运动类</c:when>
												<c:when test="${depositRecord.rangeDeposit == 4}">劳动修缮类</c:when>
												<c:when test="${depositRecord.rangeDeposit == 5}">其它</c:when>
												<c:otherwise>获取状态出错！</c:otherwise>
											</c:choose>
										</span>
									</p>
								</div>
								<div class="rowRight">
									<span class="bigNum goodBlue">
										${depositRecord.username}
									</span>
									在
									<span class="bigNum goodGreen">
										${depositRecord.createTime}
									</span>
									发布这条帮助信息，并说：
									<br />
									<hr />
									<br />
									<span class="bigNum">
									${depositRecord.description}
									</span>
									<br />
									<br />
									（
									<c:choose>
										<c:when test="${depositRecord.mode == 1}">
											Ta还可以提供
											<span class="bigNum">
												${depositRecord.seekLeft}
											</span>
											人次这样的帮助
										</c:when>
										<c:when test="${depositRecord.mode == 2}">
											在
											<span class="bigNum">
												${depositRecord.expireDate}
											</span>
											过期
										</c:when>
										<c:when test="${depositRecord.mode == 3}">
											Ta还可以提供
											<span class="bigNum">
												${depositRecord.seekLeft}
											</span>
											人次这样的帮助，并在
											<span class="bigNum">
												${depositRecord.expireDate}
											</span>
											过期
										</c:when>
									</c:choose>
									）
								</div>
							</div>
							<hr />
							<div class="oneRow">
								<div class="rowLeft"></div>
								<div class="rowRight">
									<c:choose>
										<c:when test="${depositRecord.status != 6}">
											<span class="bigNum">
												此记录已关闭，无法操作。
											</span>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${depositRecord.userId == userLogined.userId}">
													<span>
														您是这条帮助信息的主人，请耐心等待符合您要求的求助者。<br/>
														您也可以直接去查看“
														<a href="/TimeBank/deposit/Deposit_selectSubmit?select=1">最近需要帮助的时间清单</a>
														”，自己寻找合适的求助者。
													</span>
													<br/>
													<br/>
													或者您因为某些原因，想
													<a href="/TimeBank/deposit/Deposit_closeDeposit?did=${depositRecord.depositId}" class="button">
														关闭这个帮助信息
													</a>
													？
												</c:when>
												<c:otherwise>
													<span class="bigNum">我需要这种帮助！</span>下面是我需要别人帮助我的内容：
													<br/>
													<textarea cols="50" rows="3" name="addDesc"></textarea><br/>
													<input type="submit" value="嗯，填写完毕，提交给管理员审核！" class="button"/><br />
													<span class="tips">(点击此按钮之后对方将会收到您希望得到ta的帮助的通知，对方同意帮助您之后双方的联系方式将会互相公开。)</span>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</fieldset>
						<fieldset id="messageBoard">
							<legend>留言板</legend>
							<p id="close">留言功能暂不开放，敬请期待。</p>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<!-- end #content -->
		<jsp:include page="${path}/view/common/part/user/sidebar/withdraw.jsp"/>
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	<!-- end #page -->
	<jsp:include page="${path}/view/common/part/common/foot.jsp"/>
</div>
</body>
</html>