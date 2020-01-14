package com.bywin.download.dao;

import com.bywin.download.model.AppInfoKey;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * created by yeric on 2019/8/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AppInfoKeyMapperTest {

    @Autowired
    private AppInfoKeyMapper appInfoKeyMapper;

    @Test
    public void testFindAll () {
/*        List<AppInfoKey> appInfoKeyList = appInfoKeyMapper.findAppInfoKeyList();
        if (appInfoKeyList.size() > 0) {
            try {
                int i = 1 / 0;
            } catch (Exception e) {
                e.printStackTrace();
                log.error("cuo: {}",e.getMessage());
            }
        }*/
    }

}