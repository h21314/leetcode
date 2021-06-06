package com.hetufei.leetcode.easy.array;

/**
 * Description:
 * Created by hekangmin on 2021/6/6 17:45
 */
public class Leetcode121 {
    /**
     * O(n2)
     * 运行不通过，超时了
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < i + 1; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[2];
        prices[0] = 1;
        prices[1] = 2;
        int ans = maxProfit1(prices);

    }

    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }

        }
        return maxProfit;
    }
}
