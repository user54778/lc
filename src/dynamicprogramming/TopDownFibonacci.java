package dynamicprogramming;

public class TopDownFibonacci {
    /**
     * Calculate the Fibonacci Sequence using memoization to go from O(2^N) to O(N).
     * @param n nth number to calculate
     * @return F(N)
     */
    public int fib(int n) {
        return topDownFib(n, new int[n + 1]);   // avoid global array to memoize
    }

    /**
     * Memoized previously computed results into an array to avoid re-solving
     * previously computed sub-problems.
     * @param n nth number
     * @param cache cached solutions
     * @return F(N)
     */
    private int topDownFib(int n, int[] cache) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }
        // will default to 0 if it hasn't been cached
        if (cache[n] != 0) {
            return cache[n];    // already calculated n
        } else {
            return cache[n] = topDownFib(n - 1, cache) + topDownFib(n - 2, cache);
        }
    }
}
