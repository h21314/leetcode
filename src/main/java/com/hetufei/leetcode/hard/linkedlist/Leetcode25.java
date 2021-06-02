package com.hetufei.leetcode.hard.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by hekangmin on 2021/6/2 20:04
 */
public class Leetcode25 {

    public static void main(String[] args) {
        ListNode p1 = new ListNode();
        p1.val = 1;
        ListNode p2 = new ListNode();
        p2.val = 2;
        ListNode p3 = new ListNode();
        p3.val = 3;
        ListNode p4 = new ListNode();
        p4.val = 4;
        ListNode p5 = new ListNode();
        p5.val = 5;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        ListNode ans = reverseKGroup(p1,2);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        int count = 0;
        ListNode dummy = new ListNode();
        while (head != null) {

            //头插法,进行k个结点反转
            ListNode tmp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
            count++;
            if (count == k || head == null || head.next == null) {
                list.add(dummy.next);
                count = 0;
                dummy = new ListNode();
            }
        }

        ListNode ansDummy = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            ansDummy = mergeListNode(ansDummy,list.get(i));
        }
        return ansDummy;


    }

    public static ListNode mergeListNode(ListNode head1,ListNode head2){
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (head1 != null || head2 != null) {
            if (head1 != null){
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            }
            if (head2 != null){
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        return dummy.next;
    }
}
