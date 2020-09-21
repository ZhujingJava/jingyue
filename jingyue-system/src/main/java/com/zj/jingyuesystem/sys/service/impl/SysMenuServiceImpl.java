package com.zj.jingyuesystem.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.jingyuesystem.sys.entity.SysMenu;
import com.zj.jingyuesystem.sys.mapper.SysMenuMapper;
import com.zj.jingyuesystem.sys.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author zhujing
 * @since 2020-09-04
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {


    @Autowired
    SysMenuMapper sysMenuMapper;
    @Override
    @Cacheable(value = "SYS_MENU",key = "#userId")
    public List<SysMenu> selectMenusById(Long userId) {
        List<SysMenu> sysMenus = sysMenuMapper.selectMenusById(userId);
        return sysMenus;
    }
}
