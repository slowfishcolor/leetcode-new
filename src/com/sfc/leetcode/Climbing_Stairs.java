package com.sfc.leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * Created by Prophet on 2017/2/28.
 */
public class Climbing_Stairs {
    /**
     * 递归
     * TIL
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n-2);
    }

    /**
     * 动态规划
     * dp[i] = dp[i-1] + dp[i-2]
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * 动态规划，优化空间
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int c1 = 1, c2 = 2;
        for (int i = 3; i < n + 1; i++) {
            int t = c2;
            c2 = c1 + c2;
            c1 = t;
        }
        return c2;
    }
}
