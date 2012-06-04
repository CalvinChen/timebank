$(document).ready(function(){
	console.log("call the login.js file");
	$("#formLogin").validate({
		rules: {
			"form.user.loginName": {
				required: true,
				email: true
			},
			"form.user.password": {
				required: true,
				minlength: 6
			}
		},
		messages: {
			"form.user.loginName": {
				required: "请输入账户名",
				email: "请输入您的电子邮箱！"
			},
			"form.user.password": {
				required: "请输入密码",
				minlength: "密码最短为6个字符！"
			}
		}
	});
});
$("#btnLogin").on("click", function(){
	$("#formLogin").validate();
	$("#formLogin").submit();
});
$("#btnRegister").on("click", function(){
	location.href = $(this).attr("data-url");
	return false;
});