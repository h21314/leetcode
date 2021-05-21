package com.hetufei.leetcode.lagou.stack;

import java.util.Stack;

/**
 * Description:
 * 例 2：大鱼吃小鱼
 * 【题目】在水中有许多鱼，可以认为这些鱼停放在 x 轴上。再给定两个数组 Size，Dir，Size[i] 表示第 i 条鱼的大小，Dir[i] 表示鱼的方向 （0 表示向左游，1 表示向右游）。这两个数组分别表示鱼的大小和游动的方向，并且两个数组的长度相等。鱼的行为符合以下几个条件:
 *
 * 所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离；
 *
 * 当方向相对时，大鱼会吃掉小鱼；
 *
 * 鱼的大小都不一样。
 *
 * 输入：Size = [4, 2, 5, 3, 1], Dir = [1, 1, 0, 0, 0]
 *
 * 输出：3
 * Created by hekangmin on 2021/5/21 11:19
 *
 * 栈，可以看作消除行为，使用栈来模拟消除行为
 */
public class Stack2 {
    /**
     * 时间复杂度O(N),空间复杂度O(N)
     * 在该例题中，栈中只存了索引
     * @param fishSize
     * @param fishDir
     * @return
     */
    int solution(int[] fishSize,int[] fishDir){
        //鱼的数量
        int fishNumber = fishSize.length;
        if (fishNumber <= 1) {
            return fishNumber;
        }
        final int left = 0;
        final int right = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < fishNumber; i++) {
            final int curFishDir = fishDir[i];
            final int curFishSize = fishSize[i];
            boolean hasEat = false;
            //如果栈中还有鱼，且栈向右，当前向左，则才会相遇,注意这里使用的是peek
            while (!stack.empty() && fishDir[stack.peek()] == right && curFishDir == left){
                if (fishSize[stack.peek()] > curFishSize) {//栈中的鱼更大，新来的会被吃掉
                    hasEat = true;
                    break;
                }
                //栈中的鱼更小，栈中的鱼被吃掉，则使用pop模拟栈中的鱼被吃掉
                stack.pop();
            }
            //如果新来的鱼没有被吃掉，则说明栈中的鱼被吃掉了，此时新来的鱼需要入栈
            if (!hasEat) {
                stack.push(i);
            }
        }
        return stack.size();
    }
}
