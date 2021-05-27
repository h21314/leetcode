package com.hetufei.leetcode.easy.linkedlist;
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//
// 示例 1：
//
//
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
//
//
// 示例 2：
//
//
//输入：head = [], val = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [7,7,7,7], val = 7
//输出：[]
//
//
//
//
// 提示：
//
//
// 列表中的节点在范围 [0, 104] 内
// 1 <= Node.val <= 50
// 0 <= k <= 50
//
// Related Topics 链表
// 👍 596 👎 0
public class Leetcode203 {
    //采用建立一个新链表的方式
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (head != null) {
            if (head.val != val) {//不相等则使用尾插法
                tail.next = head;
                tail = head;
            }
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode();
        p1.val = 1;
        ListNode p2 = new ListNode();
        p2.val = 2;
        ListNode p3 = new ListNode();
        p3.val = 6;
        ListNode p4 = new ListNode();
        p4.val = 3;
        ListNode p5 = new ListNode();
        p5.val = 4;
        ListNode p6 = new ListNode();
        p6.val = 5;
        ListNode p7 = new ListNode();
        p7.val = 6;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        ListNode ans = removeElements(p1, 6);

    }
}
