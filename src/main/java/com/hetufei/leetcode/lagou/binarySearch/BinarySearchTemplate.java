package com.hetufei.leetcode.lagou.binarySearch;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class BinarySearchTemplate {

    boolean binarySearch(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        //使用开闭原则[left,right)
        int left = 0,right = A.length;
        while (left < right) {
            final int m = left + ((right - left) >> 1);
            if (A[m] == target) {
                return true;
            }
            //当重点比目标值小时，去右边继续查找，由于使用的是开闭原则，所以新的区间是[m+1,right)，因此left=m+1;
            if (A[m] < target) {
                left = m + 1;
            }
            //当中点比目标值大时，去左边查找，所以需要丢弃[m.right），所以设置right=m；
            else{
                right = m;
            }
        }
        return false;
    }

    public static int lowwerBound(int[] A, int target) {
        //使用开闭原则[left,right)
        int left = 0,right = A.length;
        while (left < right) {
            final int m = left + ((right - left) >> 1);
            if (A[m] < target) {
                left = m + 1;
            }else {
                right = m;
            }
        }
        return left;
    }

    public static int upperBound(int[] A, int target) {
        int left = 0, right = A.length;
        while (left < right) {
            final int m = left + ((right - left) >> 1);
            if (A[m] <= target) {
                left = m +1;
            }else{
                right = m;
            }
        }
        return left;
    }
}
