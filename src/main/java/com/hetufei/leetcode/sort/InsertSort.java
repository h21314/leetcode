package com.hetufei.leetcode.sort;

/**
 * Description: 插入排序
 * Created by hekangmin on 2021/3/29 22:21
 */
public class InsertSort {
    public static int[] insertSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i + 1];
            int index = i;
            while (index >= 0 && current < array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = current;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {2,3,1,5,0};
        int[] result = insertSort(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(i);
        }
    }
}
