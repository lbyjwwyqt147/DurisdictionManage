var Login = function() {
	
	/**
	 * 用户登录
	 */
    var handleLogin = {
    
    	 /**
    	  * 验证登录表单
    	  */
         validateLoginForm : function(){
	         //获取登录用户名
	    	var loginUser = $("#login_user").val();
	    	//获取密码
	    	var loginPwd = $("#login_pwd").val();
	    	//是否验证成功
	    	var isValidate = true;
	    	if($.trim(loginUser) == "" && $.trim(loginPwd) != ""){
	    	   $('.alert-danger', $('.login-form')).show();
	    	   isValidate = false;
	    	   $("#loginErrorMessage").html("请输入帐号.")
	    	}else if($.trim(loginPwd) == "" && $.trim(loginUser) != "" ){
	    	    $('.alert-danger', $('.login-form')).show();
	    		isValidate = false;
	    		$("#loginErrorMessage").html("请输入密码.")
	    	}else if($.trim(loginUser) == "" && $.trim(loginPwd) == ""){
	    	    $('.alert-danger', $('.login-form')).show();
	    		isValidate = false;
	    		$("#loginErrorMessage").html("请输入登录帐号和密码.")
	    	}else{
	    	    $('.alert-danger', $('.login-form')).hide();
	    	}
	    	return isValidate;
         },
         
         /**
          * 用户登录事件
          */
         userLogin : function(){
            //判断是否表单验证成功,进行登录操作
         	if(handleLogin.validateLoginForm()){
         	    $.ajax({
         	      url : "tally/user/userLogin",
         	      data :$(".login-form").serialize(),
         	      dataType : "json",
         	      type : "post",
         	      success : function(data, textStatus){
         	         console.log(data);
         	         window.location.href="tally/home/initHome";
         	      }

         	   });
         	}
         
         },
         
         /**
          * 隐藏登录验证提示信息
          */
         loginErrorMessageHide : function(){
            $('.alert-danger', $('.login-form')).hide();
         },
         
         init : function (){
	          $('.login-form input').keypress(function(e) {
	            if (e.which == 13) {
	                handleLogin.userLogin();
	                return false;
	            }
	          });
             
	          /**
	           * 登录点击事件
	           */
	         $("#login-btn").click(function(e){
	             handleLogin.userLogin();
	         }) 
	         //底部版本信息内容
	         commonUtil.pageMsgUitl.setPageBottomMsg("copyright");
         }
         
    };
    
    /**
     * 找回密码
     */
    var handleForgetPassword = function() {
        $('.forget-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
            rules: {
            	 forget_user: {
                    required: true
                },
                forget_email: {
                    required: true,
                    email: true
                }
            },

            messages: {
            	forget_user: {
                    required: "请输入要找回密码的用户名."
                },
                forget_email: {
                    required: "请输入注册时的邮箱地址."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   

            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function(form) {
                form.submit();
            }
        });

        $('.forget-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.forget-form').validate().form()) {
                    $('.forget-form').submit();
                }
                return false;
            }
        });
        
        /**
         * 点击“忘记密码”事件
         */
        jQuery('#forget-password').click(function() {
        	//隐藏登录验证提示信息
        	handleLogin.loginErrorMessageHide();
        	//隐藏登录页面
            jQuery('.login-form').hide();
            //显示找回密码页面
            jQuery('.forget-form').show();
            
        });

        /**
         * 找回密码页面中点击"上一步"事件
         */
        jQuery('#back-btn').click(function() {
        	//登录页面显示
            jQuery('.login-form').show();
            //找回密码页面隐藏
            jQuery('.forget-form').hide();
            //将找回密码页面中的form表单数据重置
            jQuery('.forget-form')[0].reset();
            //重置找回密码form表单验证为初始状态
            jQuery('.has-error .input-icon>i').css({"color":"#ccc"});
            jQuery('.forget-form').validate().resetForm();
        });

    };

    /**
     * 注册
     */
    var handleRegister = function() {

        function format(state) {
            if (!state.id) { return state.text; }
            var $state = $(
             '<span><img src="../assets/global/img/flags/' + state.element.value.toLowerCase() + '.png" class="img-flag" /> ' + state.text + '</span>'
            );
            
            return $state;
        }

        if (jQuery().select2 && $('#country_list').size() > 0) {
            $("#country_list").select2({
	            placeholder: '<i class="fa fa-map-marker"></i>&nbsp;Select a Country',
	            templateResult: format,
                templateSelection: format,
                width: 'auto', 
	            escapeMarkup: function(m) {
	                return m;
	            }
	        });


	        $('#country_list').change(function() {
	            $('.register-form').validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input
	        });
    	}

        $('.register-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
            rules: {

                userNickname: {
                    required: true,
                    rangelength:[2,10],
                    userName:true
                },
                userEmail: {
                    required: true,
                    email: true,
                    rangelength:[4,20]
                },
                loginUser: {
                    required: true,
                    rangelength:[4,20],
                    loginAccount:true
                },
                loginPwd: {
                    required: true,
                    rangelength:[6,16]
                },
                affirmLoginPwd: {
                    equalTo: "#register_password"
                },
                userSecurityCode: {
                    required: true
                },
                tnc: {
                    required: true
                }
            },

            messages: { // custom messages for radio buttons and checkboxes
                tnc: {
                    required: "请同意服务条款."
                },
                userNickname: {
                    required: "请填写长度在2到10之间的昵称.",
                    rangelength:"请填写长度在2到10之间的昵称."
                },
                userEmail: {
                    required: "请填写电子邮箱，邮箱用于找回密码.",
                    rangelength:"请填写长度在4到20之间的邮箱地址."
                    
                },
                loginUser: {
                    required: "请填写帐号,帐号由字母开头、数字、下划线组成.",
                    rangelength:"请填写长度在4到20之间的帐号."
                },
                loginPwd: {
                    required: "请填写登录密码.",
                    rangelength:"请填写长度在6到16之间的密码."
                },
                affirmLoginPwd: {
                    equalTo: "两次密码输入不一致."
                },
                userSecurityCode: {
                    required: "请填写验证码."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   

            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
               
                //验证码错误时控制“获取验证码”按钮的位置    
                if(typeof($("#userSecurityCode").attr("aria-invalid"))=="undefined" || $("#userSecurityCode").attr("aria-invalid")){
                    $("#getUserSecurityCode").css({"margin-top":"-29px"});
                }    
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
                //验证码正确时控制“获取验证码”按钮的位置    
                if(label.attr("id") == "userSecurityCode-error"){
                	$("#getUserSecurityCode").css({"margin-top":"0px"});
                }
            },

            errorPlacement: function(error, element) {
                if (element.attr("name") == "tnc") { // insert checkbox errors after the container                  
                    error.insertAfter($('#register_tnc_error'));
                } else if (element.closest('.input-icon').size() === 1) {
                    error.insertAfter(element.closest('.input-icon'));
                }else {
                    error.insertAfter(element);
                }
            },

            submitHandler: function(form) {
                
                
            }
        });

        /**
         * 提交注册表单
         */
        function registerFormAjaxSubmit(){
            $('.register-form').ajaxSubmit({
                  url : commonUtil.itemAbsolutePath+"/tally/user/saveUser",
         	      data :$(".register-form").serialize(),
         	      dataType : "json",
         	      type : "post",
         	      success : function(data, textStatus){
         	         console.log(data);
         	      }
            });
        }
        
        $('.register-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.register-form').validate().form()) {
                    $('.register-form').submit();
                }
                return false;
            }
        });
        
        

        /**
         * 点击"注册"按钮事件
         */
        jQuery('#register-btn').click(function() {
        	//隐藏登录验证提示信息
        	handleLogin.loginErrorMessageHide();
        	//登录页面隐藏
            jQuery('.login-form').hide();
            //注册页面显示
            jQuery('.register-form').show();
        });

        /**
         * 注册页面中"上一步"事件
         */
        jQuery('#register-back-btn').click(function() {
        	//登录页面显示
            jQuery('.login-form').show();
            //注册页面隐藏
            jQuery('.register-form').hide();
            //重置注册页面form
            jQuery('.register-form')[0].reset();
            //重置注册form表单验证为初始状态
            jQuery('.has-error .input-icon>i').css({"color":"#ccc"});
            jQuery('.register-form').validate().resetForm();
            $("#getUserSecurityCode").css({"margin-top":"0px"});
        });
    };

    return {
        //main function to initiate the module
        init: function() {

            handleLogin.init();
            handleForgetPassword();
            handleRegister();

        }

    };

}();

jQuery(document).ready(function() {
    Login.init();
});