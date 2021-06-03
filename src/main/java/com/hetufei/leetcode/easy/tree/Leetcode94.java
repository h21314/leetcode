package com.hetufei.leetcode.easy.tree;

import java.util.*;

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

    //中序遍历
    private void middleOrder(TreeNode root , List<Integer> ans){
        if (root == null) {
            return;
        }
        middleOrder(root.left,ans);
        ans.add(root.val);
        middleOrder(root.right,ans);
    }

    public List<Integer> inorderTraversalByStack(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
