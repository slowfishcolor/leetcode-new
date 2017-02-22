package com.sfc.leetcode;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.Here, we will use the integers 0, 1, and 2 to represent
 * the color red, white, and blue respectively.
 *
 * 数组中有三个数，0，1，2，乱序排，要求把按照顺序排好，0放最前，2放最后，1在中间
 *
 * Created by Prophet on 2017/2/22.
 */
public class Sort_Colors {
    public void sortColors(int[] nums) {
        // 0 的 index，从前往后
        int i = 0;
        // 2 的 index，从后往前
        int j = nums.length - 1;
        // 遍历使用到的 index
        int p = 0;
        for ( ;p < j; ) {
            if (nums[p] == 1) {
                p++;
                continue;
            } else if (nums[p] == 0) {
                swap(nums, i, p);
                i++;
                p++;
            } else {
                // 交换回来的有可能还是 3，故 p 不前进，下一轮继续判断
                swap(nums, j, p);
                j--;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int t = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = t;
    }
}
