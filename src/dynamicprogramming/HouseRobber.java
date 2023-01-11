package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    public int rob(int[] nums) {
        return rob(nums, 0, new HashMap<>());
    }

    // top down memoization
    private int rob(int[] nums, int currentHouse, Map<Integer, Integer> cache) {
        // base case -> no more houses
        if (currentHouse >= nums.length) {
            return 0;
        }

        // check if pre-computed answer already
        if (cache.containsKey(currentHouse)) {
            return cache.get(currentHouse);
        } else {
            int max = Math.max(rob(nums, currentHouse + 1, cache),
                    rob(nums, currentHouse + 2, cache) + nums[currentHouse]);
            cache.put(currentHouse, max);   // key current house, value is max money rob up to current house
            return max;
        }
    }



    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[] {2,7,9,3,1}));
    }
}
