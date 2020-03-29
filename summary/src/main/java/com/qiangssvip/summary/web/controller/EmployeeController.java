package com.qiangssvip.summary.web.controller;

import com.qiangssvip.summary.pojo.Employee;
import com.qiangssvip.summary.service.IEmployeeService;
import com.qiangssvip.summary.utils.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@Slf4j
@Api(description = "员工api")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public HttpResult login(@RequestParam(required = true) String username,
                            @RequestParam(required = true) String password) {
        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(password);
        HttpResult result = employeeService.login(employee);
        return result;
    }

}
