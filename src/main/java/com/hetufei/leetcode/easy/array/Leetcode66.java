package com.hetufei.leetcode.easy.array;
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
//输入：digits = [0]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics 数组
// 👍 646 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode66 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] ans = plusOne(nums);
        print(ans);

        int[] nums4 = {9};
        int[] ans4 = plusOne(nums4);
        print(ans4);

        int[] nums1 = {4,3,2,1};
        int[] ans1 = plusOne(nums1);
        print(ans1);

        int[] nums2 = {9,8,7,6,5,4,3,2,1,0};
        int[] ans2 = plusOne(nums2);
        print(ans2);
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0 ; i--) {
            if (digits[i] != 9) {
                //不为9的话只要在当前位置+1然后返回原数组即可
                digits[i]++;
                return digits;
            }else{
                //当前位置为9的话，把当前位置变为0即可，如果不是全为9，则会再进入上面循环，如果全为9，则新建一个数组，将第一位变为1即可
                digits[i] = 0;
            }
        }
        //全为999的情况下执行此处语句
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }

    public static int[] plusOne1(int[] digits){
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        //全为9的情况下
        int[] ans = new int[len + 1];
        ans[0] = 1;
        return ans;

    }
}
