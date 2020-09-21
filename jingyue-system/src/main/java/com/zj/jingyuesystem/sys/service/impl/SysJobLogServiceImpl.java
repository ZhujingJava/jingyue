package com.zj.jingyuesystem.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.jingyuesystem.sys.entity.SysJobLog;
import com.zj.jingyuesystem.sys.mapper.SysJobLogMapper;
import com.zj.jingyuesystem.sys.service.ISysJobLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度日志表 服务实现类
 * </p>
 *
 * @author zhujing
 * @since 2020-09-04
 */
@Service
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLog> implements ISysJobLogService {

}
