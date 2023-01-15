package dynamicprogramming;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];    // one state variable -> max sub array ending w/ arr[i]
        dp[0] = nums[0];    // base case
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2, 1}));
    }
}
