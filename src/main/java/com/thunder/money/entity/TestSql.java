package com.thunder.money.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class TestSql implements Serializable {
    private Integer id;

    private String no;

    private String manName;

    private String projectName;

    private Integer gameLike;

    private Integer loveLike;

    private static final long serialVersionUID = 1L;
}