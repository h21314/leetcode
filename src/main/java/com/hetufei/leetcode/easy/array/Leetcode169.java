package com.hetufei.leetcode.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
//输入：[3,2,3]
//输出：3
//
// 示例 2：
//
//
//输入：[2,2,1,1,1,2,2]
//输出：2
//
//
//
//
// 进阶：
//
//
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
//
// Related Topics 位运算 数组 分治算法
// 👍 1026 👎 0
public class Leetcode169 {

    //先排序，排完序后，中间的元素肯定是众数
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //首先遍历整个数组，使用map统计每一个元素出现的次数，然后遍历map取最大值
    //时间复杂度O（n），空间复杂度O（N）
    public int majorityElement1(int[] nums){
        Map<Integer,Integer> count = new HashMap<>();
        for (int n : nums) {
            if (!count.containsKey(n)){
                count.put(n,1);
            }else{
                count.put(n,count.get(n) +1);
            }
        }
        Map.Entry<Integer,Integer> majorEntry = null;
        for (Map.Entry<Integer, Integer> map : count.entrySet()) {
            if (majorEntry == null || map.getValue() > majorEntry.getValue()) {
                majorEntry = map;
            }
        }
        return majorEntry.getKey();
    }
}
