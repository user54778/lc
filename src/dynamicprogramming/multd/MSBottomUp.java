package dynamicprogramming.multd;

public class MSBottomUp {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];  // sized according to state variable row and col (step 1)
        int maxLen = 0; // max length of square

        // no other bases cases (step 2)
        // step 3 -> iterate over our state variables based on base cases
        // i decided to start from the BOTTOM RIGHT, so i should go UP
        for (int row = matrix.length - 1; row >= 0; row--) {        // then row
            for (int col = matrix[0].length - 1; col >= 0; col--) { // function call of right state from given row
                if (matrix[row][col] == '1') {  // test condition of our recurrence
                    /*
                     * We have to find the MINIMUM of the square's sides.
                     * If there is a zero at ANY position, the square CAN NOT be extended in that direction.
                     * We are taking the MINIMUM length of the square that can be formed from
                     * the three positions.
                     */
                    dp[row][col] = 1 + Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row + 1][col + 1]);

                    maxLen = Math.max(maxLen, dp[row][col]);
                }
            }
        }

        return maxLen * maxLen;
    }
}
