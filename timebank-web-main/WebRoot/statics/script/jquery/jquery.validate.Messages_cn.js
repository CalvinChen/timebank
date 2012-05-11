jQuery.extend(jQuery.validator.messages, {
        required: "此项必填",
		remote: "请修正该字段",
		email: "Email格式错误",
		url: "网址格式错误",
		date: "日期格式错误",
		dateISO: "日期格式 (ISO)错误",
		number: "数字不合法",
		digits: "只能输入整数",
		creditcard: "信用卡号不合法",
		equalTo: "两次输入不一致",
		accept: "请输入拥有合法后缀名的字符串",
		maxlength: jQuery.format("最大长度为 {0}"),
		minlength: jQuery.format("最小长度为 {0}"),
		rangelength: jQuery.format("长度应介于 {0} 和 {1}"),
		range: jQuery.format("值应介于 {0} 和 {1}"),
		max: jQuery.format("最大为 {0}"),
		min: jQuery.format("最小为 {0}")
});