package dynamicprogramming;

import java.util.Arrays;

/**
 * Given a rod of length n inches, and a table of prices p, determine the MAXIMUM
 * revenue r obtainable by cutting up the rod and selling the pieces.
 * Our first approach is a naive recursive solution to the problem.
 */
public class RodCutting {
    /**
     * Naive recursive solution in a top-down approach.
     * Solves the same subproblems repeatedly, leading to T(N) = 2^N.
     * @param prices price of rod
     * @param rodLength rod length
     * @return maximum revenue obtainable
     */
    public static int cutRod(int[] prices, int rodLength) {
        if (rodLength == 0) {
            return 0;   // no revenue is possible
        }
        int maxRevenue = Integer.MIN_VALUE;
        for (int i = 1; i <= rodLength; i++) {
            // max is max revenue or price of current element plus the cut of other element
            maxRevenue = Math.max(maxRevenue, prices[i] + cutRod(prices, rodLength - i));
        }
        return maxRevenue;
    }

    /**
     * Improve our original solution by using memoization to remember solved subproblems.
     * @param prices array of prices for different rod lengths
     * @param rodLength length of rod
     * @return maximum revenue obtainable
     */
    public static int topDownCutRod(int[] prices, int rodLength) {
        int[] r = new int[rodLength + 1];   // memoization table
        return topDownCutRod(prices, rodLength, r);
    }

    /**
     * Performs the actual computation of the problem.
     * @param prices array of prices for different rod lengths
     * @param rodLength length of rod
     * @param r memoization table
     * @return max revenue
     */
    private static int topDownCutRod(int[] prices, int rodLength, int[] r) {
        // first case -> we have already solved the sub-problem in our memo table
        if (r[rodLength] != 0) {
            return r[rodLength];
        }

        // base case -> rod of length 0 or 1; max revenue is 0 or p[1]
        if (rodLength == 0) {
            return 0;
        }

        int maxRevenue = Integer.MIN_VALUE; // max revenue
        /*
         * For each cut of the rod, find the MAX revenue obtainable
         */
        for (int i = 1; i <= rodLength; i++) {
            /*
             * Calculate maximum profit through our recursive function:
             * C(i) = max(Vk + C(i - k)).
             * C(i) is the price of optimal cut until length i
             * Vk is the price of a cut at length k
             * Keep calling this function for every cut of the size of rod we are on.
             */
            maxRevenue = Math.max(maxRevenue, prices[i] + topDownCutRod(prices, rodLength - i, r));
        }
        r[rodLength] = maxRevenue; // store our solution for this sub-problem in our memoization table
        return maxRevenue;
    }

    public static int bottomUpCutRod(int[] prices, int rodLength) {
        int[] r = new int[rodLength + 1];

        r[0] = 0;   // base case

        for (int i = 1; i <= rodLength; i++) {
            int maxRevenue = Integer.MIN_VALUE; // reset our maxRevenue per increasing sub-problem
            /*
             * Iterate in order of each sub-problem of the rodlengths
             */
            for (int j = 1; j <= i; j++) {  // j is position of the first cut
                // directly reference our memo array to solve each sub-problem of size i - j
                maxRevenue = Math.max(maxRevenue, prices[j] + r[i - j]);
            }
            r[i] = maxRevenue;  // remember solution for value of length i
        }
        return r[rodLength];
    }

    public static void main(String[] args) {
        int[] prices = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(topDownCutRod(prices, 2));
        System.out.println(bottomUpCutRod(prices, 2));
    }
}
