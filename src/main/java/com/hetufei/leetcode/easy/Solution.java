package com.hetufei.leetcode.easy;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 2;
        ListNode node3 = new ListNode();
        node3.val = 3;
        node1.next = node2;
        node2.next = node3;

        ListNode ans = reverseList(node1);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    static ListNode reverseList(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        while (node != null) {
            ListNode tmp = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = tmp;
        }
        return dummy.next;
    }


}

class ListNode{
    int val;
    ListNode next;

    ListNode() {

    }
}
