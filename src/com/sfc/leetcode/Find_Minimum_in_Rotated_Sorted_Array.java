package com.sfc.leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 * Created by Prophet on 2017/8/24.
 */
public class Find_Minimum_in_Rotated_Sorted_Array {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        int mid = 0;

        while (left < right) {
            // 有序子序列，首元素即为最小值
            if (nums[left] < nums[right]) return nums[left];
            mid = left + (right - left) / 2;
            // 在左边继续找
            if (nums[left] > nums[mid]) {
                right = mid;
            }
            // 在右边继续找
            else if (nums[mid] > nums[right]) {
                // 注意这里 mid + 1，能保证这里不会死循环
                // 最终若 mid + 1 = left = right 退出循环时，该位置就是最小值
                // 同时由于循环体一开始的检测，保证了其他情况退出循环
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,1,2,3};
        System.out.println(findMin(nums));
    }
}
