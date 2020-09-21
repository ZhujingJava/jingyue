package com.zj.jingyuesystem.sys.entity;
import com.zj.jingyuesystem.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 用户和角色关联表
 * </p>
 *
 * @author zhujing
 * @since 2020-09-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysUserRole对象", description="用户和角色关联表")
public class SysUserRole extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

}
