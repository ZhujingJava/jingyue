package com.zj.jingyuesystem.utils;

import com.zj.jingyuesystem.sys.entity.SysMenu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SysMenuItem extends SysMenu implements Comparator<SysMenu> {
    private Long id;
    private Long parentId;
    private Integer orderNum;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<SysMenuItem> childList = new ArrayList<>();
    private SysMenu sysMenu;


    public void add(SysMenuItem menuItem) {
        childList.add(menuItem);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public SysMenuItem() {

    }


    public List<SysMenuItem> getChildList() {
        return childList;
    }

    public void setChildList(List<SysMenuItem> childList) {
        this.childList = childList;
    }

    public SysMenu getSysMenu() {
        return sysMenu;
    }

    public void setSysMenu(SysMenu sysMenu) {
        this.sysMenu = sysMenu;
    }

    public SysMenuItem(Long id) {
        this.id = id;
    }

    @Override
    public int compare(SysMenu o1, SysMenu o2) {
        return o2.getOrderNum() - o1.getOrderNum();
    }
}
