package com.kither.controller;

import com.kither.Response;
import com.kither.bean.QuartzBaseBean;
import com.kither.service.QuartzService;
import com.kither.util.QuartzJobUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "QuartzController", tags = "quartz", protocols = "HTTP", description = "自动任务Controller")
public class QuartzController {

    @Autowired
    private QuartzService quartzService;

    @GetMapping("quartz")
    public String toLogInfo() {
        return "quartzs";
    }

//    @GetMapping(value = "quartzs", produces = "application/json;chasrset=utf-8")
//    @ResponseBody
//    @ApiOperation(value = "findAll", notes = "查询所有自动任务", tags = "quartz", httpMethod = "GET")
//    public List<QuartzBaseBean> findAll() {
//        return quartzService.findAll();
//    }

    // 该注解标识的方法会在controller中的每个其他@RequestMapping方法执行前先执行，相当于往Model中注入属性(默认存储到request域中)，我们可以在其他方法中获取这个属性值(类似下面参数使用@ModelAttribute修饰获取)
    @ModelAttribute("quartzs")
    public List<QuartzBaseBean> quartzs() {
        return quartzService.findAll();
    }

    // 这里参数不加@ModelAttribute注解也是先从request域获取quartzs数据
    @GetMapping(value = "quartzs", produces = "application/json;chasrset=utf-8")
    @ResponseBody
    @ApiOperation(value = "findAll", notes = "查询所有自动任务", tags = "quartz", httpMethod = "GET")
    public List<QuartzBaseBean> findAll(@ModelAttribute("quartzs") List<QuartzBaseBean> quartzs) {
        return quartzs;
    }

    @GetMapping("quartz/enable/{id}")
    @ResponseBody
    @ApiOperation(value = "enable", notes = "启用自动任务", tags = "quartz", httpMethod = "GET")
    public Response enable(@PathVariable("id") Integer id) throws Exception {
        Response response = new Response();
        response.setSuccess(false);
        // 先检查状态
        QuartzBaseBean baseBean = quartzService.find(id);
        if (baseBean != null) {
            if (baseBean.getState() == 0) {
                // 启用
                Class name = Class.forName(baseBean.getExeLink());
                QuartzJobUtil.start(name, baseBean.getCronExpression(), baseBean.getStartDate(), baseBean.getEndDate());
                int enable = quartzService.enable(id);
                if (enable != 0) {
                    response.setSuccess(true);
                    response.setSuccessMessgae("启用成功");
                    return response;
                }
                response.setErrMessage("自动任务已启用失败");
                return response;
            }
            response.setErrMessage("自动任务已启用");
            return response;
        }
        response.setErrMessage("未找到对应的自动任务");
        return response;
    }

    @GetMapping("quartz/disable/{id}")
    @ResponseBody
    public Response disable(@PathVariable("id") Integer id) throws Exception {
        Response response = new Response();
        response.setSuccess(false);
        // 先检查状态
        QuartzBaseBean baseBean = quartzService.find(id);
        if (baseBean != null) {
            if (baseBean.getState() == 1) {
                // 禁用
                Class name = Class.forName(baseBean.getExeLink());
                QuartzJobUtil.stop(name);
                int disabled = quartzService.disabled(id);
                if (disabled != 0) {
                    response.setSuccess(true);
                    response.setSuccessMessgae("禁用成功");
                    return response;
                }
                response.setErrMessage("自动任务已禁用失败");
                return response;
            }
            response.setErrMessage("自动任务已禁用");
            return response;
        }
        response.setErrMessage("未找到对应的自动任务");
        return response;
    }
}