package dynamicprogramming.iteraterecurrence;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1]; // base case is last position; out of bounds

        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
        }

        dp[s.length()] = true;  // base case

        for (int i = s.length(); i >= 0; i--) {
            for (String word : wordDict) {
                // starting at position i, does string s have enough characters w to be compared to it
                // are characters at i equal to word in worddict
                if (((i + word.length()) <= s.length() && (s.substring(i, i + word.length()).startsWith(word)))) {
                    dp[i] = dp[i + word.length()];  // recurrence relation
                }
                // stop this loop
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];   // original solution should be at index 0
    }
}
