<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="sidebar">
	<div id="loginForm">

		<form method="post" action="LoginAdmin_login">
			<fieldset>
				<h2 class="title">
						<c:choose>
							<c:when test="${empty adminLogined}">
							管理员登陆
							</c:when>
							<c:otherwise>
							管理员首页
							</c:otherwise>
						</c:choose> 
				</h2>
				<c:choose>
					<c:when test="${empty adminLogined}">
						<div id="fieldset">
						<span id="message">&nbsp;${message}<s:fielderror /></span>
							<div class="oneRowMin clear">
								<div class="rowLeftMin">
									<label for="labelUser">
										<span id="login-key">账&nbsp;&nbsp;号：</span>
									</label>
								</div>
								<div class="rowRightMin">
									<input id="labelUser" type="text" name="admin.username"
									class="login-text" size="15"/>
								</div>
							</div>
							<div class="oneRowMin clear">
								<div class="rowLeftMin">
									<label for="labelPass">
										<span id="login-key">密&nbsp;&nbsp;码：</span>
									</label>
								</div>
								<div class="rowRightMin">
									<input id="labelPass" type="password" name="admin.password"
									class="login-text" size="15" />
								</div>
							</div>
							<div class="oneRowMin clear">
								<div class="rowLeftMin">
									<input type="checkbox" id="auto" name="autoLogin" value="Yes" checked="checked">
								</div>
								<div class="rowRightMin">
									<span class="emphasized">
										<label for="auto">记住我的登录状态</label>
									</span>
								</div>
							</div>
							<div class="oneRowMin clear">
								<div class="rowLeftMin">
									&nbsp;
								</div>
								<div class="rowRightMin">
									<span class="emphasized">
										<input type="submit" value="登陆" class="button" />
									</span>
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div id="fieldset">
							<p>
								<br />
								<label for="labelUser">
									<span id="login-key">您好，</span>
								</label>
								<span class="emphasized">${adminLogined.username}</span>
								<br />
								<input type="hidden" name="message" value="quit" />
								<input type="submit" value="退出" class="button" />
							</p>
						</div>
					</c:otherwise>
				</c:choose>
			</fieldset>
		</form>
	</div>
</div>