package com.hetufei.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root,ans);
        return ans;
    }

    private void postorder(TreeNode root,List<Integer> ans){
        if (root == null) {
            return;
        }
        postorder(root.left,ans);
        postorder(root.right,ans);
        ans.add(root.val);
    }
}
