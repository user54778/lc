package dynamicprogramming.multd;

public class LCSBottomUp {
    // lets solve bottomup next
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // start at the BOTTOM RIGHT, iterate up EACH COLUMN first, then go through EACH ROW
        for (int j = text2.length() - 1; j >= 0; j--) {
            for (int i = text1.length() - 1; i >= 0; i--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];  // traverse diagonally, and look at remaining two strings
                } else {
                    // check all other possible subsequences, and use the BEST one
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];    // original answer will be TOP LEFT
    }
}
