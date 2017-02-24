package com.sfc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 给定一个整形数组，找出其中的两个数，使其和为某个指定的值
 * Created by Prophet on 2017/2/23.
 */
public class Two_Sum {
    /**
     * 暴力搜索， O(n2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        for (int i = 0; i < nums.length - 1; i++ ) {
            int t = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (t == nums[j]) return new int[]{i, j};
            }
        }
        return null;
    }

    /**
     * 先排序，再从两头开始查找 O(NlogN +  N)
     * 然而排序后顺序乱了。。。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; ) {
            int t = nums[i] + nums[j];
            if (t == target) {return new int[] {i, j};}
            if (t > target) {j--;}
            else {i++;}
        }
        return null;
    }

    /**
     * Hash 存储，直接找，O(n)
     * 有可能存在相同的元素
     * map存的value是元素出现的次数
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (map.containsKey(t))
                return new int[] {map.get(t), i};
            map.put(nums[i], i);
        }

        return null;
    }




}
