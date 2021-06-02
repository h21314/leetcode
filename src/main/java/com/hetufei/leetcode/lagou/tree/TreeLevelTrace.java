package com.hetufei.leetcode.lagou.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 二叉树层次遍历
 * Created by hekangmin on 2021/3/31 16:48
 */
public class TreeLevelTrace {
    public static List<List<Integer>> levelOrder(TreeNode rootNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (rootNode != null) {
            //等同于add
            queue.offer(rootNode);
        }
        //保存结果
        List<List<Integer>> ans = new ArrayList<>();
        //利用当前层里面的元素进行层次遍历
        while (queue.size() > 0) {
            int qSize = queue.size();
            List<Integer> levelList = new LinkedList<>();
            //便利当前层的每个节点
            for (int i = 0; i < qSize; i++) {
                TreeNode current = queue.poll();
                levelList.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            ans.add(levelList);
        }
        return ans;
    }

    public static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (queue.size() > 0) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode current = queue.poll();
                System.out.print(current.val + ", ");
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
    }
}
