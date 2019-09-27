package com.bywin.download.controller;

import com.bywin.download.model.AppInfoKey;
import com.bywin.download.service.AppInfoKeyService;
import com.bywin.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<AppInfoKey> findAppInfoKeyList(@RequestAttribute("preHandle") String preHandle) {
        System.out.println("拦截器设置的值：" + preHandle);
        System.out.println("[业务处理：--------]");
        List<AppInfoKey> appInfoKeyList = appInfoKeyService.findAppInfoKeyList();
        return appInfoKeyList;
    }


    @RequestMapping(value = "/excelDownloads", method = RequestMethod.GET)
    @ApiOperation(value = "excel下载")
    public void excelDownloads(HttpServletResponse response) throws IOException {
        String sheetName = "密钥表";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);

        List<AppInfoKey> appInfoKeyList = appInfoKeyService.findAppInfoKeyList();
        int rowNum = 1;
        String[] headers = {"id", "app_info_id", "app_id", "app_key"};
        CellStyle headerStyle = ExcelUtils.getHeaderStyle(workbook);
        XSSFRow titleRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            XSSFCell cell = titleRow.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
            cell.setCellStyle(headerStyle);
        }
        CellStyle centerStyle = ExcelUtils.getCenterStyle(workbook);

        for (AppInfoKey apInfoKey : appInfoKeyList) {
            XSSFRow row = sheet.createRow(rowNum);
            for (int i = 0; i < headers.length; i++) {
                XSSFCell cell = row.createCell(i);
                cell.setCellStyle(centerStyle);
            }
            XSSFRow row1 = sheet.createRow(rowNum);
            row.getCell(0).setCellValue(new XSSFRichTextString(String.valueOf(rowNum++)));
            row.getCell(1).setCellValue(new XSSFRichTextString(apInfoKey.getAppInfoId().toString()));
            row.getCell(2).setCellValue(new XSSFRichTextString(apInfoKey.getAppId()));
            row.getCell(3).setCellValue(new XSSFRichTextString(apInfoKey.getAppKey()));
            row.getCell(4).setCellValue(apInfoKey.getCreateTime());
        }
        ExcelUtils.exportExcel(workbook, sheetName, response);
    }
}
