package com.hetufei.leetcode.easy.linkedlist;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: 相交链表
 **/
public class Leetcode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ans = null;
        ListNode pA = headA, pB = headB;
        while (headA != pB) {
            if (pA == null) {
                pA = headB;
            }else{
                pA = pA.next;
            }
            if (pB == null) {
                pB = headA;
            }else{
                pB = pB.next;
            }
        }
        return pA;
    }
}
