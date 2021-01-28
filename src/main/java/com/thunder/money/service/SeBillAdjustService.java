package com.thunder.money.service;

import com.thunder.money.entity.SeBillAdjust;import java.util.List;

public interface SeBillAdjustService {


    int deleteByPrimaryKey(Integer id);

    int insert(SeBillAdjust record);

    int insertSelective(SeBillAdjust record);

    SeBillAdjust selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeBillAdjust record);

    int updateByPrimaryKey(SeBillAdjust record);

    int insertOrUpdate(SeBillAdjust record);

    int insertOrUpdateSelective(SeBillAdjust record);

    int updateBatch(List<SeBillAdjust> list);

    int updateBatchSelective(List<SeBillAdjust> list);

    int batchInsert(List<SeBillAdjust> list);
    
    List<SeBillAdjust> selectAll(Integer status);
}



