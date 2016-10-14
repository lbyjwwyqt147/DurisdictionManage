package pers.liujunyi.tally.factory.sendFactory;

import pers.liujunyi.tally.service.ISenderProviderService;
import pers.liujunyi.tally.service.ISenderService;
import pers.liujunyi.tally.service.impl.MailSenderServiceImpl;

/***
 * 文件名称: SendMailFactory.java
 * 文件描述: 发送邮箱工厂
 * 公 司: 
 * 内容摘要: 
 * 其他说明:
 * 完成日期:2016年10月10日 
 * 修改记录:
 * @version 1.0
 * @author liujunyi
 */
public class SendMailFactory implements ISenderProviderService {

	@Override
	public ISenderService produce() {
		return new MailSenderServiceImpl();
	}

}
