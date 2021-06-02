package com.hetufei.leetcode.easy.string;

/**
 * Description:
 * Created by hekangmin on 2021/6/2 15:12
 */
public class Leetcode14 {
    public static void main(String[] args) {
        String s1 = "flower";
        String s2 = "flower";
        String s3 = "flower";
        String[] strs = new String[3];
        strs[0] = s1;
        strs[1] = s2;
        strs[2] = s3;
        String ans = longestCommonPrefix(strs);
        System.out.println(ans);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int length = Math.min(prefix.length(),strs[i].length());
            int index = 0;
            while (index < length && prefix.charAt(index) == strs[i].charAt(index)){
                index++;
            }
            prefix = prefix.substring(0,index);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1,String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
