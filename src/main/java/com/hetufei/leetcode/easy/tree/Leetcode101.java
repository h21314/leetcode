package com.hetufei.leetcode.easy.tree;

/**
 * Description:
 * Created by hekangmin on 2021/6/6 22:24
 */
public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);

    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.val == root2.val) && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right,root2.left);
    }
}
