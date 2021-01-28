package com.thunder.money.mapper;

import com.thunder.money.entity.ScmHx07SettlereceivableSd;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScmHx07SettlereceivableSdMapper {
    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(ScmHx07SettlereceivableSd record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ScmHx07SettlereceivableSd record);
}