package dynamicprogramming.multd;

import java.util.Arrays;
import java.util.Objects;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        String[][] cache = new String[s.length()][s.length()];
        for (String[] row : cache) {
            Arrays.fill(row, "");
        }
        return longestPalindromeHelper(s, 0, s.length() - 1, cache);
    }

    private String longestPalindromeHelper(String s, int start, int end, String[][] cache) {
        if (!Objects.equals(cache[start][end], "")) {
            return cache[start][end];
        }
        String result = "";
        if (start == end) {
            result = s.substring(start, start + 1);
        } else if (s.charAt(start) == s.charAt(end)) {
            if (end - start == 1) {
                result = s.substring(start, end + 1);
            } else {
                String next = longestPalindromeHelper(s, start + 1, end - 1, cache);
                if (!Objects.equals(next, "")) {
                    result = s.charAt(start) + next + s.charAt(end);
                }
            }
        } else {
            String left = longestPalindromeHelper(s, start + 1, end, cache);
            String right = longestPalindromeHelper(s, start, end - 1, cache);
            result = (left.length() > right.length()) ? left : right;
        }
        cache[start][end] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));   // "bab" or "aba"
    }
}
