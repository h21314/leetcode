package com.hetufei.leetcode.lagou.sort;

/**
 * Description: 快速排序
 * Created by hekangmin on 2021/3/31 10:14
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {1,4,2,5,6,9,4,2,9,10};
        quickSort(array,0,array.length - 1);
        print(array);
    }

    public static void quickSort(int[] array,int low,int hight){
        if (low < hight) {
            int privotpos = partition(array, low, hight);
            quickSort(array, low, privotpos - 1);
            quickSort(array,privotpos + 1,hight);
        }
    }

    public static int partition(int[] array, int low, int hight) {
        //找到基准数字，第一个数字作为基准数字
        int privot = array[low];
        while (low < hight) {
            //从右边开始找第一个小于基准数字,当队尾元素大于等于基准数字时，往前挪动high指针
            while (low < hight && array[hight] >= privot) {
                hight--;
            }
            //如果队尾元素小于tmp了，需要将其复制给low
            array[low] = array[hight];
            //当队首元素小于等于基准元素时，向前挪动low指针
            while (low < hight && array[low] <= privot){
                low++;
            }
            //当队首元素大于基准元素时，将其复制给hiht
            array[hight] = array[low];

        }
        //跳出循环时low和high相等，此时low或high的位置就是基准数据的索引位置，需要将privot复制给array[low]
        array[low] = privot;
        //返回privot的正确位置
        return low;
    }

    private static void print(int[] array) {
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }
}
