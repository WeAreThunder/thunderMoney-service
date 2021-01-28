package com.thunder.money;

import com.thunder.money.entity.TestEntity;
import org.junit.platform.commons.util.StringUtils;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Java 8 Stream
 * <p>
 * 对于简单操作推荐使用外部迭代手动实现，
 * ⭐对于复杂操作，推荐使用Stream API，
 * ⭐在多核情况下，推荐使用并行Stream API来发挥多核优势，
 * 单核情况下不建议使用并行Stream API。
 */
public class TestSteam {
    public static void main(String[] args) throws InterruptedException {
        List<TestEntity> testEntityList = getList();
        //开始计时
        Long startTime = System.currentTimeMillis();
        //------------------------------------------------

        //for循环过滤
//        System.out.println(forFilter(testEntityList));
        //filter 方法用于通过设置的条件过滤出元素。
//        System.out.println(streamFilter(testEntityList));

        //for循环去重
//        System.out.println(forDistinct(testEntityList));
        //distinct()去重
//        System.out.println(streamDistinct(testEntityList));

//        for (TestEntity t :
//                testEntityList) {
//            t.setCreateTime(new Date());
//            t.setBirthday(new Date());
//        }
//        List<TestEntity> testEntityList1 = forDistinct(testEntityList);
//        System.out.println(testEntityList1);

        List<TestEntity> collect = testEntityList.stream().map(testEntity -> {
            testEntity.setBirthday(new Date());
            testEntity.setCreateTime(new Date());
            return testEntity;
        }).distinct().collect(Collectors.toList());

        List<TestEntity> wlm = testEntityList
                .stream()
                //parallelStream 是流并行处理程序的代替方法,此处发现该方法比stream()慢
//                .parallelStream()
                //自定义每个元素的对应元素
                .map(testEntity -> {
                    testEntity.setBirthday(new Date());
                    testEntity.setCreateTime(new Date());
                    return testEntity;
                })
                .filter((testEntity) -> {
                    boolean flag;
                    if (testEntity.getName().equals("wlm") || testEntity.getName().equals("yly")) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                    return flag;
                })
                //去重
                .distinct()
                //获取前10000个
                .limit(10000)
                //排序，默认为正序排序，加上.reversed()为倒序
                .sorted(Comparator
                        .comparing(TestEntity::getId)
                        .reversed()//按照id倒序排序
                        .thenComparing((testEntity) -> testEntity.getName())//按照name正序排序
                        .thenComparing((testEntity) -> testEntity.getEditTime()))//按照EditTime正序排序
                .collect(Collectors.toList());

                testEntityList.stream().forEach(testEntity -> {
                    testEntity.setBirthday(new Date());
                    System.out.println(testEntity);
                });

        testEntityList
                .stream()
                .filter(testEntity -> testEntity.getId() > 0 )
                .collect(Collectors.toList());

//        for (int i = 0; i < testEntityList.size(); i++) {
//            testEntityList.get(i).setCreateTime(new Date());
//            testEntityList.set(i,testEntityList.get(i));
//            System.out.println(testEntityList.get(i));
//        }

//        对list进行排序
        Collections.sort(testEntityList, new Comparator<TestEntity>() {
            @Override
            public int compare(TestEntity o1, TestEntity o2) {
                int a = o1.getId()*30 + o1.getName().length()*20;
                int b = o2.getId()*30 + o2.getName().length()*20;
                return  a-b;
            }
        });

//        int i = testEntityList.indexOf(new TestEntity());
//        System.out.println(i);

        //相同的排序逻辑
        //stream流取最大值 .max()
        Optional<TestEntity> max = testEntityList.stream().max((t1, t2) -> {
            int a = t1.getId() * 10 + t1.getName().length() * 20;
            int b = t2.getId() * 10 + t2.getName().length() * 20;
            return a - b;
        });
        TestEntity testEntityMax = max.get();
        System.out.println(testEntityMax);
        //stream流取最小值 .mix()
        Optional<TestEntity> min = testEntityList.stream().min((t1, t2) -> {
            int a = t1.getId() * 10 + t1.getName().length() * 20;
            int b = t2.getId() * 10 + t2.getName().length() * 20;
            return a - b;
        });
        TestEntity testEntityMin = min.get();
        System.out.println(testEntityMin);

        //求和,使用reduce求和
        Integer reduce = testEntityList.stream()
                .map(testEntity -> testEntity.getId())
                .reduce(0, Integer::sum);
        System.out.println(reduce);
        //求和，使用聚合.collect
        testEntityList.stream().collect(Collectors.toList());
        testEntityList.stream().collect(Collectors.summingInt(TestEntity :: getId));

        Map<Date, List<TestEntity>> listMap = testEntityList
                .stream()
                .collect(Collectors.groupingBy(TestEntity::getBirthday));

        List<HashMap<TestEntity, Integer>> collect1 = testEntityList.stream().map(testEntity -> {
            HashMap<TestEntity, Integer> testEntityIntegerHashMap = new HashMap<>();
            testEntityIntegerHashMap.put(testEntity, testEntity.getId() * 10);
            return testEntityIntegerHashMap;
        }).collect(Collectors.toList());

        //只需要两个属性
//        Map<Integer, String> collect2 = testEntityList
//                .stream()
//                .collect(Collectors
//                        .toMap(TestEntity::getId, TestEntity::getName));

        //当需要计算对象的对应的各种数值时
        Map<Integer, String> collect3 = testEntityList
                .stream()
                .collect(
                        Collectors
                                .toMap(
                                        //key
                                        testEntity -> {
                                            return testEntity.getId();
                                        }
                                        , 
                                        //value
                                        testEntity -> {
//                                            int num = testEntity.getId() * 10 + testEntity.getName().length();
//                                            return 10;
                                            return testEntity.getName();
                                        }
                                        ,
                                        //（非必填参数）当key发生冲突时，将value也就是两个string进行拼接
                                        (s1, s2) ->  {
                                            return s1.concat(s2);
                                        }
                                )
                );
        System.out.println("-----------------");
        System.out.println(collect3);
        

//        TestEntity testEntity = TestEntity.builder().id(23).birthday(new Date()).createTime(new Date()).name("23333").build();

        
        
        List<Map<Integer,String>> ass = new ArrayList<>();
        Map<Integer,String> aa = new HashMap<>();
        aa.put(1,"23");
        ass.add(aa);
        Map<Integer,String> ab = new HashMap<>();
        ass.forEach(a ->{
            Map<Integer, String> a1 = a;
            ab.putAll(a1);
        });

        System.out.println(ab);
        
//      +--------------+---------------+  
//      |  列名1        |     列名2     |
//      +--------------+---------------+
//      |  值名1        |     值名2     |
//      +--------------+---------------+
//      Map< 列名1, 值名1 >        

        String streamJoining = testEntityList
                .stream()
                .map(entity -> entity.getName())
                //参数为：分隔符，前缀，后缀
                .collect(Collectors.joining(",", "前缀-", "-后缀"));
        System.out.println(streamJoining);


        //------------------------------------------------
        //计时结束
        Long endTime = System.currentTimeMillis();
        Long tempTime = (endTime - startTime);
//        testEntityList.forEach(testEntity -> {
//            testEntity.getName();
//            System.out.println(testEntity);
//        });
        System.out.println(showTimeByTemp(tempTime));

        System.out.println(showTimeByTemp(new Date().getTime()));
    }
    
    /**
     * @Description :根据时间戳输出如 18640 d 2 h 59 m 34 s 752 ms的时间长度，用于计算耗时
     * @param tempTime: 时间戳
     * @Return : java.lang.String
     * @Author : wangleiming
     * @Date : 2021/1/13 上午 10:58
     */
    public static String showTimeByTemp(Long tempTime){
        return "花费时间：" +
                (((tempTime / 86400000) > 0) ? ((tempTime / 86400000) + " d ") : "") +
                ((((tempTime / 86400000) > 0) || ((tempTime % 86400000 / 3600000) > 0)) ? ((tempTime % 86400000 / 3600000) + " h ") : ("")) +
                ((((tempTime / 3600000) > 0) || ((tempTime % 3600000 / 60000) > 0)) ? ((tempTime % 3600000 / 60000) + " m ") : ("")) +
                ((((tempTime / 60000) > 0) || ((tempTime % 60000 / 1000) > 0)) ? ((tempTime % 60000 / 1000) + " s ") : ("")) +
                ((tempTime % 1000) + " ms ");
    }

    //for循环过滤 该方法快过stream方式
    public static List<TestEntity> forFilter(List<TestEntity> testEntityList) {
        List<TestEntity> testEntityList1 = new ArrayList<>();
        for (TestEntity testEntity :
                testEntityList) {
            if (testEntity.getName().equals("wlm")) {
                testEntityList1.add(testEntity);
            }
        }
        return testEntityList1;
    }

    //filter 方法用于通过设置的条件过滤出元素。
    public static List<TestEntity> streamFilter(List<TestEntity> testEntityList) {
        List<TestEntity> wlm = testEntityList
                .stream()
                .filter(testEntity -> testEntity.getName().equals("wlm"))
                .collect(Collectors.toList());
        return wlm;
    }

    //for循环去重 快过stream方法
    public static List<TestEntity> forDistinct(List<TestEntity> testEntityList) throws InterruptedException {
        List<TestEntity> testEntityList1 = new ArrayList<>();
        for (TestEntity t :
                testEntityList) {
            if (!testEntityList1.contains(t)) {
                testEntityList1.add(t);
            }
        }
//        Thread.sleep(1000);
        return testEntityList1;
    }


    //distinct()去重
    public static List<TestEntity> streamDistinct(List<TestEntity> testEntityList) {
        List<TestEntity> collect = testEntityList.stream().distinct().collect(Collectors.toList());
        return collect;
    }


    /**
     * @Description :去重
     * @param : 
     * @Return : java.util.List<com.thunder.money.entity.TestEntity>
     * @Author : wangleiming
     * @Date : 2020/12/25 下午 01:44
     */
    private static List<TestEntity> getList() {
        List<TestEntity> testEntityList = new ArrayList<>();
        TestEntity testEntity1 = new TestEntity();
        TestEntity testEntity2 = new TestEntity();
        TestEntity testEntity3 = new TestEntity();
        TestEntity testEntity4 = new TestEntity();
        TestEntity testEntity5 = new TestEntity();

        testEntity1.setId(1);
        testEntity2.setId(1);
        testEntity3.setId(3);
        testEntity4.setId(4);
        testEntity5.setId(5);

        testEntity1.setName("wlm");
        testEntity2.setName("yly");
        testEntity3.setName("wxc");
        testEntity4.setName("wq");
        testEntity5.setName("cym");

        testEntity1.setEditTime(new Date());
        testEntity2.setEditTime(new Date());
        testEntity3.setEditTime(new Date());
        testEntity4.setEditTime(new Date());
        testEntity5.setEditTime(new Date());

        testEntityList.add(testEntity1);
        testEntityList.add(testEntity2);
        testEntityList.add(testEntity3);
        testEntityList.add(testEntity4);
        testEntityList.add(testEntity5);

//        for (int i = 0; i < 1000000; i++) {
//            TestEntity testEntityFor = new TestEntity();
//            testEntityFor.setId(i);
//            testEntityFor.setName("wlm");
//            Date date = new Date();
//            date.setTime(date.getTime() + i*1000);
//            testEntityFor.setEditTime(date);
//            testEntityList.add(testEntityFor);
//        }


//        System.out.println(testEntityList);
        return testEntityList;
    }
}
