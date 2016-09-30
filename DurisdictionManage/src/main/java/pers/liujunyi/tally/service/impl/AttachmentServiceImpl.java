package pers.liujunyi.tally.service.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import pers.liujunyi.tally.entity.TCoreAttachment;
import pers.liujunyi.tally.mapper.IAttachmentMapper;
import pers.liujunyi.tally.service.IAttachmentService;
import pers.liujunyi.tally.util.Constants;

/***
 * 文件名称: AttachmentServiceImpl.java
 * 文件描述: 附件service接口实现
 * 公 司: 
 * 内容摘要: 
 * 其他说明:
 * 完成日期:2016年09月26日 
 * 修改记录:
 * @version 1.0
 * @author liujunyi
 */
@Service
public class AttachmentServiceImpl implements IAttachmentService {

	@Autowired
	private IAttachmentMapper attMapper;
	
	@Override
	public int addAttachment(TCoreAttachment att) {
		return attMapper.addAttachment(att);
	}

	@Override
	public int deleteAttachment(TCoreAttachment att) {
		return attMapper.addAttachment(att);
	}

	@Override
	public String saveInfo(TCoreAttachment att, String task) {
		ConcurrentMap<String, Object> resulMap = new ConcurrentHashMap<String, Object>();
		AtomicBoolean success = new AtomicBoolean(false);
		String message = "保存附件信息失败.";
		try {
			int count = 0;
			if(task.equals(Constants.ADD)){
				count = attMapper.addAttachment(att);
			}
			if(count > 0){
				success.set(true);
				message = "保存附件信息成功.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resulMap.put("success", success);
		resulMap.put("message", message);
		return new Gson().toJson(resulMap);
	}

	@Override
	public int addAttachmentList(CopyOnWriteArrayList<TCoreAttachment> list) {
		return attMapper.addAttachmentList(list);
	}

	@Override
	public int updateAttachmentVoiceUrl(String id, String voiceUrl,Float voiceLength) {
		return attMapper.updateAttachmentVoiceUrl(id, voiceUrl,voiceLength);
	}

	@Override
	public CopyOnWriteArrayList<TCoreAttachment> findAttachmentList(
			ConcurrentMap<String, Object> paramsMap) {
		return attMapper.findAttachmentList(paramsMap);
	}

}
