package com.zj.jingyuesystem.utils;

import com.zj.jingyuesystem.sys.entity.SysMenu;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuTreeUtil {
    private SysMenuItem menuItem;


    @Cacheable("MENU_ITEM")
    public SysMenuItem getMenuItem() {
        System.out.println("测试是否加入到缓存");
        return this.menuItem;
    }

    @CacheEvict(value = "MENU_ITEM")
    public  void clearCache(){}

    public void setMenuItem(SysMenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public SysMenuItem buildMenuTree(SysMenuItem parent, List<SysMenu> list) {
        if (parent == null) {
            parent = new SysMenuItem();
            SysMenu sysMenu = new SysMenu();
            parent.setId(0L);
            parent.setOrderNum(0);
            parent.setName("顶级菜单");
            parent.setSysMenu(sysMenu);
        }
        if (list.size() == 0) return null;
        List<SysMenu> tempList = new ArrayList<>();
        for (SysMenu sysMenu : list) {
            Long parentId = sysMenu.getParentId();
            if (parent.getId().equals(parentId)) {
                SysMenuItem item = new SysMenuItem();
                item.setParentId(parent.getId());
                item.setId(sysMenu.getMenuId());
                item.setSysMenu(sysMenu);
                parent.add(item);
                tempList.add(sysMenu);

            }
        }

        list.removeAll(tempList);

        if (!list.isEmpty()) {
            for (SysMenuItem sysMenuItem : parent.getChildList()) {
                buildMenuTree(sysMenuItem, list);
            }
        }
        setMenuItem(menuItem);
        return parent;

    }


}
