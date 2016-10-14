
/***
 * 首页
 * @type 
 */
var HomePage = {
    
	/**
	 * 打开相关菜单项页面
	 * @param {} url
	 * @param {} params
	 */
	openIframePage : function(url,params){
	   $("#content_iframe").attr("src",url);
	},
	
	/**
	 * 初始化页面内容
	 */
	init : function(){
	  //底部版本信息内容
	  commonUtil.pageMsgUitl.setPageBottomMsg("page-footer-inner");
	}
}

$(function(){
   HomePage.init();
});