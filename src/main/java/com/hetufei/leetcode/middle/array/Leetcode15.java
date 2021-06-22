package com.hetufei.leetcode.middle.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针
// 👍 3437 👎 0
public class Leetcode15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(nums);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    //排序加双指针，时间复杂度O（N2），空间复杂度O（logN）
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return ans;
            }
            //因为题目中不允许有重复的三元组，所以需要跳过相同元素
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //定义双指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> subArr = new ArrayList<>();
                    subArr.add(nums[i]);
                    subArr.add(nums[left]);
                    subArr.add(nums[right]);
                    ans.add(subArr);
                    //需要跳过相同元素
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum > 0){
                    right--;
                }else{
                    left++;
                }
            }

            }
        return ans;

        }
    }
