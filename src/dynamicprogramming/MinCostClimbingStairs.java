package dynamicprogramming;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairs(cost, cost.length, new int[cost.length + 1]);
    }

    // use top-down dp to solve
    private int minCostClimbingStairs(int[] cost, int steps, int[] cache) {
        // base case -> can start from 0th or 1st step
        if (steps <= 1) {
            return 0;   // no cost
        }

        if (cache[steps] == 0) {
            // cost of one step, along with min cost of ALL previous one steps
            int oneStep = cost[steps - 1] + minCostClimbingStairs(cost, steps - 1, cache);
            int twoStep = cost[steps - 2] + minCostClimbingStairs(cost, steps - 2, cache);

            // memoize the min value of the two steps
            cache[steps] = Math.min(oneStep, twoStep);
        }
        return cache[steps];
    }
}
