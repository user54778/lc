package dynamicprogramming;

public class NthTribonacciNumber {
    /**
     * The Tribonacci sequence Tn is defined as follows:
     *
     * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
     *
     * Given n, return the value of Tn.
     * @param n Tn
     * @return Tn
     */
    public int tribonacci(int n) {
        return tribonacci(n, new int[n + 1]);
    }

    private int tribonacci(int n, int[] cache) {
        if (n < 2) {
            return n;
        }
        // cache the base case of 1 being 1 and 2 being 1
        cache[1] = 1;   // other base cases
        cache[2] = 1;
        // if haven't calculated it, calculate it
        if (cache[n] == 0) {
            cache[n] = tribonacci(n - 1, cache) + tribonacci(n - 2, cache) + tribonacci(n - 3, cache);
        }
        return cache[n];
    }
}
