package com.sfc.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 *
 * Created by Prophet on 2017/9/12.
 */
public class Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        findPath(result, path, root, 0, sum);
        return result;
    }

    private void findPath(List<List<Integer>> result, List<Integer> path, TreeNode node, int sum, int target) {

        if (node == null) return;

        sum += node.val;
        path.add(node.val);

        if (node.left == null && node.right == null) {
            if (sum == target) {
                // add the copy of path
                result.add(new ArrayList<>(path));
            }
            return;
        }

        if (node.left != null) {
            findPath(result, path, node.left, sum, target);
            // remove current node from path to apply to other path
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            findPath(result, path, node.right, sum, target);
            path.remove(path.size() - 1);
        }

    }

}
