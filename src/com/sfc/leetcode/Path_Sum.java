package com.sfc.leetcode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.
 *
 * Created by Prophet on 2017/9/12.
 */
public class Path_Sum {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return sum (root, sum, 0);
    }

    private boolean sum (TreeNode node, int sum, int curSum) {
        if (node == null) return false;

        curSum += node.val;

        if (node.left == null && node.right == null) {
            // 叶子节点
            if (curSum == sum) {
                return true;
            } else {
                return false;
            }
        }

        return sum(node.left, sum, curSum) || sum(node.right, sum, curSum);
    }

}
