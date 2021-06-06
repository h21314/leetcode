package com.hetufei.leetcode.easy.array;

/**
 * Description:
 * Created by hekangmin on 2021/6/6 18:00
 */
public class Leetcode122 {
    /**
     * 动态规划，时间复杂度O(n),空间复杂度O(N)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 0; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i - 1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][i],dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }

    /**
     * 贪心算法,时间复杂度O(N),O(1),因为只需要一个变量来存储答案
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int ans = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            ans += Math.max(0,prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
