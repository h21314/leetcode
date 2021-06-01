package com.hetufei.leetcode.easy.linkedlist;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        //存放返回结果
        ListNode ans = new ListNode();
        ListNode tail_ans = ans;

        //存放相同元素
        ListNode tmp = new ListNode();
        ListNode tmp_tail = tmp;

        ListNode p = head;
        while (p.next != null) {
            //tmp_tail == tmp说明链表为空，当链表为空或者链表中的元素跟p.val相等
            if (tmp_tail == tmp || p.val == tmp_tail.val) {
                tmp_tail.next = p;
                tmp_tail = p;

            }else{
                //当和tmp链表不相等时，则看一下tmp链表节点个数，
                //如果只有一个节点
                if (tmp_tail == tmp.next) {
                  tail_ans.next = tmp.next;
                  tail_ans = tail_ans.next;
                }
                //如果tmp链表中有多个节点，则什么也不做
                tmp_tail = tmp;
                tmp.next = null;
                tmp_tail.next = p;
                tmp_tail = p;
            }
            p = p.next;
        }
        if (tmp_tail == tmp.next) {
            tail_ans.next = tmp.next;
            tail_ans = tail_ans.next;
        }
        tail_ans.next = null;
        return ans.next;
    }
}
