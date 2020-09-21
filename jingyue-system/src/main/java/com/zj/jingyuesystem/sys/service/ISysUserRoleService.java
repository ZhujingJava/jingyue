package com.zj.jingyuesystem.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.jingyuesystem.sys.entity.SysUserRole;

import java.util.List;

/**
 * <p>
 * 用户和角色关联表 服务类
 * </p>
 *
 * @author zhujing
 * @since 2020-09-04
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    List<Long> selectList(Long userId);
}
