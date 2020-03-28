package com.qiangssvip.summary.service;

import com.qiangssvip.summary.pojo.Employee;
import com.qiangssvip.summary.utils.HttpResult;

public interface IEmployeeService {
    /**
     * 登录
     * @param employee
     * @return
     */
    HttpResult login(Employee employee);
}
