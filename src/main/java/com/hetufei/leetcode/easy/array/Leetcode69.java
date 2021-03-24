package com.hetufei.leetcode.easy.array;
//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
// Related Topics 数学 二分查找
// 👍 625 👎 0
/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode69 {
    public static void main(String[] args) {
        int x = 2147395599;
        int x1 = 1;
        int y = 18;
        int z = 25;
        System.out.println(mySqrt1(x));
        System.out.println(mySqrt1(x1));
        System.out.println(mySqrt1(y));
        System.out.println(mySqrt1(z));

    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1;
        int right = x / 2;
        while (left < right) {
            int middle = (left + right) / 2;
            if ((long)middle * middle < x) {
                if ((long)(middle + 1) * (middle +1) > x){
                    return middle;
                }
                left = middle + 1;
            } else if ((long)middle * middle > x) {
                right = middle;
            }else {
                return middle;
            }

        }
        return left;
    }


    public static int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 0,right = x / 2;
        int ans = -1;
        while (left <= right) {
            int middle = (left + right) /2 ;
            if ((long) middle * middle <= x) {
                ans = middle;
                left = middle + 1;
            }else{
                right = middle - 1;
            }

        }
        return ans;
    }
}
