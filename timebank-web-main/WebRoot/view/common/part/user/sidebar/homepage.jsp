<%@ page language="java" pageEncoding="UTF-8"%>
<div id="sidebar">
	<ul>
		
		<li>
			<h2>资料完善度</h2>
			<p>您的个人资料已完善了${percentage}%。</p>
		</li>
		
		<li>
			<h2>查看&修改</h2>
			<ul>
				<li><a href="/TimeBank/user/Homepage_viewPic">我的头像</a></li>
				<li><a href="/TimeBank/user/Skill_view">
						技能储备
						<span class="warn tips">[必选]</span>
					</a>
				</li>
				<li><a href="/TimeBank/user/IdleTime_view">
						时间储备
						<span class="warn tips">[必选]</span>
					</a>
				</li>
				<li><a href="/TimeBank/user/Homepage_viewInfo">详细信息</a></li>
				<li><a href="/TimeBank/user/Homepage_viewContact">联系方式</a></li>
				<li><a href="/TimeBank/user/Homepage_viewPSW">修改密码</a></li>
				<li><a href="/TimeBank/user/Homepage_viewMessage">我的消息</a></li>
				<li><a href="/TimeBank/user/Homepage_viewRecords">互助记录</a></li>
			</ul>
		</li>
		
	</ul>
</div>