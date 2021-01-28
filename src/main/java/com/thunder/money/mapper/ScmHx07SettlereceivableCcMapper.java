package com.thunder.money.mapper;

import com.thunder.money.entity.ScmHx07SettlereceivableCc;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScmHx07SettlereceivableCcMapper {
    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(ScmHx07SettlereceivableCc record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ScmHx07SettlereceivableCc record);
}