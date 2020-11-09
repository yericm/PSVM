package com.bywin.download.service;

import com.bywin.base.sort.Dto;
import com.bywin.download.dao.AppInfoKeyMapper;
import com.bywin.download.model.AppInfoKey;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/**
 * created by yeric on 2019/8/8
 */
@Service
public class AppInfoKeyService {

    @Autowired
    private AppInfoKeyMapper appInfoKeyMapper;

    public List<AppInfoKey> findAppInfoKeyList () {
        Page<Object> page = PageHelper.startPage(1, 15);
        List<AppInfoKey> appInfoKeyList = appInfoKeyMapper.findAppInfoKeyList();
        PageInfo<AppInfoKey> appInfoKeyPageInfo = new PageInfo<>(appInfoKeyList);
        return appInfoKeyList;
    }

    public Object ts (Dto dto) {
        return dto;
    }
}
