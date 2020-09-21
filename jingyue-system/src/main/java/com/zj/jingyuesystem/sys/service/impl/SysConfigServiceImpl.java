package com.zj.jingyuesystem.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.jingyuesystem.sys.entity.SysConfig;
import com.zj.jingyuesystem.sys.mapper.SysConfigMapper;
import com.zj.jingyuesystem.sys.service.ISysConfigService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author zhujing
 * @since 2020-09-04
 */
@Service(value = "iSysConfigService")
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {

}
