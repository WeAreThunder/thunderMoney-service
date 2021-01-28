package com.thunder.money.entity;

import java.util.Date;

import com.github.pagehelper.Page;
import lombok.Data;

/**
    * 测试对象：game
    */
@Data
public class TestGame {

    private Integer id;

    private String name;

    private Integer version;

    private Integer likeCount;

    private Date createTime;

    private Date editTime;

}