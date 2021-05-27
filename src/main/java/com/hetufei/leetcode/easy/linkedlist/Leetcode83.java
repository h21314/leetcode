package com.hetufei.leetcode.easy.linkedlist;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//
// 返回同样按升序排列的结果链表。
//
//
//
// 示例 1：
//
//
//输入：head = [1,1,2]
//输出：[1,2]
//
//
// 示例 2：
//
//
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围 [0, 300] 内
// -100 <= Node.val <= 100
// 题目数据保证链表已经按升序排列
//
// Related Topics 链表
// 👍 577 👎 0
public class Leetcode83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode();
        p1.val = 1;
        ListNode p2 = new ListNode();
        p2.val = 1;
        ListNode p3 = new ListNode();
        p3.val = 2;
        /*ListNode p4 = new ListNode();
        p4.val = 0;
        ListNode p5 = new ListNode();
        p5.val = 0;*/
        p1.next = p2;
        p2.next = p3;
        /*p3.next = p4;
        p4.next = p5;*/
        ListNode ans = deleteDuplicates(p1);

    }
}
