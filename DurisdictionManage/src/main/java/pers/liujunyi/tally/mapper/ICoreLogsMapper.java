package pers.liujunyi.tally.mapper;

import pers.liujunyi.tally.entity.TCoreLogs;

/***
 * 文件名称: ICoreLogsMapper.java
 * 文件描述: 日志dao接口
 * 公 司: 
 * 内容摘要: 
 * 其他说明:
 * 完成日期:2016年10月17日 
 * 修改记录:
 * @version 1.0
 * @author liujunyi
 */
public interface ICoreLogsMapper {

	/**
	 * 新增日志信息
	 * @param logs
	 * @return
	 */
	public int addLogs(TCoreLogs logs);
	
	/**
	 * 修改日志信息
	 * @param logs
	 * @return
	 */
	public int updateLogs(TCoreLogs logs);
	
	/**
	 * 删除日志
	 * @param ids
	 * @return
	 */
	public int deleteLogs(String[] ids);
	
	
}
