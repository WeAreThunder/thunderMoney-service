package com.thunder.money.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.thunder.money.mapper.ScmHx07SettlereceivableheadMapper;
import com.thunder.money.entity.ScmHx07Settlereceivablehead;
import com.thunder.money.service.ScmHx07SettlereceivableheadService;
@Service
public class ScmHx07SettlereceivableheadServiceImpl implements ScmHx07SettlereceivableheadService{

    @Resource
    private ScmHx07SettlereceivableheadMapper scmHx07SettlereceivableheadMapper;

    @Override
    public int insert(ScmHx07Settlereceivablehead record) {
        return scmHx07SettlereceivableheadMapper.insert(record);
    }

    @Override
    public int insertSelective(ScmHx07Settlereceivablehead record) {
        return scmHx07SettlereceivableheadMapper.insertSelective(record);
    }

}
