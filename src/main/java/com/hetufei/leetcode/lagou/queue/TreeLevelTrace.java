package com.hetufei.leetcode.lagou.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:二叉树的层次遍历
 * Created by hekangmin on 2021/5/21 14:26
 */
public class TreeLevelTrace {

    /**
     * 层序遍历
     * 由于二叉树的每个结点，我们都只访问了一遍，所以时间复杂度为 O(n)。如果不算返回的数组，那么空间复杂度为 O(k）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (queue.size() > 0) {
            final int qSize = queue.size();
            //当前层的结果存放于tmp链表中
            List<Integer> tmp = new ArrayList<>();
            //遍历当前层的每个结点
            for (int i = 0; i < qSize; i++) {
                //当前层前面的结点先出队
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }

    public void trace(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(rootNode);
        while (queue.size() > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                System.out.print(curNode.val + ", ");
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }

        }
    }

}
