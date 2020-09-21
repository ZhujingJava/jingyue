package com.zj.jingyuesystem.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.jingyuesystem.sys.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author zhujing
 * @since 2020-09-04
 */
public interface ISysMenuService extends IService<SysMenu> {
    List<SysMenu> selectMenusById(Long roleId);

}
