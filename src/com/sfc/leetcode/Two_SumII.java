package com.sfc.leetcode;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.The function twoSum should return indices of the two numbers such that they add up to the
 * target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 * are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * 已排序的数组，给定target = 其中两数相加, 返回的index + 1
 * Created by Prophet on 2017/2/24.
 */
public class Two_SumII {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            int t = numbers[i] + numbers[j];
            if ( t == target) return new int[] {i + 1, j + 1};
            if ( t < target ) i++;
            else j--;
        }
        return null;
    }
}
