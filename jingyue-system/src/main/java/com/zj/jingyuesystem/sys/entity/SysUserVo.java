package com.zj.jingyuesystem.sys.entity;

import com.zj.jingyuesystem.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor

public class SysUserVo extends BaseEntity {
    private  Integer userId;
    private  String loginName;
    private  String userName;
    private List<SysRoleMenu> permissions;
    private  List<String> roles;

}
