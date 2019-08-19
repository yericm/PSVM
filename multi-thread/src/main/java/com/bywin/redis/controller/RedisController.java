package com.bywin.redis.controller;

import com.bywin.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by yeric on 2019/8/15
 */
@RestController
@Api(description = "使用java操作redis")
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "设置字符串键值对")
    @PostMapping("setSKV")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "键", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "value", value = "值", required = true, paramType = "query", dataType = "String")
    })
    public Object setStringKeyValue (@RequestParam("key") String key, @RequestParam("value") String value) {
        redisUtil.set(key, value);
        return redisUtil.get(key);
    }

    @ApiImplicitParam(name = "key", value = "键", required = true, paramType = "query", dataType = "String")
    @PostMapping("removeSK")
    @ApiOperation(value = "删除缓存")
    public void removeStringKey (@RequestParam("key") String key) {
        redisUtil.del(key);
    }

    @ApiImplicitParam(name = "key", value = "键", required = true, paramType = "query", dataType = "String")
    @PostMapping("getSK")
    @ApiOperation(value = "根据key获取值")
    public Object getStringKey (@RequestParam("key") String key) {
        return redisUtil.get(key);
    }
}
