package com.bywin.download.service;

import com.bywin.download.dao.AppInfoMapper;
import com.bywin.download.model.AppInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by yeric on 2019/8/12
 */
@Service
public class AppInfoService {

    @Autowired
    private AppInfoMapper appInfoMapper;

    public void batchInsert (List<AppInfo> list) {

    }
}
