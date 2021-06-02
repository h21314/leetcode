package com.hetufei.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        middleOrder(root,ans);
        return ans;
    }

    private void middleOrder(TreeNode root , List<Integer> ans){
        if (root == null) {
            return;
        }
        middleOrder(root.left,ans);
        ans.add(root.val);
        middleOrder(root.right,ans);
    }
}
