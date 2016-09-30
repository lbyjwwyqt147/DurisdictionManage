package pers.liujunyi.tally.mapper;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.ibatis.annotations.Param;

import pers.liujunyi.tally.entity.TCoreAttachment;

/***
 * 文件名称: IAttachmentMapper.java
 * 文件描述: 附件dao接口
 * 公 司: 
 * 内容摘要: 
 * 其他说明:
 * 完成日期:2016年09月26日 
 * 修改记录:
 * @version 1.0
 * @author liujunyi
 */
public interface IAttachmentMapper {
	
	/**
	 * 新增附件信息
	 * @param att
	 * @return
	 */
	public int addAttachment(TCoreAttachment att);
	
	/**
	 * 批量新增附件信息
	 * @param list
	 * @return
	 */
	public int addAttachmentList(CopyOnWriteArrayList<TCoreAttachment> list);
	
	/**
	 * 删除附件信息
	 * @param att
	 * @return
	 */
	public int deleteAttachment(TCoreAttachment att);
	
	/**
	 * 修改附件语音地址
	 * @param id  图片ID
	 * @param voiceUrl  语音路径
	 * @param voiceLength 语音时长
	 * @return
	 */
	public int updateAttachmentVoiceUrl(@Param("id")String id,@Param("voiceUrl")String voiceUrl,@Param("voiceLength")Float voiceLength);
	
	/**
	 * 获取附件集合
	 * @param paramsMap
	 * @return
	 */
	public CopyOnWriteArrayList<TCoreAttachment> findAttachmentList(ConcurrentMap<String, Object> paramsMap);
	

}
