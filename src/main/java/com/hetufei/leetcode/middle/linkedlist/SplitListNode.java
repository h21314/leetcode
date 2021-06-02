package com.hetufei.leetcode.middle.linkedlist;

/**
 * Description: 给定一个链表，需要把链表从中间拆分成长度相等的两半（如果链表长度为奇数，那么拆分之后，前半部分长度更长一点）。
 * Created by hekangmin on 2021/6/2 19:15
 */
public class SplitListNode {

    /**
     * 找中间节点，如果为奇数，则前面节点更长
     * @param head
     * @return
     */
    public ListNode findMiddleNode(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode front = head;
        ListNode back = head;
        ListNode prev = dummy;//dummy是head的前驱，所以prev指向dummy
        while (back != null && back.next != null) {
            prev = front;
            front = front.next;
            back = back.next.next;
        }
        return back != null ? front : prev;
    }


    public ListNode[] splitListNode(ListNode head) {
        ListNode middle = findMiddleNode(head);
        ListNode back = middle.next;
        middle.next = null;
        return new ListNode[]{head, back};
    }
}
