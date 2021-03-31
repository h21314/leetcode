package com.hetufei.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 每一层的平均值
 * Created by hekangmin on 2021/3/31 21:49
 */
public class TreeLevelTraceAvg {
    public List<Double> getLevelAvg(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levelList = new ArrayList<>();
        List<Double> ans = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (queue.size() > 0) {

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode current = queue.poll();
                list.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            levelList.add(list);
        }

        for (int i = 0; i < levelList.size(); i++) {
            List<Integer> list = levelList.get(i);
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                sum += list.get(j);
            }
            double tmp = sum / list.size();
            ans.add(tmp);
        }
        return ans;
    }
}
