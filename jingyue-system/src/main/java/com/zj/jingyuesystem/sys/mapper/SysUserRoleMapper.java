package com.zj.jingyuesystem.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.jingyuesystem.sys.entity.SysUserRole;

import java.util.List;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author zhujing
 * @since 2020-09-04
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
       List<Long> selectList(Long userId);
}
