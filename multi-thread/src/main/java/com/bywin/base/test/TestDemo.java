package com.bywin.base.test;

import java.io.IOException;
import java.util.*;

/**
 * created by yeric on 2019/8/7
 */
public class TestDemo {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int target = 3;
        int[] rotate = rotate(nums, target);
        System.out.println(rotate);
    /*    int[] nums = {2, 11, 7, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(ints.length);*/
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
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
