package sliding_window;

public class LongestRepeatedCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFrequency = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxFrequency = Math.max(maxFrequency, count[s.charAt(right) - 'A']);    // avoid recalculating max frequency of count array

            // length of window - count most freq char; not valid
            if ((right - left + 1) - maxFrequency > k) {
                count[s.charAt(left) - 'A']--;    // take count of character at left position and decrement it; no longer in our window
                left++; // shift our LEFT pointer
            }
            ans = Math.max(ans, (right - left + 1));
        }
        return ans;
    }
}
