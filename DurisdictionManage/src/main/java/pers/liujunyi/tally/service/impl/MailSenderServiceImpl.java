package pers.liujunyi.tally.service.impl;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;







import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import pers.liujunyi.tally.entity.TCoreMailModel;
import pers.liujunyi.tally.service.ISenderService;

/***
 * 文件名称: MailSenderServiceImpl.java
 * 文件描述: 通过邮箱方式发送验证码
 * 公 司: 
 * 内容摘要: 
 * 其他说明:
 * 完成日期:2016年10月10日 
 * 修改记录:
 * @version 1.0
 * @author liujunyi
 */
@Service
public class MailSenderServiceImpl implements ISenderService {
    
	private static final Logger LOGGER = Logger.getLogger(MailSenderServiceImpl.class);
	
    
	private JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

	@Override
	public AtomicBoolean sendSecurityCode(String receiver) {
		LOGGER.info("邮件正在发送中...........");
		TCoreMailModel mailModel =  new  TCoreMailModel();
		AtomicBoolean success =  new AtomicBoolean(false);
		try {
			//创建邮件消息
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper;
			messageHelper = new MimeMessageHelper(message, true,"utf-8");
			//设置发件人邮箱
			if(mailModel.getEmailFrom() != null){
				messageHelper.setFrom(mailModel.getEmailFrom());
			}
			//设置收件人邮箱
			if(mailModel.getToEmails() != null){
				//拆分为多个收件人
				String[] toEmailArray =  mailModel.getToEmails().split(";");
				messageHelper.setTo(toEmailArray);
			}else{
				LOGGER.error("收件人邮箱不能为空.");
			}
			
			//设置邮件主题
			if(mailModel.getSubject() != null){
				messageHelper.setSubject(mailModel.getSubject());
			}
			
			//如果有图片
			if(mailModel.getPictures() != null && !mailModel.getPictures().isEmpty()){
				for(Iterator<Map.Entry<String, Object>> iterator = mailModel.getPictures().entrySet().iterator();iterator.hasNext();){
					Map.Entry<String, Object> entry = iterator.next();
					//key
					String key = entry.getKey();
					//value
					String filePath = (String) entry.getValue();
					File file = new File(filePath);
                    if (!file.exists()) {
                    	LOGGER.error("图片不存在.");
                    }else{
                    	FileSystemResource img = new FileSystemResource(file);
                        messageHelper.addInline(key, img);
                    }
				}
			}
			
			//如果有附件
			if(mailModel.getAttachments() != null && !mailModel.getAttachments().isEmpty()){
				for(Iterator<Map.Entry<String, Object>> iterator = mailModel.getAttachments().entrySet().iterator();iterator.hasNext();){
					Map.Entry<String, Object> entry = iterator.next();
					//key
					String key = entry.getKey();
					//value
					String filePath = (String) entry.getValue();
					File file = new File(filePath);
                    if (!file.exists()) {
                    	LOGGER.error("附件不存在.");
                    }else{
                    	FileSystemResource fileResource = new FileSystemResource(file);
                        messageHelper.addAttachment(key, fileResource);
                    }
				}
			}
			
			//true 表示启动html格式邮件
			messageHelper.setText(mailModel.getContent(), true);
			Properties prop = new Properties();
			//将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确  
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.timeout", "25000");
			prop.put("mail.smtp.port", "25");
			//设置发送时间
			messageHelper.setSentDate(new Date());
			javaMailSender.setHost(mailModel.getEmailHost());
			javaMailSender.setJavaMailProperties(prop);
			javaMailSender.setUsername(mailModel.getEmailFrom());
			javaMailSender.setPassword(mailModel.getEmailPassword());
			//发送邮件
			javaMailSender.send(message);
			success.set(true);
			LOGGER.info("邮件发送完毕.");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("发送邮件失败.");
		}
		return success;

	}

}
