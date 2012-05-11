<%@ page language="java" pageEncoding="UTF-8"%>
<div id="sidebar">
	<ul>
		
		<li>
			<h2>24小时内银行状态：</h2>
			<p>
				未审核互助记录数：
				<span class="warn">${unverifyH}</span>
				<br>
				
				新存储记录数：
				<span class="emphasized">${newD}</span>
				<br/>
				
				新提取记录数：
				<span class="emphasized">${newW}</span>
				<br/>
				
				新互助记录数：
				<span class="emphasized">${newH}</span>
				<br/>
				
			</p>
		</li>
		
		<li>
			<h2>操作</h2>
			<ul>
				<li><a href="/TimeBank/admin/HomepageAdmin_viewRecords">处理互助</a></li>
				<li><a href="/TimeBank/admin/HomepageAdmin_viewDeposits">处理存储</a></li>
				<li><a href="/TimeBank/admin/HomepageAdmin_viewWithdraws">处理提取</a></li><%--
				<li><a href="/TimeBank/admin/HomepageAdmin_viewPSW">修改密码</a></li>
				<li><a href="/TimeBank/admin/HomepageAdmin_viewSetting">个性设置</a></li>
			--%></ul>
		</li>
	</ul>
</div>