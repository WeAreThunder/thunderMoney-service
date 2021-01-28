package com.thunder.money.service.impl;

import com.thunder.money.entity.DTO.TestSqlDTO;
import com.thunder.money.entity.TestEntity;
import com.thunder.money.entity.TestGame;
import com.thunder.money.service.TestGameService;
import com.thunder.money.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.thunder.money.entity.TestSql;
import com.thunder.money.mapper.TestSqlMapper;
import com.thunder.money.service.TestSqlService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestSqlServiceImpl implements TestSqlService {

    @Resource
    private TestSqlMapper testSqlMapper;

    @Qualifier("TestGameServiceImpl")
    @Autowired
    private TestGameService testGameService;

    @Autowired
    private TestService testLoveService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return testSqlMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TestSql record) {
        return testSqlMapper.insert(record);
    }

    @Override
    public int insertSelective(TestSql record) {
        return testSqlMapper.insertSelective(record);
    }

    @Override
    public TestSql selectByPrimaryKey(Integer id) {
        return testSqlMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TestSql record) {
        return testSqlMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TestSql record) {
        return testSqlMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TestSqlDTO> testSql(TestSqlDTO testSqlDTO) {
        List<TestSqlDTO> testSqlDTOS = new ArrayList<>();
        testSqlDTO.setStartRow((testSqlDTO.getPage()-1)*testSqlDTO.getSize());
        testSqlDTO.setEndRow(testSqlDTO.getSize());
        List<TestSql> testSqls = testSqlMapper.testSql(testSqlDTO);
        TestSqlDTO testSqlDTOForLoop = new TestSqlDTO();
        for (TestSql testSql : testSqls) {
            TestGame testGame = testGameService.selectByPrimaryKey(testSql.getGameLike());
            TestEntity testLove = testLoveService.selectById(testSql.getLoveLike());
            testSqlDTOForLoop.setTestSql(testSql);
            testSqlDTOForLoop.setTestGame(testGame);
            testSqlDTOForLoop.setTestLove(testLove);
            testSqlDTOS.add(testSqlDTOForLoop);
        }
        return testSqlDTOS;
    }

}

