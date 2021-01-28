package com.thunder.money.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.thunder.money.entity.SeBillAdjustDetail;
import com.thunder.money.mapper.SeBillAdjustDetailMapper;
import com.thunder.money.service.SeBillAdjustDetailService;

@Service
public class SeBillAdjustDetailServiceImpl implements SeBillAdjustDetailService {

    @Resource
    private SeBillAdjustDetailMapper seBillAdjustDetailMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return seBillAdjustDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SeBillAdjustDetail record) {
        return seBillAdjustDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(SeBillAdjustDetail record) {
        return seBillAdjustDetailMapper.insertSelective(record);
    }

    @Override
    public SeBillAdjustDetail selectByPrimaryKey(Integer id) {
        return seBillAdjustDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SeBillAdjustDetail record) {
        return seBillAdjustDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SeBillAdjustDetail record) {
        return seBillAdjustDetailMapper.updateByPrimaryKey(record);
    }

}

