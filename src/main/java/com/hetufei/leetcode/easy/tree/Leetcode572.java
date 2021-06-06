package com.hetufei.leetcode.easy.tree;

import javax.security.auth.Subject;

/**
 * Description:
 * Created by hekangmin on 2021/6/6 22:56
 */
public class Leetcode572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == subRoot || subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return root.val == subRoot.val && isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.val == b.val && isSame(a, b) && isSame(a.left, b.left) && isSame(a.right, b.right);
    }

}
