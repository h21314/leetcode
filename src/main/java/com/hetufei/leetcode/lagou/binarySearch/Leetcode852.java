package com.hetufei.leetcode.lagou.binarySearch;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode852 {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            return -1;
        }
        int left = 1,right = arr.length - 1;
        while (left < right) {
            final int m = left + ((right - left) >> 1);
            if (arr[m-1] < arr[m] && arr[m] < arr[m+1]){
                left = m + 1;
            }else{
                right = m;
            }
        }
        return left;
    }

    public int peakIndexInMountainArray1(int[] arr) {
        int n = arr.length;
        int ans = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i+1]){
                ans = i;
                break;
            }
        }
        return ans;
    }



    }
