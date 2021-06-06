package com.hetufei.leetcode.middle.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by hekangmin on 2021/6/6 19:58
 */
public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int count = 0,row = matrix.length,column = matrix[0].length;
        int total = row * column;
        int up = 0,down = row - 1,left = 0,right = column - 1;
        while (column < total) {
            //第一层
            for (int i = left; i <= right && count < total; i++) {
                ans.add(matrix[up][i]);
                count++;
            }
            up++;
            for (int i = up; i <= down && count < total; i++) {
                ans.add(matrix[i][right]);
                count++;
            }
            right--;
            for (int i = right; i >= left && count < total ; i--) {
                ans.add(matrix[down][i]);
                count++;
            }
            down--;
            for (int i = down; i >= up && count<total ; i++) {
                ans.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return ans;
    }
}
