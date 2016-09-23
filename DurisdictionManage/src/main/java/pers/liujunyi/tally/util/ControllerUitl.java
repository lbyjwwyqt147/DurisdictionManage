package pers.liujunyi.tally.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

/***
 * 文件名称: ControllerUitl.java
 * 文件描述: Controller工具类
 * 公 司: 
 * 内容摘要: 
 * 其他说明:
 * 完成日期:2016年09月22日 
 * 修改记录:
 * @version 1.0
 * @author liujunyi
 */
public class ControllerUitl {

   private static final Logger LOGGER = Logger.getLogger(ControllerUitl.class);

   /**
    * 获取前端提交到后台的参数
    * @param request
    * @return map
    */
   @SuppressWarnings("rawtypes")
   public static ConcurrentMap<String,Object> getFormData(HttpServletRequest request){
	   ConcurrentMap<String,Object> map = new ConcurrentHashMap<String,Object>();
 		try {
 			Enumeration en = request.getParameterNames();
 	 		while(en.hasMoreElements()){
 	 			String name=(String)en.nextElement();
 	 			String [] values= request.getParameterValues(name);
 	 			if(!name.contains("[]")){
 	 				if(!values[0].equals(""))
 	 					map.put(name, values[0]);
 	 			}else {
 	 				map.put(name.replace("[]", ""), values);
 	 			}
 	 		}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("获取客户端向后台传入的参数出现异常.");
		}
 		return map;
 	}
   
   
	/**
	 * 将json输出到前端(参数非json格式)
	 * @param response
	 * @param obj  任意类型
	 */
	public static void writeJavaScript(HttpServletResponse response,Object obj){
		response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Cache-Control","no-store, max-age=0, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
		try {
			    Gson gson = new Gson();
	            PrintWriter out = response.getWriter();
	            out.write(gson.toJson(obj));
	            out.flush();
	            out.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            LOGGER.error("向客户端输出Json出现异常.");
	        }
	}
	
	/**
	 * 将json输出到前端(参数为json格式)
	 * @param response
	 * @param json  json字符串
	 */
	public static void writeJsonJavaScript(HttpServletResponse response,String json){
		response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Cache-Control","no-store, max-age=0, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
		try {
	            PrintWriter out = response.getWriter();
	            out.write(json);
	            out.flush();
	            out.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            LOGGER.error("向客户端输出Json出现异常.");
	        }
	}
	
	
	
}
