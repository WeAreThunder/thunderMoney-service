package com.thunder.money.service.impl;

import com.github.pagehelper.PageHelper;
import com.thunder.money.entity.DTO.TestGameDTO;
import com.thunder.money.entity.TestGame;
import com.thunder.money.mapper.TestGameMapper;
import com.thunder.money.service.TestGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 当一个service有多个impl时，给impl一个名字，controller里可以根据名字指定引入那个impl
 * */
@Service("TestGameServiceImplCopy")
public class TestGameServiceImplCopy implements TestGameService {
    @Autowired
    private TestGameMapper testGameMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return testGameMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TestGame record) {
        return testGameMapper.insert(record);
    }

    @Override
    public int insertSelective(TestGame record) {
        testGameMapper.insertSelective(record);
        return record.getId();
    }

    @Override
    public TestGame selectByPrimaryKey(Integer id) {
        return testGameMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TestGame record) {
        testGameMapper.updateByPrimaryKeySelective(record);
        return record.getId();
    }

    @Override
    public int updateByPrimaryKey(TestGame record) {
        return testGameMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TestGame> selectAll() {
        return testGameMapper.selectAll();
    }

    @Override
    public List<TestGame> selectAllByTestGameDTO(TestGameDTO testGameDTO) {
        return testGameMapper.selectAllByTestGameDTO(testGameDTO);
    }

    @Override
    public List<TestGame> selectByAll(TestGame testGame) {
        return null;
    }

    @Override
    public int insertList(List list) {
        int i = testGameMapper.insertList(list);
        return i;
    }

    @Override
    public List<TestGame> selectAllByTestGameDTOAndPage(int page, int size, TestGameDTO testGameDTO) {
        PageHelper.startPage(page, size);
        List testGameList = testGameMapper.selectAllByTestGameDTO(testGameDTO);
        System.out.println("233333333333333333333");
        return testGameList;
    }

    @Override
    public List<TestGame> selectByTestGameDTO(TestGameDTO testGameDTO) {
        if (testGameDTO.getPage() == null) {
            testGameDTO.setPage(1);
        }
        if (testGameDTO.getSize() == null) {
            testGameDTO.setSize(5);
        }
        PageHelper.startPage(testGameDTO.getPage(), testGameDTO.getSize());
        List testGameList = testGameMapper.selectAllByTestGameDTO(testGameDTO);
        return testGameList;
    }

}
