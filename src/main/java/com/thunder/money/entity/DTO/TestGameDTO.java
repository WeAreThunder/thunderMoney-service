package com.thunder.money.entity.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class TestGameDTO {
    private Integer page;

    private Integer size;

    private Integer id;

    private String name;

    private Integer version;

    private Integer minLikeCount;

    private Integer maxLikeCount;

    private Date minCreateDate;

    private Date maxCreateDate;
}
