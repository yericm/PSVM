package com.bywin.download.dao;


import com.bywin.download.model.AppInfoKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppInfoKeyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppInfoKey record);

    int insertSelective(AppInfoKey record);

    AppInfoKey selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfoKey record);

    int updateByPrimaryKey(AppInfoKey record);
    /**
     * 1. 密钥列表
     * @return
     */
    List<AppInfoKey> findAppInfoKeyList();
}