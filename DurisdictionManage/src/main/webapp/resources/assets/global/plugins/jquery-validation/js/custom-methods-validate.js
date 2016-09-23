/**
 * 只能由字母数字下划线组成
 */
jQuery.validator.addMethod("loginAccount", function(value, element, params) {
		return this.optional(element) || /^[a-zA-Z][a-zA-Z0-9_]*$/.test(value);
	}, "该字段值由字母开头、数字、下划线组成.");
	
/**
 * 只能由汉字字母数字下划线组成
 */
jQuery.validator.addMethod("userName", function(value, element, params) {
		return this.optional(element) || /^[A-Za-z0-9_\u554A-\u9C52]+$/.test(value);
	}, "该字段值由汉字、字母、数字、下划线组成.");
