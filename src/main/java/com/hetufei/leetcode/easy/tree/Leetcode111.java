package com.hetufei.leetcode.easy.tree;

/**
 * Description:
 * Created by hekangmin on 2021/6/9 14:39
 */
public class Leetcode111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int depth = Integer.MAX_VALUE;
        if (root.left != null) {
            depth = Math.min(depth, minDepth(root.left));
        }
        if (root.right != null) {
            depth = Math.min(depth, minDepth(root.right));
        }
        return depth + 1;
    }
}
