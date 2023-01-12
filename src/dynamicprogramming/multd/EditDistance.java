package dynamicprogramming.multd;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        // two states, the edit distance between word1 and 2
        if (word1.length() == 0) {
            return word2.length();
        } else if (word2.length() == 0) {
            return word1.length();
        }
        return dp(0, 0, new int[word1.length()][word2.length()], word1, word2);
    }

    private int dp(int i, int j, int[][] cache, String word1, String word2) {
        // reached end of index, therefore return remaining length of the word -> base case
        if (i == word1.length()) {
            return word2.length() - j;  // return remaining length of word2
        }
        if (j == word2.length()) {
            return word1.length() - i;  // return remaining length of word1
        }

        // check cache for values
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            // no operation is required, just traverse through each string respectively
            cache[i][j] = dp(i + 1, j + 1, cache, word1, word2);
        } else {
            // do our recurrence
            // three cases: insertion, deletion, replace
            int costReplace = 1 + dp(i + 1, j + 1, cache, word1, word2);

            int costDelete  = 1 + dp(i + 1, j, cache, word1, word2);

            int costInsert  = 1 + dp(i, j + 1, cache, word1, word2);

            // cache minimum operations of the three operations
            cache[i][j] = Math.min(Math.min(costReplace, costDelete), costInsert);

        }
        return cache[i][j];
    }
}
