package com.hetufei.leetcode.easy.binarySearch;

import com.hetufei.leetcode.lagou.binarySearch.BinarySearchTemplate;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode34 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int[] ans = searchRange(nums,3);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int left = BinarySearchTemplate.lowwerBound(nums, target);
        int right = BinarySearchTemplate.upperBound(nums, target);
        if (left == right) {
            return ans;
        }
        ans[0] = left;
        ans[1] = right - 1;
        return ans;

    }

}
