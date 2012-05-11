console.log("call the register.js file");
function bindResetForm(){
	$("#registerForm input[type=reset]").click(function(){
		var validator = $("#registerForm").validate();
		validator.resetForm();
	});
}
function setupValidate(){
	$("#registerForm").validate({
		rules: {
			"user.userInfo.email": {
				email: true,
				required: true
			},
			"user.username": {
				required: true,
				minlength: 2,
				maxlength: 20
			},
			"user.password": {
				required: true,
				minlength: 6,
				maxlength: 50
			},
			"passwordConfirm": {
				required: true,
				equalTo: "#passwordInput"
			}
		}
	});
}
function tryAjaxForm(){
	$("#registerForm").ajaxForm({
//		dataType: "json",
		success: showMessage
	});
}
function showMessage(resp){
	var message = JSON.parse(resp);
	console.log(message.status);
	console.log(message.info);
	$("#returnText h3").html(message.info);
	if(message.status == true){
		NMDialog.openDialog("#returnText", function(){
			NMDialog.closeDialog();
		});
	} else {
		NMDialog.openDialog("#returnText");
	}
}