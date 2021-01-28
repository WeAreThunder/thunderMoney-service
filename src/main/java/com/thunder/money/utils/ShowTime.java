package com.thunder.money.utils;

/**
 * @author wangleiming
 */
public class ShowTime {
    /**
     * @Description :根据时间戳输出如 18640 d 2 h 59 m 34 s 752 ms的时间长度，用于计算耗时
     * @param tempTime: 时间戳
     * @Return : java.lang.String
     */
    public static String showTimeByTemp(Long tempTime){
        return "花费时间：" +
                (((tempTime / 86400000) > 0) ? ((tempTime / 86400000) + " d ") : "") +
                ((((tempTime / 86400000) > 0) || ((tempTime % 86400000 / 3600000) > 0)) ? ((tempTime % 86400000 / 3600000) + " h ") : ("")) +
                ((((tempTime / 3600000) > 0) || ((tempTime % 3600000 / 60000) > 0)) ? ((tempTime % 3600000 / 60000) + " m ") : ("")) +
                ((((tempTime / 60000) > 0) || ((tempTime % 60000 / 1000) > 0)) ? ((tempTime % 60000 / 1000) + " s ") : ("")) +
                ((tempTime % 1000) + " ms ");
    }
}
