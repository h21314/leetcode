package com.hetufei.leetcode.middle.tree;

/**
 * Description:
 * Created by hekangmin on 2021/6/6 22:10
 */
import com.hetufei.leetcode.lagou.queue.TreeNode;

import java.util.*;

public class Leetcode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.getVal());
                if (cur.getLeft() != null) {
                    queue.offer(cur.getLeft());
                }
                if (cur.getRight() != null) {
                    queue.offer(cur.getRight());
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
