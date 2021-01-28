package com.thunder.money.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author wangleiming
 */
@Data
public class TestEntity {
    private int id;
    private String name;
    private Date birthday;
    private Date createTime;
    private Date editTime;
}
