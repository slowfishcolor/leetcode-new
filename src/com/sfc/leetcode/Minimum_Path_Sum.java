package com.sfc.leetcode;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * dp[i][j] 到 (i,j) 处的 minimum path sum
 * dp[i][j] = min (dp[i][j-1], dp[i-1][j]) + grid[i][j]
 * dp[m - 1][n - 1] 即为所求
 * Created by Prophet on 2017/3/1.
 */
public class Minimum_Path_Sum {
    /**
     * 动态规划，求dp[][]阵，dp[m - 1][n - 1] 即为所求
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        // 填充第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // 填充第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 逐行计算dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 动态规划，优化空间，只用一行，逐行计算
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];

        dp[0] = grid[0][0];
        // 计算第一行
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        // 逐行计算
        for (int i = 1; i < m; i++) {
            // 计算 dp[0][i]
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }

        return dp[n - 1];
    }
}
