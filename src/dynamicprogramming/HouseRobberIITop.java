package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIITop {
    // attempt to use top down memoization
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n =  rob(nums, 0, nums.length - 2, new HashMap<>());
        int n1 = rob(nums, 1, nums.length - 1, new HashMap<>());
        return Math.max(n, n1);
    }

    private int rob(int[] nums, int currHouse, int end, Map<Integer, Integer> cache) {
        if (currHouse > end) {
            return 0;   // base case reached end of houses
        }

        if (cache.containsKey(currHouse)) {
            return cache.get(currHouse);    // precomputed
        }
        int max = Math.max(rob(nums, currHouse + 2, end, cache) + nums[currHouse],
                rob(nums, currHouse + 1, end, cache));
        cache.put(currHouse, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberIITop().rob(new int[] {1,2,1,1}));

    }
}
