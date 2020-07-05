package com.bywin.base.sort;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.OSSObject;
import com.bywin.dto.KefuDTO;
import com.bywin.dto.KefuSeatDTO;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;

/**
 * 排序算法
 */
public class SortAlgorithm {
    public static void main(String[] args) throws ParseException, IOException {
//        write();
        read();
    }

    private static void write() throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4FwMvTpo9467mSregAC8";
        String accessKeySecret = "V7DiGc0WQ56oO0siBqHzUj2O43qVfJ";
        String butckName = "yerikm";
        KefuSeatDTO kefuSeatDTO = new KefuSeatDTO();
        kefuSeatDTO.setPolicyId(5);
        kefuSeatDTO.setName("班级名次");
        KefuSeatDTO kefuSeatDTO2 = new KefuSeatDTO();
        kefuSeatDTO2.setPolicyId(90);
        kefuSeatDTO2.setName("成绩");
        KefuSeatDTO kefuSeatDTO3 = new KefuSeatDTO();
        kefuSeatDTO3.setPolicyId(20);
        kefuSeatDTO3.setName("年级名次");
        KefuSeatDTO kefuSeatDTO4 = new KefuSeatDTO();

        kefuSeatDTO4.setPolicyId(100);

        kefuSeatDTO4.setName("年级");
        List<KefuSeatDTO> list = new ArrayList<>();
        list.add(kefuSeatDTO);
        list.add(kefuSeatDTO2);
        list.add(kefuSeatDTO3);
        list.add(kefuSeatDTO4);

        System.out.println(list.toString());
        List<KefuSeatDTO> collect = list.stream().sorted(Comparator.comparing(KefuSeatDTO::getPolicyId))
                .collect(Collectors.toList());
        System.out.println(collect);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet名字");
        // fields字段按照order重新排序,excel直接使用
        Integer columnWidth = 7000;
        // 设置表头
        List<String> headers = new ArrayList<>();
        for (KefuSeatDTO field : collect) {
            headers.add(field.getName());
        }
        XSSFRow titleRow = sheet.createRow(0);
        CellStyle headerStyle = getHeaderStyle(workbook);
        sheet.createFreezePane(0, 1, 0, 1);

        for (int i = 0; i < headers.size(); i++) {
            XSSFCell cell = titleRow.createCell(i);
            sheet.autoSizeColumn(i, Boolean.TRUE);
            sheet.setColumnWidth(i, columnWidth);
            XSSFRichTextString text = new XSSFRichTextString(headers.get(i));
            cell.setCellStyle(headerStyle);
            cell.setCellValue(text);
        }
        int rowNum = 1;
        CellStyle leftStyle = workbook.createCellStyle();
        leftStyle.setAlignment(HorizontalAlignment.CENTER);
        leftStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        leftStyle.setWrapText(true);
        KefuSeatDTO d1 = new KefuSeatDTO(1, 5, 99, "高一");
        KefuSeatDTO d2 = new KefuSeatDTO(2, 13, 97, "高一");
        KefuSeatDTO d3 = new KefuSeatDTO(3, 22, null, "高一");
        KefuSeatDTO d4 = new KefuSeatDTO(4, 40, 90, "高一");
        List<KefuSeatDTO> list1 = new ArrayList<>();
        list1.add(d1);
        list1.add(d2);
        list1.add(d3);
        list1.add(d4);
        for (KefuSeatDTO api : list1) {

            XSSFRow row = sheet.createRow(rowNum++);
            for (int i = 0; i < headers.size(); i++) {
                XSSFCell cell = row.createCell(i);
                cell.setCellStyle(leftStyle);
            }
            row.getCell(0).setCellValue(new XSSFRichTextString(api.getPolicyId() != null ? String.valueOf(api.getPolicyId()) : ""));
            row.getCell(1).setCellValue(new XSSFRichTextString(api.getGroupType() != null ? String.valueOf(api.getGroupType()) : ""));
            row.getCell(2).setCellValue(new XSSFRichTextString(api.getType() != null ? String.valueOf(api.getType()) : ""));
            row.getCell(3).setCellValue(new XSSFRichTextString(api.getName() != null ? String.valueOf(api.getName()) : ""));
        }

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        workbook.write(os);
        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 上传文件流。
        String key = "workbook/testwork.xlsx";
        ossClient.putObject(butckName, key, is);

// 关闭OSSClient。
        ossClient.shutdown();
        System.out.println("操作完成");
    }

    private static void read() {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4FwMvTpo9467mSregAC8";
        String accessKeySecret = "V7DiGc0WQ56oO0siBqHzUj2O43qVfJ";
        String bucketName = "yerikm";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String key = "workbook/testwork.xlsx";

// ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSSObject ossObject = ossClient.getObject(bucketName, key);
        try {
            //1、获取文件输入流
            //2、获取Excel工作簿对象
            Workbook workbook = new XSSFWorkbook(ossObject.getObjectContent());
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rowIterator = sheet.iterator();
                Row row;
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();
                    if (row.getRowNum() == 0) {
                        continue;
                    }
                    System.out.println("单元格数量" + (row.getLastCellNum()));
                    short minColIx = row.getFirstCellNum();
                    short maxColIx = row.getLastCellNum();

                    for (short colIx = minColIx; colIx < maxColIx; colIx++) {
                        Cell cell = row.getCell(colIx);
                        if (cell != null) {
                            switch (cell.getCellTypeEnum()) {
                                case NUMERIC:
                                    System.out.println(cell.getNumericCellValue());
                                    break;
                                case STRING:
                                    System.out.println(cell.getStringCellValue());
                                    break;
                                case BOOLEAN:
                                    System.out.println(cell.getBooleanCellValue());
                                    break;
                                case BLANK:
                                    System.out.println("BLANK");

                            }
                        }
                    }
                    System.out.println("第" + row.getRowNum() + "行读取完毕");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tem;
                } else {
                    break;
                }
            }
        }
        System.out.print("插入排序的结果是：");
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            for (int i = j; i < arr.length; i++) {
                if (arr[j] > arr[i]) {
                    int tem = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tem;
                }
            }
        }
        System.out.print("选择排序的结果是：");
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.print("冒泡排序的结果是：");
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }

    public static CellStyle getHeaderStyle(Workbook workbook) {
        //新建表头单元格样式
        CellStyle headerStyle = workbook.createCellStyle();
        //下边框
        headerStyle.setBorderBottom(BorderStyle.THIN);
        //左边框
        headerStyle.setBorderLeft(BorderStyle.THIN);
        //上边框
        headerStyle.setBorderTop(BorderStyle.THIN);
        //右边框
        headerStyle.setBorderRight(BorderStyle.THIN);
        // 居中
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        Font font = workbook.createFont();
        font.setFontName("仿宋_GB2312");
        //粗体显示
        font.setBold(Boolean.TRUE);
        //字体大小
        font.setFontHeightInPoints((short) 11);
        headerStyle.setFont(font);
        return headerStyle;
    }

    public static String ossObjectToAuthorizedUri(String path) {
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4FwMvTpo9467mSregAC8";
        String accessKeySecret = "V7DiGc0WQ56oO0siBqHzUj2O43qVfJ";
        String bucketName = "yerikm";
        try {
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, path, HttpMethod.GET);
            //uri 时效, 5 min
            request.setExpiration(new Date(System.currentTimeMillis() + 300000L));
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            String uri = ossClient.generatePresignedUrl(request).toString();
            return uri;
        } catch (Exception e) {
        }
        return null;
    }
}
