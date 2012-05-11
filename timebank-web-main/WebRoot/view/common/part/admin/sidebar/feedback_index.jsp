<%@ page language="java" pageEncoding="UTF-8"%>
<div id="sidebar">
	<ul>
		<li>
			<h2>24小时内反馈状态：</h2>
			<p>
				尚未回复的条数：
				<span class="warn">${allHandOn - allReply}</span>
				<br>
				提交反馈的条数：
				<span class="emphasized">${todayHandOn}</span>
				<br/>
				已经回复的条数：
				<span class="emphasized">${todayReply}</span>
				<br/>
			</p>
		</li>
		<li>
			<h2>操作</h2>
			<ul>
				<li><a href="/TimeBank/admin/FeedbackAdmin_viewUnhandle">处理反馈</a></li>
				<li><a href="/TimeBank/admin/FeedbackAdmin_viewList">反馈清单</a></li>
			</ul>
		</li>
	</ul>
</div>