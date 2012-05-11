<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${css}/module/user/login/login.css" type="text/css" rel="stylesheet" />
<div class="sidebar-nav">
	<form id="loginForm" class="well" method="post" action="Login_execute">
		<fieldset>
		<legend>
			<c:choose>
				<c:when test="${empty userLogined}">
				<i class="icon-time"></i> 欢迎使用时间银行
				</c:when>
				<c:otherwise>
				首页
				</c:otherwise>
			</c:choose> 
		</legend>
		<c:choose>
			<c:when test="${empty userLogined}">
				<span id="message">${message}</span>
				<input class="span4" type="text" name="loginUser.username" placeholder="用户名/学号"/>
				<input class="span4" type="password" name="loginUser.password" placeholder="密码"/>
				<label class="checkbox">
					<input type="checkbox" name="autoLogin" value="Yes" checked="checked">
					记住我的登录状态
				</label>
				<div class="btn-group">
					<button class="btn btn-large btn-success"><i class="icon-ok icon-white"></i> 登录</button>
					<a class="btn btn-large dialoglink" href="${path}/user/register/register" data-callback="reloadIndex">
						<i class="icon-plus"></i> 注册
					</a>
				</div>
				<a href="Contact_forgetPSW"><span class="tips">忘记密码？</span></a>
				<hr/>
				<span class="label label-info">注意咯！</span><br/>
				<h4><i class="icon-user"></i> 本银行的服务对象：华南农业大学全日制本科生</h4>
			</c:when>
			<c:otherwise>
				<div id="fieldset">
					<p>
						<img class="userPicture120" src="${user.picture}" alt="头像" />
						<br />
						<label for="labelUser">
							<span id="login-key">您好，</span>
						</label>
						<span class="emphasized">${userLogined.username}</span>
						<br />
						<input type="hidden" name="message" value="quit" />
						<input type="submit" value="退出" class="button" />
					</p>
				</div>
			</c:otherwise>
		</c:choose>
		</fieldset>
	</form>
	<script type="text/javascript" src="${statics}/script/module/user/login/login.js"></script>
	<script type="text/javascript" src="${statics}/script/module/user/login/register.js"></script>
</div>