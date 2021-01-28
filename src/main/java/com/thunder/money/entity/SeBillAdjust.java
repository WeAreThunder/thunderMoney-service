package com.thunder.money.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 客户结算调整单
 */
@ApiModel(value = "com-thunder-money-entity-SeBillAdjust")
@Data
public class SeBillAdjust implements Serializable {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Integer id;

    /**
     * 单据类型
     */
    @ApiModelProperty(value = "单据类型")
    private Byte billType;

    /**
     * 单据编号
     */
    @ApiModelProperty(value = "单据编号")
    private String billNo;

    /**
     * 单据状态，0：已输入，1：已确认，2：审批中，3：已审批，4：已作废
     */
    @ApiModelProperty(value = "单据状态，0：已输入，1：已确认，2：审批中，3：已审批，4：已作废")
    private Byte billStatus;

    /**
     * 公司ID
     */
    @ApiModelProperty(value = "公司ID")
    private Integer companyId;

    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;

    /**
     * 事业部ID
     */
    @ApiModelProperty(value = "事业部ID")
    private Integer bizUnitId;

    /**
     * 事业部名称
     */
    @ApiModelProperty(value = "事业部名称")
    private String bizUnitName;

    /**
     * 营业店ID
     */
    @ApiModelProperty(value = "营业店ID")
    private Integer bizShopId;

    /**
     * 营业店名称
     */
    @ApiModelProperty(value = "营业店名称")
    private String bizShopName;

    /**
     * 业务员ad账号
     */
    @ApiModelProperty(value = "业务员ad账号")
    private String adAccount;

    /**
     * 业务员名称
     */
    @ApiModelProperty(value = "业务员名称")
    private String adAccountName;

    /**
     * 客户mmpId
     */
    @ApiModelProperty(value = "客户mmpId")
    private Integer custMmpId;

    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称")
    private String custName;

    /**
     * 核销项目
     */
    @ApiModelProperty(value = "核销项目")
    private String verifyName;

    /**
     * 项目总营业额
     */
    @ApiModelProperty(value = "项目总营业额")
    private BigDecimal totalTurnover;

    /**
     * 调整金额
     */
    @ApiModelProperty(value = "调整金额")
    private BigDecimal adjustAmount;

    /**
     * 项目总调整金额
     */
    @ApiModelProperty(value = "项目总调整金额")
    private BigDecimal totalAdjustAmount;

    /**
     * 项目折免比例
     */
    @ApiModelProperty(value = "项目折免比例")
    private BigDecimal discountRate;

    /**
     * 调整原因
     */
    @ApiModelProperty(value = "调整原因")
    private String adjustReason;

    /**
     * 客户备注
     */
    @ApiModelProperty(value = "客户备注")
    private String remark;

    /**
     * 对内审批备注
     */
    @ApiModelProperty(value = "对内审批备注")
    private String innerRemark;

    /**
     * 财务结算单号
     */
    @ApiModelProperty(value = "财务结算单号")
    private String receivableNo;

    /**
     * 工作流id
     */
    @ApiModelProperty(value = "工作流id")
    private String bpmTaskId;

    /**
     * 工作流状态:0.初始状态；10.正常流程；30.退回发起人；50.流程重启中；70.流程作废中；90.流程暂停中
     */
    @ApiModelProperty(value = "工作流状态:0.初始状态；10.正常流程；30.退回发起人；50.流程重启中；70.流程作废中；90.流程暂停中")
    private Byte bpmStatus;

    /**
     * 系统创建时间
     */
    @ApiModelProperty(value = "系统创建时间")
    private Date createTime;

    /**
     * 系统更新时间
     */
    @ApiModelProperty(value = "系统更新时间")
    private Date editTime;

    /**
     * 删除标志，0：否，1：是
     */
    @ApiModelProperty(value = "删除标志，0：否，1：是")
    private Byte deleteFlag;

    private static final long serialVersionUID = 1L;
}