package com.hetufei.leetcode.lagou.stack;

import java.util.Stack;

/**
 * Description:判断字符串括号是否合法
 * 当遇到配对消除时，可以考虑使用栈，当栈中内容一样时，可以使用计数器优化空间复杂度
 * Created by hekangmin on 2021/5/21 11:13
 */
public class Stack1 {

    /**
     * 使用栈，時間复杂度O(N),空间复杂度O(n)
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }

        }
        return stack.empty();
    }

    /**
     * 当栈中存储的元素都相同时，可以不使用栈，只要记录栈中元素的个数,時間复杂度O(N),空间复杂度O(1)
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        int count = 0 ;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count <= 0) {
                    return false;
                }
                --count;
            }

        }
        return count == 0;
    }
}
