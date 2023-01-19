package dynamicprogramming.multd;

import java.util.Arrays;

/**
 * There is a robot on an m x n grid.
 * The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths
 * that the robot can take to reach the bottom-right corner.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // two states -> col, rows left
        int[][] dp = new int[m][n];

        // base case -> initialize num of paths to 1; all initialized to 1 for convenience
        for (int[] paths : dp) {
            Arrays.fill(paths, 1);
        }

        // recurrence -> we either traverse right or down each path; grid setup as col, row
        for (int j = 1; j < dp.length; j++) {
            for (int i = 1; i < dp[0].length; i++) {
                dp[j][i] = dp[j - 1][i] + dp[j][i - 1];
            }
        }

        return dp[m - 1][n - 1];    // bottom right of matrix is here
    }
}
