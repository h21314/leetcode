package com.hetufei.leetcode.sort;

import java.util.Arrays;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: 归并排序
 **/
public class MergeSort {

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        //递归实现排序
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int i = 0,index = 0,j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            }else{
                result[index] = left[i++];
            }
        }
        return result;
    }


    public static void msort(int[] array, int[] tempArr, int left, int right) {
        //如果只有一个元素，则不需要继续划分
        if (left < right) {
            //找中间点
            int mid = (left + right) / 2;
            //递归划分左半区
            msort(array,tempArr,left,mid);
            //递归划分右半区
            msort(array, tempArr, mid + 1, right);
            //合并已经排序的部分
            merge1(array,tempArr,left,mid,right);
        }
    }

    //合并已经排序的部分
    public static void merge1(int[] array, int[] tempArr, int left, int mid, int right) {
        //标记左半区的第一个未排序的元素
        int l_pos = left;
        //标记右半区的第一个未排序的元素
        int r_pos =  mid +1;
        //临时数组元素的下标
        int pos = left;
        //合并
        while (l_pos <= mid && r_pos <= right) {
            //左半区第一个剩余的元素小于右边第一个元素，则直接把左边第一个元素放入临时数组中，然后指针往后移动
            if (array[l_pos] <= array[r_pos]){
                tempArr[pos++] = array[l_pos++];
            }else{//右半区第一个剩余元素更小，则直接把右边第一个元素放入临时数组中
                tempArr[pos++] = array[r_pos++];
            }
        }
        //合并左半区剩余的元素，右半区已经遍历完成，此时只需要把左边的元素直接复制到临时数组
        //左边半区还有元素未遍历到，则直接将左边剩余元素复制到临时数组中
        while (l_pos <= mid) {
            tempArr[pos++] = array[l_pos++];
        }
        //合并右半区剩余的元素，左半区已经遍历完成，此时只需要把右边的元素直接复制到临时数组中
        while (r_pos <= right) {
            tempArr[pos++] = array[r_pos++];
        }
        //把临时数组中合并后的元素复制回原来的数组
        while (left <= right) {
            array[left] = tempArr[left];
            left++;
        }
    }


    public static void main(String[] args) {
        int[] array = {1,3,2,6,5,8,7,9,5,4};
        int[] tempArr = new int[array.length];
        msort(array,tempArr,0,array.length - 1);
        print(tempArr);
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
