package com.thunder.money.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @author wangleiming
 */
@ApiModel(value="com-thunder-money-entity-ScmHx07SettlereceivableCc")
@Data
public class ScmHx07SettlereceivableCc implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="")
    private BigDecimal billdtlid;

    @ApiModelProperty(value="")
    private BigDecimal billid;

    @ApiModelProperty(value="")
    private BigDecimal ccStatus;

    @ApiModelProperty(value="")
    private Date ccChangedate;

    @ApiModelProperty(value="")
    private String ccNotes;

    @ApiModelProperty(value="")
    private BigDecimal ccMender;

    @ApiModelProperty(value="")
    private Date ccMendertime;

    @ApiModelProperty(value="")
    private BigDecimal ccLaststatus;

    @ApiModelProperty(value="")
    private BigDecimal dtlLaststatus;

    @ApiModelProperty(value="")
    private Date syncdate;

}