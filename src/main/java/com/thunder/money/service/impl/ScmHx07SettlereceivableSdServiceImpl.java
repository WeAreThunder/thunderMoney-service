package com.thunder.money.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.thunder.money.mapper.ScmHx07SettlereceivableSdMapper;
import com.thunder.money.entity.ScmHx07SettlereceivableSd;
import com.thunder.money.service.ScmHx07SettlereceivableSdService;
@Service
public class ScmHx07SettlereceivableSdServiceImpl implements ScmHx07SettlereceivableSdService{

    @Resource
    private ScmHx07SettlereceivableSdMapper scmHx07SettlereceivableSdMapper;

    @Override
    public int insert(ScmHx07SettlereceivableSd record) {
        return scmHx07SettlereceivableSdMapper.insert(record);
    }

    @Override
    public int insertSelective(ScmHx07SettlereceivableSd record) {
        return scmHx07SettlereceivableSdMapper.insertSelective(record);
    }

}
