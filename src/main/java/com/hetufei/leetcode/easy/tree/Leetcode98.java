package com.hetufei.leetcode.easy.tree;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode98 {
    public boolean isValidBST(TreeNode root) {
        return preOrder(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean preOrder(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return preOrder(root.left, left, root.val) && preOrder(root.right, root.val, right);
    }
}
