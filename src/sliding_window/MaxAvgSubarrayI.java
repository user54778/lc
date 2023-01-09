package sliding_window;

public class MaxAvgSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        double ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (i >= k - 1) {
                ans = Math.max(ans, sum / k);
                sum -= nums[i - k + 1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1};
        System.out.println(findMaxAverage(nums, 1));
    }
}
