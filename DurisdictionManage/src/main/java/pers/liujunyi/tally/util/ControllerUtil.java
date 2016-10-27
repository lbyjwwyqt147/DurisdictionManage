package pers.liujunyi.tally.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor.GOLD;
import org.apache.tools.ant.taskdefs.compilers.Gcj;

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
public class ControllerUtil {

   private static final Logger LOGGER = Logger.getLogger(ControllerUtil.class);

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
	
	/**
	 * 将对象中的字典代码转换为字典名称
	 * @param map  自定义map 数据     map中的key 对应需要转换的 实体对象中的字段名称
	 * @param obj  实体对象
	 * @return
	 */
	public static Object toBean(ConcurrentMap<String,Object>map,Object obj){
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field:fields){
				String fieldName = field.getName();
				Object o = map.get(fieldName);
				if(o!=null&&!o.equals("")){
					String methodName = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
					Method method = obj.getClass().getDeclaredMethod(methodName,field.getType());
					if("BigDecimal".equals(o.getClass().getSimpleName()))
						o = ((BigDecimal)o).doubleValue();
					method.invoke(obj, field.getType().cast(o));
				}
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("将对象中的字典代码转换为字典名称.");
			return null;
		}
	}
	
	/**
	 * 将对象转为map
	 * @param obj 实体对象
	 * @param strings
	 * @return  返回Map
	 */
	@SuppressWarnings("rawtypes")
	public static ConcurrentMap<String, Object> objectToMap(Object obj,String...strings){
		 ConcurrentMap<String, Object> resultMap =   new ConcurrentHashMap<String, Object>();
		 try {
			 Class type = obj.getClass(); 
			 BeanInfo beanInfo = Introspector.getBeanInfo(type); 
			 PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors(); 
		        for (int i = 0; i< propertyDescriptors.length; i++) { 
		            PropertyDescriptor descriptor = propertyDescriptors[i]; 
		            String propertyName = descriptor.getName(); 
		            if (!propertyName.equals("class")) { 
		                Method readMethod = descriptor.getReadMethod(); 
		                Object result = readMethod.invoke(obj, new Object[0]); 
		                if (result != null) { 
		                	resultMap.put(propertyName, result); 
		                } else { 
		                	resultMap.put(propertyName, ""); 
		                } 
		            } 
		        } 
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("将对象中的字典代码转换为字典名称.");
		}
		return resultMap;
	}
	
}
