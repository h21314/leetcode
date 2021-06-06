package com.hetufei.leetcode.middle.dp;

/**
 * Description:
 * Created by hekangmin on 2021/6/6 21:01
 */
public class Leetcode64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m <= 0 || n <= 0) {
            return 0;
        }
        //dp[i][j]代表党机器人总左上角走到(i,j)这个位置时，最小的路径和dp[i][j]。那么dp[m-1][n-1]就是我们要的答案。
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //初始化行
        for (int i = 0; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //初始化列
        for (int i = 0; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }

        }
        return dp[m-1][n-1];
    }
}
