package pers.liujunyi.tally.util;

import javax.servlet.http.HttpServletRequest;

/***
 * 文件名称: IServiceUtil.java
 * 文件描述: service工具类接口
 * 公 司: 
 * 内容摘要: 
 * 其他说明:
 * 完成日期:2016年09月20日 
 * 修改记录:
 * @version 1.0
 * @author liujunyi
 */
public interface IServiceUtil {

	/**
	 * 封装Ztree树结构
	 * @param id        字典编号值
	 * @param pid       字典父级编号
	 * @param name      字典名称
	 * @param open      当前节点是否展开
	 * @param checked   当前节点是否选中
	 * @param title     标题
	 * @param url       节点点击url链接 
	 * @param isParent  是否是父节点
	 * @param target    指向的标记 超链接 target 属性: "_blank", "_self" 或 其他指定窗口名称
	 * @param icon      节点icon图标
	 * @param iconOpen  节点展开icon图标
	 * @param iconClose 节点关闭icon图标
	 * @param isHidden  节点是否被隐藏
	 * @param nocheck   节点是否显示选择框   
	 * @param iconSkin  节点图标css样式名称  
	 * @param request
	 * @param str
	 * @return 返回 zTree需要的json格式数据
	 */
	public  String getZTreeItemJSON(String id,String pid,String name,String open,String checked,
			String title,String url,String isParent,String target,String icon,String iconOpen,String iconClose,
			String isHidden,String nocheck,String iconSkin,HttpServletRequest request,String... str);
}
