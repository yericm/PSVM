package com.bywin.base.sort;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 排序算法
 */
public class SortAlgorithm {
    public static void main(String[] args) throws ParseException {
        int[] arr = {5, 1, 0, 9, 20, 7};
        // selectSort(arr);
        // bubbleSort(arr);
//        insertSort(arr);
        Date date = DateUtils.parseDate("2099-12-12 23:59:59", "yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        int hour24 = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour24);
        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2099-12-12 23:59:59");
        System.out.println(parse);
    }

    /**
     *  插入排序
     */
    public static void insertSort (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j --) {
                if (arr[j] < arr[j - 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tem;
                }else {
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
     * @param arr
     */
    public static void selectSort (int [] arr) {
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
     * @param arr
     */
    public static void bubbleSort (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j ++) {
                if (arr[j] > arr[j+1]) {
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
}
