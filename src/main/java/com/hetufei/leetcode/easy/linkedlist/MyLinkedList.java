package com.hetufei.leetcode.easy.linkedlist;

import com.hetufei.basis.Test;

import java.io.PrintStream;

/**
 * Description:
 * Created by hekangmin on 2021/5/27 10:07
 */
// 实现单链表
class MyLinkedList {
    // 链表结点的定义
    class ListNode {
        // val用来存放链表中的数据
        public int val = 0;
        // next指向下一个结点
        public ListNode next = null;
        public ListNode() {}
        public ListNode(int x) {
            val = x;
        }
    }
    /** code here: 初始化链表*/
    private ListNode dummy = new ListNode();
    private ListNode tail = dummy;
    private int length = 0;
    public MyLinkedList() {

    }
    public void addAtTail(int val) {
        ListNode p = new ListNode(val);
        tail.next = p;
        tail = p;
        length++;
    }
    public void addAtHead(int val) {
        /* code here: 插入值val的新结点，使它成为链表的第一个结点*/
        ListNode p = new ListNode(val);
        p.next = dummy.next;
        dummy.next = p;
        if (tail == dummy) {//如果是空链表（即只有一个dummy节点，此时需要指定tail尾节点）
            tail = p;
        }
        length++;
    }
    public int get(int index) {
        /* code here: 获取链表中第index个结点的值。如果索引无效，则返回-1。*/
        // index从0开始。
        if (index < 0 || index >= length) {
            return -1;
        }
        ListNode prev = getPrevNode(index);
        return prev.next.val;

    }
    public void addAtIndex(int index, int val) {
        // code here:
        // 在链表中的第 index 个结点之前添加值为 val  的结点。
        // 1. 如果 index 等于链表的长度，则该结点将附加到链表的末尾。
        // 2. 如果 index 大于链表长度，则不会插入结点。
        // 3. 如果index小于0，则在头
        if (index > length) {
            return;
        } else if (index == length) {
            addAtTail(val);
        } else if (index <= 0) {
            addAtHead(val);
        }else{
            ListNode prevNode = getPrevNode(index);
            ListNode p = new ListNode(val);
            p.next = prevNode.next;
            prevNode.next = p;
            length++;
        }


    }
    public void deleteAtIndex(int index) {
        /* code here: 如果索引index有效，则删除链表中的第index个结点。*/
        if (index >= length || index < 0) {
            return;
        }
        ListNode prevNode = getPrevNode(index);
        if (tail == prevNode.next) {//如果要删除的是最后一个节点，则需要修改tail指针
            tail = prevNode;
        }
        prevNode.next = prevNode.next.next;
        length--;
    }

    private ListNode getPrevNode(int index) {
        //返回index结点的前驱结点，如果index不存在，则返回dummy结点
        ListNode front = dummy.next;
        ListNode back = dummy;
        for (int i = 0; i < index && front != null; i++) {
            back = front;
            front = front.next;
        }
        return back;
    }

    private ListNode getNodeByTarget(int target) {
        ListNode p1 = dummy.next;//第一个节点
        while (p1 != null) {
            if (p1.val == target) {
                return p1;
            }
            p1 = p1.next;
        }
        return null;

    }
}