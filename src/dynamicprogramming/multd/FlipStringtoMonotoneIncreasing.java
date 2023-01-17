package dynamicprogramming.multd;

public class FlipStringtoMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        // two states -> remaining input string, current bit value
        int[][] dp = new int[s.length() + 1][2];

        /*
         * Represent min number of flips if ith character is 0 or 1.
         * Base Case -> First i characters are not monotone increasing: require i flips to make
         * them monotone increasing.
         */
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = i;
            dp[i][1] = i;
        }

        for (int i = 1; i <= s.length(); i++) {
            // recurrence -> 1 is in wrong place
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][0]) + (s.charAt(i - 1) == '1' ? 1 : 0);
            // recurrence -> 0 is in the wrong place
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s.charAt(i - 1) == '0' ? 1 : 0);
        }

        return Math.min(dp[s.length()][0], dp[s.length()][1]);
    }

    public static void main(String[] args) {
        System.out.println(new FlipStringtoMonotoneIncreasing().minFlipsMonoIncr("00110")); // 1
    }
}
