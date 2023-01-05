package arrays_and_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly once.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>(); // return a list OF the list of the anagrams

        if (strs.length == 0) { // can't contain anagrams if empty
            return ans;
        }

        // hashmap where we KEY -> strings and VALUE -> LIST of anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        /*
         * For each one of the strings in strs, we want to COUNT each character from
         * LOWERCASE [a-z].
         */
        for (String s : strs) {

            char[] count = new char[26];        // at MOST 26 unique characters
            for (char c : s.toCharArray()) {    // count characters a-z for each string
                count[c - 'a']++;
            }

            // now we can key with our count array to IDENTIFY anagrams
            String key = new String(count);
            map.computeIfAbsent(key, k -> new ArrayList<>());   // if specified key is not associated with a value, enter it into the hashmap
            map.get(key).add(s);    // add string to the value of the key in the hashmap
        }

        ans.addAll(map.values());   // add all values from the hashmap to our list of strings
        return ans;
    }
}
