package com.hetufei.leetcode.middle.string;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode5 {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    /**
     * 暴力法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int maxLen = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i,j);
                if (isPalindrome(subStr) && subStr.length() > maxLen){
                    ans = subStr;
                    maxLen = subStr.length();
                }
            }
        }
        return ans;
    }

    public static boolean isPalindrome(String s){
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}
