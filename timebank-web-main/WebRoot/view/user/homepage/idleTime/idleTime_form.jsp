<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>时间储备 - 个人中心</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/TimeBank/CSS/styleGlobal.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleTable.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleUserPicture.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleSidebarOfDeposit.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleHoverTips.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/TimeBank/CSS/styleFeedback.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<jsp:include page="${path}/view/common/part/common/logo.jsp"/>
	<hr />
			<jsp:include page="${path}/view/common/part/admin/head.jsp"/>
	<div id="page">
	<div id="page-bgtop">
		<a name="flag"></a>
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">时间储备</a><span class="warn"><c:if test="${!empty message}"> - ${message}</c:if></span></h2>
				<jsp:include page="${path}/view/common/part/user/tips/tipIdleTime.jsp"/>
				<div class="entry">
					<form action="IdleTime_update" method="post">
						<fieldset>
							<div class="oneRow clear">
								<div class="rowLeft emphasized">星期一</div>
								<input type="hidden" name="day1.idleDay" value="星期一"/>
								<div class="rowRight">
									上午
									<span class="emphasized">
										<span class="radio">
											<input id="L1-1" type="checkbox" name="day1.idleHour" value="第01-02节"/>
											<label for="L1-1">第01-02节</label>
										</span>
										<span  class="radio">
											<input id="L1-2" type="checkbox" name="day1.idleHour" value="第03-04节"/>
											<label for="L1-2">第03-04节</label>
										</span>
									</span>
									中午
									<span class="emphasized">
										<span  class="radio">
											<input id="L1-3" type="checkbox" name="day1.idleHour" value="第05-06节"/>
											<label for="L1-3">第05-06节</label>
										</span>
									</span>
									<br /><br />
									下午
									<span class="emphasized">
										<span  class="radio">
											<input id="L1-4" type="checkbox" name="day1.idleHour" value="第07-08节"/>
											<label for="L1-4">第07-08节</label>
										</span>
										<span  class="radio">
											<input id="L1-5" type="checkbox" name="day1.idleHour" value="第09-10节"/>
											<label for="L1-5">第09-10节</label>
										</span>
									</span>
									晚上
									<span class="emphasized">
										<span  class="radio">
											<input id="L1-6" type="checkbox" name="day1.idleHour" value="第11-12节"/>
											<label for="L1-6">第11-12节</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">星期二</div>
								<input type="hidden" name="day2.idleDay" value="星期二"/>
								<div class="rowRight">
									上午
									<span class="emphasized">
										<span class="radio">
											<input id="L2-1" type="checkbox" name="day2.idleHour" value="第01-02节"/>
											<label for="L2-1">第01-02节</label>
										</span>
										<span  class="radio">
											<input id="L2-2" type="checkbox" name="day2.idleHour" value="第03-04节"/>
											<label for="L2-2">第03-04节</label>
										</span>
									</span>
									中午
									<span class="emphasized">
										<span  class="radio">
											<input id="L2-3" type="checkbox" name="day2.idleHour" value="第05-06节"/>
											<label for="L2-3">第05-06节</label>
										</span>
									</span>
									<br /><br />
									下午
									<span class="emphasized">
										<span  class="radio">
											<input id="L2-4" type="checkbox" name="day2.idleHour" value="第07-08节"/>
											<label for="L2-4">第07-08节</label>
										</span>
										<span  class="radio">
											<input id="L2-5" type="checkbox" name="day2.idleHour" value="第09-10节"/>
											<label for="L2-5">第09-10节</label>
										</span>
									</span>
									晚上
									<span class="emphasized">
										<span  class="radio">
											<input id="L2-6" type="checkbox" name="day2.idleHour" value="第11-12节"/>
											<label for="L2-6">第11-12节</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">星期三</div>
								<input type="hidden" name="day3.idleDay" value="星期三"/>
								<div class="rowRight">
									上午
									<span class="emphasized">
										<span class="radio">
											<input id="L3-1" type="checkbox" name="day3.idleHour" value="第01-02节"/>
											<label for="L3-1">第01-02节</label>
										</span>
										<span  class="radio">
											<input id="L3-2" type="checkbox" name="day3.idleHour" value="第03-04节"/>
											<label for="L3-2">第03-04节</label>
										</span>
									</span>
									中午
									<span class="emphasized">
										<span  class="radio">
											<input id="L3-3" type="checkbox" name="day3.idleHour" value="第05-06节"/>
											<label for="L3-3">第05-06节</label>
										</span>
									</span>
									<br /><br />
									下午
									<span class="emphasized">
										<span  class="radio">
											<input id="L3-4" type="checkbox" name="day3.idleHour" value="第07-08节"/>
											<label for="L3-4">第07-08节</label>
										</span>
										<span  class="radio">
											<input id="L3-5" type="checkbox" name="day3.idleHour" value="第09-10节"/>
											<label for="L3-5">第09-10节</label>
										</span>
									</span>
									晚上
									<span class="emphasized">
										<span  class="radio">
											<input id="L3-6" type="checkbox" name="day3.idleHour" value="第11-12节"/>
											<label for="L3-6">第11-12节</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">星期四</div>
								<input type="hidden" name="day4.idleDay" value="星期四"/>
								<div class="rowRight">
									上午
									<span class="emphasized">
										<span class="radio">
											<input id="L4-1" type="checkbox" name="day4.idleHour" value="第01-02节"/>
											<label for="L4-1">第01-02节</label>
										</span>
										<span  class="radio">
											<input id="L4-2" type="checkbox" name="day4.idleHour" value="第03-04节"/>
											<label for="L4-2">第03-04节</label>
										</span>
									</span>
									中午
									<span class="emphasized">
										<span  class="radio">
											<input id="L4-3" type="checkbox" name="day4.idleHour" value="第05-06节"/>
											<label for="L4-3">第05-06节</label>
										</span>
									</span>
									<br /><br />
									下午
									<span class="emphasized">
										<span  class="radio">
											<input id="L4-4" type="checkbox" name="day4.idleHour" value="第07-08节"/>
											<label for="L4-4">第07-08节</label>
										</span>
										<span  class="radio">
											<input id="L4-5" type="checkbox" name="day4.idleHour" value="第09-10节"/>
											<label for="L4-5">第09-10节</label>
										</span>
									</span>
									晚上
									<span class="emphasized">
										<span  class="radio">
											<input id="L4-6" type="checkbox" name="day4.idleHour" value="第11-12节"/>
											<label for="L4-6">第11-12节</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">星期五</div>
								<input type="hidden" name="day5.idleDay" value="星期五"/>
								<div class="rowRight">
									上午
									<span class="emphasized">
										<span class="radio">
											<input id="L5-1" type="checkbox" name="day5.idleHour" value="第01-02节"/>
											<label for="L5-1">第01-02节</label>
										</span>
										<span  class="radio">
											<input id="L5-2" type="checkbox" name="day5.idleHour" value="第03-04节"/>
											<label for="L5-2">第03-04节</label>
										</span>
									</span>
									中午
									<span class="emphasized">
										<span  class="radio">
											<input id="L5-3" type="checkbox" name="day5.idleHour" value="第05-06节"/>
											<label for="L5-3">第05-06节</label>
										</span>
									</span>
									<br /><br />
									下午
									<span class="emphasized">
										<span  class="radio">
											<input id="L5-4" type="checkbox" name="day5.idleHour" value="第07-08节"/>
											<label for="L5-4">第07-08节</label>
										</span>
										<span  class="radio">
											<input id="L5-5" type="checkbox" name="day5.idleHour" value="第09-10节"/>
											<label for="L5-5">第09-10节</label>
										</span>
									</span>
									晚上
									<span class="emphasized">
										<span  class="radio">
											<input id="L5-6" type="checkbox" name="day5.idleHour" value="第11-12节"/>
											<label for="L5-6">第11-12节</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">星期六</div>
								<input type="hidden" name="day6.idleDay" value="星期六"/>
								<div class="rowRight">
									上午
									<span class="emphasized">
										<span class="radio">
											<input id="L6-1" type="checkbox" name="day6.idleHour" value="第01-02节"/>
											<label for="L6-1">第01-02节</label>
										</span>
										<span  class="radio">
											<input id="L6-2" type="checkbox" name="day6.idleHour" value="第03-04节"/>
											<label for="L6-2">第03-04节</label>
										</span>
									</span>
									中午
									<span class="emphasized">
										<span  class="radio">
											<input id="L6-3" type="checkbox" name="day6.idleHour" value="第05-06节"/>
											<label for="L6-3">第05-06节</label>
										</span>
									</span>
									<br /><br />
									下午
									<span class="emphasized">
										<span  class="radio">
											<input id="L6-4" type="checkbox" name="day6.idleHour" value="第07-08节"/>
											<label for="L6-4">第07-08节</label>
										</span>
										<span  class="radio">
											<input id="L6-5" type="checkbox" name="day6.idleHour" value="第09-10节"/>
											<label for="L6-5">第09-10节</label>
										</span>
									</span>
									晚上
									<span class="emphasized">
										<span  class="radio">
											<input id="L6-6" type="checkbox" name="day6.idleHour" value="第11-12节"/>
											<label for="L6-6">第11-12节</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft emphasized">星期天</div>
								<input type="hidden" name="day7.idleDay" value="星期天"/>
								<div class="rowRight">
									上午
									<span class="emphasized">
										<span class="radio">
											<input id="L7-1" type="checkbox" name="day7.idleHour" value="第01-02节"/>
											<label for="L7-1">第01-02节</label>
										</span>
										<span  class="radio">
											<input id="L7-2" type="checkbox" name="day7.idleHour" value="第03-04节"/>
											<label for="L7-2">第03-04节</label>
										</span>
									</span>
									中午
									<span class="emphasized">
										<span  class="radio">
											<input id="L7-3" type="checkbox" name="day7.idleHour" value="第05-06节"/>
											<label for="L7-3">第05-06节</label>
										</span>
									</span>
									<br /><br />
									下午
									<span class="emphasized">
										<span  class="radio">
											<input id="L7-4" type="checkbox" name="day7.idleHour" value="第07-08节"/>
											<label for="L7-4">第07-08节</label>
										</span>
										<span  class="radio">
											<input id="L7-5" type="checkbox" name="day7.idleHour" value="第09-10节"/>
											<label for="L7-5">第09-10节</label>
										</span>
									</span>
									晚上
									<span class="emphasized">
										<span  class="radio">
											<input id="L7-6" type="checkbox" name="day7.idleHour" value="第11-12节"/>
											<label for="L7-6">第11-12节</label>
										</span>
									</span>
								</div>
							</div>
							<hr />
							<div class="oneRow clear">
								<div class="rowLeft">
								</div>
								<div class="rowRight">
									<input type="submit" value="嗯，填写完整了，更新吧！" class="button"/><br/>
									<span class="tips">
										<a href="/TimeBank/Feedback_view">
											(还有我们没有包括的项目？点击反馈跟我们建议，我们会及时响应您的建议的！)
										</a>
									</span>
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