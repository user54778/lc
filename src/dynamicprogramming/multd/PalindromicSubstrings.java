package dynamicprogramming.multd;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int ans = 0;

        if (s.length() == 0) {
            return 0;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];

        // single letter substrings
        for (int i = 0; i < s.length(); i++, ans++) {
            dp[i][i] = true;
            System.out.println(ans);
        }

        // double letter substrings
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            ans += (dp[i][i + 1] ? 1 : 0);
            System.out.println(ans);
        }

        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0, j = i + s.length() - 1; j < s.length(); i++, j++) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                ans += (dp[i][j] ? 1 : 0);
                System.out.println(ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().countSubstrings("aaaaa"));
    }
}
