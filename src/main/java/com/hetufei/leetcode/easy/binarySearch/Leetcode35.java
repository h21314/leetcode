package com.hetufei.leetcode.easy.binarySearch;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length;
        while (left < right) {
            final int m = left + ((right - left) >> 1);
            if (nums[m] < target) {
                left = m + 1;
            }else{
                right = m;
            }
        }
        return left;
    }
}
