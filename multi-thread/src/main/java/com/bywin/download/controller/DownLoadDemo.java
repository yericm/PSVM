package com.bywin.download.controller;

import com.bywin.download.model.AppInfoKey;
import com.bywin.download.utils.FileDownloadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * created by yeric on 2019/8/6
 */
@Slf4j
@RestController
@Api(value = "文件下载", description = "文件下载")
public class DownLoadDemo {

    @GetMapping("/downloadDoc")
    @ApiOperation("下载服务器的文件")
    public void download(HttpServletResponse response) {
        FileDownloadUtil.downloadFile(response, "doc/接入操作说明书.docx");
    }

    @GetMapping("/downloadTxt")
    @ApiOperation("读取对象中属性写入txt")
    public ResponseEntity<FileSystemResource> downloadTxt() throws IOException {


        AppInfoKey key = new AppInfoKey();
        key.setAppId("50047672928943B184FD004179675790");
        key.setAppKey("B9764C835C6D473CBAADD615BA784762");

        File resourceFile = null;
        FileWriter fileWriter = null;
        PrintWriter pw = null;
        try {
            resourceFile = new File(ResourceUtils.getURL("classpath:").getPath(), "密钥ID.txt");
            if (!resourceFile.getParentFile().exists()) {
                resourceFile.getParentFile().mkdirs();
            }
            fileWriter = new FileWriter(resourceFile, false);
            pw = new PrintWriter(fileWriter);

            pw.println("app-id:" + key.getAppId());
            pw.print("密钥ID:" + key.getAppKey());

            pw.flush();
            fileWriter.flush();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new RuntimeException(e.getLocalizedMessage());
        } finally {
            try {
                pw.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileSystemResource file = new FileSystemResource(resourceFile);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        // 设置下载时的文件名，中文文件名需要进行转码，否则是乱码
        headers.add("Content-Disposition",
                "attachment; filename=" +
                        new String(file.getFilename().getBytes("UTF-8"), "iso-8859-1"));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(file);
    }
}
