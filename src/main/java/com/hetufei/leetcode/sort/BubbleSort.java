package com.hetufei.leetcode.sort;

/**
 * Description: 冒泡排序 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 * Created by hekangmin on 2021/3/29 22:08
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - 1 -i; j++) {
                if (arrays[j] < arrays[i+1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j+1] = temp;
                }
            }
        }
        return arrays;
    }
}
