package com.hetufei.leetcode.lagou.queue;

/**
 * Description:
 * Created by hekangmin on 2021/5/21 14:28
 */
public class TreeNode {
    // 树结点中的元素值
    int val = 0;
    // 二叉树结点的左子结点
    TreeNode left = null;
    // 二叉树结点的右子结点
    TreeNode right = null;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
