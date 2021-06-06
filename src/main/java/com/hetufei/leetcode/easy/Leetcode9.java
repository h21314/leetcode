package com.hetufei.leetcode.easy;

/**
 * Description:
 * Created by hekangmin on 2021/6/6 14:55
 */
public class Leetcode9 {
    public boolean isPalindrome(int x) {
        String  s = x + "";
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}
