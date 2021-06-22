package com.hetufei.leetcode.middle.array;

import java.util.Arrays;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。
//
//
//
// 示例：
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4
//
// Related Topics 数组 双指针
// 👍 802 👎 0
public class Leetcode16 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int targe = 1;
        int ans = threeSumClosest(nums, targe);
        System.out.println(ans);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minAbsNum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int sub = target - sum;
                if (sub < 0) {
                    right--;
                } else if (sub == 0) {
                    ans = sum;
                    return ans;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }
}
