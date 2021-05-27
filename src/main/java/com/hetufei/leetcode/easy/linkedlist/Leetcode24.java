package com.hetufei.leetcode.easy.linkedlist;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
//
//
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
// Related Topics 递归 链表
// 👍 922 👎 0
public class Leetcode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode oddDummy = new ListNode();
        ListNode oddTail = oddDummy;
        ListNode evenDummy = new ListNode();
        ListNode evenTail = evenDummy;
        int next = 0;
        ListNode p = head;
        while (p != null) {
            ListNode back = p.next;
            if (next % 2 == 0) {//偶数
                evenTail.next = p;
                evenTail = p;
            }else{//奇数
                oddTail.next = p;
                oddTail = p;
            }
            next++;
            p = p.next;
        }
        oddTail.next = null;
        evenTail.next = null;
        return mergeListNodes(oddDummy.next, evenDummy.next);


    }

    public ListNode mergeListNodes(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }
            if (l2 != null) {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        tail.next = null;
        return dummy.next;
    }
}
