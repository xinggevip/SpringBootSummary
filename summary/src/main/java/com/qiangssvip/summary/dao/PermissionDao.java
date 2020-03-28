package com.qiangssvip.summary.dao;

import com.qiangssvip.summary.pojo.Permission;
import com.qiangssvip.summary.pojo.PermissionQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDao {
    int countByExample(PermissionQuery example);

    int deleteByExample(PermissionQuery example);

    int deleteByPrimaryKey(Long pid);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionQuery example);

    Permission selectByPrimaryKey(Long pid);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionQuery example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionQuery example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}