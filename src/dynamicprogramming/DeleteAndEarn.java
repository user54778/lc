package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        Map<Integer, Integer> totalPoints = new HashMap<>();
        int max = 0;
        // precompute number of occurrences of each element in input array
        for (int n : nums) {
            totalPoints.put(n, totalPoints.getOrDefault(n, 0) + n); // precompute total points from each element
            max = Math.max(max, n); // save max number in the array to set bounds on our recurrence
        }
        return dp(max, cache, totalPoints);
    }

    private int dp(int num, Map<Integer, Integer> cache, Map<Integer, Integer> totalPoints) {
        // first base case -> 0 elements, 0 points
        if (num == 0) {
            return 0;
        }

        // second base case -> two elements, always take 1 based on our recurrence relation
        if (num == 1) {
            return totalPoints.getOrDefault(1, 0);
        }

        // apply recurrence relation
        if (!cache.containsKey(num)) {
            int gain = totalPoints.getOrDefault(num, 0);    // total gain
            cache.put(num, Math.max(dp(num - 1, cache, totalPoints), gain + dp(num - 2, cache, totalPoints)));  // cache max result of picking or not picking nums[i]
        }
        return cache.get(num);
    }

        public static void main(String[] args) {
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[] {3, 4, 2}));
    }
}
