<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/view/common/taglibs.jsp"%>
<div id="myModal">
	<div class="modal-header">
		<h3>欢迎入户时间银行！</h3>
	</div>
	<div class="span10">
		<div class="row">
			<div class="span4 well">
				<h4><i class="icon-star"></i> 入户须知 <i class="icon-star"></i></h4>
				<p>时间银行目前对外开放注册。注册用户可以登录网站查看相关信息，
				但是还无法使用如存储时间、提取时间等银行业务哦。</p>
				<p>只有通过我们身份验证的<br>
					<strong>华南农业大学全日制本科生</strong><br>
				才拥有使用银行业务的权限。</p>
			</div>
			<div class="span5">
				<form id="registerForm" class="form-horizontal" 
						action="${path}/user/register/do_register" method="post">
					<fieldset>
						<div class="control-group">
								<input class="input-large required" name="user.userInfo.email" 
									type="text" placeholder="Email">
						</div>
						<div class="control-group">
								<input class="input-large" name="user.username" 
									type="text" placeholder="用户名">
						</div>
						<div class="control-group">
								<input id="passwordInput" class="input-large" name="user.password" 
									type="password" placeholder="密码">
						</div>
						<div class="control-group">
								<input class="input-large" name="passwordConfirm" 
									type="password" placeholder="重复密码">
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
</div>
<div id="returnText" class="hide">
	<h3></h3>
	<button class="btn btn-large btn-success closeDialog">确定</button>
</div>
<script>
	setupValidate();
	bindResetForm();
	tryAjaxForm();
</script>