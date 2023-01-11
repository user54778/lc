package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // start at n, then we must stop 2 places before end, otherwise one spot
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    // bottom-up tabulation only difference is where we start and end
    private int rob(int[] nums, int start, int end) {
        int rob = 0;
        int noRob = 0;

        // [rob1, rob2, n, n + 1, ...]
        for (int i = start; i <= end; i++) {
            int max = Math.max(nums[i] + rob, noRob);
            rob = noRob;
            noRob = max;
        }
        return noRob;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[] {2, 3, 2}));
    }
}
