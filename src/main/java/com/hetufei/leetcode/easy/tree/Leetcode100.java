package com.hetufei.leetcode.easy.tree;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        return false;
    }
}
