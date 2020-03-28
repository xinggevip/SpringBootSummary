package com.qiangssvip.summary.dao;

import com.qiangssvip.summary.pojo.EmployeeRoleRelKey;
import com.qiangssvip.summary.pojo.EmployeeRoleRelQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeRoleRelDao {
    int countByExample(EmployeeRoleRelQuery example);

    int deleteByExample(EmployeeRoleRelQuery example);

    int deleteByPrimaryKey(EmployeeRoleRelKey key);

    int insert(EmployeeRoleRelKey record);

    int insertSelective(EmployeeRoleRelKey record);

    List<EmployeeRoleRelKey> selectByExample(EmployeeRoleRelQuery example);

    int updateByExampleSelective(@Param("record") EmployeeRoleRelKey record, @Param("example") EmployeeRoleRelQuery example);

    int updateByExample(@Param("record") EmployeeRoleRelKey record, @Param("example") EmployeeRoleRelQuery example);
}