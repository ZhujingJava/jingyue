package com.zj.jingyuesystem.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.zj.jingyuesystem.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
/**
 * <p>
 * 在线用户记录
 * </p>
 *
 * @author zhujing
 * @since 2020-09-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysUserOnline对象", description="在线用户记录")
public class SysUserOnline extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户会话id")
    @TableId("sessionId")
    private String sessionId;

    @ApiModelProperty(value = "登录账号")
    private String loginName;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "登录IP地址")
    private String ipaddr;

    @ApiModelProperty(value = "登录地点")
    private String loginLocation;

    @ApiModelProperty(value = "浏览器类型")
    private String browser;

    @ApiModelProperty(value = "操作系统")
    private String os;

    @ApiModelProperty(value = "在线状态on_line在线off_line离线")
    private String status;

    @ApiModelProperty(value = "session创建时间")
    private LocalDateTime startTimestamp;

    @ApiModelProperty(value = "session最后访问时间")
    private LocalDateTime lastAccessTime;

    @ApiModelProperty(value = "超时时间，单位为分钟")
    private Integer expireTime;

}
