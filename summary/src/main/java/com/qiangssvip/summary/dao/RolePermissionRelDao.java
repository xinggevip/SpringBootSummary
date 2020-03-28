package com.qiangssvip.summary.dao;

import com.qiangssvip.summary.pojo.RolePermissionRelKey;
import com.qiangssvip.summary.pojo.RolePermissionRelQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionRelDao {
    int countByExample(RolePermissionRelQuery example);

    int deleteByExample(RolePermissionRelQuery example);

    int deleteByPrimaryKey(RolePermissionRelKey key);

    int insert(RolePermissionRelKey record);

    int insertSelective(RolePermissionRelKey record);

    List<RolePermissionRelKey> selectByExample(RolePermissionRelQuery example);

    int updateByExampleSelective(@Param("record") RolePermissionRelKey record, @Param("example") RolePermissionRelQuery example);

    int updateByExample(@Param("record") RolePermissionRelKey record, @Param("example") RolePermissionRelQuery example);
}