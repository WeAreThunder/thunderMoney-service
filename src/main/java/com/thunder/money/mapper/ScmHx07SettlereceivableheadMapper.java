package com.thunder.money.mapper;

import com.thunder.money.entity.ScmHx07Settlereceivablehead;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScmHx07SettlereceivableheadMapper {
    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(ScmHx07Settlereceivablehead record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ScmHx07Settlereceivablehead record);
}