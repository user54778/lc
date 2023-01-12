package dynamicprogramming.multd;

/**
 * Given an integer array nums, return true if you can partition the array into two subsets
 * such that the sum of the elements in both subsets is equal or false otherwise.
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int maxSum = 0;
        // find the sum of every array element
        for (int n : nums) {
            maxSum += n;
        }

        // if we get an odd sum, can NOT possibly partition into two equal subsets
        if (maxSum % 2 != 0) {
            return false;
        }

        int subSetSum = maxSum / 2; // partition our subsetsum into two equal partitions
        return dp(nums.length - 1, subSetSum, new Boolean[nums.length + 1][subSetSum + 1], nums);
    }

    private boolean dp(int n, int subSetSum, Boolean[][] cache, int[] nums) {
        // base cases -> subsetsum is 0, reached end of array
        if (subSetSum == 0) {
            return true;
        }
        if (n == 0 || subSetSum < 0) {
            return false;
        }

        if (cache[n][subSetSum] != null) {
            return cache[n][subSetSum];
        } else {
            // recurrence -> dfs on our subset tree
            // choice -> INCLUDE this sub sum, or DONT include
            cache[n][subSetSum] = dp(n - 1, subSetSum - nums[n - 1], cache, nums)
                    || dp(n - 1, subSetSum, cache, nums);

        }
        return cache[n][subSetSum];
    }
}
