package com.hetufei.leetcode.easy.linkedlist;

/**
 * Description:
 * Created by hekangmin on 2021/6/2 19:53
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode front = head;
        ListNode back = head;
        while (back != null && back.next != null) {
            front = front.next;
            back = back.next.next;
            if (front == back) {
                break;
            }
        }
        return front == back;

    }
}
