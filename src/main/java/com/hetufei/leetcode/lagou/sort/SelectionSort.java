package com.hetufei.leetcode.lagou.sort;

/**
 * Description: 选择排序 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 * Created by hekangmin on 2021/3/29 22:13
 */
public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {//遍历剩余未排序元素，继续寻找最小元素
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
}
