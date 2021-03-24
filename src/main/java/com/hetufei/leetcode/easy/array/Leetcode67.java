package com.hetufei.leetcode.easy.array;
//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 数学 字符串
// 👍 582 👎 0

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode67 {
    public static void main(String[] args) {
        String a = "11111";
        String b = "1011";
        System.out.println(addBinary(a,b));
    }

    public static String addBinary(String a, String b) {
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        StringBuilder ans = new StringBuilder();
        int carry = 0;//代表进位
        while (aLen >= 0 || bLen >= 0) {
            if (aLen >= 0) {
                carry += a.charAt(aLen) - '0';
                aLen--;
            }
            if (bLen >= 0) {
                carry += b.charAt(bLen) - '0';
                bLen--;
            }
            ans.append(carry % 2);
            carry = carry / 2;//如果相加为2，则2 /2= 1，代表前一位进1；
        }
        String res = ans.reverse().toString();
        if (carry == 1) {
            res = '1' + res;
        }
        return res;
    }
}
