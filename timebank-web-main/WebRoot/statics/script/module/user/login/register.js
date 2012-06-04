console.log("call the register.js file");
$.validator.addMethod("checkEmailDuplicate", function(value, element){
	var result = false;
	$.ajax({
		url : Global.path + "/user/checkEmailDuplicate?form.user.loginName=" + value,
		type : "post", 
		dataType : "json",
		async : false,
		success : function(json) {
			result = json.form.checkDuplicateResult;
		}
	});
	return result;
});
$.validator.addMethod("checkDisplayNameDuplicate", function(value, element){
	var result = false;
	$.ajax({
		url : Global.path + "/user/checkDisplayNameDuplicate?form.user.displayName=" + value,
		type : "post", 
		dataType : "json",
		async : false,
		success : function(json) {
			result = json.form.checkDuplicateResult;
		}
	});
	return result;
});
$("#registerForm").validate({
			rules : {
				"form.user.loginName" : {
					email : true,
					required : true,
					checkEmailDuplicate : true
				},
				"form.user.displayName" : {
					required : true,
					minlength : 2,
					maxlength : 20,
					checkDisplayNameDuplicate : true
				},
				"form.user.password" : {
					required : true,
					minlength : 6,
					maxlength : 50
				},
				"form.passwordConfirm" : {
					required : true,
					equalTo : "#passwordInput"
				}
			}
		});
$("#registerForm input[type=reset]").click(function() {
			var validator = $("#registerForm").validate();
			validator.resetForm();
		});