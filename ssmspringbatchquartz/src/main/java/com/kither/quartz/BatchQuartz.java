package com.kither.quartz;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BatchQuartz {

    @Autowired
    private Job job;

    @Autowired
    private JobLauncher jobLauncher;

    // 定时任务执行方法
    public void batchQuartz() throws Exception {

        System.out.println("执行quartz方法 - " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        // 设置reader的参数date
        JobParameter jobParameter = new JobParameter(new Date());
        Map<String, JobParameter> parameterMap = new HashMap<>();
        parameterMap.put("date", jobParameter);
        // 执行job
        JobExecution jobExecution = jobLauncher.run(job, new JobParameters(parameterMap));
        System.out.println("status: " + jobExecution.getStatus());
    }
}
