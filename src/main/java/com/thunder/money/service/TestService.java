package com.thunder.money.service;

import com.thunder.money.entity.TestEntity;
import com.thunder.money.mapper.TestMapper;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TestService {
    List<TestEntity> selectAll();

    TestEntity selectById(int id);

    List<TestEntity> getAllByXml();

    public TestEntity getOneByXml(int id);

    int insert(TestEntity testEntity);

}
