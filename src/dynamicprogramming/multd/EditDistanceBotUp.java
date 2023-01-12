package dynamicprogramming.multd;

public class EditDistanceBotUp {
    // bottom up tabulation -> start from end of strings and work our way towards 0,0
    public int minDistance(String word1, String word2) {
        // edge cases with empty strings
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        int r = word1.length();
        int c = word2.length();

        // base case -> reached end of index, return remaining length of the word
        // equivalent to
        for (int i = 0; i <= r; i++) {
            dp[i][c] = r - i;
        }

        for (int j = 0; j <= c; j++) {
            dp[r][j] = c - j;
        }

        // step 3 -> recurrence
        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];    // no operation cost for same word
                } else {
                    // perform our recurrence
                    int costReplace = 1 + dp[i + 1][j + 1]; // move both pointers
                    int costDelete  = 1 + dp[i + 1][j];     // move i's pointer, but NOT j
                    int costInsert  = 1 + dp[i][j + 1];     // move j's pointer, but NOT i
                    dp[i][j] = Math.min(Math.min(costDelete, costInsert), costReplace);
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistanceBotUp().minDistance("horse", "ros"));
    }
}
