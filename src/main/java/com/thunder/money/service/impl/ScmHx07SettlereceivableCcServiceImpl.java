package com.thunder.money.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.thunder.money.mapper.ScmHx07SettlereceivableCcMapper;
import com.thunder.money.entity.ScmHx07SettlereceivableCc;
import com.thunder.money.service.ScmHx07SettlereceivableCcService;
@Service
public class ScmHx07SettlereceivableCcServiceImpl implements ScmHx07SettlereceivableCcService{

    @Resource
    private ScmHx07SettlereceivableCcMapper scmHx07SettlereceivableCcMapper;

    @Override
    public int insert(ScmHx07SettlereceivableCc record) {
        return scmHx07SettlereceivableCcMapper.insert(record);
    }

    @Override
    public int insertSelective(ScmHx07SettlereceivableCc record) {
        return scmHx07SettlereceivableCcMapper.insertSelective(record);
    }

}
