package com.hetufei.leetcode.middle.binarySearch;

import sun.font.FontRunIterator;

import java.util.Arrays;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode209 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,3};
        int target = 10;
        int ans = minSubArrayLen2(target,nums);
    }

    //暴力法,时间复杂度：O(n^2)，空间复杂度O(1)
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans,j - i +1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    //二分法,时间复杂度：O(n \log n)O(nlogn);其中 nn 是数组的长度。需要遍历每个下标作为子数组的开始下标，遍历的时间复杂度是 O(n)O(n)，对于每个开始下标，需要通过二分查找得到长度最小的子数组，二分查找得时间复杂度是 O(\log n)O(logn)，因此总时间复杂度是 O(n \log n)O(nlogn)。
   //空间复杂度：O(n)O(n)，其中 nn 是数组的长度。额外创建数组 \text{sums}sums 存储前缀和。
    public int minSubArrayLen1(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] sum = new int[n +1];
        //为了使用二分查找，需要额外创建一个数组 \text{sums}sums 用于存储数组 \text{nums}nums 的前缀和，其中 \text{sums}[i]sums[i] 表示从 \text{nums}[0]nums[0] 到 \text{nums}[i-1]nums[i−1] 的元素和
        //
        //作者：LeetCode-Solution
        //链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        for (int i = 1; i <= n ; i++) {
            sum[i] = sum[i-1] + nums[i - 1];
        }

        for (int i = 1; i <= n ; i++) {
            int total = target + sum[i - 1];
            int bound = Arrays.binarySearch(sum, total);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans,bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    //滑动窗口,时间复杂度：O(n).其中 nn 是数组的长度。指针 \textit{start}start 和 \textit{end}end 最多各移动 nn 次。
    //空间复杂度O(1)
    public static int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0,end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            //如果总和大于目标值，则更新子数组的最小长度（此时子数组的长度为end-start+1）.然后将nums[start]从nums中减去并将start右移，直到sum < s,在该过程中同样
            //需要更新子数组的最小长度,在每一轮迭代的最后，将end右移
            while (sum >= target) {
                ans = Math.min(ans,end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
