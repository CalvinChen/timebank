<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="sidebar">
	<ul>
		<li>
			<h2>24小时内用户状态：</h2>
			<p>
				新注册的用户数：
				<span class="emphasized">${newReg}</span>
				<br/>
				验证通过的用户数：
				<span class="emphasized">${newVer}</span>
				<br/>
			</p>
		</li>
		<li>
			<h2>用户分类</h2>
			<ul>
				<li><a href="/TimeBank/admin/SearchUser_unverified">未验证</a></li>
				<li><a href="/TimeBank/admin/SearchUser_verified">已验证</a></li>
				<li><a href="/TimeBank/admin/SearchUser_unregister">未注册</a></li>
				<li><a href="/TimeBank/admin/AdminManager_view">管理员</a></li>
			</ul>
		</li>
		<li>
			<h2>匹配查找</h2>
			<ul>
				<li><a href="/TimeBank/admin/SearchUser_viewSkills">技能储备</a></li>
				<li><a href="/TimeBank/admin/SearchUser_viewIdleTimes">时间储备</a></li>
				<li><a href="/TimeBank/admin/SearchUser_viewCollege">学院纵览</a></li>
			</ul>
		</li>
	</ul>
</div>