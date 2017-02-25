package com.sfc.leetcode;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 注意，k 可能大于 nums.length
 * Created by Prophet on 2017/2/24.
 */
public class Rotate_Array {

    /**
     * 依次右移 O(N2) TIL
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int tail = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tail;
        }
    }

    /**
     * Using extra array
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {

        if (nums.length < 2) return;
        if (nums.length < k) k = k % nums.length;

        int[] t = nums.clone();

        for (int i = nums.length - k, j = 0; i < nums.length; i++, j++) {
            nums[j] = t[i];
        }

        for (int i = 0, j = k; i < nums.length - k; i++, j++) {
            nums[j] = t[i];
        }
    }

    /**
     * 通过三次反转
     * 第一次全部 reverse
     * 第二次reverse 前 k-1 个
     * 第三次 reverse 剩下的
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (nums.length < 2) return;
        if (nums.length < k) k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for ( ;start < end; start++, end--) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
        }
    }
}
