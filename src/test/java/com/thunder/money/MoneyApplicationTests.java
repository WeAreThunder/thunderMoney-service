package com.thunder.money;

import com.thunder.money.entity.SeBillAdjust;
import com.thunder.money.service.SeBillAdjustService;
import com.thunder.money.utils.OmsCodeGenerateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootTest
class MoneyApplicationTests {

    @Autowired
    SeBillAdjustService seBillAdjustService;


    @Test
    void contextLoads() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMDD");
        List<String> noList = OmsCodeGenerateUtil.batchGenerateCode("BAS", dateFormat, 1, 5);

        SeBillAdjust seBillAdjust = new SeBillAdjust();
        
        seBillAdjust.setBillNo(noList.get(0));
        seBillAdjustService.insert(seBillAdjust);
        
    }

}
