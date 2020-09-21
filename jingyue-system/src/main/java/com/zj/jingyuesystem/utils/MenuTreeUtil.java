package com.zj.jingyuesystem.utils;

import com.zj.jingyuesystem.sys.entity.SysMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuTreeUtil {

    public static SysMenuItem buildMenuTree(SysMenuItem parent, List<SysMenu> list) {

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

        return parent;

    }


}
