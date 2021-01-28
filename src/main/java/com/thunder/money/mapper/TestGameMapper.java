package com.thunder.money.mapper;
import java.util.Date;
import com.thunder.money.entity.DTO.TestGameDTO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.thunder.money.entity.TestGame;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestGameMapper<selectAll, selectByAll> {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TestGame record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TestGame record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    TestGame selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TestGame record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TestGame record);


    List<TestGame> selectAll();

    List<TestGame> selectAllByTestGameDTO(TestGameDTO testGameDTO);

    List<TestGame> selectByAll(TestGame testGame);

    int insertList(@Param("list")List<TestGame> list);





}