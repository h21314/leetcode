package com.hetufei.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: {USER}
 * @Date: {DATE} TIME}
 * @Description: TODO
 **/
public class Leetcode144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = null;
        root.right = node1;
        node1.left = null;
        node1.right = node2;
    }

    //递归实现前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root,ans);
        return ans;
    }

    private void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }

    //使用栈来模拟
    public List<Integer> preorderTraversalByStack(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()){
           //先遍历左边
            while (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ans;
    }
}
