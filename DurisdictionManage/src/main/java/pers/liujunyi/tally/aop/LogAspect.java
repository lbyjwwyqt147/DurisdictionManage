package pers.liujunyi.tally.aop;

import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;

/***
 * 文件名称: LogAspect.java
 * 文件描述: 日志AOP
 * 公 司: 
 * 内容摘要: 
 * 其他说明:
 * 完成日期:2016年10月17日 
 * 修改记录:
 * @version 1.0
 * @author liujunyi
 */
@Aspect
public class LogAspect {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	// 请求地址
	private String requestPath = null ;   
	// 用户名  
    private String userName = null ;
    // 传入参数  
    private ConcurrentMap<?,?> inputParamMap = null ; 
    // 存放输出结果  
    private ConcurrentMap<String, Object> outputParamMap = null; 
    // 开始时间  
    private long startTimeMillis = 0; 
    // 结束时间  
    private long endTimeMillis = 0;
  
    /**
     * 方法调用前触发  
     * @param joinPoint
     */
    @Before("execution(* pers.liujunyi.tally.controller..*.*(..))")  
    public void doBeforeInServiceLayer(JoinPoint joinPoint) {  
        startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间  
    }  
  
    /**
     * 方法调用后触发
     * @param joinPoint
     */
    @After("execution(* pers.liujunyi.tally.controller..*.*(..))")  
    public void doAfterInServiceLayer(JoinPoint joinPoint) {  
        endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间  
        this.printOptLog();  
    }  
  
   
    @Around("execution(* pers.liujunyi.tally.controller..*.*(..))")  
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {  
        /** 
         * 1.获取request信息 
         * 2.根据request获取session 
         * 3.从session中取出登录用户信息 
         */  
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;  
        HttpServletRequest request = sra.getRequest();  
        // 从session中获取用户信息  
        /*String loginInfo = (String) session.getAttribute("username");  
        if(loginInfo != null && !"".equals(loginInfo)){  
            userName = operLoginModel.getLogin_Name();  
        }else{  
            userName = "用户未登录" ;  
        }*/  
        // 获取输入参数  
        inputParamMap = (ConcurrentMap<?, ?>) request.getParameterMap();  
        // 获取请求地址  
        requestPath = request.getRequestURI();  
          
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行  
        outputParamMap = new ConcurrentHashMap<String, Object>();  
        Object result = pjp.proceed();// result的值就是被拦截方法的返回值  
        outputParamMap.put("result", result);  
          
        return result;  
    }  
  
    /**
     * 控制台输出日志   
     */
    private void printOptLog() {  
        Gson gson = new Gson(); 
        String optTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTimeMillis);  
        logger.info("\n user："+userName  
                +"  url："+requestPath+"; op_time：" + optTime + " pro_time：" + (endTimeMillis - startTimeMillis) + "ms ;"  
                +" param："+gson.toJson(inputParamMap)+";"+"\n result："+gson.toJson(outputParamMap));  
    }  
	
}
