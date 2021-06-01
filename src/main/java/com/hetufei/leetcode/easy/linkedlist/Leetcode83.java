package com.hetufei.leetcode.easy.linkedlist;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode p = head;
        while (p != null) {
            if (p.val == tail.val) {
                p = p.next;
            }else{
                tail.next = p;
                tail = p;
                p = p.next;
            }
        }
        tail.next = null;
        return dummy.next;
    }
}
