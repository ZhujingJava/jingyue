package com.zj.jingyuesystem.sys.entity;
import com.zj.jingyuesystem.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 用户与岗位关联表
 * </p>
 *
 * @author zhujing
 * @since 2020-09-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysUserPost对象", description="用户与岗位关联表")
public class SysUserPost extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "岗位ID")
    private Long postId;

}
