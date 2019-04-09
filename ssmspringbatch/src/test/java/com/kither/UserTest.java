package com.kither;

import com.kither.bean.User;
import com.kither.service.UserService;
import org.junit.Before;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
@WebAppConfiguration
public class UserTest {

    @Autowired
    private UserService userService;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setName("张三");
        user.setGender(0);
        user.setInfo("我是张三");
        user.setSalary(new BigDecimal(10000));
        userService.insert(user);
    }

    @Test
    public void insertUser() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/add").characterEncoding("utf-8")
                .param("name", "赵六").param("gender", "1")
                .param("salary", "10000").param("info", "我是赵六"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void findAll() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/users")).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Test
    public void testBatch() throws Exception {
        Map<String, JobParameter> paraMap = new HashMap<>();
        paraMap.put("date", new JobParameter(new Date()));
        JobParameters jobParameters = new JobParameters(paraMap);
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        System.out.println("status: " + jobExecution.getStatus());
    }
}
