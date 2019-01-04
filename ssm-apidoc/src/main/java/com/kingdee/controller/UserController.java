package com.kingdee.controller;

import com.kingdee.bean.User;
import com.kingdee.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @apiDefine userInfo  用户详细信息
 * @apiSuccess {Integer} id 用户编号
 * @apiSuccess {String} name 用户编号
 * @apiSuccess {String} password 用户密码
 * @apiSuccess {Integer} gender 用户性别
 */

@Controller
@MapperScan("com.kingdee.mapper")
@Api(value = "用户操作控制器")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @api {get} /user/:id  根据id查询用户信息
     * @apiName find
     * @apiGroup User
     * @apiSampleRequest /user/:id
     * @apiUse userInfo
     * @apiSuccessExample user
     * {
     * "id":1,
     * "name":"张三",
     * "password":"张三",
     * "gender":1
     * }
     */
    @GetMapping(value = "/user/{id}", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "find", notes = "根据id查询用户", httpMethod = "GET")
    @ResponseBody
    @CrossOrigin    // 解决测试时报错：跨域错误
    public User find(@PathVariable("id") Integer id) {
        return userService.find(id);
    }

    /**
     * @param user
     * @return
     * @api {POST} /user 添加用户
     * @apiName add
     * @apiGroup User
     * @apiParam {String} name 姓名
     * @apiParam {String} password 密码
     * @apiParam {Integer} [gender=0] 性别(0男1女)
     * @apiUse userInfo
     * @apiSampleRequest /user
     * @apiSuccessExample user
     * {
     * "id":"1",
     * "name":"张三",
     * "password":"zs123",
     * "gender":1
     * }
     */
    @PostMapping(value = "user", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "add", notes = "添加用户", response = User.class, httpMethod = "POST")
    @ResponseBody
    @CrossOrigin    // 解决测试时报错：跨域错误
    public User add(User user) {
        return userService.add(user);
    }


    /**
     * 文件上传不需要跳转页面和返回信息，使用void
     *
     * @param response
     */
    @GetMapping("loadExcel")
    @ResponseBody
    public void loadExcel(HttpServletResponse response) throws Exception {
        // 模拟需要下载的数据
        List<User> users = new ArrayList<User>() {{
            add(new User(1, "张三", "zs", 1));
            add(new User(2, "王五", "ww", 1));
            add(new User(3, "赵六", "zl", 0));
            add(new User(4, "李四", "ls", 1));
        }};
        // SXSSFWorkbook适用于大数据量的操作
        // 使用SXSSFWorkbook需要同时引用rg.apache.poi.poi和org.apache.poi.poi-ooxml
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        // 创建sheet
        SXSSFSheet sheet = workbook.createSheet("测试poi-用户信息下载");
        // 设置列宽
        sheet.setColumnWidth(0, 1000);
        sheet.setColumnWidth(0, 1000);
        sheet.setColumnWidth(0, 1000);
        sheet.setColumnWidth(0, 1000);

        // 创建表头
        SXSSFRow row = sheet.createRow(0);
        row.createCell(0, CellType.STRING).setCellValue("用户编号");
        row.createCell(1, CellType.STRING).setCellValue("用户姓名");
        row.createCell(2, CellType.STRING).setCellValue("用户密码");
        row.createCell(3, CellType.STRING).setCellValue("用户性别");

        // 遍历集合生成数据
        for (int i = 0, size = users.size(); i < size; i++) {
            User user = users.get(i);
            SXSSFRow sheetRow = sheet.createRow(i + 1);
            sheetRow.createCell(0, CellType.NUMERIC).setCellValue(Optional.of(user.getId()).orElse(0));
            sheetRow.createCell(1, CellType.STRING).setCellValue(Optional.of(user.getName()).orElse(""));
            sheetRow.createCell(2, CellType.STRING).setCellValue(Optional.of(user.getPassword()).orElse(""));
            sheetRow.createCell(3, CellType.STRING).setCellValue(1 == user.getGender() ? "男" : "女");
        }

        // 将文件写入输出流
        // 设置文件导出格式
        String filaName = "Users Information_".concat(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).concat(".xlsx");
        // 必须设置以下两个属性
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + filaName);
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
