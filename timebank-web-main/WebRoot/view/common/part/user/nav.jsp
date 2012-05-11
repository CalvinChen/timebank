<%@ page language="java" pageEncoding="UTF-8"%>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span6">
					<a class="brand" href="#">时间银行</a>beta<br>
					<span class="label label-info">SCAU TIME</span>
					<div id="beta" style="display: none;">
						网站还正在完善中，不足之处请见谅！<br> 有任何建议敬请向我们反馈。
					</div>
					<c:choose>
						<c:when test="${!empty userLogined && empty adminLogined}">
							<a href="/TimeBank/user/Homepage_view"> ——欢迎您， <span> [
									${userLogined.username} ] </span>。
							</a>
						</c:when>
						<c:when test="${!empty userLogined && !empty adminLogined}">
							<a href="/TimeBank/admin/HomepageAdmin_view"> ——管理员 <span>
									[ ${adminLogined.username} ] </span>， 您现在同时以会员 <span> [
									${userLogined.username} ] </span> 的身份登陆，请注意操作。
							</a>
						</c:when>
						<c:when test="${empty userLogined && !empty adminLogined}">
							<a href="/TimeBank/admin/HomepageAdmin_view"> ——欢迎您，管理员 <span>
									[ ${adminLogined.username} ] </span>。
							</a>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="span6">
					<div class="nav-collapse">
						<ul class="nav">
							<li class="active" title="首页" rel="#load1"><a
								href="/TimeBank/Index_view" class="first">首页</a></li>
							<li class="supertips" title="项目简介" rel="#load11"><a
								href="/TimeBank/Document_view?aid=6" class="first">项目简介</a></li>
							<li class="supertips" title="个人中心" rel="#load2"><a
								href="/TimeBank/user/Homepage_view" class="first">个人中心</a></li>
							<li class="supertips" title="存储时间" rel="#load3"><a
								href="/TimeBank/deposit/Deposit_guide" class="first">存储时间</a></li>
							<li class="supertips" title="提取时间" rel="#load4"><a
								href="/TimeBank/withdraw/Withdraw_guide" class="first">提取时间</a></li>
							<li class="supertips" title="反馈" rel="#load5"><a
								href="/TimeBank/Feedback_view" class="first">反馈 </a></li>
							<li class="supertips" title="联系我们" rel="#load6"><a
								href="/TimeBank/Contact_view" class="first">联系我们</a></li>
							<c:if test="${!empty userLogined}">
								<li class="supertips" title="退出" rel="#load7"><a
									href="/TimeBank/Login_execute?message=quit">退出</a></li>
							</c:if>
						</ul>
						<p class="navbar-text pull-right">你好，<a href="#">陈凯</a></p>
					</div>
				</div>
			</div>
			<div id="load1" style="display: none;">
				在这里，您可以：<br /> 1，注册，登录，退出；<br /> 2，查看时间银行最新动态；<br />
				3，查看他人存储或提取的时间记录。
			</div>
			<div id="load11" style="display: none;">
				在这里，您可以：<br> 1，了解时间银行的概念；<br> 2，了解我们如何来开展这个项目。
			</div>
			<div id="load2" style="display: none;">
				在这里，您可以：<br> 1，管理个人资料；<br> 2，查看互助记录。
			</div>
			<div id="load3" style="display: none;">
				在这里，您可以：<br> 1，填写一个时间段，帮助别人；<br> 2，看有哪些人需要帮助；<br>
				3，查看自己的存储记录。<br>
				<c:if test="${userLogined.isVerified == 0}">
					<hr>
					<span class="warn">您尚未验证，无法进入哦！</span>
				</c:if>
			</div>
			<div id="load4" style="display: none;">
				在这里，您可以：<br> 1，填写一个时间段，寻求帮助；<br> 2，看有哪些人提供帮助；<br>
				3，查看自己的提取记录<br>
				<c:if test="${userLogined.isVerified == 0}">
					<hr>
					<span class="warn">您尚未验证，无法进入哦！</span>
				</c:if>
			</div>
			<div id="load5" style="display: none;">
				在这里，您可以：<br> 1，向我们提建议、意见、想法；<br> 2，提交网站的bug、错误；<br>
				3，查看自己提交过的反馈;<br> 4，查看我们给您的回复。
			</div>
			<div id="load6" style="display: none;">
				在这里，您可以：<br> 1，查看我们的联系方式；<br> 2，了解与我们相关的信息。
			</div>
			<div id="load7" style="display: none;">
				欢迎下次光临<span class="emphasized">时间银行</span>，<br> 请您记得记下我们的网址哦！
			</div>
			<c:if
				test="${!empty floatMessage && (floatMessage[1] != 0 || 
						 floatMessage[2] != 0 || floatMessage[3] != 0 || floatMessage[4] != 0)}">
				<div class="float" id="float">
					<c:if test="${!empty floatMessage[1] && floatMessage[1] != 0}">
						<p>
							${floatMessage[1]}条新消息，<a
								href="/TimeBank/user/Homepage_viewMessage">查看消息</a>
						</p>
					</c:if>
					<c:if test="${!empty floatMessage[2] && floatMessage[2] != 0}">
						<p>
							${floatMessage[2]}条新私信，<a
								href="/TimeBank/user/Homepage_viewMessage">查看私信</a>
						</p>
					</c:if>
					<c:if test="${!empty floatMessage[3] && floatMessage[3] != 0}">
						<p>
							${floatMessage[3]}条新通知，<a
								href="/TimeBank/user/Homepage_viewMessage">查看通知</a>
						</p>
					</c:if>
					<c:if test="${!empty floatMessage[4] && floatMessage[4] != 0}">
						<p>
							${floatMessage[4]}个新粉丝，<a
								href="/TimeBank/user/Homepage_viewMessage">查看粉丝</a>
						</p>
					</c:if>
					<a href="#" title="关闭" id="" class="close-ico">关闭</a>
				</div>
			</c:if>
		</div>
	</div>
</div>