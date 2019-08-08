package com.bywin.download.service;

import com.bywin.download.dao.AppInfoKeyMapper;
import com.bywin.download.model.AppInfoKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by yeric on 2019/8/8
 */
@Service
public class AppInfoKeyService {

    @Autowired
    private AppInfoKeyMapper appInfoKeyMapper;

    public List<AppInfoKey> findAppInfoKeyList () {
        return appInfoKeyMapper.findAppInfoKeyList();
    }
}
