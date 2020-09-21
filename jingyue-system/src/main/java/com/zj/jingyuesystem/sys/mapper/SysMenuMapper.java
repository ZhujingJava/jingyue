package com.zj.jingyuesystem.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.jingyuesystem.sys.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author zhujing
 * @since 2020-09-04
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<SysMenu> selectMenusById(Long roleId);
}
