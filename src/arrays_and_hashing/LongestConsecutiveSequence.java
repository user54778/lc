package arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0;    //
        Set<Integer> consec = new HashSet<>();
        for (int i : nums) {
            consec.add(i);
        }

        for (int i : nums) {
            if (!consec.contains(i - 1)) {   // check if curr num has a neighbor (left value)
                int count = 1;
                while (consec.contains(i + 1)) {
                    i++;
                    count++;
                }
                res = Math.max(count, res);
            }
        }

        return res;
    }
}
