package com.thunder.money.service;

import com.thunder.money.entity.DTO.TestSqlDTO;
import com.thunder.money.entity.TestSql;

import java.util.List;

public interface TestSqlService {


    int deleteByPrimaryKey(Integer id);

    int insert(TestSql record);

    int insertSelective(TestSql record);

    TestSql selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestSql record);

    int updateByPrimaryKey(TestSql record);

    List<TestSqlDTO> testSql(TestSqlDTO testSqlDTO);

}

