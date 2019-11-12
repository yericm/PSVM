package com.bywin.base.test;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * created by yeric on 2019/8/7
 */
public class TestDemo {

    public static void main(String[] args) {
        double o = (double)(1)/3;
        System.out.println("o----------   "+(Math.round(o)));
        System.out.println("0.0-0.0----   "+(0.0-0.0)/0.0);
        BigDecimal b = new BigDecimal((double)(1689-1787)/1687);
        double rmoney = b.setScale(5,   BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("b----------   "+b);
        System.out.println(rmoney);
        double tpD = 6.15565;
        BigDecimal bigD = new BigDecimal(tpD);
        double tpD2 = bigD .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(tpD2);
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
//            Date date = sdf.parse("2019-03-31");
            Calendar c = Calendar.getInstance();
            //设置为指定日期
            c.setTime(new Date());
            //指定日期月份减去一
            c.add(Calendar.MONTH, -1);
            //指定日期月份减去一后的 最大天数
            c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
            //获取最终的时间
            Date lastDateOfPrevMonth = c.getTime();
            System.out.println("上月最后一天：" + sdf.format(lastDateOfPrevMonth));
            System.out.println(lastDateOfPrevMonth);
        } catch (Exception e) {
        }*/
    }

    public static String longestCommonPrefix(String[] strs) {

        return "";
    }

    public static int romanToInt(String s) {
        if (s.length() == 0 || "".equals(s)) {
            throw new RuntimeException("输入确保在 1 到 3999 的范围内");
        }
        String[] split = s.split("");
        Integer num = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        HashMap<String, Integer> fixValueMap = new HashMap<>();
        fixValueMap.put("IV", 4);
        fixValueMap.put("IX", 9);
        fixValueMap.put("XL", 40);
        fixValueMap.put("XC", 90);
        fixValueMap.put("CD", 400);
        fixValueMap.put("CM", 900);


        if (s.length() == 2) {
            if (!fixValueMap.containsKey(s)) {
                String[] split1 = s.split("");
                for (int i = 0; i < 2; i++) {
                    num += map.get(split1[i]);
                }
                return num;
            } else {
                return fixValueMap.get(s);
            }
        }
        for (int i = 0; i < split.length; i++) {
            num += map.get(split[i]);
        }
        return num;
    }

    static void pong() {

        System.out.print("pong");

    }

    public static int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];// temp=1,temp=1
                nums[j] = previous;// nums[0]=7;nums[1]=1
                previous = temp;// previous=1;previous=1
                // 1. [7,123456]
            }
        }
        return nums;
       /* if (k > nums.length) {
            return nums;
        }
        int[] newArray = new int[nums.length];
        int j = 0;
        for (int i = 0; i < k; i++) {
            newArray[j++] = nums[nums.length-k+i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            newArray[j++] = nums[i];
        }
        return newArray;*/
    }
}
