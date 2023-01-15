package dynamicprogramming.multd;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSumBU {
    public boolean canPartition(int[] nums) {
        int maxSum = 0;
        for (int n : nums) maxSum += n;

        if (maxSum % 2 != 0) {
            return false;
        }

        int subsetSum = maxSum / 2; // partition into two equal subsets

        Set<Integer> dp = new HashSet<>();
        dp.add(0);  // add up to sum of 0; base case
        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> nextDp = new HashSet<>();
            for (int j : dp) {
                if (j + nums[i] == subsetSum) {
                    return true;
                }
                nextDp.add(j + nums[i]);    // include curr value along w/ nums[i]
                nextDp.add(j);              // include orig values
            }
            dp = nextDp;
        }

        return false;
    }
}
