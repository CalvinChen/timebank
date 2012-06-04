<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/view/common/header.jsp"%>
<%@ include file="/view/common/part/user/nav.jsp"%>

<div id="registerDiv">
	<div class="row">
		<div class="span11 offset1">
			<h1>欢迎入户时间银行！</h1>
		</div>
	</div>
	<div class="row">
		<div class="span4 offset1 well">
			<ul>
				<h3><i class="icon-star"></i> 入户须知 <i class="icon-star"></i></h3>
				<li>时间银行目前对外开放注册，但只有通过身份验证的会员才可使用时间银行业务。</li>
				<li>欲使用时间银行业务，请于工作日上班时间，亲自持本人校园卡到启林南分点办理身份验证。</li>
				<li>真诚互助，惠及你我。</li>
			</ul>
		</div>
		<div class="span6">
				<form id="registerForm" class="form-horizontal" 
						action="${path}/user/submitRegister" method="post">
					<fieldset>
						<%@ include file="/view/common/part/common/message.jsp"%>
						<legend>请填写以下简单信息</legend>
						<div class="control-group">
							<label class="control-label" for="inputLoginName">电子邮件</label>
							<div class="controls">
								<input id="inputLoginName" class="input-large required" name="form.user.loginName" 
									type="text" placeholder="推荐填写最常使用的Email">
								<p class="help-block">用于登录时间银行以及Email联系</p>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputDisplayName">用户名</label>
							<div class="controls">
								<input id="inputDisplayName" class="input-small" name="form.user.displayName" 
									type="text" placeholder="2-20字以内">
								<p class="help-block">对其它用户的唯一昵称显示，可在注册后更换</p>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="passwordInput">密码</label>
							<div class="controls">
								<input id="passwordInput" class="input-large" name="form.user.password" 
									type="password" placeholder="6个字符以上">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="input03">重复密码</label>
							<div class="controls">
								<input id="input03" class="input-large" name="form.passwordConfirm" 
									type="password" placeholder="与上面保持一致">
							</div>
						</div>
						<hr>
						<div class="btn-group pull-right">
							<input type="submit" value="注册" id="registerBtn"
								 class="btn btn-primary btn-large"/>
							<input type="reset" value="重置" class="btn btn-large"/>
						</div>
					</fieldset>
				</form>
		</div>
	</div>
</div>

<script src="${statics}/script/module/user/login/register.js" type="text/javascript"></script>
<link href="${css}/module/user/login/register.css" type="text/css" rel="stylesheet" />
<%@ include file="/view/common/footer.jsp"%>