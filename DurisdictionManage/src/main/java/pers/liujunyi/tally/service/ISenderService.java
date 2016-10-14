package pers.liujunyi.tally.service;

import java.util.concurrent.atomic.AtomicBoolean;

/***
 * 文件名称: ISenderService.java
 * 文件描述: 发送验证码service接口
 * 公 司: 
 * 内容摘要: 
 * 其他说明:
 * 完成日期:2016年10月10日 
 * 修改记录:
 * @version 1.0
 * @author liujunyi
 */
public interface ISenderService {

	/**
	 * 发送验证码方法
	 * @param receiver 接收者  多个用;隔开
	 */
	public AtomicBoolean sendSecurityCode(String receiver);
}
