package com.hetufei.leetcode.middle.linkedlist;

/**
 * Description:
 * Created by hekangmin on 2021/6/2 17:24
 */
public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        int prewalkedSteps = 0;
        //front指针先从dummy走n步
        ListNode front = dummy;
        while (prewalkedSteps < n && front != null && front.next != null) {
            prewalkedSteps++;
            front = front.next;
        }
        //当front指针走了n步以后，back指针和front指针开始一起走,直到front到达最后一个节点
        ListNode back = dummy;
        while (front != null && front.next != null) {
            front = front.next;
            back = back.next;
        }

        //如果prewalkedSteps == n则说明处于以下两种情况；1.链表长度 == n，此时删除原来的链表头结点；
        // 2.链表长度 > k，此时找到倒数第 k 个结点的前驱，然后删除倒数第 k 个结点。
        if (prewalkedSteps == n) {
            back.next = back.next.next;
        }
        return dummy.next;
    }
}
