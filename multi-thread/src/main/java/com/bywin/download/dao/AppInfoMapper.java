package com.bywin.download.dao;

import com.bywin.download.model.AppInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);
}