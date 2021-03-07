package com.thunder.money.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 客户结算调整单明细表
 */
@ApiModel(value = "com-thunder-money-entity-SeBillAdjustDetail")
@Data
public class SeBillAdjustDetail implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 调整单ID
     */
    @ApiModelProperty(value = "调整单ID")
    private Integer billId;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    /**
     * 订单明细ID
     */
    @ApiModelProperty(value = "订单明细ID")
    private Integer orderDetailId;

    /**
     * 费用类型
     */
    @ApiModelProperty(value = "费用类型")
    private Integer chargeType;

    /**
     * 款项类别
     */
    @ApiModelProperty(value = "款项类别")
    private Integer paymentType;

    /**
     * 调整金额
     */
    @ApiModelProperty(value = "调整金额")
    private BigDecimal adjustAmount;

    /**
     * 调整前营业额
     */
    @ApiModelProperty(value = "调整前营业额")
    private BigDecimal amount;

    /**
     * 调整税率
     */
    @ApiModelProperty(value = "调整税率")
    private BigDecimal taxRate;

    /**
     * 调整日期
     */
    @ApiModelProperty(value = "调整日期")
    private Date adjustDate;

    /**
     * 明细备注
     */
    @ApiModelProperty(value = "明细备注")
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date editTime;

    /**
     * 是否删除，0：否，1：是
     */
    @ApiModelProperty(value = "是否删除，0：否，1：是")
    private Byte deleteFlag;

    private static final long serialVersionUID = 1L;
}