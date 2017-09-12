package com.sfc.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 * BFS, using a queue
 *
 * 按层遍历二叉树，使用 queue，poll() 的时候遍历，使用 last 记录当前层最后一个节点，
 * nlast 记录下一层的最后一个节点，遍历时不断更新 nlast
 *
 * Created by Prophet on 2017/9/12.
 */
public class Binary_Tree_Level_Order_Traversal {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<Integer> layer = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        // 记录当前层的最后一个节点
        TreeNode last = root;
        // 记录下一层的最后一个节点
        TreeNode nlast = root;
        while (!queue.isEmpty()) {
            // 出队，遍历
            node = queue.poll();
            layer.add(node.val);
            if (node.left != null) {
                // 入队
                queue.offer(node.left);
                // 更新 nlast
                nlast = node.left;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nlast = node.right;
            }
            // 该层最后一个节点，切换处理下一层
            if (node == last) {
                result.add(layer);
                layer = new LinkedList<>();
                last = nlast;
            }

        }


        return result;
    }
}
