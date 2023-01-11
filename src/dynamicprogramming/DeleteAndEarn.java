package dynamicprogramming;

import java.util.HashMap;

public class DeleteAndEarn {
    private final HashMap<Integer, Integer> cache = new HashMap<>();
    private final HashMap<Integer, Integer> totalPoints = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        // populate total points to find max, the largest element in nums
        for (int n : nums) {
            // compute total points by adding nums[n] + previous computed value of n
            totalPoints.put(n, totalPoints.getOrDefault(n, 0) + n);
            max = Math.max(max, n);
        }
        return dp(max);
    }

    private int dp(int num) {
        // first base case -> 0 elements, 0 points
        if (num == 0) {
            return 0;
        }

        // second base case -> two elements, always take 1 based on our recurrence relation,
        // default to 0 if non-existent
        if (num == 1) {
            return totalPoints.getOrDefault(1, 0);
        }

        // apply recurrence relation -> maxPoints = max(dp(i - 1), gain + dp(i - 2))
        // dp(i - 1) -> we choose to not pick nums[i - 1]
        // dp(i - 2) + gain -> we pick nums[i], and non adjacent values of nums[i], which is equivalent
        // to nums[i - 2]
        if (!cache.containsKey(num)) {
            int gain = totalPoints.getOrDefault(num, 0);    // total gain
            cache.put(num, Math.max(dp(num - 1), gain + dp(num - 2)));  // cache max result of picking or not picking nums[i]
        }
        return cache.get(num);
    }
}
