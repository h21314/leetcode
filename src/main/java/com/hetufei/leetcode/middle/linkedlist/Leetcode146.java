package com.hetufei.leetcode.middle.linkedlist;

import sun.misc.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: LRUCache
 * Created by hekangmin on 2021/6/6 13:53
 */
public class Leetcode146 {

    private Node dummy = new Node();
    private Node tail = new Node();
    private int capacity;
    private int size;
    private Map<Integer,Node> hashMap = new HashMap<>();

    public Leetcode146(int capacity) {
        dummy.next = tail;
        tail.pre = dummy;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return -1;
        }
        del(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if (node != null) {
            node.value = value;
            del(node);
            add(node);
        }else{
            if (size < capacity) {
               size++;
            }else{
                Node delNode = tail.pre;
                hashMap.remove(delNode.key);
                del(delNode);
            }
            Node newNode = new Node(key, value);
            add(newNode);
            hashMap.put(key,newNode);
        }
    }

    private void del(Node node){
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        node.pre = null;
        node.next = null;
    }

    public void add(Node node) {
        //原先的头结点
        Node originHead = dummy.next;
        dummy.next = node;//node设置为新的头结点
        node.pre = dummy;
        node.next = originHead;
        originHead.pre = node;
    }


    private class Node{
        private int key;
        private int value;
        private Node pre;
        private Node next;
        public Node(){}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}


