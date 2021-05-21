package com.hetufei.leetcode.middle.tree;

//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层序遍历如下：
//
//
//[
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索
// 👍 443 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.hetufei.leetcode.lagou.queue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (level % 2 == 0) {//奇数层，左->右
                    if (cur.getLeft() != null){
                        queue.offer(cur.getLeft());
                    }
                    if (cur.getRight() != null){
                        queue.offer(cur.getRight());
                    }
                }else{
                    if (cur.getRight() != null){
                        queue.offer(cur.getRight());
                    }
                    if (cur.getLeft() != null){
                        queue.offer(cur.getLeft());
                    }
                }
                tmp.add(cur.getVal());

            }
            level++;
            ans.add(tmp);
        }
        return ans;
    }
}
