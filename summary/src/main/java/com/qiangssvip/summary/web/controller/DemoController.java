package com.qiangssvip.summary.web.controller;


import com.qiangssvip.summary.enunm.ResultCodeEnum;
import com.qiangssvip.summary.form.DemoForm;
import com.qiangssvip.summary.pojo.Employee;
import com.qiangssvip.summary.utils.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/demo")
@Slf4j
@Api(description = "DemoApi")
public class DemoController {

    /**
     * 无参数
     * @return
     */
    @ApiOperation(value = "获取所有员工")
    @GetMapping("/getAll")
    public HttpResult getAll() {
        ArrayList<Employee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setId(Long.valueOf(i));
            employee.setUsername("Tom" + 1);
            list.add(employee);
        }
        return HttpResult.success(list);
    }

    /**
     * @RequestParam required属性默认为true 意为前端请求必填参数，value、name的效果是一样的，意为前端发送参数的属性名
     */
    @ApiOperation(value = "获取单个员工")
    @GetMapping("/selectOne")
    public HttpResult selectOne(@RequestParam(required = true,name = "userId") Integer id,String key) {
        Employee employee = new Employee();
        employee.setId(Long.valueOf(id));
        employee.setUsername("DemoName");
        log.info("ley = {}",key);
        return HttpResult.success(employee);
    }

    /**
     * @RequestBody 接收前端发送的json对象
     */
    @ApiOperation(value = "员工注册")
    @PostMapping("/register")
    public HttpResult register(@RequestBody Employee employee) {
        log.info("employee = {}",employee);
        if (employee == null) {
            return HttpResult.failure(ResultCodeEnum.NOT_FOUND);
        }
        return HttpResult.success();
    }

    /**
     * @ApiImplicitParams @ApiImplicitParam required = true 规定前端json对象的必填参数
     * 参考连接文档使用
     * https://www.cnblogs.com/h-c-g/p/11004020.html
     */
    @ApiOperation(value = "员工登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,paramType = "query",dataType = "String")
        }
    )
    @PostMapping("/login")
    public HttpResult login(Employee employee) {
        if ("".equals(employee.getUsername()) || "".equals(employee.getPassword())) {
            return HttpResult.failure(ResultCodeEnum.NOT_FOUND);
        }
        log.info("employee = {}",employee);
        return HttpResult.success();
    }

    /**
     * 参数验证测试
     */

    @PostMapping("/addEmployee")
    public HttpResult addEmployee(@Validated @RequestBody DemoForm form){
        return HttpResult.success(form);
    }




}
