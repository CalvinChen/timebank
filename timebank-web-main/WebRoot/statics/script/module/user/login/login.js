$(document).ready(function(){
	console.log("call the login.js file");
	$("#loginForm").validate({
		rules: {
			"loginUser.username": {
				required: true,
				minlength: 2
			},
			"loginUser.password": {
				required: true,
				minlength: 6
			}
		},
		messages: {
			"loginUser.username": {
				required: "请输入用户名",
				minlength: "用户名最短为2个字符！"
			},
			"loginUser.password": {
				required: "请输入密码",
				minlength: "密码最短为6个字符！"
			}
		}
	});
	
	NMDialog.initDialogLink();
});

function reloadIndex(){
	console.log("reload");
}