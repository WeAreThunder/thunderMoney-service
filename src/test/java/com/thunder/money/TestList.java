package com.thunder.money;

import com.sun.org.apache.xerces.internal.xs.StringList;
import com.thunder.money.entity.SeBillAdjust;
import com.thunder.money.entity.TestEntity;
import com.thunder.money.service.SeBillAdjustService;
import com.thunder.money.service.TestGameService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class TestList {
    @Autowired
    private static SeBillAdjustService seBillAdjustService;
    
    public static void main(String[] args) {
//        testList();
        Date date = new Date();
        long d = date.getTime();
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        calendar.add(Calendar.DATE,-100);
        long c = calendar.getTime().getTime();
        System.out.println("--------起-----------");
        System.out.println(calendar.getTime());
        System.out.println(df.format(calendar.getTime()));
        System.out.println(c);
        System.out.println("--------止-----------");
        System.out.println(date);
        System.out.println(df.format(date));
        System.out.println(d);


        BigDecimal bigDecimal = new BigDecimal("1234.1234");
        //小数点右移两位
        BigDecimal bigDecimal1 = bigDecimal.movePointRight(2);//123412.34
        //小数点左移两位
        BigDecimal bigDecimal2 = bigDecimal.movePointLeft(2);//12.341234
        //得到整数
        System.out.println(bigDecimal.intValue());//1234
        //得到浮点数
        System.out.println(bigDecimal.floatValue());
        System.out.println(bigDecimal.byteValue());
        
        

        System.out.println(bigDecimal);
        System.out.println(bigDecimal1);
        System.out.println(bigDecimal2);
        
        //优雅的判空写法
        SeBillAdjust seBillAdjust = new SeBillAdjust();
//        seBillAdjust = null;
        Integer integer = Optional.ofNullable(seBillAdjust.getId()).orElse(200);
        System.out.println(integer);

//        List<SeBillAdjust> list1 = seBillAdjustService.selectAll(10);
//        System.out.println(list1);

        List<SeBillAdjust> list = new ArrayList<>();
//        list = null;
        
        


        String s = Optional.ofNullable(
                StringUtils.join(
                        list.stream()
                        .map(SeBillAdjust::getBillNo)
                        .collect(Collectors.toList())
                        ,
                        ','
                )
        ).orElse("22222");
        System.out.println("sout:"+s+"end");



    }

    public void play(){
        int num = 0;
        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(j);
                num++;
            }
            if (i%5==0){
                System.out.println();
            }
        }
        System.out.println(num);
    }

    public static void testList(){
        List<TestEntity> testEntityList = new ArrayList<>();
        int bizType;
        List<Integer> bizTypeList = new ArrayList<>();
        bizTypeList.add(1);
        bizTypeList.add(2);
        bizTypeList.add(3);
        bizTypeList.add(4);
        bizTypeList.add(5);


        TestEntity testEntity1 = new TestEntity();
        TestEntity testEntity2 = new TestEntity();
        TestEntity testEntity3 = new TestEntity();
        TestEntity testEntity4 = new TestEntity();
        TestEntity testEntity5 = new TestEntity();

        testEntity1.setId(1);
        testEntity2.setId(2);
        testEntity3.setId(3);
        testEntity4.setId(4);
        testEntity5.setId(5);

        testEntity1.setName("wlm");
        testEntity2.setName("yly");
        testEntity3.setName("wxc");
        testEntity4.setName("wq");
        testEntity5.setName("cym");

        testEntityList.add(testEntity1);
        testEntityList.add(testEntity2);
        testEntityList.add(testEntity3);
        testEntityList.add(testEntity4);
        testEntityList.add(testEntity5);
        System.out.println("----------------------");
        //list.???
        boolean add = testEntityList.add(testEntity1);
        boolean b = testEntityList.addAll(testEntityList);
        TestEntity remove = testEntityList.remove(10);
        TestEntity set = testEntityList.set(0, testEntity1);
        TestEntity testEntity = testEntityList.get(1);
        TestEntity x = testEntityList.get(2);
        System.out.println(x);
        System.out.println(testEntityList.get(1));
        //List<E> subList(int fromIndex, int toIndex),返回从索引fromIndex到toIndex的元素集合，包左不包右
        List<TestEntity> testEntityList1 = testEntityList.subList(1, 4);
        System.out.println(testEntityList1);
        //sort排序，reversed()倒序
        testEntityList.sort(Comparator.comparing(TestEntity::getId).reversed().thenComparing(testEntity6 -> testEntity6.getName()));
        System.out.println(testEntity);


        Map<Integer, String> integerStringMap = new HashMap<>();
        integerStringMap.put(1,"23");
        integerStringMap.put(2,"234");
        integerStringMap.put(3,"234");
        integerStringMap.put(4,"234");
        String s = integerStringMap.get(2);
        boolean empty = integerStringMap.isEmpty();
        System.out.println(integerStringMap.containsKey(5));
        integerStringMap.put(5, "234234");
        System.out.println(integerStringMap.containsKey(5));

        System.out.println(integerStringMap.containsValue("23"));

        integerStringMap.remove(1);
        Collection<String> values = integerStringMap.values();
        System.out.println(integerStringMap.size());
        System.out.println(integerStringMap.keySet());

        System.out.println(integerStringMap);
        integerStringMap.putAll(integerStringMap);
        
    }
}

