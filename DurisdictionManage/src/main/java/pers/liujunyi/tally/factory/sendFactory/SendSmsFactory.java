package pers.liujunyi.tally.factory.sendFactory;

import pers.liujunyi.tally.service.ISenderProviderService;
import pers.liujunyi.tally.service.ISenderService;
import pers.liujunyi.tally.service.impl.SmsSenderServiceImpl;

/***
 * 文件名称: SendSmsFactory.java
 * 文件描述: 发送短信工厂
 * 公 司: 
 * 内容摘要: 
 * 其他说明:
 * 完成日期:2016年10月10日 
 * 修改记录:
 * @version 1.0
 * @author liujunyi
 */
public class SendSmsFactory implements ISenderProviderService {

	@Override
	public ISenderService produce() {
		return new SmsSenderServiceImpl();
	}

}
