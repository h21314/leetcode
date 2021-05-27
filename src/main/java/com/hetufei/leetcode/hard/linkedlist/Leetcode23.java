package com.hetufei.leetcode.hard.linkedlist;


import java.util.PriorityQueue;
import java.util.Queue;

//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 堆 链表 分治算法
// 👍 1320 👎 0
public class Leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        final int length = lists.length;
        Queue<ListNode> queue = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (int i = 0; i < length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            tail.next = cur;
            tail = cur;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
