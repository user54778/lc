package sliding_window;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        /*
         * Count the occurrence of each character in s1 so we can use it check for permutations
         * in s2.
         */
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }

        int winLen = s1.length();   // our window length is the length of s1
        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;    // move right side of the window
            // check valid left pointer for window
            if (i - winLen >= 0) {
                count[s2.charAt(i - winLen) - 'a']++;   // count left side of the window
            }
            // if we have zero count, that means the window in s2 chars are the same as the characters
            // in s1, therefore we must have a permutation
            if (checkAllZeroes(count)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkAllZeroes(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
