package com.thunder.money.mapper;

import com.thunder.money.entity.SeBillAdjust;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SeBillAdjustMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(SeBillAdjust record);

    int insertOrUpdate(SeBillAdjust record);

    int insertOrUpdateSelective(SeBillAdjust record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SeBillAdjust record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    SeBillAdjust selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SeBillAdjust record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SeBillAdjust record);

    int updateBatch(List<SeBillAdjust> list);

    int updateBatchSelective(List<SeBillAdjust> list);

    int batchInsert(@Param("list") List<SeBillAdjust> list);
    
    List<SeBillAdjust> selectAllByBillStatus(@Param("billStatus")Integer billStatus);

	
}