package com.hetufei.leetcode.middle.array;

import java.util.Random;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode215 {
    Random random  = new Random();
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return 0;
        }

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }


    public int quickSelect(int[] a,int left,int right,int index){
        int q = randomPartition(a, left, right);
        if (q == index) {
            return a[q];
        }else{
            return q < index ? quickSelect(a, q + 1, right, index) : quickSelect(a, left, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(a,i,right);
        return partition(a,left,right);
    }

    public int partition(int[] a, int left, int right) {
        int x = a[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (a[j] <= x) {
                swap(a,++i,j);
            }
        }
        swap(a,i+1,right);
        return i+1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
