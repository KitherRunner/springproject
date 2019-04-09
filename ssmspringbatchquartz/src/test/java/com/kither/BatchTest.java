package com.kither;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
@WebAppConfiguration
public class BatchTest {

    @Autowired
    private Job job;

    @Autowired
    private JobLauncher jobLauncher;

    @Test
    public void testBatch() throws Exception {
        JobParameter jobParameter = new JobParameter(new Date());
        Map<String, JobParameter> parameterMap = new HashMap<>();
        parameterMap.put("date", jobParameter);
        JobExecution run = jobLauncher.run(job, new JobParameters(parameterMap));
        System.out.println(run.getStatus());
    }
}
