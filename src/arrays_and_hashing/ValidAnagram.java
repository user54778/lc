package arrays_and_hashing;

import java.util.HashMap;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);    // increment character count by 1
        }

        for (int i = 0; i < t.length(); i++) {
            int count = sMap.getOrDefault(t.charAt(i), 0);
            if (count == 0) {
                return false;
            } else {
                sMap.put(t.charAt(i), count - 1);
            }
        }

        return true;
    }
}
