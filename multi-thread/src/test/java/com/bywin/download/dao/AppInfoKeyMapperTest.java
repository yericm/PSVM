package com.bywin.download.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testFindAll () {
//        ResponseEntity<Object> objectResponseEntity = restTemplate.postForEntity("http://172.18.110.157:36104/secret/symmetry/obtainKeyCode", null, Object.class);
//        System.out.println(objectResponseEntity);
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