package com.kingdee.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 控制台输出的自动任务
 */
public class ConsoleTask {

    /**
     * 自动任务执行的逻辑，可以是业务代码，这里简单模拟在控制台输出一个语句
     */
    public void printHello() {
        // LocalDateTime：jdk8中新的时间类
        String time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(time + " ,hello");
    }
}
