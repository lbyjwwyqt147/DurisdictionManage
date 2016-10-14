/***
 * 业务字典
 * @type 
 */
var Dict = {
    form : $("#dict-form"),
	/**
	 * 表单验证
	 */
	dictFormValidation :function() {
	   Dict.form.validate({
                errorElement: 'span',
                errorClass: 'help-block help-block-error',
                focusInvalid: false, 
                //focusCleanup:true,
                ignore: "",  
                rules: {
                    dictWord: {
                        maxlength: 4,
                        required: true,
                        numberLetter :true,
                        remote: {
						    url: "tally/dict/checkDictWord",     //后台处理程序
						    type: "post",               //数据发送方式
						    dataType: "json",           //接受数据格式   
						    data: {                     //要传递的数据
						        dictWord: function() {
						            return $.trim($("#dictWord").val());
						        },
						        parentCode: function() {
						            return $.trim($("#parentCode").val());
						        }
						    }
						}
                    },
                    dictName: {
                    	maxlength: 15,
                        required: true,
                        chineseNumber: true
                    },
                    parentText: {
                        required: true
                    },
                    entityName: {
                        maxlength: 50
                    },
                    entityFieldName: {
                        maxlength: 50,
                        remote: {
						    url: "tally/dict/checkDictEntityAndFieldName",     //后台处理程序
						    type: "post",               //数据发送方式
						    dataType: "json",           //接受数据格式   
						    data: {                     //要传递的数据
						        entityName: function() {
						            return $.trim($("#entityName").val());
						        },
						        fieldName: function() {
						            return $.trim($("#entityFieldName").val());
						        }
						    }
						}
                    },
                    dictDescription: {
                        maxlength: 50
                    }
                    
                },

                invalidHandler: function (event, validator) {             
                   
                },

                errorPlacement: function (error, element) { 
                    var icon = $(element).parent('.input-icon').children('i');
                    icon.removeClass('fa-check').addClass("fa-warning");  
                    icon.attr("data-original-title", error.text()).tooltip({'container': 'body'});
                },

                highlight: function (element) { 
                    $(element)
                        .closest('.form-group').removeClass("has-success").addClass('has-error'); 
                },

                unhighlight: function (element) { 
                    
                },

                success: function (label, element) {
                    var icon = $(element).parent('.input-icon').children('i');
                    $(element).closest('.form-group').removeClass('has-error').addClass('has-success'); 
                    icon.removeClass("fa-warning").addClass("fa-check");
                },

                submitHandler: function (form) {
                     form[0].submit(); 
                }
            });
	},
	/**
	 * 初始化字典树
	 */
	initZtree : function(){
	  zTreeUtil.createZtree({
	    zTreeWidgetId : "dictTree",    //树控件div Id
	    zTreeWidgetInputValue : "1",  //树被选中的节点ID值
	    zTreeWidgetInputId : "",     //树被选中的节点ID
	    zTreeNodeIdValue : "1",      //节点值
	    searchInputId : "", //查询条件input ID
	    zTreeUrl : "tally/dict/dictTree",
	    onCloseTree : function(){
	       
	    },
	    onMouseUp : function(){
	    
	    },
	    onClick : function(event, treeId, treeNode){
	       var nodeName = treeNode.name;
	       var nodeId = treeNode.id;
           $('#parentText').val(nodeName);
           $('#parentCode').val(nodeId);
           
	    }
	});
	},
	
	/**
	 * 初始化 
	 */
	init : function(){
		Dict.initZtree();
	    Dict.dictFormValidation();
	    //$("#isParent").select2();
	    $('#isParent', Dict.form).change(function () {
	    	    var entityName = $("#entityName");
	    	    var entityFieldName = $("#entityFieldName");
	    	    if($(this).val() == "1"){
	    	    	var fieldVild = {required:true,letter:true};
	    	    	//实体名称增加验证规则
	    	    	entityName.rules("add",fieldVild);
	    	    	//字段名称增加验证规则
	    	        entityFieldName.rules("add",fieldVild);
	    	        $(".labelcustom").css({"color":"rgb(231, 61, 74)"});
	    	        entityFieldName.css({"border-color":"rgb(231, 61, 74)"});
	    	        entityName.css({"border-color":"rgb(231, 61, 74)"});
	    	    }else{
	    	    	//实体名称移除验证规则
	    	    	entityName.rules("remove","required letter");
	    	    	//字段名称移除验证规则
	    	        entityFieldName.rules("remove","required letter");
	    	        entityFieldName.removeAttr("aria-invalid");
	    	        entityName.removeAttr("aria-invalid");
	    	        entityFieldName.removeAttr("aria-describedby");
	    	        entityName.removeAttr("aria-describedby");
	    	        entityFieldName.css({"border-color":"#c2cad8"});
	    	        entityName.css({"border-color":"#c2cad8"});
	    	        $(".facustom").removeClass("fa-warning");
	    	        $(".labelcustom").css({"color":"#333"});
	    	        
	    	    }
	    	    
	    	    //验证实体名称
                Dict.form.validate().element(entityName); 
                //验证字段名称
                Dict.form.validate().element(entityFieldName); 
                
        });
	}
}

$(function(){
   Dict.init();
})