package com.sfc.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * Created by Prophet on 2017/9/12.
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        // 每层结果
        List<Integer> layer = new LinkedList<>();
        // 当前处理层
        Stack<TreeNode> stack = new Stack<>();
        // 下个处理层
        Stack<TreeNode> nextStack = new Stack<>();
        stack.push(root);

        // 标识处理方向
        boolean flag = true;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            layer.add(node.val);
            if (flag) {
                // 从左向右添加
                if (node.left != null) {
                    nextStack.push(node.left);
                }
                if (node.right != null) {
                    nextStack.push(node.right);
                }
            } else {
                // 从右向左添加
                if (node.right != null) {
                    nextStack.push(node.right);
                }
                if (node.left != null) {
                    nextStack.push(node.left);
                }
            }

            // 当前层已处理完成
            if (stack.isEmpty()) {
                // 存储改层
                result.add(layer);
                // 存储下一层
                layer = new LinkedList<>();
                // 交换 stack
                Stack<TreeNode> temp = stack;
                stack = nextStack;
                nextStack = temp;
                // 切换 flag
                flag = !flag;
            }
        }


        return result;
    }
}
