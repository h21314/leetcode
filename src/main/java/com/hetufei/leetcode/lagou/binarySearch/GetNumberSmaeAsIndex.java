package com.hetufei.leetcode.lagou.binarySearch;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class GetNumberSmaeAsIndex {
    public int getNumberSameAsIndex(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int left = 0,right = A.length;
        while (left < right) {
            final int m = left + ((right - left) >> 1);
            if (A[m] < m) {
                left = m + 1;
            }else{
                right = m;
            }
        }
        if (left < A.length && A[left] == left) {
            return left;
        }
        return -1;
    }
}
