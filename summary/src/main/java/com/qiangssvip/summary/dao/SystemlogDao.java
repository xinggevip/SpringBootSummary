package com.qiangssvip.summary.dao;

import com.qiangssvip.summary.pojo.Systemlog;
import com.qiangssvip.summary.pojo.SystemlogQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemlogDao {
    int countByExample(SystemlogQuery example);

    int deleteByExample(SystemlogQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Systemlog record);

    int insertSelective(Systemlog record);

    List<Systemlog> selectByExample(SystemlogQuery example);

    Systemlog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Systemlog record, @Param("example") SystemlogQuery example);

    int updateByExample(@Param("record") Systemlog record, @Param("example") SystemlogQuery example);

    int updateByPrimaryKeySelective(Systemlog record);

    int updateByPrimaryKey(Systemlog record);
}