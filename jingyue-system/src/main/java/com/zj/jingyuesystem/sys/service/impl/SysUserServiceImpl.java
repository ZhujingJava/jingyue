package com.zj.jingyuesystem.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.jingyuesystem.sys.entity.SysUser;
import com.zj.jingyuesystem.sys.mapper.SysUserMapper;
import com.zj.jingyuesystem.sys.service.ISysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zhujing
 * @since 2020-09-04
 */
//@Service("sysUserService")
@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
