package com.zj.jingyuesystem.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.jingyuesystem.sys.entity.SysUserRole;
import com.zj.jingyuesystem.sys.mapper.SysUserRoleMapper;
import com.zj.jingyuesystem.sys.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author zhujing
 * @since 2020-09-04
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Override
    public List<Long> selectList(Long userId) {
        return sysUserRoleMapper.selectList(userId);
    }
}
