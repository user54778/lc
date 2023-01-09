package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Set<Character> charSet = new HashSet<>();
        int leftPointer = 0;

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            while(charSet.contains(s.charAt(rightPointer))) {
                charSet.remove(s.charAt(leftPointer));
                leftPointer++;
            }
            charSet.add(s.charAt(rightPointer));
            maxLen = Math.max(maxLen, charSet.size());
        }

        return maxLen;
    }
}
