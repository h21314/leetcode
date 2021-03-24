package com.hetufei.leetcode.easy.array;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// 👍 851 👎 0

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode35 {

    public static void main(String[] args) {
        Leetcode35 t = new Leetcode35();
        int nums[] = {1,3,5,7,8,9,10};
        int target = 7;
        int tagret1 = 6;

        int index = t.searchInsert(nums, target);
        int index1 = t.searchInsert(nums, tagret1);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0,n = nums.length - 1;
        int right = n;
        int middle = 0;
        while (left <= right) {
            middle = (right + left) / 2;
            if (nums[middle] == target) {
                return middle;
            }else if (nums[middle] < target){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return left;
    }
}
