package com.bywin.download.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * created by yeric on 2019/8/12
 */
@RestController
@Api(description = "批量导入")
public class BatchHandleController {


    @PostMapping("importExcel")
    @ApiOperation(value = "批量导入数据")
    public void importExcel(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        String contentType = file.getContentType();
        byte[] bytes = file.getBytes();
        String name = file.getName();
        Resource resource = file.getResource();
        boolean empty = file.isEmpty();
        long size = file.getSize();
//        file.transferTo(new File("C:\\Users\\yerik\\Desktop"));
//        List<ArrayList<String>> list = new ExcelRead().readExcel(file);
    }
}
