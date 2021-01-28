package com.thunder.money.service;

import com.thunder.money.entity.DTO.TestGameDTO;
import com.thunder.money.entity.TestGame;
import com.thunder.money.mapper.TestGameMapper;

import java.util.List;


public interface TestGameService {
    List<TestGame> selectAllByTestGameDTOAndPage(int page, int size, TestGameDTO testGameDTO);

    int deleteByPrimaryKey(Integer id);

    int insert(TestGame record);

    int insertSelective(TestGame record);

    TestGame selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestGame record);

    int updateByPrimaryKey(TestGame record);

    List<TestGame> selectAll();

    List<TestGame> selectAllByTestGameDTO(TestGameDTO testGameDTO);

    List<TestGame> selectByAll(TestGame testGame);

    int insertList(List list);

    List<TestGame> selectByTestGameDTO(TestGameDTO testGameDTO);

}
