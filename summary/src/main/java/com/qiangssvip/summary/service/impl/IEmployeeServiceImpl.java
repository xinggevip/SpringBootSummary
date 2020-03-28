package com.qiangssvip.summary.service.impl;

import com.qiangssvip.summary.dao.EmployeeDao;
import com.qiangssvip.summary.enunm.ResultCodeEnum;
import com.qiangssvip.summary.pojo.Employee;
import com.qiangssvip.summary.pojo.EmployeeQuery;
import com.qiangssvip.summary.service.IEmployeeService;
import com.qiangssvip.summary.utils.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class IEmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 登录
     *
     * @param employee
     * @return
     */
    @Override
    public HttpResult login(Employee employee) {
        EmployeeQuery employeeQuery = new EmployeeQuery();
        EmployeeQuery.Criteria criteria = employeeQuery.createCriteria();
        criteria.andUsernameEqualTo(employee.getUsername()).andPasswordEqualTo(employee.getPassword());
        List<Employee> employees = employeeDao.selectByExample(employeeQuery);
        if (employees.size() <= 0) {
            return HttpResult.failure(ResultCodeEnum.NOT_FOUND);
        }
        return HttpResult.success(employees.get(0));
    }
}
