package com.thunder.money.service;

import com.thunder.money.entity.SeBillAdjustDetail;

public interface SeBillAdjustDetailService {


    int deleteByPrimaryKey(Integer id);

    int insert(SeBillAdjustDetail record);

    int insertSelective(SeBillAdjustDetail record);

    SeBillAdjustDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeBillAdjustDetail record);

    int updateByPrimaryKey(SeBillAdjustDetail record);

}

