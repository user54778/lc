package dynamicprogramming.multd;

/**
 * You are given two 0-indexed integer arrays nums and multipliers of size n and m respectively, where n >= m.
 *
 * You begin with a score of 0. You want to perform exactly m operations.
 * On the ith operation (0-indexed) you will:
 *
 * Choose one integer x from either the START or the END of the array nums.
 * ADD multipliers[i] * x to your score.
 * Note that multipliers[0] corresponds to the first operation, multipliers[1] to the second operation, and so on.
 * Remove x from nums.
 * Return the maximum score after performing m operations.
 */
public class MaximumScoreFromPerformingMultiplicationOperations {
    public int maximumScore(int[] nums, int[] multipliers) {
        return dp(0, 0, nums, multipliers, new int[nums.length][multipliers.length]);
    }

    // two states: i to indicate operations done, and left to indicate leftmost variable
    // right state will be calculated based on the state of the operations and leftmost variable
    private int dp(int i, int left, int[] nums, int[] multipliers, int[][] cache) {
        // base case -> performed m operations
        if (i == multipliers.length) {
            return 0;
        }

        int mult = multipliers[i];  // multipliers[i] for the score
        int right = nums.length - 1 - (i - left);   // must have picked i - left elements from the right-side

        // hasn't been cached yet
        if (cache[i][left] == 0) {
            // recurrence relation we defined: max(mult * nums[left] + dp(i + 1, left + 1),
            // mult * nums[right] + dp(i + 1, right))
            // mult * nums[left/right] -> points left end
            // choose the side that gives us MORE points
            // choose left, next left will occur i + 1, left + 1 operations away
            // choose right, next right will occur i + 1, right - 1 operations away
            // in this case, only using TWO state variables so just left operations away
            cache[i][left] = Math.max(mult * nums[left] + dp(i + 1, left + 1, nums, multipliers, cache),
                    mult * nums[right] + dp(i + 1, left, nums, multipliers, cache));
        }

        return cache[i][left];
    }

    public static void main(String[] args) {
        System.out.println(new MaximumScoreFromPerformingMultiplicationOperations().maximumScore(new int[] {1, 2, 3}, new int[] {3, 2, 1}));
    }
}
