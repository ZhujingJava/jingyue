package com.zj.jingyuesystem.sys.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zj.jingyuesystem.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 代码生成业务表字段
 * </p>
 *
 * @author zhujing
 * @since 2020-09-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="GenTableColumn对象", description="代码生成业务表字段")
public class GenTableColumn extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "column_id", type = IdType.AUTO)
    private Long columnId;

    @ApiModelProperty(value = "归属表编号")
    private String tableId;

    @ApiModelProperty(value = "列名称")
    private String columnName;

    @ApiModelProperty(value = "列描述")
    private String columnComment;

    @ApiModelProperty(value = "列类型")
    private String columnType;

    @ApiModelProperty(value = "JAVA类型")
    private String javaType;

    @ApiModelProperty(value = "JAVA字段名")
    private String javaField;

    @ApiModelProperty(value = "是否主键（1是）")
    private String isPk;

    @ApiModelProperty(value = "是否自增（1是）")
    private String isIncrement;

    @ApiModelProperty(value = "是否必填（1是）")
    private String isRequired;

    @ApiModelProperty(value = "是否为插入字段（1是）")
    private String isInsert;

    @ApiModelProperty(value = "是否编辑字段（1是）")
    private String isEdit;

    @ApiModelProperty(value = "是否列表字段（1是）")
    private String isList;

    @ApiModelProperty(value = "是否查询字段（1是）")
    private String isQuery;

    @ApiModelProperty(value = "查询方式（等于、不等于、大于、小于、范围）")
    private String queryType;

    @ApiModelProperty(value = "显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）")
    private String htmlType;

    @ApiModelProperty(value = "字典类型")
    private String dictType;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

}
