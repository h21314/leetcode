package com.hetufei.leetcode.hard.array;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
//
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
// 示例 3：
//
//
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
//
//
// 示例 4：
//
//
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
//
//
// 示例 5：
//
//
//输入：nums1 = [2], nums2 = []
//输出：2.00000
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
//
//
//
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
// Related Topics 数组 二分查找 分治算法
// 👍 4188 👎 0
public class Leetcode4 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        double ans = findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0d;
        }
        //定义双指针
        int p = 0, q = 0;
        int len1 = nums1.length,len2 = nums2.length;
        int[] ans = new int[len1+len2];
        int index = 0;
        while (p < len1 || q < len2) {
            if (p < len1) {

            }
            if (nums1[p] <= nums2[q]){
                ans[index++] = nums1[p++];
            }else{
                ans[index++] = nums2[q++];
            }
        }
        int newLen = ans.length;
        if (newLen % 2 == 1) {
            return (double) ans[newLen / 2];
        }else{
            return (double) ans[(newLen - 1) / 2] + (double) ans[newLen / 2];
        }

    }
}
