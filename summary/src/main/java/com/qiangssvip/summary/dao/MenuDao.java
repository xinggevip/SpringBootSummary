package com.qiangssvip.summary.dao;

import com.qiangssvip.summary.pojo.Menu;
import com.qiangssvip.summary.pojo.MenuQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    int countByExample(MenuQuery example);

    int deleteByExample(MenuQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuQuery example);

    Menu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuQuery example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuQuery example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}