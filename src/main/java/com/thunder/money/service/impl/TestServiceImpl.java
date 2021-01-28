package com.thunder.money.service.impl;

import com.thunder.money.entity.TestEntity;
import com.thunder.money.mapper.TestMapper;
import com.thunder.money.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<TestEntity> selectAll() {
        List<TestEntity> testEntity = testMapper.selectAll();
        return testEntity;
    }

    @Override
    public TestEntity selectById(int id) {
        TestEntity testEntity = testMapper.selectById(id);
        return testEntity;
    }

    @Override
    public List<TestEntity> getAllByXml() {
        List<TestEntity> allByXml = testMapper.getAllByXml();
        System.out.println(allByXml);
        return allByXml;
    }

    @Override
    public TestEntity getOneByXml(int id) {
        TestEntity oneByXml = testMapper.getOneByXml(id);
        return oneByXml;
    }

//    插入之后，获取主键，只需要直接调用方法，getId即可
    @Override
    public int insert(TestEntity testEntity) {
        int insert = testMapper.insert(testEntity);
        return testEntity.getId();
    }


}
