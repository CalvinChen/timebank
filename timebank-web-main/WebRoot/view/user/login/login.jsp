<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${css}/module/user/login/login.css" type="text/css" rel="stylesheet" />
<div class="row">
	<div class="span4 well">
	<form id="formLogin" class="form-horizontal" method="post" action="user/submitLogin">
		<fieldset>
		<%@ include file="/view/common/part/common/message.jsp"%>
		<legend>
			<c:choose>
				<c:when test="${empty userLogined}">
				<i class="icon-time"></i> 欢迎使用华南农业大学<strong>时间银行</strong>
				</c:when>
				<c:otherwise>
				首页
				</c:otherwise>
			</c:choose> 
		</legend>
		<c:choose>
			<c:when test="${empty currentUser}">
				<div class="control-group">
					<label class="control-label" for="input01">账户名 <i class="icon-user"></i></label>
					<div class="controls">
						<input id="input01" class="input-medium" type="text" name="form.user.loginName" placeholder="您的电子邮件"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="input02">密码 <i class="icon-lock"></i></label>
					<div class="controls">
						<input id="input02" class="input-medium" type="password" name="form.user.password" placeholder="您的密码"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">是否记住登录状态 <i class="icon-check"></i></label>
					<div class="controls">
						<label class="checkbox">
							<input type="checkbox" name="form.addCookie" value="true" checked="checked">
							是的，记住
						</label>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">
						<a href="Contact_forgetPSW">忘记密码 </a><i class="icon-question-sign"></i>
					</label>
					<div class="controls">
						<div class="btn-group">
							<button id="btnLogin" class="btn btn-large btn-success">
								<i class="icon-ok icon-white"></i> 登录
							</button>
							<button id="btnRegister" class="btn btn-large" data-url="${path}/user/register">
								<i class="icon-plus"></i> 注册
							</button>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
					<ul class="thumbnails">
					  <li id="userPhoto" class="span4">
					    <div class="thumbnail">
    					<a href="#" class="thumbnail">
					      <img src="
					      	<c:choose>
						      	<c:when test="${empty user.userInfo.userPhoto}">
						      		http://placehold.it/320X320
						      	</c:when>
						      	<c:otherwise>${user.userInfo.userPhoto}</c:otherwise>
					      	</c:choose>
					      	" alt="${currentUser.displayName}">
					      </a>
					      <h5>${currentUser.displayName}</h5>
					      <p>Thumbnail caption right here...</p>
					    </div>
					  </li>
					</ul>
			</c:otherwise>
		</c:choose>
		<hr>
		<div class="span3">
			<div class="alert alert-info">
				他们刚刚也注册了哦！
			</div>
			<ul class="thumbnails">
				<c:forEach begin="1" end="6">
					<li class="span1">
						<a href="#" class="thumbnail">
							<img alt="" src="http://placehold.it/120X120">
						</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		</fieldset>
		
	</form>
	</div>
	
	<script type="text/javascript" src="${statics}/script/module/user/login/login.js"></script>
	<script type="text/javascript" src="${statics}/script/module/user/login/register.js"></script>
</div>