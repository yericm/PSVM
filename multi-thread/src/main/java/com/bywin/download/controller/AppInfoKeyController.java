package com.bywin.download.controller;

import com.bywin.download.model.AppInfoKey;
import com.bywin.download.service.AppInfoKeyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

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


    @RequestMapping(value = "/excelDownloads", method = RequestMethod.GET)
    @ApiOperation(value = "excel下载")
    public void excelDownloads(HttpServletResponse response) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("密钥表");
        // 设置居中
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);

        List<AppInfoKey> appInfoKeyList = appInfoKeyService.findAppInfoKeyList();
        String fileName = "密钥列表" + ".xlsx";
        int rowNum = 1;
        String[] headers = {"id", "app_info_id", "app_id", "app_key"};
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
            cell.setCellStyle(cellStyle);
        }
        for (AppInfoKey apInfoKey : appInfoKeyList) {
            XSSFRow row1 = sheet.createRow(rowNum);
            XSSFCell cell = row1.createCell(0);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(apInfoKey.getId().toString());
            row1.createCell(1).setCellValue(new XSSFRichTextString(apInfoKey.getAppInfoId().toString()));
            row1.createCell(2).setCellValue(new XSSFRichTextString(apInfoKey.getAppId()));
            row1.createCell(3).setCellValue(new XSSFRichTextString(apInfoKey.getAppKey()));
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
    }
}
