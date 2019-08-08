package com.bywin.download.controller;

import com.bywin.download.model.AppInfoKey;
import com.bywin.download.service.AppInfoKeyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * created by yeric on 2019/8/8
 */
@RestController
@Api(description = "密钥管理")
@Slf4j
public class AppInfoKeyController {

    @Autowired
    private AppInfoKeyService appInfoKeyService;

    @GetMapping("/findAll")
    @ApiOperation(value = "密钥列表")
    public List<AppInfoKey> findAppInfoKeyList() {
        List<AppInfoKey> appInfoKeyList = appInfoKeyService.findAppInfoKeyList();
        return appInfoKeyList;
    }

    @RequestMapping(value = "/excelDownloads",method = RequestMethod.GET)
    @ApiOperation(value = "密钥excel下载")
    public void excelDownloads(HttpServletResponse response)throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("密钥表");
        List<AppInfoKey> appInfoKeyList = appInfoKeyService.findAppInfoKeyList();
        String fileName = "密钥列表" + ".xls";
        int rowNum = 1;
        String [] headers = {"id","app_info_id","app_id","app_key"};
        HSSFRow row = sheet.createRow(0);
        for (int i = 0;i<headers.length;i++){
            HSSFCell cell = row.createCell((short) i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        for (AppInfoKey apInfoKey : appInfoKeyList){
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell((short) 0).setCellValue(new HSSFRichTextString(apInfoKey.getId().toString()));
            row1.createCell((short) 1).setCellValue(new HSSFRichTextString(apInfoKey.getAppInfoId().toString()));
            row1.createCell((short) 2).setCellValue(new HSSFRichTextString(apInfoKey.getAppId()));
            row1.createCell((short) 3).setCellValue(new HSSFRichTextString(apInfoKey.getAppKey()));
            rowNum++;

        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "iso-8859-1"));
        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        workbook.write(response.getOutputStream());
    }
}
