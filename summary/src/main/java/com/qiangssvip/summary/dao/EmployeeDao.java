package com.qiangssvip.summary.dao;

import com.qiangssvip.summary.pojo.Employee;
import com.qiangssvip.summary.pojo.EmployeeQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    int countByExample(EmployeeQuery example);

    int deleteByExample(EmployeeQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeQuery example);

    Employee selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeQuery example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeQuery example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}