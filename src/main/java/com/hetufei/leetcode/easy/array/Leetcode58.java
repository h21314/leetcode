package com.hetufei.leetcode.easy.array;
//给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "Hello World"
//输出：5
//
//
// 示例 2：
//
//
//输入：s = " "
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅有英文字母和空格 ' ' 组成
//
// Related Topics 字符串
/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode58 {

    public static void main(String[] args) {
        Leetcode58 l = new Leetcode58();
        String s = "Hello World";
        System.out.println(l.lengthOfLastWord(s));
        s = "a ";
        System.out.println(l.lengthOfLastWord(s));
        s = "        ";
        System.out.println(l.lengthOfLastWord(s));
        s = "ab cd vfdgsdf";
        System.out.println(l.lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 || s.equals(" ")) {
            return 0;
        }
        String[] array = s.split(" ");
        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        return array[length - 1].length();
    }

    public int lengthOfLastWord1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }
}
