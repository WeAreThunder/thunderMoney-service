package com.thunder.money.controller;

import com.thunder.money.entity.BASE.RestFul;
import com.thunder.money.entity.SeBillAdjust;
import com.thunder.money.service.SeBillAdjustService;
import com.thunder.money.utils.OmsCodeGenerateUtil;
import com.thunder.money.utils.RandNameUtil;
import com.thunder.money.utils.ShowTime;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Description :test
 * @Author : wangleiming
 * @Date : 2021/1/5 上午 11:04
 */
@RestController
@RequestMapping("/seBillAdjust")
@Slf4j
@Api("结算调整")
public class SeBillAdjustController {

    @Autowired
    private SeBillAdjustService seBillAdjustService;

    /**
     * @param seBillAdjustList: 调整单列表
     * @Description :批量插入
     * @Return : com.thunder.money.entity.BASE.RestFul<java.lang.Integer>
     * @Author : wangleiming
     * @Date : 2021/1/8 下午 01:14
     */
    @PostMapping("/batchInsert")
    public RestFul<Integer> batchInsert(@RequestBody List<SeBillAdjust> seBillAdjustList) {
        int i = seBillAdjustService.batchInsert(seBillAdjustList);

        //单条插入
        int insert = seBillAdjustService.insert(seBillAdjustList.get(0));
        Integer id = seBillAdjustList.get(0).getId();
        System.out.println(id);
        System.out.println(insert);

        //单挑插入并返回idlist
        seBillAdjustList.stream().map(seBillAdjust -> seBillAdjust.getId()).collect(Collectors.toList()).forEach(integer -> System.out.println(integer));

        return RestFul.mAnds("批量插入" + i + "条数据", i);
    }

    @PostMapping("/insert")
    public RestFul<SeBillAdjust> insert(@RequestBody SeBillAdjust seBillAdjust) {

//        UUID uuid = UUID.randomUUID();
//        String s = uuid.toString();
//        char a  = ' ';
//        String trim = s.trim();
//        String replace = s.replace("-", "");
//        System.out.println(replace);
        //开始计时
        Long startTime = System.currentTimeMillis();

        int insert = 0;
        for (int i = 0; i < 100000; i++) {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            List<String> noList = OmsCodeGenerateUtil.batchGenerateCode("BAS", dateFormat, 1, 5);

//        SeBillAdjust seBillAdjust = new SeBillAdjust();

            seBillAdjust.setAdAccountName(RandNameUtil.randomName(false,3));
            seBillAdjust.setBillNo(noList.get(0));

            insert = insert + seBillAdjustService.insert(seBillAdjust);

            if (i % 100 == 0){
                //计时结束
                Long endTime = System.currentTimeMillis();
                System.out.print("生成到第"+i + "条  ");
                Long tempTime = (endTime - startTime);System.out.println(ShowTime.showTimeByTemp(tempTime));
                System.out.println(ShowTime.showTimeByTemp(tempTime));
            }
        }


        
        return RestFul.mAnds("插入" + insert + "条数据成功", seBillAdjust);

    }

    /**
     * @param seBillAdjustList: 调整单列表
     * @Description :批量更新
     * @Return : com.thunder.money.entity.BASE.RestFul<java.lang.Integer>
     * @Author : wangleiming
     * @Date : 2021/1/8 下午 01:13
     */
    @PostMapping("/batchUpdate")
    public RestFul<Integer> batchUpdate(@RequestBody List<SeBillAdjust> seBillAdjustList) {
        int i = seBillAdjustService.updateBatch(seBillAdjustList);
        int i1 = seBillAdjustService.updateByPrimaryKeySelective(seBillAdjustList.get(0));
        System.out.println(i1);

        //单条插入
        int insert = seBillAdjustService.insert(seBillAdjustList.get(0));
        System.out.println(insert);
        ShowTime.showTimeByTemp(System.currentTimeMillis());

        return RestFul.mAnds("批量更新" + i + "条数据", i);
    }

    
    

}
