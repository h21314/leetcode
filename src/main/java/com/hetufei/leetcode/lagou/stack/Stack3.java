package com.hetufei.leetcode.lagou.stack;

import java.util.Stack;

/**
 * Description:单调栈
 * Created by hekangmin on 2021/5/21 11:35
 */
public class Stack3 {

    public static void main(String[] args) {
        int[] arr = {5,3,12,1,25};
        int[] ans = findRightSmall(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    /**
     * 一个整数数组 A，找到每个元素：右边第一个比我小的下标位置，没有则用 -1 表示。时间复杂度为 O(N)，而空间复杂度为 O(N)
     * 输入：[5, 2]
     * 输出：[1, -1]
     * @param A
     * @return
     */
    public static int[] findRightSmall(int[] A) {
        int[] ans = new int[A.length];
        //栈中存的是下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            final int x = A[i];
            //每个元素向左遍历栈中的元素完成消除动作
            while (!stack.empty() && A[stack.peek()] > x) {
                //记录一下谁被消除了
                ans[stack.peek()] = i;
                stack.pop();
            }
            //入栈
            stack.push(i);
        }
        // 栈中剩下的元素，由于没有人能消除他们，因此，只能将结果设置为-1。
        while (!stack.empty()) {
            ans[stack.peek()] = -1;
            stack.pop();
        }
        return ans;

    }

    public static int[] findRightBigger(int[] A) {
        int[] ans = new int[A.length];
        //栈中存的是下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            final int x = A[i];
            //每个元素向左遍历栈中的元素完成消除动作
            while (!stack.empty() && A[stack.peek()] < x) {
                //记录一下谁被消除了
                ans[stack.peek()] = i;
                stack.pop();
            }
            //入栈
            stack.push(i);
        }
        // 栈中剩下的元素，由于没有人能消除他们，因此，只能将结果设置为-1。
        while (!stack.empty()) {
            ans[stack.peek()] = -1;
            stack.pop();
        }
        return ans;

    }
}
