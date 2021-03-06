package com.jianpan.sell.app.utils;

import java.util.Random;

public class KeyUtil {

    public static synchronized String genUniqueKey() {

        /**
         * 生成唯一的主键
         * 格式: 时间+随机数
         * @return
         */
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
