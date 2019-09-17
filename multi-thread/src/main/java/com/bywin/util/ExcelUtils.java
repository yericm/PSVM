package com.bywin.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by yeric on 2019/9/5
 */
public class ExcelUtils {
    /**
     * hearder样式
     *
     * @param workbook
     * @return
     */
    public static CellStyle getHeaderStyle(Workbook workbook) {
        //新建表头单元格样式
        CellStyle headerStyle = workbook.createCellStyle();
        //下边框
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //左边框
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //上边框
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //右边框
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // 居中
        headerStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);

        Font font = workbook.createFont();
        font.setFontName("仿宋_GB2312");
        //粗体显示
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //字体大小
        font.setFontHeightInPoints((short) 11);
        headerStyle.setFont(font);
        return headerStyle;
    }

    /**
     * 默认内容样式：居中，自动换行
     *
     * @param workbook
     * @return
     */
    public static CellStyle getCenterStyle(Workbook workbook) {
        // 居中样式
        CellStyle centerStyle = workbook.createCellStyle();
        centerStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        centerStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        // 自动换行
        centerStyle.setWrapText(true);
        return centerStyle;
    }

    /**
     * 单元格左对齐
     *
     * @param workbook
     * @return
     */
    public static CellStyle getLeftStyle(Workbook workbook) {
        CellStyle leftStyle = workbook.createCellStyle();
        leftStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        leftStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        leftStyle.setWrapText(true);
        return leftStyle;
    }

    /**
     * 执行导出
     *
     * @param workbook
     * @param fileName 导出文件名
     */
    public static void exportExcel(Workbook workbook, String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "iso-8859-1") + ".xlsx");
        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String null2String(Object obj) {
        return obj != null ? String.valueOf(obj) : "";
    }

    /**
     * 将日期转化为String
     *
     * @param data
     * @param format
     * @return
     */
    public static String date2String(Date data, String... format) {
        if (data == null) {
            return "";
        }
        SimpleDateFormat sdf = null;
        if (format == null || format.length == 0) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else {
            sdf = new SimpleDateFormat(format[0]);
        }
        return sdf.format(data);
    }

    /**
     * json格式化
     *
     * @param jsonStr
     * @return
     */
    public static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr)) return "";
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);

            //遇到{[换行，且下一行缩进
            switch (current) {
                case '{':
                case '[':
                    sb.append(current);
                    sb.append('\n');
                    indent++;
                    addIndentBlank(sb, indent);
                    break;

                //遇到}]换行，当前行缩进
                case '}':
                case ']':
                    sb.append('\n');
                    indent--;
                    addIndentBlank(sb, indent);
                    sb.append(current);
                    break;

                //遇到,换行
                case ',':
                    sb.append(current);
                    if (last != '\\') {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }

        return sb.toString();
    }

    /**
     * 添加space
     *
     * @param sb
     * @param indent
     */
    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }
}
