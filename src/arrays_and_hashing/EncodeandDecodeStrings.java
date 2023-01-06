package arrays_and_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeandDecodeStrings {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for (String str : strs) {
            s.append(str.length());
            s.append("#");
            s.append(str);
        }
        return s.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            // while we are still at an integer character increment until we find the # character
            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j)); // know length will be at i to non-inclusive j
            res.add(str.substring(j + 1, j + 1 + len));   // append current string to result
            i = j + 1 + len;    // move i to the next word
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("lint");
        strings.add("code");
        strings.add("love");
        strings.add("you");
        EncodeandDecodeStrings encodeandDecodeStrings = new EncodeandDecodeStrings();
        String str = encodeandDecodeStrings.encode(strings);
        encodeandDecodeStrings.decode(str);
    }
}
