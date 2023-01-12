package dynamicprogramming.multd;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original
 * string with some characters (can be none) deleted without changing
 * the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        return dp(0, 0, new int[text1.length()][text2.length()], text1, text2);
    }

    /**
     * Memoize our solution using a 2-d array/
     * @param i first state
     * @param j second state
     * @param cache cache; 2 dimensional since we have two states
     * @param str1 first string
     * @param str2 second string
     * @return lcs, bottom right
     */
    private int dp(int i, int j, int[][] cache, String str1, String str2) {
        if (i >= str1.length() || j >= str2.length()) {
            return 0;   // base case where reached end of string
        }

        if (cache[i][j] != 0) {
            return cache[i][j]; // check if cached answer before
        }

        /*
         * Recurrence goes as this -> if two states are on same string character, add one to our
         * result. Otherwise, we need to check the subsequence of the ith sequence and jth sequence,
         * and we want the BEST of those two, the longest subsequence.
         */
        if (str1.charAt(i) == str2.charAt(j)) {
            cache[i][j] = 1 + dp(i + 1, j + 1, cache, str1, str2);
        } else {
            // check ith and jth sequence, and choose the BEST value for our cache
            cache[i][j] = Math.max(dp(i + 1, j, cache, str1, str2), dp(i, j + 1, cache, str1, str2));
        }
        return cache[i][j];
    }
}
