package com.kither.util;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class QuartzJobUtil {

    private static final String EXE_METHOD = "execute";

    private static final SchedulerFactory factory = new StdSchedulerFactory();

    public static void stop(Class beanName) throws Exception {
        Scheduler scheduler = factory.getScheduler();
        JobKey key = new JobKey(beanName.getName(), beanName.getName());
        JobDetail jobDetail = scheduler.getJobDetail(key);
        if (jobDetail != null) {
            scheduler.deleteJob(key);
        }
    }

    public static void start(Class beanName, String cronExpression, Date startDate, Date endDate) throws Exception {
        // 查询有没有对应的job
        Scheduler scheduler = factory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(beanName)
                .withIdentity(beanName.getName(), beanName.getName())
                .build();
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(beanName.getName(), beanName.getName())
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).startAt(startDate).endAt(endDate).build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
