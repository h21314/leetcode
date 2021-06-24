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
        int[] nums = new int[]{1,1,-1,-1,3};
        int targe = -1;
        int ans = threeSumClosest(nums, targe);
        System.out.println(ans);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = 1000;
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                int sub = target - sum;
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    //移动到下一个不等于nums[right]的元素
                    int right1 = right - 1;
                    while (left < right1 && nums[right] == nums[right1]){
                        --right1;
                    }
                    //更新right的位置
                    right = right1;
                }else{
                    int left1 = left + 1;
                    while (left1 < right && nums[left] == nums[left1]) {
                        left1++;
                    }
                    left = left1;
                }
            }
        }
        return best;
    }
}
