package pers.liujunyi.tally.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.liujunyi.tally.entity.TCoreLogs;
import pers.liujunyi.tally.mapper.ICoreLogsMapper;
import pers.liujunyi.tally.service.ICoreLogsService;

/***
 * 文件名称: CoreLogsServiceImpl.java
 * 文件描述: 日志service接口实现
 * 公 司: 
 * 内容摘要: 
 * 其他说明:
 * 完成日期:2016年10月17日 
 * 修改记录:
 * @version 1.0
 * @author liujunyi
 */
@Service
public class CoreLogsServiceImpl implements ICoreLogsService {

	@Autowired
	private ICoreLogsMapper logsMapper;
	
	@Override
	public int addLogs(TCoreLogs logs) {
		return logsMapper.addLogs(logs);
	}

	@Override
	public String saveLogs(TCoreLogs logs, String... strs) {
        int count = logsMapper.addLogs(logs);
        String result = null;
        if(count > 0){
        	result = "保存日志成功.";
        }
		return result;
	}

	@Override
	public int deleteLogs(String[] ids) {
		return logsMapper.deleteLogs(ids);
	}

}
