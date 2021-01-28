package com.thunder.money.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.thunder.money.mapper.SeBillAdjustMapper;
import com.thunder.money.entity.SeBillAdjust;
import com.thunder.money.service.SeBillAdjustService;import java.util.List;

@Service
public class SeBillAdjustServiceImpl implements SeBillAdjustService {

    @Resource
    private SeBillAdjustMapper seBillAdjustMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return seBillAdjustMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SeBillAdjust record) {
        return seBillAdjustMapper.insert(record);
    }

    @Override
    public int insertSelective(SeBillAdjust record) {
        return seBillAdjustMapper.insertSelective(record);
    }

    @Override
    public SeBillAdjust selectByPrimaryKey(Integer id) {
        return seBillAdjustMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SeBillAdjust record) {
        return seBillAdjustMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SeBillAdjust record) {
        return seBillAdjustMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertOrUpdate(SeBillAdjust record) {
        return seBillAdjustMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SeBillAdjust record) {
        return seBillAdjustMapper.insertOrUpdateSelective(record);
    }

    /**
     * @Description :批量更新
     * @param list: 调整单列表
     * @Return : int 更新行数
     * @Author : WangLeiMing
     * @Date : 2021/1/6 下午 07:50
     */
    @Override
    public int updateBatch(List<SeBillAdjust> list) {
        return seBillAdjustMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SeBillAdjust> list) {
        return seBillAdjustMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SeBillAdjust> list) {
        return seBillAdjustMapper.batchInsert(list);
    }

    @Override
    public List<SeBillAdjust> selectAll(Integer status) {
        return seBillAdjustMapper.selectAllByBillStatus(status);
    }
}



