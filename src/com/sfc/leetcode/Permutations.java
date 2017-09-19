package com.sfc.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * 给定一个无重复数字的序列，返回这些数所能排列出所有序列。
 *
 * 样例输入：
 [1,2,3]

 样例输出：
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 *
 *
 *
 * Created by Prophet on 2017/9/18.
 */
public class Permutations {

    /**
     * 理解为分别将长度为 n 的数组的每一个数与数组的第一个数进行交换，然后对后面的 n-1 子数组进行全排列
     *
     * 交换 + DFS
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        exchange(nums, 0, nums.length, result);
        return result;
    }

    /**
     *                      1 2 3                           第一位 1 与后面 n-1 交换，包括与自己交换，得到下一层
     *                      ^
     *
     *      1 2 3           2 1 3           3 2 1           第一位固定 ，第二位分别与后面交换，包括与自己交换，得到下一层
     *      " ^             " ^             " ^
     *
     * 1 2 3    1 3 2   2 1 3   2 3 1   3 2 1   3 1 2       固定前两位，发现第三位是最后一位，该层即为结果
     *
     * @param nums
     * @param i
     * @param len
     * @param res
     */
    private void exchange(int[] nums, int i, int len, List<List<Integer>> res) {
        // 最后一层，将当前数组加到结果集中
        if(i == len-1) {
            List<Integer> list = new ArrayList<>();
            for (int j=0; j<len; j++){
                list.add(nums[j]);
            }
            res.add(list);
            return ;
        }
        // 将当前位置的数跟后面的数交换，并搜索解
        for (int j = i; j < len; j++) {
            swap(nums, i, j);
            // 交换下一层
            exchange(nums, i + 1, len, res);
            // reset 当前层，自始至终操作的是一个 nums
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
