package com.hetufei.leetcode.lagou.tree;

/**
 * Description: 修改二叉树里所有的 next 指针，使其指向右边的结点，如果右边没有结点，那么设置为空指针。
 * Created by hekangmin on 2021/3/31 19:33
 */
public class TreeNext {
    public Node connectNext(Node root) {
        Node Q = null;
        if (root != null) {
            Q = root;
        }

        while (Q != null) {
            // 下一层前驱结点
            Node nextLevelPreNode = null;
            // 下一层的头结点
            Node nextLevelHead = null;
            // 顺序遍历当前层的每个结点
            Node curLevelNode = Q;
            while (curLevelNode != null) {
                // 如果得到一个下一层的结点
                if (curLevelNode.left != null) {
                    // 让下一层的前驱结点指向得到的下一层结点
                    if (nextLevelPreNode != null) {
                        nextLevelPreNode.next = curLevelNode.left;
                    }
                    nextLevelPreNode = curLevelNode.left;
                    // 设置下一层的头
                    if (nextLevelHead == null) {
                        nextLevelHead = curLevelNode.left;
                    }
                }
                // 如果得到一个下一层的结点
                if (curLevelNode.right != null) {
                    // 让下一层的前驱结点指向得到的下一层结点
                    if (nextLevelPreNode != null) {
                        nextLevelPreNode.next = curLevelNode.right;
                    }
                    nextLevelPreNode = curLevelNode.right;
                    // 设置下一层的头
                    if (nextLevelHead == null) {
                        nextLevelHead = curLevelNode.right;
                    }
                }
                curLevelNode = curLevelNode.next;
            }
            Q = nextLevelHead;
        }
        return root;
    }
}

class Node{
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(){}

    public Node(int _value) {
        this.val = _value;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

}