package com.qiangssvip.summary.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qiangssvip.summary.pojo.Employee;
import com.qiangssvip.summary.service.IEmployeeService;
import com.qiangssvip.summary.utils.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class IEmployeeServiceImplTest {

    @Autowired
    private IEmployeeService employeeService;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @Test
    void login() {
        Employee employee = new Employee();
        employee.setUsername("itlike113");
        employee.setPassword("1234");
        HttpResult login = employeeService.login(employee);
        log.info("login = {}",gson.toJson(login));
    }
}