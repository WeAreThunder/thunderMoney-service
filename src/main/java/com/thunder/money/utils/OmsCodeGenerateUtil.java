package com.thunder.money.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.*;

/**
 * <p>Description: [编码生成工具类]</p>
 */
@Component
public class OmsCodeGenerateUtil {
    
    /**
     * 批量获取Code
     * @param prefix：业务场景，比如 ZLJG 表示租赁价格
     * @param sdf: 日期格式化方式，如 yyyyMMdd
     * @param batchNum: 批量生成多少条，如 1000条
     * @param increaseFormatNum: 自增数格式化成多少位，如 5位
     * @return 生成的编码列表,如[]
     */
    public static List<String> batchGenerateCode(String prefix, DateFormat sdf, int batchNum, int increaseFormatNum) {
        if (null == prefix || sdf==null ||batchNum<=0) {
            return null;
        }

        //构造key
        Date date = Calendar.getInstance().getTime();
        String formatDate = sdf.format(date);

        //批量生成no
        Random random = new Random();
        int finalNum = random.nextInt(99999);
//        int i = UUID.randomUUID().toString().hashCode();
//        finalNum += i;

        //获取自增位格式化位数
        DecimalFormat df = new DecimalFormat(StringUtils.repeat("0",increaseFormatNum));

        //构造结果
        List<String> result = new ArrayList<>(batchNum);
        for(int num = finalNum-batchNum+1; num<=finalNum; num++){
            result.add(new StringBuffer(prefix).append(formatDate).append(df.format(num)).toString());
        }

        return result;
    }

}
