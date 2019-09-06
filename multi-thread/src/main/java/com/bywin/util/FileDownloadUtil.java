package com.bywin.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Slf4j
public class FileDownloadUtil {

    public static void downloadFile(HttpServletResponse response, String path) {
        // 下载文件
        File excel = null;
        try {
            excel = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + path);
        } catch (FileNotFoundException e) {
            log.error("文件找不到", e);
        }
        if (excel == null) {
            throw new RuntimeException("系统异常，请稍后再试。");
        }
        System.out.println(excel.getAbsolutePath());
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        // 下载文件能正常显示中文
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(excel.getName(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            log.error("文件下载时encode异常", e);
            throw new RuntimeException("系统异常，请稍后再试。");
        }
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(excel);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            log.error("文件下载读写异常", e);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    log.error("文件下载读后资源回收写异常", e);
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    log.error("文件下载读后资源回收写异常", e);
                }
            }
        }
    }
}
